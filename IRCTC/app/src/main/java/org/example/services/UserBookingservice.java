package org.example.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Utils.UserServiceUtil;
import org.example.entities.Train;
import org.example.entities.User;
import org.jspecify.annotations.NonNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UserBookingservice {
    private User user;

    private List<User> userList;

    private ObjectMapper objectmapper = new ObjectMapper();

    private static final String USER_PATH = "java/org/example/entities/User.java";

    public UserBookingservice(User user)throws IOException {
        this.user = user;
        loadUsers();
    }

    public UserBookingservice() throws IOException{
        loadUsers();
    }

    public List<User> loadUsers() throws IOException{
        File users = new File(USER_PATH);
        return objectmapper.readValue(users, new TypeReference<List<User>>(){});
    }

    public Boolean loginUser(){
        Optional<User> foundUser = userList.stream().filter(user1 -> {
            return user1.getName().equalsIgnoreCase(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(), user1.getHashedPassword());
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

    private void saveUserListToFile()throws IOException {
        File userFile = new File(USER_PATH);
        objectmapper.writeValue(userFile,userList);
    }


    public void fetchBooking(){
        Optional<User> userfetched = userList.stream().filter(user1->{
            return user1.getName().equalsIgnoreCase(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(), user1.getHashedPassword());
        }).findFirst();
        if(userfetched.isPresent()){
            userfetched.get().Printticktes();
        }
    }

    public boolean CancleBooking(String ticketId){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your TicketId");
        String str = sc.next();

        if(str.isEmpty()){
            System.out.println("Dont have any such Id to cancle");
            return Boolean.FALSE;
        }
        String finalTicketId1 = ticketId;
        boolean removed = user.getTicketsBooked().removeIf(ticket -> ticket.getTicketId().equals(finalTicketId1));
        if (removed) {
            System.out.println("Ticket with ID " + ticketId + " has been canceled.");
            return Boolean.TRUE;
        }else{
            System.out.println("No ticket found with ID " + ticketId);
            return Boolean.FALSE;
        }
    }

    public List<Train> getTrains(String source, String destinations){
        try{
            TrainService trainService = new TrainService();
            return trainService.searchTrains(source,destinations);
        }
        catch (Exception e){
            return new ArrayList<>();
        }
    }


    public List<List<Integer>> fetchSeats(Train train){
        return train.getSeats();
    }

    public Boolean bookTrainSeat(Train train,int row, int seat){
        try{
            TrainService trainService = new TrainService();
            List<List<Integer>> seats = train.getSeats();
            if(row>=0 && row<seats.size() && seat>=0 && seat < seats.get(row).size()){
                if(seats.get(row).get(seat)==0){
                    seats.get(row).set(seat,1);
                    train.setSeats(seats);
                    trainService.addTrain(train);
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return  false;
            }
        }
        catch(Exception ex){
            return Boolean.FALSE;
        }

    }


}
