package com.projeto.currencyconverter.exceptions

import java.time.LocalDateTime
import java.util.*

class ErrorMessage {
    var currentDate : LocalDateTime = LocalDateTime.now()
    var message : String = ""

    fun errorMessage (message : String){
        this.message = message
    }
}