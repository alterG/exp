package nfwya.alterg.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class StudyController
{

    @RequestMapping(value = "/")
    public String index()
    {
        return "You should study very quickly.";
    }

}
