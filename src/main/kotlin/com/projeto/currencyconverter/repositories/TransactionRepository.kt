package com.projeto.currencyconverter.repositories

import com.projeto.currencyconverter.entities.Transaction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface TransactionRepository: JpaRepository<Transaction, Long>{

    @Query(value = "select * from transactions where user_id = ?1", nativeQuery = true)
    fun findUserId(userId: Long): List<Transaction>

}