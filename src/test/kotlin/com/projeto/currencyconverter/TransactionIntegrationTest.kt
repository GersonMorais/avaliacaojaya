package com.projeto.currencyconverter

import com.projeto.currencyconverter.controllers.TransactionController
import com.projeto.currencyconverter.service.TransactionService
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import io.restassured.module.mockmvc.RestAssuredMockMvc
import org.junit.Test
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.HttpStatus

@WebMvcTest
class TransactionIntegrationTest {
    @Autowired
    var controller = TransactionController()

    @MockBean
    var service = TransactionService()

    @BeforeEach
    fun before() {
        RestAssuredMockMvc.standaloneSetup(controller)
    }

    @Test
    fun `findAll with success`() {


        given()
                .accept(ContentType.JSON)
                .`when`()

                .get("/transactions").then().statusCode(HttpStatus.OK.value())

//        RestAssured
//                .given()
////                .param("page", "1")
////                .param("size", "20")
//                .`when`()
//                .get("/transactions")
//                .then()
//                .body("$", Matchers.hasSize<Int>(10))
//                .statusCode(HttpStatus.OK.value())
    }
}