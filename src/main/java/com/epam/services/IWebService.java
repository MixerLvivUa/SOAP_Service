package com.epam.services;

import com.epam.services.handlers.MessageResponse;
import com.epam.services.handlers.UserResponse;
import com.epam.services.handlers.UsersResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface IWebService {
    @WebMethod
    @WebResult(name = "result")
    MessageResponse getTest(@WebParam(name = "inputTest") String test);

    @WebMethod
    @WebResult(name = "result")
    UserResponse authorize(@WebParam(name = "login") String login, @WebParam(name = "password") String password);

    @WebMethod
    @WebResult(name = "result")
    UsersResponse getAllUsers();

    @WebMethod
    @WebResult(name = "result")
    UsersResponse getUsersByRole(@WebParam(name = "role") String role);

    @WebMethod
    @WebResult(name = "result")
    MessageResponse deleteUser(@WebParam(name = "authenticator") long authenticator, @WebParam(name = "userId") long userId);
}
