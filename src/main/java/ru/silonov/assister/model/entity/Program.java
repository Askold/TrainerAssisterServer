package ru.silonov.assister.model.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;


@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    int client;
    int durationInWeeks;
    int workoutsPerWeek;
    String description;
    String type;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Program program = (Program) o;
        return id == program.id && client == program.client && durationInWeeks == program.durationInWeeks && workoutsPerWeek == program.workoutsPerWeek && Objects.equals(description, program.description) && Objects.equals(type, program.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, durationInWeeks, workoutsPerWeek, description, type);
    }

    @Override
    public String toString() {
        return "Program{" +
                "id=" + id +
                ", client=" + client +
                ", durationInWeeks=" + durationInWeeks +
                ", workoutsPerWeek=" + workoutsPerWeek +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
