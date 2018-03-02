package com.epam.services.handlers;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Response")
public abstract class Response {

    @XmlElement(name = "status")
    protected String status;
    @XmlElement(name = "info")
    protected String info;

}
