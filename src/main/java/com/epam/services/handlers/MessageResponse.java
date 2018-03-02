package com.epam.services.handlers;

import javax.xml.bind.annotation.XmlElement;

public class MessageResponse extends Response {
    @XmlElement(name = "value")
    String value;

    public MessageResponse(String status, String massage) {
        this.status = status;
        value = massage;
    }

    public MessageResponse(String status, String massage, String info) {
        this.status = status;
        value = massage;
        this.info = info;
    }
}
