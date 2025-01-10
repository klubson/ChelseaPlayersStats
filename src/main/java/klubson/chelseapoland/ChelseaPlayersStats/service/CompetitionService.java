package klubson.chelseapoland.ChelseaPlayersStats.service;

import klubson.chelseapoland.ChelseaPlayersStats.modal.Competition;

import java.util.List;

public interface CompetitionService {
    List<Competition> getAllCompetition();
    Competition getCompetitionByCompetitionid(Integer competitionid);
    Competition getCompetitionByName(String name);
    void save(Competition competition);
    void delete(Competition competition);
}
