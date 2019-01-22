package com.example.thymeleafpdfapi.controller

import com.example.thymeleafpdfapi.builder.PDFBuilder
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PDFController(
    val pdfBuilder: PDFBuilder
) {

    @PostMapping("/pdf/hello/{name}", MediaType.APPLICATION_PDF_VALUE)
    fun hello(@PathVariable name: String): ResponseEntity<ByteArray> {

        val pdf = pdfBuilder.createPdfFromThymeleafTemplate(
            templateName = "hello",
            variables = mutableMapOf("name" to name)
        )

        return ResponseEntity
            .ok()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
            .body(pdf)
    }

    @PostMapping("/pdf/hello/css/{name}", MediaType.APPLICATION_PDF_VALUE)
    fun helloWithCss(@PathVariable name: String): ResponseEntity<ByteArray> {

        val pdf = pdfBuilder.createPdfFromThymeleafTemplate(
            templateName = "hello-css",
            variables = mutableMapOf("name" to name)
        )

        return ResponseEntity
            .ok()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
            .body(pdf)
    }

    @PostMapping("/report}", MediaType.APPLICATION_PDF_VALUE)
    fun report(): ResponseEntity<ByteArray> {
        TODO("Need Request Body, etc...")
    }

}