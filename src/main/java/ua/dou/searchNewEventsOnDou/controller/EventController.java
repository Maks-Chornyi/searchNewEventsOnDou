package ua.dou.searchNewEventsOnDou.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.dou.searchNewEventsOnDou.domain.User;
import ua.dou.searchNewEventsOnDou.service.UserService;

@RestController
@AllArgsConstructor
public class EventController {

    UserService userService;

    @GetMapping
    public ResponseEntity<?> welcomePage() {
        return new ResponseEntity<String>("This is welcome page",HttpStatus.OK);
    }

    @GetMapping(value = "/add")
    public ResponseEntity<?> addNewUserAndEmail(@RequestBody String mail) {
        userService.addNewMail(mail);
        User user = userService.findByMail(mail);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }
}