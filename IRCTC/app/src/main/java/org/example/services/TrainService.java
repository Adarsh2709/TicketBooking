package org.example.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entities.Train;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TrainService {

    private List<Train> trainList;
    private ObjectMapper objectmapper = new ObjectMapper();
    private static final String TRAIN_DB_PATH = "org/example/localDb/trains.json";

    public TrainService() throws Exception{
        loadTrains();
    }

    public List<Train> loadTrains() throws IOException {
        File trains = new File(TRAIN_DB_PATH);
        return objectmapper.readValue(trains, new TypeReference<List<Train>>(){});
    }

    public List<Train> searchTrains(String source, String destination){
        return trainList.stream().filter(train -> validTrain(train,source,destination)).collect(Collectors.toList());
    }

    public boolean validTrain(Train train,String source, String destination){
        List<String> stationOrder = train.getStations();
        int sourceIdx = stationOrder.indexOf(source.toLowerCase());
        int destinationIdx = stationOrder.indexOf(destination.toUpperCase());
        return sourceIdx!=-1 && destinationIdx!=-1 && sourceIdx<destinationIdx;
    }

    public void addTrain(Train newTrain) throws IOException {
        Optional<Train> existingTrain = trainList.stream().filter(train -> train.getTrainId().equalsIgnoreCase(newTrain.getTrainId())).findFirst();
        if(existingTrain.isPresent()){
            updateTrain(newTrain);
        }
        else{
            trainList.add(newTrain);
            saveTrainListToFile();
        }
    }

    public void updateTrain(Train uptrain) throws IOException {
            OptionalInt index = IntStream.range(0,trainList.size())
                    .filter(i -> trainList.get(i).getTrainId().equalsIgnoreCase(uptrain.getTrainId()))
                    .findFirst();

            if(index.isPresent()){
                trainList.set(index.getAsInt(), uptrain);
                saveTrainListToFile();
            }
            else {
                addTrain(uptrain);
            }
    }

    public void saveTrainListToFile() throws IOException {
        objectmapper.writeValue(new File(TRAIN_DB_PATH),trainList);
    }
}
