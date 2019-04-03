package ua.dou.searchNewEventsOnDou.repository;

import org.springframework.data.repository.CrudRepository;
import ua.dou.searchNewEventsOnDou.domain.User;


public interface UserRepo extends CrudRepository<User, Long> {
    User findByMail(String mail);
}
