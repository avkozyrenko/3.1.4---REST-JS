package com.example.REST314.DTOservice;

import com.example.REST314.dto.UserDTO;
import com.example.REST314.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserDTOServiceImp implements UserDTOService {

    private final ModelMapper modelMapper;

    @Autowired
    public UserDTOServiceImp(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDTO convertToUserDTO(UserDetails userDetails) {
        return modelMapper.map(userDetails, UserDTO.class);
    }

    @Override
    public UserDTO convertToUserDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public User convertToUser(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
}
