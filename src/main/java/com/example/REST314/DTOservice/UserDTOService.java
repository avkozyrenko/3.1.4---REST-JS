package com.example.REST314.DTOservice;

import com.example.REST314.dto.UserDTO;
import com.example.REST314.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserDTOService {

    public UserDTO convertToUserDTO(UserDetails userDetails);

    public UserDTO convertToUserDTO(User user);

    public User convertToUser(UserDTO userDTO);
}
