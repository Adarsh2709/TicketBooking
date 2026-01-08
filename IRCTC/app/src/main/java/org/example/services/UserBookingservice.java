package org.example.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entities.User;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class UserBookingservice {
    private User user;

    private List<User> userList;

    private ObjectMapper objectmapper = new ObjectMapper();

    private static final String USER_PATH = "../localDb/users.json";

    public UserBookingservice(User user)throws IOException {
        this.user = user;
        File users = new File(USER_PATH);
        userList = objectmapper.readValue(users, new TypeReference<List<User>>() {
        });
    }
    public Boolean loginUser(){
        Optional<User> foundUser = userList.stream().filter(user1 -> {
            return user1.getName().equals(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(), user1.getHashedPassword());
        }).findFirst();
        return foundUser.isPresent();
    }

    public Boolean signUp(User user1){
        try{
            userList.add(user1);
            saveUserListToFile();
            return Boolean.TRUE;
        }catch (IOException ex){
            return Boolean.FALSE;
        }
    }
}
