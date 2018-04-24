package plumbusx.service;

import plumbusx.model.Competence;

import java.util.List;

/**
 * Created by i1yas on 21.05.2017.
 */
public interface  CompetenceService {

    Competence addCompetence(Competence competence);
    void delete(int id);
    Competence getById(int id);
    List<Competence> getAllByCurrentUser();

}
