package klubson.chelseapoland.ChelseaPlayersStats.controller;

import klubson.chelseapoland.ChelseaPlayersStats.exception.SeasonAlreadyExistsException;
import klubson.chelseapoland.ChelseaPlayersStats.modal.Season;
import klubson.chelseapoland.ChelseaPlayersStats.service.SeasonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SeasonController {

    @Autowired
    private SeasonServiceImpl seasonService;

    @GetMapping("/seasons")
    public String viewSeasonsHomePage(Model model) {
        model.addAttribute("allseasonlist", seasonService.getAllSeason());
        return "seasons";
    }
    @GetMapping("/seasons/add")
    public String addSeason(Model model){
        Season season = new Season();
        model.addAttribute("season", season);
        return "season_add";
    }

    @PostMapping("/seasons/save")
    public String saveSeason(@ModelAttribute("season") Season season){
        try {
            seasonService.save(season);
        } catch (SeasonAlreadyExistsException e) {
            return "redirect:/seasons/add";
        }
        return "redirect:/seasons";
    }

    @GetMapping("/seasons/edit/{startyear}")
    public String editSeason(@PathVariable String startyear, Model model){
        Season season = seasonService.getSeasonByStartYear(Integer.valueOf(startyear));
        model.addAttribute("season", season);
        return "season_edit";
    }

    @GetMapping(value = "/seasons/delete/{seasonid}")
    public String deleteSeason(@PathVariable String seasonid){
        seasonService.delete(seasonService.getSeasonBySeasonid(Integer.valueOf(seasonid)));
        return "redirect:/seasons";
    }
}
