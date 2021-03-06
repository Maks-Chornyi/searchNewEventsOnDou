package ua.dou.searchNewEventsOnDou.service;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.dou.searchNewEventsOnDou.domain.User;
import ua.dou.searchNewEventsOnDou.repository.UserRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void addNewMail(User user) {
        User user1 = userRepo.findByMail(user.getMail());

        if(user1 == null) {
            user1 = new User();
            user1.setMail(user.getMail());
            userRepo.save(user1);
        } else {
            try {
                throw new NotFoundException("User with this email is already exist");
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public List<User> findAllUsers() {
        return (ArrayList<User>) userRepo.findAll();
    }


    @Transactional
    public void deleteUserAndMail(String mail) {
        User user = userRepo.findByMail(mail);
        if (user != null) {
            userRepo.deleteByMail(mail);
        } else {
            throw new NoSuchElementException("No such element in DB");
        }
    }
}
