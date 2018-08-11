package nfwya.alterg.controller.account;


import java.lang.reflect.Parameter;

import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/account")
public class AccountController
{

    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void save(@RequestBody @Validated final Account account, final BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            throw new IllegalArgumentException();
        }
        System.out.println(account);
    }
}
