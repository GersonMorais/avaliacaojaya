package com.projeto.currencyconverter.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.projeto.currencyconverter.entities.Transaction
import com.projeto.currencyconverter.http.HttpHelper
import java.time.LocalDateTime
import kotlin.collections.HashMap

class Converter {

    fun converts(transaction : Transaction): Transaction{
        var http : HttpHelper = HttpHelper()
        var jsonString = http.get(transaction.originCurrency)
        val exchange = ObjectMapper().readValue<MutableMap<Any, Any>>(jsonString)
        val rates = exchange["rates"] as HashMap<String, Double>
        val rate = rates.getOrDefault(transaction.targetCurrency,0.0).toDouble()
        val targetValue = transaction.originValue * rate
        return Transaction(
                0,
                transaction.userId,
                transaction.originCurrency,
                transaction.originValue,
                transaction.targetCurrency,
                targetValue,
                rate,
                LocalDateTime.now()
        )
    }
}