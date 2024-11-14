package klubson.chelseapoland.ChelseaPlayersStats.service;

import klubson.chelseapoland.ChelseaPlayersStats.modal.Season;
import klubson.chelseapoland.ChelseaPlayersStats.repository.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeasonServiceImpl implements SeasonService {

    @Autowired private SeasonRepository seasonRepository;

    @Override
    public List<Season> getAllSeason() {
        return seasonRepository.findAll();
    }

    @Override
    public void save(Season season) {
        seasonRepository.save(season);
    }
}
