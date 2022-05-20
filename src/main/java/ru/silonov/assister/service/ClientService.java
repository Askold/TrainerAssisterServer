package ru.silonov.assister.service;


import org.springframework.stereotype.Service;
import ru.silonov.assister.model.dto.ClientDto;
import ru.silonov.assister.model.dto.TrainerDto;
import ru.silonov.assister.model.entity.Client;
import ru.silonov.assister.model.entity.Trainer;

import javax.transaction.Transactional;

@Service
public class ClientService {

    @Transactional
    public Client registerNewClientAccount(ClientDto userDto){
        Client client = new Client();
        client.setName(userDto.getName());
        client.setSurname(userDto.getSurname());
        client.setLogin(userDto.getLogin());
        client.setPassword(userDto.getPassword());
        client.setAge(userDto.getAge());
        client.setWeight(userDto.getWeight());
        client.setHeight(userDto.getHeight());
        return client;
    }
}
