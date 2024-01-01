package com.example.demo.serviceImpl;

import com.example.demo.entity.User;
import com.example.demo.entityDTO.LogingInfoDTO;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthentificationServiceImpl implements AuthentificationService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<Object> loginUser(LogingInfoDTO logingInfoDTO) {
        Optional<User> m_user = userRepository.findUserByLogin(logingInfoDTO.getLogin());
        if (m_user.isEmpty()){
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        if (isPasswordCorrect(m_user.get().getPassword(),logingInfoDTO.getPassword())){
            return new ResponseEntity<>("Logged",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Wrong password",HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public void logoutUser() {

    }

    public Boolean isPasswordCorrect(String realPassWord, String dtoPassWord) {
        return realPassWord.equals(dtoPassWord);
    }
}
