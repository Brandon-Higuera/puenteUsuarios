package com.puente.controller;

import com.puente.DTO.userDTO;
import com.puente.service.impl.userServiceImpl;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/puente")
public class userController {
    @Autowired
    private userServiceImpl userService;

    @GetMapping("/usuarios")
    public List<userDTO> getAllActiveUser(){
        return userService.getAllActiveUser();
    }

    @GetMapping("/usuarios/{id}")
    public userDTO getUserById(@PathVariable Long id){
        return  userService.getUserById(id);
    }

   @GetMapping(value = "/usuarios" , params ="area")
   public List<userDTO> getUsuarios(@RequestParam String area) {
       if (area != null && !area.isEmpty()) {
           return userService.getUsersByArea(area);
       } else {
           return userService.getAllActiveUser();
       }

   }

   @PostMapping("/usuarios/crear")
   public userDTO saveUser(@RequestBody userDTO user){
       return userService.saveUser(user);
   }

   @DeleteMapping("/usuarios/borrar/{id}")
   public ResponseEntity<String> deleteUser(@PathVariable Long id) {
       try {
           userService.deleteUser(id);
           return ResponseEntity.ok("Usuario eliminado exitosamente.");
       } catch (FeignException.NotFound e) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado.");
       }
   }

   @DeleteMapping("/usuarios/eliminar/{id}")
   public ResponseEntity<String> softDeleteUser(@PathVariable Long id) {
       try {
           userService.softDeleteUser(id);
           return ResponseEntity.ok("Usuario eliminado exitosamente.");
       }catch (FeignException.NotFound e){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado.");
       }catch (FeignException.BadRequest e){
           return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuario no se puede eliminar.");
       }
   }
}
