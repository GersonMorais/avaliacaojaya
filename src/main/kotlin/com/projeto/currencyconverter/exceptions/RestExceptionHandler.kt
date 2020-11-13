package com.projeto.currencyconverter.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.util.MultiValueMap
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class RestExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [ (Exception::class) ])
    fun handleAnyException(e : Exception, request : WebRequest) : ResponseEntity<ErrorMessage>{

        var errorMessage = ErrorMessage()
        errorMessage.errorMessage(e.message.toString())
        return ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST)
    }
}