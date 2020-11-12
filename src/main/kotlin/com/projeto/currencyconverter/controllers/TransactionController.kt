package com.projeto.currencyconverter.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.projeto.currencyconverter.entities.Transaction
import com.projeto.currencyconverter.http.HttpHelper
import com.projeto.currencyconverter.repositories.TransactionRepository
import com.projeto.currencyconverter.service.Converter
import com.projeto.currencyconverter.service.TransactionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*
import kotlin.collections.ArrayList


@RestController
@RequestMapping("/transactions")
class TransactionController {
    @Autowired
    lateinit var repository: TransactionRepository

    @GetMapping
    fun index(): List<Transaction>{
        return repository.findAll()
    }

    @GetMapping("/{userId}")
    fun index(@PathVariable("userId") userId: Long): List<Transaction>{
        var listIds : ArrayList<Long> = ArrayList()
        listIds.add(userId)
        return repository.findUserId(userId)

//        var service : TransactionService = TransactionService()
//        return service.transactionsByUserid(1)
    }

    @PostMapping
    fun create(@RequestBody transaction: Transaction): Transaction {
        var service = TransactionService()

        var converter: Converter = Converter()
        var transactionConversor: Transaction
        transactionConversor = converter.converts(transaction.originCurrency,transaction.targetCurrency)

        transaction.conversionRate = transactionConversor.conversionRate

        return repository.save(transaction)
    }
}