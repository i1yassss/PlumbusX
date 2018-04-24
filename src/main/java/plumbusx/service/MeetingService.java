package plumbusx.service;

import plumbusx.model.Meeting;

import java.util.List;
import java.util.Set;

/**
 * Created by i1yas on 25.05.2017.
 */
public interface MeetingService  {

    Meeting addMeeting(Meeting myMeeting);
    Meeting joinMeeting(Meeting myMeeting);
    Meeting findById(Integer id);
    List<Meeting> getUngroupMeetings();
    void delete(Meeting meeting);
    List<Meeting> findAll();
    List<Meeting> getAllByCurrentUser();
    Set<Meeting> getJoinedMeetings(Integer id);
}
