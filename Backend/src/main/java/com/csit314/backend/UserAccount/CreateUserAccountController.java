package com.csit314.backend.UserAccount;

import java.sql.SQLException;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/createuseraccount") // This means URL's start with /useraccount (after Application path)
public class CreateUserAccountController {
    @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody ResponseEntity<?> addNewUser(@RequestBody UserAccount user) throws SQLException {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestBody means it is the message sent in the GET or POST request
        if (user.getName() == null || user.getName().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Name cannot be empty");
        }
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email cannot be empty");
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Password cannot be empty");
        }
        // Default value for userAccount is -1, so it represents no role selected.
        if (user.getUserProfile() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User Profile cannot be empty");
        }
        UserAccount.save(user);
        return ResponseEntity.ok("Account has been created successfully");
    }
}