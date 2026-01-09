package org.example.entities;

import java.util.Date;

public class Ticket {
    private String ticket_Id;
    private String userId;
    private String source;
    private String destination;
    private Date dateOfTravel;
    private Train train;

    public Ticket(String ticket_Id, String userId, String source, String destination, Date dateOfTravel, Train train) {
        this.ticket_Id = ticket_Id;
        this.userId = userId;
        this.source = source;
        this.destination = destination;
        this.dateOfTravel = dateOfTravel;
        this.train = train;
    }

    public String getTicket_Id() {
        return ticket_Id;
    }

    public String getUserId() {
        return userId;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public Date getDateOfTravel() {
        return dateOfTravel;
    }

    public Train getTrain() {
        return train;
    }

    public void setTicket_Id(String ticket_Id) {
        this.ticket_Id = ticket_Id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDateOfTravel(Date dateOfTravel) {
        this.dateOfTravel = dateOfTravel;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public String getTicketInfo(){
        return String.format("Ticket Id:%s belongs to User %s from %s to %s on %s",ticket_Id,userId,source,destination,dateOfTravel);
    }


}
