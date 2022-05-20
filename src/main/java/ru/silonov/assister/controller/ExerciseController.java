package ru.silonov.assister.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import ru.silonov.assister.dao.DataProvider;
import ru.silonov.assister.model.dto.ExerciseDto;
import ru.silonov.assister.model.dto.WorkoutDto;
import ru.silonov.assister.model.entity.Exercise;
import ru.silonov.assister.model.entity.Workout;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    private static final DataProvider dataProvider = new DataProvider();
    private static final Logger logger = LogManager.getLogger(ExerciseController.class);

    @PostMapping("/new")
    public ExerciseDto newProgram(@RequestBody ExerciseDto exerciseDto) {
        Exercise exercise = new Exercise();
        exercise.setName(exerciseDto.getName());
        exercise.setDescription(exerciseDto.getDescription());
        exercise.setVideo(exerciseDto.getVideo());

        if(!dataProvider.insert(exercise)){
            return null;
        }
        exerciseDto.setId(exercise.getId());
        return exerciseDto;
    }

    @GetMapping("/all")
    public List<String> getAllExercises(){
        List<String> arrayList = new ArrayList<>();
        List<Exercise> exercises = dataProvider.selectAllExercises();
        for (Exercise exercise:exercises){
            arrayList.add(exercise.getName());
        }
        System.out.println(exercises);
        System.out.println(arrayList);
        return arrayList;
    }

    @GetMapping("/get/{name}")
    public Exercise getExerciseByName(@PathVariable String name){
        return dataProvider.getExerciseByName(name);
    }
}
