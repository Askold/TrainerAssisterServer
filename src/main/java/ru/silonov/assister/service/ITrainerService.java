package ru.silonov.assister.service;

import ru.silonov.assister.model.dto.TrainerDto;
import ru.silonov.assister.model.entity.Trainer;

public interface ITrainerService {
    Trainer registerNewTrainerAccount(TrainerDto userDto);
}
