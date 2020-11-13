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
        var teste : Int = 1
        if(teste == 1){
            throw Exception("TESTETESTETESTE")
        }else{
            return repository.findAll()
        }


    }

    @GetMapping("/{userId}")
    fun index(@PathVariable("userId") userId: Long): List<Transaction>{
//        require(userId>1){ "ErrorMessage"}
        var listIds : ArrayList<Long> = ArrayList()
        listIds.add(userId)
        return repository.findUserId(userId)

    }

    @PostMapping
    fun create(@RequestBody transaction: Transaction): Transaction {
        var listCurrency = listOf("USD","BRL","EUR","JPY")
        if(!listCurrency.contains(transaction.originCurrency)){
            throw Exception("The currency of origin is not valid")
//            return ResponseEntity.badRequest().body<>(Error(""))

        }
        try {
            var converter: Converter = Converter()
            var transactionConversor: Transaction
            transactionConversor = converter.converts(transaction.originCurrency,transaction.targetCurrency)

            transaction.conversionRate = transactionConversor.conversionRate
            transaction.create_at = LocalDateTime.now()
            return repository.save(transaction)
        }catch (e: Exception){
//            return ResponseEntity.notFound().build()
            throw Exception("An error occurred while storing data")
        }

    }


}