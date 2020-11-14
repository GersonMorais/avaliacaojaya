package com.projeto.currencyconverter

import com.projeto.currencyconverter.entities.Transaction
import com.projeto.currencyconverter.service.Converter
import com.projeto.currencyconverter.service.TransactionService
import io.mockk.every
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import org.junit.Assert
import org.junit.Test
import org.springframework.boot.devtools.restart.FailureHandler
import java.time.LocalDateTime


class TransactionUnitTest {
    private val repository = mockk<TransactionService>()
    private val transaction = mockk<Transaction>()

    @Test
    fun shouldBeAbleToReceiveSuccess_whenCalculateConversion(){

        every { transaction.conversionRate } returns 0.84
        every { transaction.originValue } returns 10.0
        every { transaction.originCurrency } returns "USD"
        every { transaction.targetCurrency } returns "EUR"

        assertEquals(8.4,calculeConversion())

    }

    @Test
    fun shouldBeAbleToReceiveErro_whenCalculateConversion(){

        every { transaction.conversionRate } returns 0.0
        every { transaction.originValue } returns 10.0
        every { transaction.originCurrency } returns "USD"
        every { transaction.targetCurrency } returns "EUR"

        assertEquals(8.4,calculeConversion())

    }

    fun calculeConversion() = transaction.originValue * transaction.conversionRate
}