package edu.itvo.kmp1.core.network

import io.ktor.client.HttpClient

actual fun createHttpClient(): HttpClient {
    return HttpClient()
}