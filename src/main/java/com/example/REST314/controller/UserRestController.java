package com.example.REST314.controller;

import com.example.REST314.DTOservice.UserDTOService;
import com.example.REST314.dto.UserDTO;
import com.example.REST314.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.security.Principal;

@RestController
public class UserRestController {

    private final UserService userService;
    private final UserDTOService userDTOService;


    @Autowired
    public UserRestController(UserService userService, UserDTOService userDTOService) {
        this.userService = userService;
        this.userDTOService = userDTOService;
    }

    @GetMapping(value = "/api/user")
    public UserDTO getUser(Principal principal) {
        return userDTOService.convertToUserDTO(userService.loadUserByUsername(principal.getName()));

    }

}
