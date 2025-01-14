package com.ipso.skiservicebackend.controller;

import com.ipso.skiservicebackend.model.MyModel;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = MyModel.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found", content = @Content)}) // @formatter:on
    @GetMapping(value = "/api/myModel")
    public MyModel getMyModel() {
        // MyModel Objekts aus einem Service oder einer Datenbank beinhalten.
//        return MyModel.builder().property1("prop1").property2("prop2").build();
        MyModel model = new MyModel();
        model.property1 = "1";
        model.property2 = "1";
        return model;
    }

    // Sie können ähnliche Methoden für POST, PUT, DELETE, etc. erstellen.
}