package com.epam.models;

import javax.xml.bind.annotation.XmlElement;


public class User {
    @XmlElement(name = "userId")
    private long id;
    @XmlElement(name = "login")
    private String login;
    @XmlElement(name = "password")
    private String password;
    @XmlElement(name = "roles")
    private String[] roles;

    public User() {
        id = -1;
        login = "none";
        password = "none";
    }

    public User(long id, String login, String password, String[] roles) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String[] getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return String.format(
                "User (id=%s, login=%s, password=%s)", id, login, password);
    }
}
