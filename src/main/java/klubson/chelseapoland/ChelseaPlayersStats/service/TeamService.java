package klubson.chelseapoland.ChelseaPlayersStats.service;


import klubson.chelseapoland.ChelseaPlayersStats.modal.Team;

import java.util.List;

public interface TeamService {
    List<Team> getAllTeam();
    Team getTeamByTeamid(Integer teamid);
    Team getTeamByName(String name);
    void save(Team team);
    void delete(Team team);
}
