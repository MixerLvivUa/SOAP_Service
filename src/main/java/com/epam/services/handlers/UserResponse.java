package com.epam.services.handlers;

import com.epam.models.User;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class UserResponse extends Response {
    @XmlElement(name = "value")
    private User value;
    @XmlElement(name = "authenticator")
    private Long authenticator;

    public UserResponse() {
    }

    public UserResponse(String status, String info) {
        this.status = status;
        this.info = info;
    }

    public UserResponse(String status, User user, Long authenticator) {
        this.status = status;
        this.value = user;
        this.authenticator = authenticator;
    }
}
