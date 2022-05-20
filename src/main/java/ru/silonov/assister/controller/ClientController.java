package ru.silonov.assister.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.silonov.assister.dao.DataProvider;
import ru.silonov.assister.model.dto.ClientDto;
import ru.silonov.assister.model.dto.TrainerDto;
import ru.silonov.assister.model.entity.Client;
import ru.silonov.assister.model.entity.Trainer;
import ru.silonov.assister.model.transfer.LoginRequest;
import ru.silonov.assister.service.ClientService;
import ru.silonov.assister.service.TrainerService;

@RestController
@RequestMapping("/client")
public class ClientController {
    private static final DataProvider dataProvider = new DataProvider();
    private static final Logger logger = LogManager.getLogger(ClientController.class);

    @Autowired
    ClientService clientService;

    @PostMapping("/login")
    public ClientDto login(@RequestBody LoginRequest loginRequest) {
        Client entity =  dataProvider.getClientByLogin(loginRequest.getLogin()).orElseThrow();
        if (!entity.getPassword().equals(loginRequest.getPassword())){
            logger.error("Password wrong");
            return null;
        }
        ClientDto clientDto = new ClientDto();
        clientDto.setUserId(entity.getUserId());
        clientDto.setName(entity.getName());
        clientDto.setSurname(entity.getSurname());
        clientDto.setLogin(entity.getLogin());
        clientDto.setPassword(entity.getPassword());
        clientDto.setAge(entity.getAge());
        clientDto.setHeight(entity.getWeight());
        clientDto.setWeight(entity.getWeight());
        return clientDto;
    }


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDto postReport(@RequestBody ClientDto clientDto){
        Client entity = clientService.registerNewClientAccount(clientDto);
        logger.info(entity);
        if(!dataProvider.insert(entity)){
            return null;
        }
        clientDto.setUserId(dataProvider.getClientByLogin(entity.getLogin()).orElseThrow().getUserId());
        return clientDto;
    }

}
