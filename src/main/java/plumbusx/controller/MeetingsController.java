package plumbusx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import plumbusx.model.Meeting;
import plumbusx.model.User;
import plumbusx.repository.MeetingRepository;
import plumbusx.service.MeetingService;
import plumbusx.service.UserService;

/**
 * Created by i1yas on 25.05.2017.
 */
@Controller
public class MeetingsController {
    @Autowired
    private MeetingService meetingService;

    @Autowired
    private MeetingRepository meetingRepository;

    @Autowired
    private UserService userService;

    @Autowired(required = true)
    public void setMeetingService(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @RequestMapping(value = "/meetings/add", method = RequestMethod.POST)
    public String addMeeting(@ModelAttribute("meetings") Meeting meeting){
        meetingService.addMeeting(meeting);
        return "redirect:/meetings";
    }

    @RequestMapping("/meetings/remove/{id}")
    public String removeMeeting(@PathVariable("id") Integer id){
        Meeting meeting = meetingService.findById(id);
        //System.out.println("HHHH= " + meeting);

        meetingRepository.delete(meeting);

        return "redirect:/meetings";
    }

    @RequestMapping(value = "/mymeetings/{id}", method = RequestMethod.GET)
    public String profileId(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("user", userService.findById(id));
        User uid = userService.findById(id);
        model.addAttribute("meetingsList2", meetingService.getJoinedMeetings(uid.getId()));
        return "mymeetings";
    }

    @RequestMapping(value = {"/meetings"}, method = RequestMethod.GET)
    public String listMeetings(Model model, @ModelAttribute("meetings") Meeting meeting) {
        model.addAttribute("listMeetings", meetingService.getAllByCurrentUser());
        return "meetings";
    }

    @RequestMapping(value = {"/all-meetings"}, method = RequestMethod.GET)
    public String allMeetings(Model model, @ModelAttribute("meetings") Meeting meeting) {
        model.addAttribute("allMeetings", meetingService.findAll());
        return "all-meetings";
    }

    @RequestMapping(value = {"/ungroup-meetings"}, method = RequestMethod.GET)
    public String getaUngroupMeetings(Model model, @ModelAttribute("meetings") Meeting meeting) {
        model.addAttribute("ungroupMeetings", meetingService.getUngroupMeetings());
        return "ungroup-meetings";
    }

    @RequestMapping(value = "/ungroup-meetings/{meetingId}/join", method = RequestMethod.POST)
    public String joinToMeeting(@PathVariable("meetingId") Integer meetingId, Model model){
        Meeting meeting = meetingService.findById(meetingId);
        meetingService.joinMeeting(meeting);
        return "redirect:/ungroup-meetings";
    }
}
