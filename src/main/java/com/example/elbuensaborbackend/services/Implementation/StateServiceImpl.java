package com.example.elbuensaborbackend.services.Implementation;

import com.example.elbuensaborbackend.entities.State;
import com.example.elbuensaborbackend.repositories.BaseRepository;
import com.example.elbuensaborbackend.repositories.StateRepository;
import com.example.elbuensaborbackend.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateServiceImpl extends BaseServiceImpl<State, Long> implements StateService {

    @Autowired
    private StateRepository stateRepository;

    public StateServiceImpl(BaseRepository<State, Long> stateRepository) {
        super(stateRepository);
    }
}
