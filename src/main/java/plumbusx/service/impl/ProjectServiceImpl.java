package plumbusx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import plumbusx.model.Project;
import plumbusx.model.User;
import plumbusx.repository.ProjectsRepository;
import plumbusx.repository.UserRepository;
import plumbusx.service.ProjectService;

import java.util.List;
import java.util.Set;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private SecurityServiceImpl securityService;

    @Autowired
    private ProjectsRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Project addProject(Project myProject) {
        //----------получаем юзера
        User user = securityService.getCurrentUser();
        //----------meeting забирает юзера
        myProject.setUser(securityService.getCurrentUser());
        //----------юзер забирает meeting
        user.getProjects().add(myProject);
        //----------сохраняем
        userRepository.save(user);
        return myProject;
    }

    @Override
    public Project joinProject(Project myProject) {
        User currentUser = securityService.getCurrentUser();
        currentUser.getProjects().add(myProject);
        userRepository.saveAndFlush(currentUser);
        return myProject;
    }

    @Override
    public Project findById(Integer id) {
        return projectRepository.findOne(id);
    }

    @Override
    public void delete(Project project) {
        projectRepository.delete(project);
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public List<Project> getAllByCurrentUser() {
        return projectRepository.findAllByUser(securityService.getCurrentUser());
    }

    @Override
    public Set<Project> getJoinedProject(Integer id) {
        User user = userRepository.findOne(id);
        Set<Project> setProjects = user.getProjects();
        return setProjects;
    }
}
