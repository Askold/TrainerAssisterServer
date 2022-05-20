package ru.silonov.assister.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.silonov.assister.dao.DataProvider;
import ru.silonov.assister.model.dto.TrainerDto;
import ru.silonov.assister.model.entity.Trainer;

import javax.transaction.Transactional;

@Service
@Transactional
public class TrainerService implements ITrainerService{

    @Override
    public Trainer registerNewTrainerAccount(TrainerDto userDto){
        Trainer trainer = new Trainer();
        trainer.setName(userDto.getName());
        trainer.setSurname(userDto.getSurname());
        trainer.setLogin(userDto.getLogin());
        trainer.setPassword(userDto.getPassword());
        trainer.setExperience(userDto.getExperience());
        return trainer;
    }
}
