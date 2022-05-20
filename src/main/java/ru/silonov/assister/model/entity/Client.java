package ru.silonov.assister.model.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client")
public class Client extends User {
    @Basic
    private Integer age;
    @Basic
    private Integer weight;
    @Basic
    private Integer height;

    private int trainer;


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public int getTrainer() {
        return trainer;
    }

    public void setTrainer(int trainer) {
        this.trainer = trainer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(age, client.age) && Objects.equals(weight, client.weight) && Objects.equals(height, client.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, weight, height);
    }

    @Override
    public String toString() {
        return "Client{" +
                "age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}
