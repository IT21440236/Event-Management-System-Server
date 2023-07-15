package com.spm.eventmanagementsystem.service;

import com.spm.eventmanagementsystem.dto.LoginDTO;
import com.spm.eventmanagementsystem.dto.UserDTO;
import com.spm.eventmanagementsystem.entity.User;
import com.spm.eventmanagementsystem.repository.UserRepository;
import com.spm.eventmanagementsystem.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String addUser(UserDTO userDTO) {
        User user = new User();
        user.setUserId(userDTO.getUserId());
        user.setUserName(userDTO.getUserName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(this.passwordEncoder.encode(userDTO.getPassword()));
        userRepository.save(user);
        return "User Added Successfully";
    }

    @Override
    public LoginResponse loginUser(LoginDTO loginDTO) {
        String msg = "";
        User user1 = userRepository.findByEmail(loginDTO.getEmail());

        if(user1 != null){
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();

            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);

            if (isPwdRight){
                Optional<User> user = userRepository.findOneByEmailAndPassword(loginDTO.getEmail(),encodedPassword);
                if (user.isPresent()){
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            }else {
                return new LoginResponse("Passwords Do Not Match !", false);
            }
        } else {
            return new LoginResponse("Email not exists", false);
        }

    }
}
