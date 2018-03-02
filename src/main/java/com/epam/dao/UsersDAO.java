package com.epam.dao;

import com.epam.models.User;
import com.epam.services.handlers.Statuses;

import java.util.*;
import java.util.stream.Collectors;

public class UsersDAO {
    private static List<User> userList;
    private static long idCounter;
    private static Map<Long, User> usersOnline;

    static {
        usersOnline = new HashMap<>();
        idCounter = 0;
        userList = new ArrayList<>();
        userList.add(new User(idCounter++, "Max", "Max", new String[]{"Admin", "User", "VIP"}));
        userList.add(new User(idCounter++, "Admin", "Admin", new String[]{"Admin"}));
        userList.add(new User(idCounter++, "User", "User", new String[]{"User"}));
        userList.add(new User(idCounter++, "test", "test", new String[]{"User", "VIP"}));
    }

    public static User getUserByLogin(String login) {
        try {
            return userList.stream().filter(u -> u.getLogin().equals(login)).findFirst().get();
        } catch (NoSuchElementException e) {
            return new User();
        }
    }

    public static User getUserById(long login) {
        try {
            return userList.stream().filter(u -> u.getId() == login).findFirst().get();
        } catch (NoSuchElementException e) {
            return new User();
        }
    }

    public static Long addUserToOnline(User user) {
        long authenticator = new Random().nextLong();
        usersOnline.put(authenticator, user);
        return authenticator;
    }

    public static User[] getAllUsers() {
        return userList.toArray(new User[]{});
    }

    public static User[] getUsersWithRole(String role) {
        return userList.stream().filter(u -> Arrays.asList(u.getRoles()).contains(role)).collect(Collectors.toList()).toArray(new User[]{});
    }

    public static String deleteUser(long authenticator, long userId) {
        User currentUser = usersOnline.get(authenticator);
        if (Objects.isNull(currentUser)) {
            return "Please authorize";
        } else if (Arrays.asList(currentUser.getRoles()).contains("Admin")) {
            User userToDelete = getUserById(userId);
            if (userToDelete.getId() == -1)
                return "No such user in System";
            else {
                userList.remove(getUserById(userId));
                usersOnline.values().removeAll(Collections.singleton(userToDelete));
                return Statuses.CONST_SUCCESS;
            }
        } else if (currentUser.getId() == userId) {
            userList.remove(getUserById(userId));
            usersOnline.remove(authenticator);
            return Statuses.CONST_SUCCESS;
        } else
            return "You have no permission for delete this user";
    }

}
