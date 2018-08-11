package nfwya.alterg.controller.greeting;


import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GreetingController
{
    @GetMapping(path = "/greeting")
    public Greeting answer(@RequestParam(required = false) final String nick,
                           @RequestHeader("Accept-Language") final List<String> acceptLanguages)
    {
        System.out.println("Languages list: " + acceptLanguages);
        return new Greeting(13, String.format("Hello %s sup how are you?", nick));
    }
}
