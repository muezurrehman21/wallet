package com.zaio.Service;

import com.zaio.DTO.UserRequestDTO;
import com.zaio.Entity.User;
import com.zaio.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    this.userId = userId;
//        this.username = username;
//        this.password = password;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//        this.createdAt = createdAt;
//        this.updatedAt = updatedAt;
    public UserRequestDTO CreateUser(UserRequestDTO userRequestDTO) {
        User user = new User(
                userRequestDTO.getUserId(),
                userRequestDTO.getUsername(),
                userRequestDTO.getPassword(),
                userRequestDTO.getEmail(),
                userRequestDTO.getPhoneNumber(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        User savedUser = userRepository.save(user);
        UserRequestDTO savedUserRequest = new UserRequestDTO(
          savedUser.getUserId(),
          savedUser.getUsername(),
          savedUser.getEmail(),
          savedUser.getPassword(),
          savedUser.getPhoneNumber()
        );
        return savedUserRequest;
    }

    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }
}
