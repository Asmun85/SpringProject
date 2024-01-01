package com.example.authentification.controller;

import com.example.authentification.entityDTO.LogingInfoDTO;
import com.example.authentification.services.AuthentificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthentificationController {

    private static final Logger logger = LoggerFactory.getLogger(AuthentificationController.class);

    @Autowired
    AuthentificationService authentificationService;

    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody LogingInfoDTO logingInfoDTO){
        logger.info("in Auth controller : loginUser");
        return authentificationService.loginUser(logingInfoDTO);
    }

    @PostMapping("/logout/{login}")
    public ResponseEntity<Object> logoutUser(@PathVariable String login){
        logger.info("in Auth Controller: logoutUser");
        return null;
    }

}
