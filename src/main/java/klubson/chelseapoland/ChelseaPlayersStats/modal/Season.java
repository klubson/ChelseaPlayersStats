package klubson.chelseapoland.ChelseaPlayersStats.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Season {

    @Id
    private int seasonid;
    private int startyear;
    private int endyear;
}
