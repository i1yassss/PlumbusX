package plumbusx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import plumbusx.model.Meeting;
import plumbusx.model.User;

import java.util.List;

/**
 * Created by i1yas on 25.05.2017.
 */
public interface MeetingRepository extends JpaRepository<Meeting, Integer>{
    List<Meeting> findAllByUser(User user);
}
