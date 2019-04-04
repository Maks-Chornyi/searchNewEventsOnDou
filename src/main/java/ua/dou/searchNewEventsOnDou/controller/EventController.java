package ua.dou.searchNewEventsOnDou.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.dou.searchNewEventsOnDou.domain.User;
import ua.dou.searchNewEventsOnDou.service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
public class EventController {

    UserService userService;

    @GetMapping
    public ResponseEntity<?> welcomePage() {
        return new ResponseEntity<List<User>>(userService.findAllUsers(),HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addNewUserAndEmail(@RequestBody User user) {
        userService.addNewMail(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUserAndMail(@RequestBody String mail) {
        userService.deleteUserAndMail(mail);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

}