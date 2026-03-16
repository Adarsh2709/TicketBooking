package org.example.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class Ticket {
    @JsonProperty("ticket_id")
    private String ticketId;
    @JsonProperty("user_id")
    private String userId;
    private String source;
    private String destination;
    @JsonProperty("date_of_travel")
    private Date dateOfTravel;
    private Train train;

    public Ticket(String ticketId, String userId, String source, String destination, Date dateOfTravel, Train train) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.source = source;
        this.destination = destination;
        this.dateOfTravel = dateOfTravel;
        this.train = train;
    }

    public Ticket() {}

    @JsonProperty("ticket_id")
    public String getTicketId() {
        return ticketId;
    }

    @JsonProperty("user_id")
    public String getUserId() {
        return userId;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    @JsonProperty("date_of_travel")
    public Date getDateOfTravel() {
        return dateOfTravel;
    }

    public Train getTrain() {
        return train;
    }

    public void setTicket_Id(String ticket_Id) {
        this.ticketId = ticket_Id;
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
        return String.format("Ticket Id:%s belongs to User %s from %s to %s on %s",ticketId,userId,source,destination,dateOfTravel);
    }


}
