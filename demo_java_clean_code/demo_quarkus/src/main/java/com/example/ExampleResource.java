package com.example;

import com.example.service.BirthdayGreeter;
import com.example.service.BirthdayGreeterImpl;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

    @Named("type1")
    @Inject
    private BirthdayGreeter birthdayGreeter;

    /*public ExampleResource(BirthdayGreeterImpl birthdayGreeter) {
        this.birthdayGreeter = birthdayGreeter;
    }*/
    public ExampleResource() {

    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }
}
