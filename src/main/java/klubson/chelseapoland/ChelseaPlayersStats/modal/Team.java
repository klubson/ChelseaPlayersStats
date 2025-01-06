package klubson.chelseapoland.ChelseaPlayersStats.modal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "team")
public class Team {
    @Id
    @SequenceGenerator(name = "team_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_seq")
    private Integer teamid;
    @Transient
    private Integer order;
    private String name;
    private String stadium;
    private String city;
    private String country;
}
