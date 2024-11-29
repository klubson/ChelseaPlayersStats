package klubson.chelseapoland.ChelseaPlayersStats.service;

import klubson.chelseapoland.ChelseaPlayersStats.modal.Season;

import java.util.List;

public interface SeasonService {
    List<Season> getAllSeason();
    Season getSeasonByStartYear(Integer startyear);
    Season getSeasonBySeasonid(Integer seasonid);
    void save(Season season);
    void delete(Season season);
}
