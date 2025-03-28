package com.example.myapplication.Lab11;

public class TraineeRepository {
    public static TraineeRepository getTraineeService() {
        return (TraineeRepository) APIClient.getClient().create(TraineeService.class);
    }
}
