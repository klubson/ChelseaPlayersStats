package klubson.chelseapoland.ChelseaPlayersStats.repository;

import klubson.chelseapoland.ChelseaPlayersStats.modal.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Integer> {

}
