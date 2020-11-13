package com.projeto.currencyconverter.entities

import com.fasterxml.jackson.annotation.JsonInclude
import org.joda.time.DateTime
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "transactions")
class Transaction (

        @field:Id
        @field:GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        var userId: Long = 0,

        var originCurrency: String = "",

        var originValue: Double = 0.0,

        var targetCurrency: String = "",

        @JsonInclude()
        @Transient
        var targetValue: Double = 0.0,

        var conversionRate: Double = 0.0,

        var create_at: LocalDateTime = LocalDateTime.now()

)