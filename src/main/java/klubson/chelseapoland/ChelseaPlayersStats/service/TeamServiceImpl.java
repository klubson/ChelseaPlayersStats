package klubson.chelseapoland.ChelseaPlayersStats.service;

import klubson.chelseapoland.ChelseaPlayersStats.modal.Team;
import klubson.chelseapoland.ChelseaPlayersStats.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired private TeamRepository teamRepository;

    @Override
    public List<Team> getAllSeason() {
        return teamRepository.findAll();
    }

    @Override
    public void save(Team team) {
        teamRepository.save(team);
    }
}
