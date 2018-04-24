package plumbusx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import plumbusx.model.Competence;
import plumbusx.repository.CompetenceRepository;
import plumbusx.service.CompetenceService;

import java.util.List;

/**
 * Created by i1yas on 21.05.2017.
 */

@Service
public class CompetenceServiceImpl implements CompetenceService {
    @Autowired
    private CompetenceRepository competenceRepository;

    @Autowired
    private SecurityServiceImpl securityService;

    @Override
    public Competence addCompetence(Competence competence){
        //соединили пользователя и компетенцию
        competence.setUser(securityService.getCurrentUser());
        Competence  saveCompetence = competenceRepository.save(competence);
        return saveCompetence;
    }

    @Override
    public void delete(int id) {
        competenceRepository.delete(id);
    }

    @Override
    public Competence getById(int id) {
        return competenceRepository.getOne(id);
    }

    @Override
    public List<Competence> getAllByCurrentUser() {
        return competenceRepository.findAllByUser(securityService.getCurrentUser());
    }



}
