package klubson.chelseapoland.ChelseaPlayersStats.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Team {

    @Id
    private int teamid;
    private String name;
    private String stadiumname;
    private String city;
    private String country;
}
