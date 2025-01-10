package klubson.chelseapoland.ChelseaPlayersStats.service;

import klubson.chelseapoland.ChelseaPlayersStats.exception.CompetitionAlreadyExistsException;
import klubson.chelseapoland.ChelseaPlayersStats.modal.Competition;
import klubson.chelseapoland.ChelseaPlayersStats.repository.CompetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    @Autowired
    CompetitionRepository competitionRepository;

    @Override
    public List<Competition> getAllCompetition() {
        List<Competition> list = competitionRepository.findAll();
        AtomicInteger order = new AtomicInteger(1);
        list.forEach(competition -> competition.setOrder(order.getAndIncrement()));
        return list;
    }

    @Override
    public Competition getCompetitionByCompetitionid(Integer competitionid) {
        return competitionRepository.findByCompetitionid(competitionid);
    }

    @Override
    public Competition getCompetitionByName(String name) {
        return competitionRepository.findByName(name);
    }

    @Override
    public void save(Competition competition) {
        competition.setName(competition.getName().trim());
        if(competition.getCompetitionid() != null || Objects.equals(getCompetitionByName(competition.getName()), null)){
            competitionRepository.save(competition);
        } else {
            throw new CompetitionAlreadyExistsException("Competition " + competition.getName() + " already exists!");
        }
    }

    @Override
    public void delete(Competition competition) {
        competitionRepository.delete(competition);
    }
}
