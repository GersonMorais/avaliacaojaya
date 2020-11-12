package com.projeto.currencyconverter.service

import com.projeto.currencyconverter.entities.Transaction
import com.projeto.currencyconverter.repositories.TransactionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TransactionService {
    @Autowired
    lateinit var repository: TransactionRepository

    fun transactionsByUserid(userId: Long):List<Transaction>{
//        lateinit var repository : TransactionRepository
        var transaction = repository.findUserId(userId)
        return transaction

    }

//    fun create()
}