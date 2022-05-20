package ru.silonov.assister.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.silonov.assister.model.entity.Feedback;
import ru.silonov.assister.model.entity.Program;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "program_id")
    private Program program;
    @OneToOne(fetch = FetchType.LAZY)
    private Feedback feedback;
}
