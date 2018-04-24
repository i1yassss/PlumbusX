package plumbusx.service;

/**
 * Created by i1yas on 04.05.2017.
 */
public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);

}

