package com.epam.services;

import com.epam.dao.UsersDAO;
import com.epam.models.User;
import com.epam.services.handlers.MessageResponse;
import com.epam.services.handlers.Statuses;
import com.epam.services.handlers.UserResponse;
import com.epam.services.handlers.UsersResponse;

import javax.jws.WebService;


@WebService(endpointInterface = "com.epam.services.IWebService")
public class UserService implements IWebService {

    public MessageResponse getTest(String test) {
        return new MessageResponse("Success", String.format("Test input: %s", test));
    }

    public UserResponse authorize(String login, String password) {
        try {
            User user = UsersDAO.getUserByLogin(login);
            if (user.getLogin().equals("none"))
                return new UserResponse(Statuses.CONST_WARNING, "Wrong login");
            else if (!user.getPassword().equals(password))
                return new UserResponse(Statuses.CONST_WARNING, "Wrong password");
            else
                return new UserResponse(Statuses.CONST_SUCCESS, user, UsersDAO.addUserToOnline(user));
        } catch (Exception e) {
            return new UserResponse(Statuses.CONST_ERROR, e.getMessage());
        }
    }

    public UsersResponse getAllUsers() {
        try {
            return new UsersResponse(Statuses.CONST_SUCCESS, UsersDAO.getAllUsers());
        } catch (Exception e) {
            return new UsersResponse(Statuses.CONST_ERROR, e.getMessage());
        }
    }

    public UsersResponse getUsersByRole(String role) {
        try {
            return new UsersResponse(Statuses.CONST_SUCCESS, UsersDAO.getUsersWithRole(role));
        } catch (Exception e) {
            return new UsersResponse(Statuses.CONST_ERROR, e.getMessage());
        }
    }


    public MessageResponse deleteUser(long authenticator, long userId) {
        try {
            String ans = UsersDAO.deleteUser(authenticator, userId);
            if (ans.equals(Statuses.CONST_SUCCESS))
                return new MessageResponse(Statuses.CONST_SUCCESS, null);
            else
                return new MessageResponse(Statuses.CONST_WARNING, null, ans);
        } catch (Exception e) {
            return new MessageResponse(Statuses.CONST_ERROR, null, e.getMessage());
        }
    }
}
