package klubson.chelseapoland.ChelseaPlayersStats.modal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "season")
public class Season {
    @Id
    @SequenceGenerator(name = "season_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "season_seq")
    private Integer seasonid;
    @Transient
    private Integer order;
    private Integer startyear;
    private Integer endyear;
}
