package plumbusx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import plumbusx.model.Project;
import plumbusx.model.User;
import plumbusx.repository.ProjectsRepository;
import plumbusx.service.ProjectService;
import plumbusx.service.UserService;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectsRepository projectsRepository;

    @Autowired
    private UserService userService;

    @Autowired(required = true)
    public void setMeetingService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping(value = "/projects/add", method = RequestMethod.POST)
    public String addProject(@ModelAttribute("projects") Project project){
        projectService.addProject(project);
        return "redirect:/projects";
    }

    @RequestMapping("/projects/remove/{id}")
    public String removeProject(@PathVariable("id") Integer id){
        Project project = projectService.findById(id);
        //System.out.println("HHHH= " + meeting);

        projectsRepository.delete(project);

        return "redirect:/projects";
    }

    @RequestMapping(value = "/myprojects/{id}", method = RequestMethod.GET)
    public String profileId(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("user", userService.findById(id));
        User uid = userService.findById(id);
        model.addAttribute("projectsList2", projectService.getJoinedProject(uid.getId()));
        return "myprojects";
    }

    @RequestMapping(value = {"/projects"}, method = RequestMethod.GET)
    public String listProjects(Model model, @ModelAttribute("projects") Project project) {
        model.addAttribute("listProjects", projectService.getAllByCurrentUser());
        return "projects";
    }

    @RequestMapping(value = {"/all-projects"}, method = RequestMethod.GET)
    public String allProjects(Model model, @ModelAttribute("meetings") Project project) {
        model.addAttribute("allProjects", projectService.findAll());
        return "all-projects";
    }

    @RequestMapping(value = "/all-projects/{projectId}/join", method = RequestMethod.POST)
    public String joinToProject(@PathVariable("projectId") Integer projectId, Model model){
        Project project = projectService.findById(projectId);
        //meetingService.joinMeeting(meeting);
        projectService.joinProject(project);
        return "redirect:/profile";
    }

}
