package ru.silonov.assister.model.dto;

public class TrainerDto extends UserDto{
    private int experience;

    public TrainerDto(long userId, String name, String surname, String login, String password, int experience) {
        super(userId, name, surname, login, password);
        this.experience = experience;
    }

    public TrainerDto(String name, String surname, String login, String password, int experience) {
        super(name, surname, login, password);
        this.experience = experience;
    }

    public TrainerDto() {
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
