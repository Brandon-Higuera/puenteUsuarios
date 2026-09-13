package com.puente.service;

import com.puente.DTO.userDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface userService {

    List<userDTO> getUsersByArea(String area);
    List<userDTO> getAllActiveUser();
    userDTO saveUser(userDTO user);
    void deleteUser(Long id);
    userDTO getUserById(Long id);
    ResponseEntity<String> softDeleteUser(Long id);
}
