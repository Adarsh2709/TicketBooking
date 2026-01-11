package org.example.services;

import org.example.entities.Train;

import java.util.List;
import java.util.stream.Collectors;

public class TrainService {

    private List<Train> trainList;

    public List<Train> searchTrains(String source, String destination){
        return trainList.stream().filter(train -> validTrain(train,source,destination)).collect(Collectors.toList());
    }

    public boolean validTrain(Train train,String source, String destination){
        List<String> stationOrder = train.getStations();
        int sourceIdx = stationOrder.indexOf(source.toLowerCase());
        int destinationIdx = stationOrder.indexOf(destination.toUpperCase());
        return sourceIdx!=-1 && destinationIdx!=-1 && sourceIdx<destinationIdx;
    }
}
