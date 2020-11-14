package com.projeto.currencyconverter.service

import com.projeto.currencyconverter.entities.Transaction
import com.projeto.currencyconverter.exceptions.NotFoundException
import com.projeto.currencyconverter.exceptions.ValidationException
import com.projeto.currencyconverter.repositories.TransactionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.client.HttpClientErrorException
import java.time.LocalDateTime

@Service
class TransactionService() {
    @Autowired
    lateinit var repository: TransactionRepository

    fun findAll(): List<Transaction>{

        var transactions : List<Transaction> = repository.findAll()
        if(transactions.count() === 0){
            throw NotFoundException("Not transactions found.")
        }
        return transactions

    }

    fun findIdUser(userId: Long): List<Transaction>{
        var transactions : List<Transaction> = repository.findUserId(userId)
        if(transactions.count() === 0){
            throw NotFoundException("Not transactions found. Search for a valid idUser.")
        }
        return transactions
    }

    fun create(transaction: Transaction): Transaction {

        // Validator of rules for sent fields
        var fieldValidatorService : FieldValidatorService = FieldValidatorService()
        var erroReturnValidator = fieldValidatorService.validator(transaction)
        if(!erroReturnValidator.isEmpty()){
            throw ValidationException(erroReturnValidator)
        }

        // Converts the amount sent by the rate and saves it from the database
        var converter: Converter = Converter()
        var transactionConversor: Transaction
        transactionConversor = converter.converts(transaction)

        return repository.save(transactionConversor)

    }
}