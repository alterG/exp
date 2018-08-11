package nfwya.alterg.controller.account;


import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
public class AccountControllerTest
{
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void should_return_ok_when_correct() throws Exception
    {
        final String requestBodyJson = "{\"id\":95,\"currency\":\"EUR\",\"amount\":300}";

        mockMvc.perform(MockMvcRequestBuilders.post(new URI("/account/save"))
                .content(requestBodyJson).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk());
    }


    @Test
    public void should_return_validation_error_if_check_failed() throws Exception
    {
        final String requestBodyJson = "{\"id\":95,\"currency\":\"DOLLAR\",\"amount\":300}";

        mockMvc.perform(MockMvcRequestBuilders.post(new URI("/account/save"))
                .content(requestBodyJson).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }
}