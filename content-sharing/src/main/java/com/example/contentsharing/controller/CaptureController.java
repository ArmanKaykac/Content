package com.example.contentsharing.controller;

import com.example.contentsharing.selenium.SeleniumTest;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://172.24.135.92:4200", maxAge = 3600L, allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class CaptureController {

    @GetMapping("/getObisCapture")
    public String convertToBase64(@RequestParam(value = "url") String url) throws InterruptedException {

        SeleniumTest seleniumTest = new SeleniumTest();

        return seleniumTest.CaptureScreen(url);
    }
}
