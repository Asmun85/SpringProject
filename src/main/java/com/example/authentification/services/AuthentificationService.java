package com.example.authentification.services;

import com.example.authentification.entityDTO.LogingInfoDTO;
import org.springframework.http.ResponseEntity;

public interface AuthentificationService {

    public ResponseEntity<Object> loginUser(LogingInfoDTO logingInfoDTO);

    public void logoutUser();

}
