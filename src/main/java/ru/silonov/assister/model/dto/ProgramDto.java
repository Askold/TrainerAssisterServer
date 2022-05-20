package ru.silonov.assister.model.dto;

import ru.silonov.assister.model.entity.Client;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ProgramDto {
    int id;
    int client;
    int durationInWeeks;
    int workoutsPerWeek;
    String description;
    String type;

    public ProgramDto(int id, int client, int durationInWeeks, int workoutsPerWeek, String description, String type) {
        this.id = id;
        this.client = client;
        this.durationInWeeks = durationInWeeks;
        this.workoutsPerWeek = workoutsPerWeek;
        this.description = description;
        this.type = type;
    }

    public ProgramDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public int getDurationInWeeks() {
        return durationInWeeks;
    }

    public void setDurationInWeeks(int durationInWeeks) {
        this.durationInWeeks = durationInWeeks;
    }

    public int getWorkoutsPerWeek() {
        return workoutsPerWeek;
    }

    public void setWorkoutsPerWeek(int workoutsPerWeek) {
        this.workoutsPerWeek = workoutsPerWeek;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ProgramDto{" +
                "id=" + id +
                ", client=" + client +
                ", durationInWeeks=" + durationInWeeks +
                ", workoutsPerWeek=" + workoutsPerWeek +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
