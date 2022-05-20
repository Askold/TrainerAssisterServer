package ru.silonov.assister.model.dto;

public class WorkoutDto {
    private int id;
    private String name;
    private int program;

    public WorkoutDto() {
    }

    public WorkoutDto(int id, String name, int program) {
        this.id = id;
        this.name = name;
        this.program = program;
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

    public int getProgram() {
        return program;
    }

    public void setProgram(int program) {
        this.program = program;
    }
}
