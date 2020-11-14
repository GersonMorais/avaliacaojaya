package com.projeto.currencyconverter

import com.projeto.currencyconverter.entities.Transaction
import com.projeto.currencyconverter.service.TransactionService
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert
import org.junit.Test
import org.springframework.boot.devtools.restart.FailureHandler
import java.time.LocalDateTime


class TransactionUnitTest {
    private val repository = mockk<TransactionService>()
    @Test
    fun shouldBeAbleToCreateTransaction(){
        val transaction = Transaction(
                1,
                1,
                "USD",
                20.0,
                "EUR",
                10.0,
                1.0,
                LocalDateTime.now()
        )
        every { repository.create(any<Transaction>()) } returns transaction
//                Mono.just(transaction)

//        val service = TransactionService()
//        val transCreated = service.create(transaction)
//        Assert.assertEquals(transaction,transCreated)
    }

    fun shouldBeAbleToCalculeRate(){

    }
}