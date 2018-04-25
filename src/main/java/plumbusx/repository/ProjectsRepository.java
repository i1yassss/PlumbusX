package plumbusx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import plumbusx.model.Project;
import plumbusx.model.User;

import java.util.List;

public interface ProjectsRepository extends JpaRepository<Project, Integer> {
    List<Project> findAllByUser(User user);

}
