package com.projeto.currencyconverter.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException

@ResponseStatus(HttpStatus.NOT_FOUND)
class ResourceNotFoundException : RuntimeException(){
    override var message : String = ""
    fun ResourceNotFoundException(message : String) : String{
        return message
    }
}