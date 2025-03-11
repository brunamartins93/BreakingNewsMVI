package com.course.breakingnews.data.repository

import com.course.breakingnews.data.mapping.toDomain
import com.course.breakingnews.data.response.raw.NewsRawResponse
import com.course.breakingnews.domain.model.raw.NewsRawDomain
import com.course.breakingnews.domain.repository.HomeRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeRepositoryImpl(
    private val httpClient: HttpClient
): HomeRepository {
    override fun getBreakingNews(): Flow<NewsRawDomain> = flow {
        val result = httpClient.get(KEY_BREAKING_NEWS_ENDPOINT) {
            url {
                parameters.append(KEY_COUNTRY_PARAM, KEY_COUNTRY)
                parameters.append(KEY_API_PARAM, KEY_API)
            }
        }.body<NewsRawResponse>().toDomain()
        emit(result)
    }

    companion object {
        const val KEY_API = "6b3283a9c8b04355957c0e1a629e295c"
        const val KEY_COUNTRY = "us"
        const val KEY_BREAKING_NEWS_ENDPOINT = "/v2/top-headlines"
        const val KEY_API_PARAM = "apiKey"
        const val KEY_COUNTRY_PARAM = "country"
    }
}