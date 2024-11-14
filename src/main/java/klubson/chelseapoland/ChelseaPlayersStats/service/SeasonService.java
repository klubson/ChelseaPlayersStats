package klubson.chelseapoland.ChelseaPlayersStats.service;

import klubson.chelseapoland.ChelseaPlayersStats.modal.Season;

import java.util.List;

public interface SeasonService {
    List<Season> getAllSeason();
    void save(Season season);
}
