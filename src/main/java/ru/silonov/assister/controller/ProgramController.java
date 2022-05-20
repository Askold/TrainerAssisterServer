package ru.silonov.assister.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.silonov.assister.dao.DataProvider;
import ru.silonov.assister.model.dto.ClientDto;
import ru.silonov.assister.model.dto.ProgramDto;
import ru.silonov.assister.model.entity.Client;
import ru.silonov.assister.model.entity.Program;
import ru.silonov.assister.model.transfer.LoginRequest;
import ru.silonov.assister.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/program")
public class ProgramController {
    private static final DataProvider dataProvider = new DataProvider();
    private static final Logger logger = LogManager.getLogger(ProgramController.class);

    @PostMapping("/new")
    public ProgramDto newProgram(@RequestBody ProgramDto programDto) {
        Program program = new Program();
        program.setDurationInWeeks(programDto.getDurationInWeeks());
        program.setWorkoutsPerWeek(programDto.getWorkoutsPerWeek());
        program.setDescription(programDto.getDescription());
        program.setType(programDto.getType());
        program.setClient(programDto.getClient());

        dataProvider.insert(program);
        programDto.setId(program.getId());
        return programDto;
    }

    @GetMapping("/client/{id}")
    public List<Program> getPrograms(@PathVariable int id){
        return dataProvider.getProgramByClient(id);
    }


//    @PostMapping("/register")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ClientDto postReport(@RequestBody ClientDto clientDto){
//        Client entity = new ClientService().registerNewClientAccount(clientDto);
//        logger.info(entity);
//        entity.setTrainer(30);
//        if(!dataProvider.insert(entity)){
//            return null;
//        }
//        clientDto.setUserId(dataProvider.getClientByLogin(entity.getLogin()).orElseThrow().getUserId());
//        return clientDto;
//    }

}
