package ru.silonov.assister.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class SingleExerciseDto implements Serializable {
    private int id;
    private int workoutId;
    private String exercise;
    private int weight;
    private int repetitions;
    private int rounds;

    public int getId() {
        return id;
    }

    public int getWorkoutId() {
        return workoutId;
    }

    public String getExercise() {
        return exercise;
    }

    public int getWeight() {
        return weight;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public int getRounds() {
        return rounds;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWorkoutId(int workoutId) {
        this.workoutId = workoutId;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }
}
