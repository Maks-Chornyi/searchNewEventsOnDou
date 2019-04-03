package ua.dou.searchNewEventsOnDou.service;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.dou.searchNewEventsOnDou.domain.User;
import ua.dou.searchNewEventsOnDou.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User findByMail(String mail) {
        return userRepo.findByMail(mail);
    }

    public void addNewMail(String mail) {
        User user = userRepo.findByMail(mail);

        if(user == null) {
            user = new User();
            user.setMail(mail);
            userRepo.save(user);
        } else {
            try {
                throw new NotFoundException("User with this email is already exist");
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
