package org.example.entities;

import java.util.List;

public class User {
    private String name;
    private String password;
    private String hashedpassword;
    private List<Ticket> ticktesBooked;

    private String userId;

    public User(String name, String password, String hashedpassword, List<Ticket> ticktesBooked, String userId) {
        this.name = name;
        this.password = password;
        this.hashedpassword = hashedpassword;
        this.ticktesBooked = ticktesBooked;
        this.userId = userId;
    }

    public User(){}

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getHashedPassword() {
        return hashedpassword;
    }

    public List<Ticket> getTicketsBooked() {
        return ticktesBooked;
    }

    public String getUserId() {
        return userId;
    }

    public void Printticktes(){
        for(int i=0; i<ticktesBooked.size(); i++){
            System.out.println(ticktesBooked.get(i).getTicketInfo());
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHashedpassword(String hashedpassword) {
        this.hashedpassword = hashedpassword;
    }

    public void setTicktesBooked(List<Ticket> ticktesBooked) {
        this.ticktesBooked = ticktesBooked;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
