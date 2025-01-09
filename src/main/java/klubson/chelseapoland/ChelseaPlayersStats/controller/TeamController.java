package klubson.chelseapoland.ChelseaPlayersStats.controller;

import klubson.chelseapoland.ChelseaPlayersStats.error.ObjectAlreadyExistsError;
import klubson.chelseapoland.ChelseaPlayersStats.exception.TeamAlreadyExistsException;
import klubson.chelseapoland.ChelseaPlayersStats.modal.Team;
import klubson.chelseapoland.ChelseaPlayersStats.service.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TeamController {

    @Autowired
    private TeamServiceImpl teamService;

    @GetMapping("/teams")
    public String viewTeamsHomePage(Model model) {
        model.addAttribute("allteamlist", teamService.getAllTeam());
        return "teams/teams";
    }
    @GetMapping("/teams/add")
    public String addTeam(Model model){
        Team team = new Team();
        model.addAttribute("team", team);
        return "teams/team_add";
    }

    @PostMapping("/teams/save")
    public String saveTeam(@ModelAttribute("team") Team team, Model model){
        try {
            teamService.save(team);
        } catch (TeamAlreadyExistsException e) {
            ObjectAlreadyExistsError error = new ObjectAlreadyExistsError(
                    "Error while saving Team",
                    e.getMessage(),
                    "Back to Teams page");
            model.addAttribute("error", error);
            return "error_page";
        }
        return "redirect:/teams";
    }

    @GetMapping("/teams/edit/{teamid}")
    public String editTeam(@PathVariable String teamid, Model model){
        Team team = teamService.getTeamByTeamid(Integer.valueOf(teamid));
        model.addAttribute("team", team);
        return "teams/team_edit";
    }

    @GetMapping(value = "/teams/delete/{teamid}")
    public String deleteTeam(@PathVariable String teamid){
        teamService.delete(teamService.getTeamByTeamid(Integer.valueOf(teamid)));
        return "redirect:/teams";
    }
}
