package com.epam.services.handlers;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Response")
public class Response {

    @XmlElement(name = "Status")
    String status;

    @XmlElement(name = "Value")
    Object value;

    public Response() {
    }

    public Response(String status, Object value) {
        this.status = status;
        this.value = value;
    }
}
