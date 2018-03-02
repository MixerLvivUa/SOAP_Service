package com.epam.services.handlers;

import com.epam.models.User;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class UsersResponse extends Response {
    @XmlElement(name = "value")
    private User[] value;

    public UsersResponse() {
    }

    public UsersResponse(String status, String info) {
        this.status = status;
        this.info = info;
    }

    public UsersResponse(String status, User[] user) {
        this.status = status;
        this.value = user;
    }
}
