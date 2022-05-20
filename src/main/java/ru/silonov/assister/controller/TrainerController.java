package ru.silonov.assister.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.silonov.assister.dao.DataProvider;
import ru.silonov.assister.model.entity.Client;
import ru.silonov.assister.model.entity.Trainer;
import ru.silonov.assister.model.dto.TrainerDto;
import ru.silonov.assister.model.request.AddClientRequest;
import ru.silonov.assister.model.response.DefaultResponse;
import ru.silonov.assister.model.transfer.LoginRequest;
import ru.silonov.assister.service.TrainerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trainer")
public class TrainerController {
    private static final DataProvider dataProvider = new DataProvider();
    private static final Logger logger = LogManager.getLogger(TrainerController.class);

    @GetMapping("/test")
    public TrainerDto test() {
        TrainerDto trainerDto = new TrainerDto();
        trainerDto.setUserId(1);
        trainerDto.setName("name");
        trainerDto.setSurname("surname");
        trainerDto.setLogin("login");
        trainerDto.setPassword("password");
        trainerDto.setExperience(43);

        return trainerDto;
    }

    @PostMapping("/login")
//    @ResponseStatus(HttpStatus.FOUND)
    public TrainerDto login(@RequestBody LoginRequest loginRequest) {
        logger.info(loginRequest);
        Trainer entity =  dataProvider.getTrainerByLogin(loginRequest.getLogin()).orElseThrow();
        if (!entity.getPassword().equals(loginRequest.getPassword())){
            logger.error("Password wrong");
            return null;
        }
        TrainerDto trainerDto = new TrainerDto();
        trainerDto.setUserId(entity.getUserId());
        trainerDto.setName(entity.getName());
        trainerDto.setSurname(entity.getSurname());
        trainerDto.setLogin(entity.getLogin());
        trainerDto.setPassword(entity.getPassword());
        trainerDto.setExperience(entity.getExperience());

        return trainerDto;
    }


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public TrainerDto postReport(@RequestBody TrainerDto trainerDto){
        Trainer entity = new TrainerService().registerNewTrainerAccount(trainerDto);
        logger.info(entity);
        if(!dataProvider.insert(entity)){
            return null;
        }
        trainerDto.setUserId(dataProvider.getTrainerByLogin(entity.getLogin()).orElseThrow().getUserId());
        return trainerDto;
    }

    @GetMapping("/allclients/{id}")
    public List<Client> getAllClients(@PathVariable int id){
        Trainer trainer = dataProvider.getById(Trainer.class, id).orElseThrow();
        return dataProvider.getClientsByTrainer(id);
    }

    @PatchMapping(value = "addclient")
    public List<Client> addClient(@RequestBody AddClientRequest addClientRequest){
        DefaultResponse defaultResponse = new DefaultResponse("Client added successfully");
        logger.info(addClientRequest);
        Optional<Client> optional = dataProvider.getClientByLogin(addClientRequest.getClientLogin());
        logger.info(dataProvider.getClientByLogin(addClientRequest.getClientLogin()).orElseThrow());
        if (optional.isEmpty()){
            defaultResponse.setMessage("Such client not found");
            return null;
        }
        Client client = optional.get();
        client.setTrainer(addClientRequest.getTrainerId());
        logger.info(client);
        if (!dataProvider.update(client)){
            defaultResponse.setMessage("Client not updated");
            return null;
        }
        return dataProvider.getClientsByTrainer(addClientRequest.getTrainerId());
    }

}
