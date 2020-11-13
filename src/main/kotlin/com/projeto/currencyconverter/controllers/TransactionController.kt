package com.projeto.currencyconverter.controllers


import com.projeto.currencyconverter.entities.Transaction
import com.projeto.currencyconverter.repositories.TransactionRepository
import com.projeto.currencyconverter.service.Converter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList


@RestController
@RequestMapping("/transactions")
class TransactionController {
    @Autowired
    lateinit var repository: TransactionRepository

    @GetMapping
    fun index(): List<Transaction>{
        try {
            return repository.findAll()
        }catch(e : Exception){
            throw Exception("Error when trying to query data.")
        }
    }

    @GetMapping("/{userId}")
    fun index(@PathVariable("userId") userId: Long): List<Transaction>{
        try{
            var listIds : ArrayList<Long> = ArrayList()
            listIds.add(userId)
            return repository.findUserId(userId)
        }catch (e : Exception){
            throw Exception("Error when trying to enter data.")
        }
    }

    @PostMapping
    fun create(@RequestBody transaction: Transaction): Transaction {

        try {
            var listCurrency = listOf("USD","BRL","EUR","JPY")

            //checks if the origin currency is valid
            if(!listCurrency.contains(transaction.originCurrency)){
                throw Exception("The currency of origin is not valid")
            }

            //checks if the target currency is valid
            if(!listCurrency.contains(transaction.targetCurrency)){
                throw Exception("The currency of target is not valid")
            }

            //checks whether the source value has been entered
            if(transaction.originValue <= 0.0){
                throw Exception("No origin value was found in the request body")
            }

            var converter: Converter = Converter()
            var transactionConversor: Transaction
            transactionConversor = converter.converts(transaction.originCurrency,transaction.targetCurrency)

            transaction.conversionRate = transactionConversor.conversionRate
            transaction.create_at = LocalDateTime.now()
            return repository.save(transaction)
        }catch (e: NullPointerException){
            throw java.lang.NullPointerException()
        }
    }
}