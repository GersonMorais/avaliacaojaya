package com.projeto.currencyconverter.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.projeto.currencyconverter.entities.Transaction
import com.projeto.currencyconverter.http.HttpHelper

class Converter {

    fun converts(from: String, to: String): Transaction{
        var http : HttpHelper = HttpHelper()
        var jsonString = http.get(from)
        val exchange = ObjectMapper().readValue<MutableMap<Any, Any>>(jsonString)
        val rates = exchange["rates"] as HashMap<String, Double>
        val rate = rates.getOrDefault(to,0.0).toDouble()
        println("taxa de conversao $rate")
        var transaction: Transaction = Transaction(
                0,
                0,
                from,
                0.0,
                to,
                0.0,
                rate
        )
        return transaction
    }
}