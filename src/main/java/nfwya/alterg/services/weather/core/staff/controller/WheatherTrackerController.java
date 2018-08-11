package nfwya.alterg.services.weather.core.staff.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/weather/tracker", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class WheatherTrackerController
{
    private static final Logger logger = LoggerFactory.getLogger(WheatherTrackerController.class);



}
