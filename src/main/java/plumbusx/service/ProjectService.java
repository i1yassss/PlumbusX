package plumbusx.service;

import plumbusx.model.Project;

import java.util.List;
import java.util.Set;

public interface ProjectService {
    Project addProject(Project myProject);
    Project joinProject(Project myProject);
    Project findById(Integer id);
    //List<Project> getUngroupProject();
    void delete(Project project);
    List<Project> findAll();
    List<Project> getAllByCurrentUser();
    Set<Project> getJoinedProject(Integer id);
}
