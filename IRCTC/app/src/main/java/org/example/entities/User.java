package org.example.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class User {
    private String name;
    private String password;
    @JsonProperty("hashed_password")
    private String hashedpassword;
    @JsonProperty("tickets_booked")
    private List<Ticket> ticketsBooked;
    @JsonProperty("user_id")
    private String userId;

    public User(String name, String password, String hashedpassword, List<Ticket> ticketsBooked, String userId) {
        this.name = name;
        this.password = password;
        this.hashedpassword = hashedpassword;
        this.ticketsBooked = ticketsBooked;
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
        return ticketsBooked;
    }

    public String getUserId() {
        return userId;
    }

    public void Printticktes(){
        for(int i=0; i<ticketsBooked.size(); i++){
            System.out.println(ticketsBooked.get(i).getTicketInfo());
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

    public void setTicketsBooked(List<Ticket> ticketsBooked) {
        this.ticketsBooked = ticketsBooked;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
