package ru.soap.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.soap.test.client.SoapClient;

/**
 * Created by rakhmetov on 05.12.16.
 */
@RestController
public class TestController {

    @Autowired
    private SoapClient soapClient;

    @GetMapping("/getSoap/{name}")
    public String getRequest(@PathVariable String name) {
        return soapClient.getResponse(name).getCountry().getCapital();
    }
}
