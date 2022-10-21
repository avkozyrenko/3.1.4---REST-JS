package com.example.REST314.controller;

import com.example.REST314.DTOservice.UserDTOService;
import com.example.REST314.dto.UserDTO;
import com.example.REST314.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class AdminRestController {

    private final UserService userservice;
    private final UserDTOService userDTOService;


    @Autowired
    public AdminRestController(UserService userservice, UserDTOService userDTOService) {
        this.userservice = userservice;
        this.userDTOService = userDTOService;
    }


    @GetMapping("/api/admin")
    public List<UserDTO> getAllUsers() {
        return userservice.getAllUsers().stream().map(user -> userDTOService.convertToUserDTO(user))
                .collect(Collectors.toList());
    }


    @PostMapping("api/admin")
    public ResponseEntity<UserDTO> registerNewUser(@RequestBody @Valid UserDTO userDTO) {
        userservice.addUser(userDTOService.convertToUser(userDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping("api/admin/{id}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody @Valid UserDTO userDTO, @PathVariable int id) {
        userservice.updateUser(id, userDTOService.convertToUser(userDTO));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("api/admin/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") int id) {
        userservice.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
