package com.example.thymeleafpdfapi.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView

@Controller("/template")
class TemplatesController {

    @GetMapping("/hello")
    fun hello(@RequestParam(name = "name", required = true) name: String): ModelAndView {
        return ModelAndView("/hello")
            .addObject("name", name)
    }

    @GetMapping("/hello-css")
    fun helloCss(@RequestParam(name = "name", required = true) name: String): ModelAndView {
        return ModelAndView("/hello-css")
            .addObject("name", name)
    }


    @GetMapping("/report")
    fun report(): ModelAndView {
        return ModelAndView("/report")
            .addObject("reportData", getReportData())
    }

    private fun getReportData(): Any? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}