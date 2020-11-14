package com.projeto.currencyconverter.service

import com.projeto.currencyconverter.entities.Transaction

class FieldValidatorService {
    fun validator(transaction : Transaction) : String{
        var listCurrency = listOf("USD","BRL","EUR","JPY")

        //checks if the origin currency is valid
        if(!listCurrency.contains(transaction.originCurrency)){
            return "The currency of origin is not valid"
        }

        //checks if the target currency is valid
        if(!listCurrency.contains(transaction.targetCurrency)){
            return "The currency of target is not valid"
        }

        //checks whether the source value has been entered
        if(transaction.originValue <= 0.0){
            return "No origin value was found in the request body"
        }

        return ""
    }
}