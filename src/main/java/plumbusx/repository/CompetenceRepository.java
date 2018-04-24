package plumbusx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import plumbusx.model.Competence;
import plumbusx.model.User;

import java.util.List;

/**
 * Created by i1yas on 21.05.2017.
 */
@Repository
public interface CompetenceRepository extends JpaRepository<Competence, Integer> {

    List<Competence> findAllByUser(User user);
    List<Competence> findAllByUserId(User id);

}
