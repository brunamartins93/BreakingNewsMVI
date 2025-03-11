package com.course.breakingnews.features.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.course.breakingnews.domain.usecase.GetHomeUseCase
import com.course.breakingnews.features.details.state.DetailsState
import com.course.breakingnews.features.home.action.HomeAction
import com.course.breakingnews.features.home.state.HomeState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getHomeUseCase: GetHomeUseCase
) : ViewModel() {

    private val pendingActions = MutableSharedFlow<HomeAction>()

    private var _state: MutableStateFlow<HomeState> =
        MutableStateFlow(HomeState.Loading)
    val state: StateFlow<HomeState> = _state

    init {
        handleActions()
    }

    private fun getBreakingNews() {
        viewModelScope.launch {
            getHomeUseCase.getBreakingNews().collect { data ->
                HomeState.ShowData(data = data.newsDomains ?: emptyList()).updateState()
            }
        }
    }

    private fun handleActions() = viewModelScope.launch {
        pendingActions.collect { action ->
            when (action) {
                is HomeAction.Idle -> requestIdleState()
                is HomeAction.RequestNavigateToDetails -> navigateToDetails(
                    urlToImage = action.urlToImage,
                    description = action.description
                )

                is HomeAction.RequestBreakingNews -> getBreakingNews()
            }
        }
    }

    private fun requestIdleState() {
        viewModelScope.launch {
            HomeState.Idle.updateState()
        }
    }

    private fun navigateToDetails(urlToImage: String, description: String) {
        viewModelScope.launch {
            HomeState.NavigateToDetails(
                urlToImage = urlToImage,
                description = description
            ).updateState()
        }
    }

    fun submitAction(action: HomeAction) {
        viewModelScope.launch {
            pendingActions.emit(action)
        }
    }

    private fun HomeState.updateState() = _state.update { this }
}