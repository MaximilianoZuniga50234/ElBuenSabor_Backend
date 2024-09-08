package com.example.elbuensaborbackend.services.Implementation;

import com.example.elbuensaborbackend.models.entities.Role;
import com.example.elbuensaborbackend.repositories.BaseRepository;
import com.example.elbuensaborbackend.repositories.RoleRepository;
import com.example.elbuensaborbackend.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, Long> implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public RoleServiceImpl(BaseRepository<Role, Long> roleRepository) {
        super(roleRepository);
    }
}
