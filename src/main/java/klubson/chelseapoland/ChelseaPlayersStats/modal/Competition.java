package klubson.chelseapoland.ChelseaPlayersStats.modal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "competition")
public class Competition {
    @Id
    @SequenceGenerator(name = "competition_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "competition_seq")
    private Integer competitionid;
    @Transient
    private Integer order;
    private String name;
}
