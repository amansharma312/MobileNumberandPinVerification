package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class PinController {
    @Autowired
    private UserDAO userDAO;

   @PostMapping(value = "/verify", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> verifyMpin(@RequestParam("mobile_number") String mobileNumber,
            @RequestParam("mpin") String mpin) {
    	
        User user = userDAO.findByMobileNumber(mobileNumber);
        if (user != null && user.getMobileNumber().equals(mobileNumber) && user.getMpin().equals(mpin)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
	   
    }
}


