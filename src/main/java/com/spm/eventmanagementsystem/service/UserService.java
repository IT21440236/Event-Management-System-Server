package com.spm.eventmanagementsystem.service;

import com.spm.eventmanagementsystem.dto.LoginDTO;
import com.spm.eventmanagementsystem.dto.UserDTO;
import com.spm.eventmanagementsystem.entity.User;
import com.spm.eventmanagementsystem.response.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public String addUser(UserDTO userDTO);

    public LoginResponse loginUser(LoginDTO loginDTO);

}
