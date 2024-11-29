package klubson.chelseapoland.ChelseaPlayersStats.service;

import klubson.chelseapoland.ChelseaPlayersStats.exception.SeasonAlreadyExistsException;
import klubson.chelseapoland.ChelseaPlayersStats.modal.Season;
import klubson.chelseapoland.ChelseaPlayersStats.repository.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class SeasonServiceImpl implements SeasonService {

    @Autowired private SeasonRepository seasonRepository;

    @Override
    public List<Season> getAllSeason() {
        List<Season> list = seasonRepository.findAll();
        AtomicInteger order = new AtomicInteger(1);
        list.forEach(season -> season.setOrder(order.getAndIncrement()));
        return list;
    }

    @Override
    public Season getSeasonByStartYear(Integer startyear) {
        return seasonRepository.findByStartyear(startyear);
    }

    @Override
    public Season getSeasonBySeasonid(Integer seasonid) {
        return seasonRepository.findBySeasonid(seasonid);
    }

    @Override
    public void save(Season season) {
        if(Objects.equals(getSeasonByStartYear(season.getStartyear()), null)){
            seasonRepository.save(season);
        } else {
            throw new SeasonAlreadyExistsException("Season " + season.getStartyear() + "-" + season.getEndyear() + " already exists!");
        }
    }

    @Override
    public void delete(Season season) {
        seasonRepository.delete(season);
    }
}
