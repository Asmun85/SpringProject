package com.example.demo.services;

import com.example.demo.entityDTO.LogingInfoDTO;
import org.springframework.http.ResponseEntity;

public interface AuthentificationService {

    public ResponseEntity<Object> loginUser(LogingInfoDTO logingInfoDTO);

    public void logoutUser();

}
