package plumbusx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import plumbusx.model.Meeting;
import plumbusx.model.User;
import plumbusx.repository.MeetingRepository;
import plumbusx.repository.UserRepository;
import plumbusx.service.MeetingService;

import java.util.List;
import java.util.Set;

/**
 * Created by i1yas on 25.05.2017.
 */
@Service
public class MeetingServiceImpl implements MeetingService {

    @Autowired
    private SecurityServiceImpl securityService;

    @Autowired
    private MeetingRepository meetingRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Meeting addMeeting(Meeting meeting) {
        //----------получаем юзера
        User user = securityService.getCurrentUser();
        //----------meeting забирает юзера
        meeting.setUser(securityService.getCurrentUser());
        //Meeting saveMeeting = meetingRepository.save(meeting);
        //----------юзер забирает meeting
        user.getMeetings().add(meeting);
        //----------сохраняем
        userRepository.save(user);
        //Set<User> users = new HashSet<>();
        //users.add(user);
        // meeting.setUsers(users);
        return meeting;
    }

    @Override
    public Meeting joinMeeting(Meeting meeting) {
        User currentUser = securityService.getCurrentUser();
        currentUser.getMeetings().add(meeting);
        userRepository.saveAndFlush(currentUser);
        return meeting;
    }

    @Override
    public List<Meeting> getUngroupMeetings(){
        User currentUser = securityService.getCurrentUser();
        List<Meeting> allMeetings = meetingRepository.findAll();
        Set<Meeting> currentUserJoinMeetings = currentUser.getMeetings();

        //System.out.println("ALL: " + allMeetings);
        //System.out.println("JOIN: " + currentUserJoinMeetings);

        allMeetings.removeAll(currentUserJoinMeetings);
        //System.out.println(allMeetings);

        return allMeetings;
    }

    @Override
    public Set<Meeting> getJoinedMeetings(Integer id) {
        User user = userRepository.findOne(id);
        Set<Meeting> setMeetings = user.getMeetings();
        return setMeetings;
    }

    @Override
    public void delete(Meeting meeting) {
        meetingRepository.delete(meeting);
    }

    @Override
    public List<Meeting> findAll() {
        return meetingRepository.findAll();
    }

    @Override
    public List<Meeting> getAllByCurrentUser() {
        return meetingRepository.findAllByUser(securityService.getCurrentUser());
    }

    @Override
    public Meeting findById(Integer id) {
        return meetingRepository.findOne(id);
    }
/*

    @Override
    public Meeting getById(int id) {
        return meetingRepository.getOne(id);
    }
    @Override
    public List<Meeting> getAllByUserId(Long id) {
        return meetingRepository.findAllByUser(userService.findById(id));
    }
*/
}
