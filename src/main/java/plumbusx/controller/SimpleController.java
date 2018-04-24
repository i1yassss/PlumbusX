package plumbusx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import plumbusx.model.Competence;
import plumbusx.model.User;
import plumbusx.repository.RoleRepository;
import plumbusx.service.CompetenceService;
import plumbusx.service.MeetingService;
import plumbusx.service.UserService;
import plumbusx.service.impl.SecurityServiceImpl;

/**
 * Created by i1yas on 21.05.2017.
 */
@Controller
public class SimpleController {

    @Autowired
    private CompetenceService competenceService;
    @Autowired
    private SecurityServiceImpl securityService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private MeetingService meetingService;

    @RequestMapping(value = {"/myprofile"}, method = RequestMethod.GET)
    public String profile(Model model, @ModelAttribute("competence") Competence competence) {
        model.addAttribute("listCompetence", this.competenceService.getAllByCurrentUser());

        //String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
        //User user_info = userService.findByUsername(currentUserName);
        model.addAttribute("user_info", securityService.getCurrentUser());

        return "myprofile";
    }

    @RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
    public String profileId(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("user", userService.findById(id));
        User uid = userService.findById(id);
        model.addAttribute("meetingsList1", meetingService.getJoinedMeetings(uid.getId()));
        return "profile";
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "/list-users", method = RequestMethod.GET)
    public String index(Model model, @ModelAttribute("users") User user) {
        model.addAttribute("listStudents", userService.getAllByRole(roleRepository.findOne((int) 3L)));
        model.addAttribute("listTeachers", userService.getAllByRole(roleRepository.findOne((int) 1L)));
        return "list-users";
    }
}