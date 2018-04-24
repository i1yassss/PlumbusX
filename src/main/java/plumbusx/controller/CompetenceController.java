package plumbusx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import plumbusx.model.Competence;
import plumbusx.service.CompetenceService;

/**
 * Created by i1yas on 21.05.2017.
 */
@Controller
public class CompetenceController {

    @Autowired
    private CompetenceService competenceService;

    @Autowired
    public void setCompetenceService(CompetenceService competenceService) {
        this.competenceService = competenceService;
    }

    @RequestMapping(value = "/myprofile/add", method = RequestMethod.POST)
    public String addCompetence(@ModelAttribute("competence") Competence competence){
        this.competenceService.addCompetence(competence);
        return "redirect:/myprofile";
    }

    @RequestMapping("/remove/{id}")
    public String removeCompetence(@PathVariable("id") int id){
        this.competenceService.delete(id);

        return "redirect:/myprofile";
    }


}