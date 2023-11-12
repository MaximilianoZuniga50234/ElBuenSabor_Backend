package com.example.elbuensaborbackend.services.Implementation;

import com.example.elbuensaborbackend.models.entities.Status;
import com.example.elbuensaborbackend.repositories.BaseRepository;
import com.example.elbuensaborbackend.repositories.StatusRepository;
import com.example.elbuensaborbackend.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl extends BaseServiceImpl<Status, Long> implements StatusService {

    @Autowired
    private StatusRepository stateRepository;

    public StatusServiceImpl(BaseRepository<Status, Long> stateRepository) {
        super(stateRepository);
    }
}
