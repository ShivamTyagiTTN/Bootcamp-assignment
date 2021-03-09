package com.example.restfulwebservices2.helloworld;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

//  Q.1 Add support for Internationalization in your application allowing messages to be shown in
//    English, German and Swedish, keeping English as default.
    @GetMapping("/morning")
    @ApiOperation(value = "Morning wish", notes = "internationalized morning message")
    public String morningWish() {
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }

//  Q.2 Create a GET request which takes "username" as param and shows a localized message "Hello Username".
    @GetMapping("/welcome")
    @ApiOperation(value = "Welcome user", notes = "Internationalized welcome message ")
    public String welcomeUser(@RequestParam String userName) {
        String welcomeMessage=  messageSource.getMessage("welcome.message",
                null, LocaleContextHolder.getLocale());
        return welcomeMessage + " " + userName;
    }
}
