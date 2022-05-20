package ru.silonov.assister.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.silonov.assister.dao.DataProvider;
import ru.silonov.assister.model.entity.Feedback;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private static final DataProvider dataProvider = new DataProvider();
    private static final Logger logger = LogManager.getLogger(ExerciseController.class);

    @PostMapping("/new")
    public Feedback insertFeedback(@RequestBody Feedback feedback){
        if (!dataProvider.insert(feedback)){
            return null;
        }
        return feedback;
    }
}
