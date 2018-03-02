package com.epam.services;

import com.epam.services.handlers.Response;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "com.epam.services.IWebService")
public class UserService implements IWebService {

    @WebMethod
    public Response getTest(String test) {
        return new Response("Success", String.format("Test input: %s", test));
    }
}
