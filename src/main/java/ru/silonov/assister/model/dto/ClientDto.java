package ru.silonov.assister.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class ClientDto extends UserDto{
    private int age;
    private int weight;
    private int height;

    public ClientDto() {

    }

    public ClientDto(int userId, String name, String surname, String login, String password, int age, int weight, int height) {
        super(userId, name, surname, login, password);
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
