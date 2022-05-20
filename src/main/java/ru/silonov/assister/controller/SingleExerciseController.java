package ru.silonov.assister.controller;

import org.springframework.web.bind.annotation.*;
import ru.silonov.assister.dao.DataProvider;
import ru.silonov.assister.model.dto.ExerciseDto;
import ru.silonov.assister.model.dto.SingleExerciseDto;
import ru.silonov.assister.model.entity.Exercise;
import ru.silonov.assister.model.entity.SingleExercise;

import java.util.List;

@RestController
@RequestMapping("/singleexercise")
public class SingleExerciseController {
    private static final DataProvider dataProvider = new DataProvider();

    @PostMapping("/new")
    public SingleExerciseDto newProgram(@RequestBody SingleExerciseDto exerciseDto) {
        SingleExercise exercise = new SingleExercise();
        exercise.setExercise(exerciseDto.getExercise());
        exercise.setWeight(exerciseDto.getWeight());
        exercise.setRepetitions(exerciseDto.getRepetitions());
        exercise.setRounds(exerciseDto.getRounds());
        exercise.setWorkoutId(exerciseDto.getWorkoutId());

        if(!dataProvider.insert(exercise)){
            return null;
        }
        exerciseDto.setId(exercise.getId());
        return exerciseDto;
    }

    @GetMapping("/workout/{id}")
    public List<SingleExercise> getExerciseByWorkout(@PathVariable int id){
//        System.out.println(id);
        System.out.println(dataProvider.getExercisesByWorkout(id));
        return dataProvider.getExercisesByWorkout(id);
    }

    @PostMapping("/addall")
    public SingleExercise insertAllSingleExercise(@RequestBody List<SingleExercise> singleExercises){
        singleExercises.forEach(dataProvider::insert);
        return singleExercises.get(0);
    }
}
