package klubson.chelseapoland.ChelseaPlayersStats.service;

import klubson.chelseapoland.ChelseaPlayersStats.exception.SeasonAlreadyExistsException;
import klubson.chelseapoland.ChelseaPlayersStats.modal.Team;
import klubson.chelseapoland.ChelseaPlayersStats.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<Team> getAllTeam() {
        List<Team> list = teamRepository.findAll();
        AtomicInteger order = new AtomicInteger(1);
        list.forEach(team -> team.setOrder(order.getAndIncrement()));
        return list;
    }

    @Override
    public Team getTeamByTeamid(Integer teamid) {
        return teamRepository.findByTeamid(teamid);
    }

    @Override
    public Team getTeamByName(String name) {
        return teamRepository.findByName(name);
    }

    @Override
    public void save(Team team) {
        team.setName(team.getName().trim());
        team.setStadium(team.getStadium().trim());
        team.setCity(team.getCity().trim());
        team.setCountry(team.getCountry().trim());
        if(team.getTeamid() != null || Objects.equals(getTeamByName(team.getName()), null)){
            teamRepository.save(team);
        } else {
            throw new SeasonAlreadyExistsException("Team " + team.getName() + " already exists!");
        }
    }

    @Override
    public void delete(Team team) {
        teamRepository.delete(team);
    }
}
