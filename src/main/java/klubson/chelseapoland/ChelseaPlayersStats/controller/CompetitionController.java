package klubson.chelseapoland.ChelseaPlayersStats.controller;

import klubson.chelseapoland.ChelseaPlayersStats.error.ObjectAlreadyExistsError;
import klubson.chelseapoland.ChelseaPlayersStats.exception.CompetitionAlreadyExistsException;
import klubson.chelseapoland.ChelseaPlayersStats.modal.Competition;
import klubson.chelseapoland.ChelseaPlayersStats.service.CompetitionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CompetitionController {

    @Autowired
    private CompetitionServiceImpl competitionService;

    @GetMapping("/competitions")
    public String viewCompetitionsHomePage(Model model) {
        model.addAttribute("allcompetitionlist", competitionService.getAllCompetition());
        return "competitions/competitions";
    }
    @GetMapping("/competitions/add")
    public String addCompetition(Model model){
        Competition competition = new Competition();
        model.addAttribute("competition", competition);
        return "competitions/competition_add";
    }

    @PostMapping("/competitions/save")
    public String saveCompetition(@ModelAttribute("competition") Competition competition, Model model){
        try {
            competitionService.save(competition);
        } catch (CompetitionAlreadyExistsException e) {
            ObjectAlreadyExistsError error = new ObjectAlreadyExistsError(
                    "Error while saving Competition",
                    e.getMessage(),
                    "Back to Competitions page");
            model.addAttribute("error", error);
            return "error_page";
        }
        return "redirect:/competitions";
    }

    @GetMapping("/competitions/edit/{competitionid}")
    public String editCompetition(@PathVariable String competitionid, Model model){
        Competition competition = competitionService.getCompetitionByCompetitionid(Integer.valueOf(competitionid));
        model.addAttribute("competition", competition);
        return "competitions/competition_edit";
    }

    @GetMapping(value = "/competitions/delete/{competitionid}")
    public String deleteCompetition(@PathVariable String competitionid){
        competitionService.delete(competitionService.getCompetitionByCompetitionid(Integer.valueOf(competitionid)));
        return "redirect:/competitions";
    }
}
