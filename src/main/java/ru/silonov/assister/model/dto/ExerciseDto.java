package ru.silonov.assister.model.dto;

public class ExerciseDto {
    private int id;
    private String name;
    private String description;
    private String video;

    public ExerciseDto(int id, String name, String description, String video) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.video = video;
    }

    public ExerciseDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
