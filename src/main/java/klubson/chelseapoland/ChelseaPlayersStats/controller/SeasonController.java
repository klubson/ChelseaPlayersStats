package klubson.chelseapoland.ChelseaPlayersStats.controller;

import klubson.chelseapoland.ChelseaPlayersStats.modal.Season;
import klubson.chelseapoland.ChelseaPlayersStats.service.SeasonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
        return "seasons_add";
    }

    @PostMapping("/seasons/save")
    public String saveSeason(@ModelAttribute("season") Season season){
        seasonService.save(season);
        return "redirect:/seasons";
    }
}
