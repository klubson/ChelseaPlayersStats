package klubson.chelseapoland.ChelseaPlayersStats.controller;

import klubson.chelseapoland.ChelseaPlayersStats.modal.Season;
import klubson.chelseapoland.ChelseaPlayersStats.modal.Team;
import klubson.chelseapoland.ChelseaPlayersStats.service.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TeamController {

    @Autowired
    private TeamServiceImpl teamService;

    @GetMapping("/teams")
    public String viewTeamsHomePage(Model model) {
        model.addAttribute("allteamlist", teamService.getAllSeason());
        return "teams";
    }
    @GetMapping("/teams/add")
    public String addTeam(Model model){
        Team team = new Team();
        model.addAttribute("team", team);
        return "teams_add";
    }

    @PostMapping("/teams/save")
    public String saveTeam(@ModelAttribute("team") Team team){
        teamService.save(team);
        return "redirect:/teams";
    }
}
