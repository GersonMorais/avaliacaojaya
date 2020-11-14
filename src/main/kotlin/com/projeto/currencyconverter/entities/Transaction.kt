package com.projeto.currencyconverter.entities

import com.fasterxml.jackson.annotation.JsonInclude
import io.swagger.annotations.ApiModelProperty
import io.swagger.annotations.ApiParam
import org.jetbrains.annotations.NotNull
import org.joda.time.DateTime
import springfox.documentation.annotations.ApiIgnore
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*
@ApiIgnore
@Entity
@Table(name = "transactions")
class Transaction (

        @field:Id
        @field:GeneratedValue(strategy = GenerationType.IDENTITY)
        @ApiModelProperty(hidden = true)
        val id: Long,

        var userId: Long = 0,

        var originCurrency: String = "",

        var originValue: Double = 0.0,

        var targetCurrency: String = "",

        @JsonInclude()
        @Transient
        @ApiModelProperty(hidden = true)
        var targetValue: Double = 0.0,

        @ApiModelProperty(hidden = true)
        var conversionRate: Double = 0.0,

        @ApiModelProperty(hidden = true)
        var create_at: LocalDateTime = LocalDateTime.now()

)