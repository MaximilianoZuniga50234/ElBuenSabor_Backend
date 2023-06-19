package com.example.elbuensaborbackend.services.Implementation;

import com.example.elbuensaborbackend.entities.User;
import com.example.elbuensaborbackend.repositories.BaseRepository;
import com.example.elbuensaborbackend.repositories.UserRepository;
import com.example.elbuensaborbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(BaseRepository<User, Long> userRepository) {
        super(userRepository);
    }
}
