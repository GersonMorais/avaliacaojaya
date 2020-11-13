package com.projeto.currencyconverter

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.projeto.currencyconverter.entities.Transaction
import com.projeto.currencyconverter.http.HttpHelper
import com.projeto.currencyconverter.service.Converter
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.format.DateTimeFormatter
import java.util.*

@SpringBootApplication
class CurrencyconverterApplication

//@Value("${ads04.swagger.path}")
var swaggerPath : String = ""

fun main(args: Array<String>) {
	runApplication<CurrencyconverterApplication>(*args)

}
