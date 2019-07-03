package pl.dms.api.rest;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.dms.Constants;

@RestController
@RequestMapping(LoginServiceRestController.LOGIN_URL)
public class LoginServiceRestController {

    public static final String LOGIN_URL = Constants.API_URL + "/login";

    @RequestMapping("/testRequest")
    public Map<String, Object> testRequest() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "response from test method");
        return model;
    }

    @RequestMapping("/protectedRequest")
    public Map<String, Object> protectedRequest() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "response from protected method");
        return model;
    }
}
