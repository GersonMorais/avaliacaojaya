package com.projeto.currencyconverter

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.projeto.currencyconverter.entities.Transaction
import com.projeto.currencyconverter.http.HttpHelper
import com.projeto.currencyconverter.service.Converter
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CurrencyconverterApplication

fun main(args: Array<String>) {
	runApplication<CurrencyconverterApplication>(*args)

	// testando retorno do get
//	var http : HttpHelper = HttpHelper()
//	var jsonString = http.get("EUR")
//	val map = ObjectMapper().readValue<MutableMap<Any, Any>>(jsonString)
//	val resposta = map["rates"] as HashMap<String, Double>
//	println(resposta.getOrDefault("JPY",0.0))


}
