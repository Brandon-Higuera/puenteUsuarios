package com.puente.service.impl;

import com.puente.DTO.userDTO;
import com.puente.client.userClient;
import com.puente.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class userServiceImpl implements userService {
    @Autowired
    private userClient userClient;

    public userServiceImpl(userClient userClient) {
        this.userClient = userClient;
    }

    public userDTO getUserById(Long id){
        return userClient.getUserById(id);
    }

    public List<userDTO> getUsersByArea(String area){
        return userClient.getUsersByArea(area);
    }

    public List<userDTO> getAllActiveUser() {
        return userClient.getAllActiveUser();
    }

    public userDTO saveUser(userDTO user) {
        return userClient.saveUser(user);
    }

    public void deleteUser(Long id){
        userClient.deleteUser(id);
    }

   public ResponseEntity<String> softDeleteUser(Long id){
       return userClient.softDeleteUser(id);
   }

}
