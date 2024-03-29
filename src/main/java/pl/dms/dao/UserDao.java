package pl.dms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.dms.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {

    User findByUsername(String username);

}
