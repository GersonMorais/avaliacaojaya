package com.projeto.currencyconverter.exceptions

import java.time.LocalDateTime
import java.util.*

class ErrorMessage {
    var currentDate : LocalDateTime = LocalDateTime.now()
    var message : String = ""

    fun errorMessage (currentDate : LocalDateTime, message : String){
        this.currentDate = currentDate
        this.message = message
    }
}