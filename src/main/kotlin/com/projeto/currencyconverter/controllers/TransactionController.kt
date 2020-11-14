package com.projeto.currencyconverter.controllers


import com.projeto.currencyconverter.entities.Transaction
import com.projeto.currencyconverter.repositories.TransactionRepository
import com.projeto.currencyconverter.service.Converter
import com.projeto.currencyconverter.service.TransactionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList


@RestController
@RequestMapping("/transactions")
class TransactionController {
    @Autowired
    lateinit var service: TransactionService

    @GetMapping
    fun findAll(): List<Transaction>{
        return service.findAll()
    }

    @GetMapping("/{userId}")
    fun findIdUser(@PathVariable("userId") userId: Long): List<Transaction>{
        return service.findIdUser(userId)
    }

    @PostMapping
    fun create(@RequestBody transaction: Transaction): Transaction {
        return service.create(transaction)
    }
}