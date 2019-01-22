package com.example.thymeleafpdfapi.builder

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException
import org.thymeleaf.TemplateEngine
import org.thymeleaf.context.Context
import org.w3c.tidy.Tidy
import org.xhtmlrenderer.pdf.ITextRenderer
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.util.*

@Component
class PDFBuilder(
    private val templateEngine: TemplateEngine
) {

    private val UTF_8 = "UTF-8"

    fun createPdfFromThymeleafTemplate(templateName: String, variables: Map<String, Any>): ByteArray {

        val context = Context(Locale("pt-BR"))

        variables.entries.forEach { e -> context.setVariable(e.key, e.value) }

        return try {
            val html = this.templateEngine.process(templateName, context)
            createPdfFromHtml(html)
        } catch (e: Exception) {
            //TODO: NEED FIX THIS EXCEPTION HANDLE.
            e.printStackTrace()
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Template not found"
            )
        }

    }

    private fun createPdfFromHtml(html: String): ByteArray {
        val xHtml = convertToXhtml(html)
        val output = ByteArrayOutputStream()
        val renderer = ITextRenderer()
        renderer.setDocumentFromString(xHtml)
        renderer.layout()
        renderer.createPDF(output)
        return output.toByteArray()
    }

    private fun convertToXhtml(html: String): String {
        val tidy = Tidy()
        tidy.inputEncoding = UTF_8
        tidy.outputEncoding = UTF_8
        tidy.xhtml = true
        val inputStream = ByteArrayInputStream(html.toByteArray(Charsets.UTF_8))
        val outputStream = ByteArrayOutputStream()
        tidy.parseDOM(inputStream, outputStream)
        return outputStream.toString(UTF_8)
    }

}