package klubson.chelseapoland.ChelseaPlayersStats.service;


import klubson.chelseapoland.ChelseaPlayersStats.modal.Team;

import java.util.List;

public interface TeamService {
    List<Team> getAllSeason();
    void save(Team team);

}
