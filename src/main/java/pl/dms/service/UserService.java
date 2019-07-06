package pl.dms.service;

import java.util.List;

import pl.dms.model.User;

public interface UserService {

    User save(User user);

    List<User> findAll();

    User findOne(long id);

    void delete(long id);
}
