package com.puente.client;

import com.puente.DTO.userDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "user-service" , url = "${MICRO_USUARIOS_URL:https://micro-usuarios-447894908434.us-central1.run.app}")
public interface userClient {

    @GetMapping(value = "/api/user", params = "area")
    List<userDTO> getUsersByArea(@RequestParam("area") String area);

    @GetMapping("/api/user/{id}")
    userDTO getUserById(@PathVariable("id") Long id);

    @GetMapping("/api/user")
    List<userDTO> getAllActiveUser();

    @PostMapping("/api/user/crear")
    userDTO saveUser(userDTO user);

    @DeleteMapping("api/user/{id}")
    void deleteUser(@PathVariable("id") Long id);

    @DeleteMapping("/api/user/eliminar/{id}")
    ResponseEntity<String> softDeleteUser(@PathVariable("id") Long id);

}
