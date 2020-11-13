package com.projeto.currencyconverter.exceptions

class ResourceNotFoundDetails {
    private var title : String = ""
    private var status : Int = 0
    private var detail : String = ""
    private var timestamp : Long = 0
    private var developerMessage : String = ""

    private fun ResourceNotFoundDetails(){
    }

    class Builder(){
        var title : String = ""
        var status : Int = 0
        var detail : String = ""
        var timestamp : Long = 0
        var developerMessage : String = ""

        private fun Builder(){
        }

        public fun newBuilder() : Builder{
            return ResourceNotFoundDetails.Builder()
        }
    }

}