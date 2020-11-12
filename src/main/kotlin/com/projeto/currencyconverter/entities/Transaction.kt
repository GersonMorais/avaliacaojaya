package com.projeto.currencyconverter.entities

import org.joda.time.DateTime
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
        var targetValue: Double = 0.0,
        var conversionRate: Double = 0.0
//        var create_at: DateTime

)