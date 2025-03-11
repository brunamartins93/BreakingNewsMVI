package com.course.breakingnews.features.about.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.course.breakingnews.features.about.action.AboutAction
import com.course.breakingnews.features.about.state.AboutState
import com.course.breakingnews.features.about.viewmodel.AboutViewModel
import com.course.breakingnews.features.details.action.DetailsAction
import com.course.breakingnews.ui.loading.Loading
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AboutScreen(
    onBackPressed: () -> Unit
) {
    val viewModel = koinViewModel<AboutViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    LifecycleEventEffect(
        event = Lifecycle.Event.ON_START
    ) {
        viewModel.submitAction(AboutAction.RequestAboutInfo)
    }

    AboutContent(
        state = state,
        action = viewModel::submitAction,
        onBackPressed = onBackPressed
    )

}

@Composable
private fun AboutContent(
    state: AboutState,
    action: (AboutAction) -> Unit,
    onBackPressed: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.White,
        topBar = {},
        content = { paddingValues ->
            when(state) {
                is AboutState.Idle -> {}
                is AboutState.Loading -> Loading()
                is AboutState.OnBackPressed -> {
                    action(AboutAction.Idle)
                    onBackPressed.invoke()
                }
                is AboutState.ShowData -> {
                    LazyColumn(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
                        items(state.data) { item ->
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(
                                    text = item.first,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                Text(
                                    text = item.second,
                                    color = Color.Black
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                            }
                            HorizontalDivider()
                        }

                        item {
                            Row(
                                modifier = Modifier
                                    .padding(16.dp)
                            ) {
                                Button(
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.LightGray,
                                        contentColor = Color.Black
                                    ),
                                    onClick = {
                                        action(AboutAction.RequestOnBackPressed)
                                    }
                                ) {
                                    Text("Voltar")
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}