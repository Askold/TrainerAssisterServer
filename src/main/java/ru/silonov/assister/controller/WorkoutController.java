package ru.silonov.assister.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import ru.silonov.assister.dao.DataProvider;
import ru.silonov.assister.model.dto.ProgramDto;
import ru.silonov.assister.model.dto.WorkoutDto;
import ru.silonov.assister.model.entity.Program;
import ru.silonov.assister.model.entity.Workout;

import java.util.List;

@RestController
@RequestMapping("/workout")
public class WorkoutController {

    private static final DataProvider dataProvider = new DataProvider();
    private static final Logger logger = LogManager.getLogger(WorkoutController.class);

    @PostMapping("/new")
    public WorkoutDto newProgram(@RequestBody WorkoutDto workoutDto) {
        Workout workout = new Workout();
        workout.setProgram(workoutDto.getProgram());
        workout.setName(workoutDto.getName());
        System.out.println(workout);
        if(!dataProvider.insert(workout)){
            return null;
        }
        workoutDto.setId(workout.getId());
        return workoutDto;
    }

    @GetMapping("/program/{id}")
    public List<Workout> getWorkoutsByProgram(@PathVariable int id){
        return dataProvider.getWorkoutsByProgramId(id);
    }
}
