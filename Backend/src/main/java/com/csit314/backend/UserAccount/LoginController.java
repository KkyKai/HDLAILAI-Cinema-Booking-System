package com.csit314.backend.UserAccount;

import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/login") // This means URL's start with /useraccount (after Application path)
public class LoginController {

    /* @PostMapping
    public ResponseEntity<String> validateLogin(@RequestBody UserAccount user) {
        try {
            if (user.getUserProfile().getId() == -1) {
                return new ResponseEntity<String>("Profile not selected", HttpStatus.BAD_REQUEST);
            }
            // Check email empty or password empty
            if (user.getEmail() == "") {
                return new ResponseEntity<String>("Empty email", HttpStatus.BAD_REQUEST);
            }
            if (user.getPassword() == "") {
                return new ResponseEntity<String>("Empty password", HttpStatus.BAD_REQUEST);
            }
            String loginResult = user.login(user);
            if (loginResult != "success") {
                return new ResponseEntity<String>(loginResult, HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<String>("Login successful", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<String>("Invalid submission", HttpStatus.BAD_REQUEST);
        }
    } */

    /*
     * @PostMapping("/logout")
     * public ResponseEntity<String> logout() {
     * // Clear the authentication details
     * SecurityContextHolder.getContext().setAuthentication(null);
     * // Get the current session and invalidate it
     * HttpSession session = request.getSession(false);
     * if (session != null) {
     * session.invalidate();
     * }
     * // Redirect the user to the login page
     * return new ResponseEntity<String>("Logout successful", HttpStatus.OK);
     * }
     */
}