package pl.dms.api.rest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.dms.Constants;
import pl.dms.model.Credentials;

@RestController
public class LoginServiceRestController {

    public static final String LOGIN_URL = Constants.API_URL + "/login";
    public static final String VALIDATE_LOGIN_URL = Constants.API_URL + "/validateLogin";

    @RequestMapping(LOGIN_URL)
    public boolean login(@RequestBody Credentials credentials) {
        return credentials.getUsername().equals("user") && 
                credentials.getPassword().equals("password");
    }

    @RequestMapping(VALIDATE_LOGIN_URL)
    public String validateLogin() {
        return "User successfully authenticated";
    }
}
