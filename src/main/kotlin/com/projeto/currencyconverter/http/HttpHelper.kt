package com.projeto.currencyconverter.http

import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import com.squareup.okhttp.ResponseBody

class HttpHelper {
    fun get(base: String): String {
        val URL = "https://api.exchangeratesapi.io/latest?base=${base}"

        val client = OkHttpClient()

        val request = Request.Builder().url(URL).get().build()

        val response = client.newCall(request).execute()

        return response.body().string()
    }


}