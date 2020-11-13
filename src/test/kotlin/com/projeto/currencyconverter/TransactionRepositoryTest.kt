package com.projeto.currencyconverter

import com.projeto.currencyconverter.entities.Transaction
import com.projeto.currencyconverter.repositories.TransactionRepository
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import java.time.LocalDateTime

class TransactionRepositoryTest {

//    lateinit var repo : TransactionRepository

    @Test
    fun shouldShowSimpleAssertion(){
        Assertions.assertEquals(1,1)
    }

//    @Test
//    fun createShouldPersistData(){
//
//        var transaction: Transaction = Transaction(
//                0,
//                1,
//                "BRL",
//                1.0,
//                "USD",
//                1.0,
//                1.0,
//                LocalDateTime.now()
//        )
//        repo.save(transaction)
//        Assertions.assertNotNull(transaction.id)
//    }
}