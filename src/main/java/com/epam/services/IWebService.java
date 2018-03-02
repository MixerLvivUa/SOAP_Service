package com.epam.services;

import com.epam.services.handlers.Response;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface IWebService {
    Response getTest(String test);
}
