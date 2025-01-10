package klubson.chelseapoland.ChelseaPlayersStats.repository;

import klubson.chelseapoland.ChelseaPlayersStats.modal.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Integer> {
    Competition findByCompetitionid(Integer competitionid);
    Competition findByName(String name);
}
