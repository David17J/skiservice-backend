package com.ipso.skiservicebackend.controller;

import com.ipso.skiservicebackend.model.MyModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping(value = "/api/myModel", method = RequestMethod.GET)
    @ApiOperation(value = "Returns a hello message")// Ihre Implementierung hier, dies könnte die Rückgabe eines
    public MyModel getMyModel() {
        // MyModel Objekts aus einem Service oder einer Datenbank beinhalten.
        return new MyModel();
    }

    // Sie können ähnliche Methoden für POST, PUT, DELETE, etc. erstellen.
}