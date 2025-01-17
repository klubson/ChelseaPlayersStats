package klubson.chelseapoland.ChelseaPlayersStats.repository;

import klubson.chelseapoland.ChelseaPlayersStats.modal.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
    Team findByTeamid(Integer teamid);
    Team findByName(String name);
}
