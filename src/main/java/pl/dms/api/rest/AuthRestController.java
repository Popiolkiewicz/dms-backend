package pl.dms.api.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthRestController {

    @RequestMapping(value = "/callback", method = RequestMethod.GET)
    public void findOne(@RequestParam String code) {
        System.out.println("Da code: " + code);
    }
}
