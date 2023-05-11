package com.example.elbuensaborbackend.services.Implementation;

import com.example.elbuensaborbackend.entities.MeasurementUnit;
import com.example.elbuensaborbackend.repositories.BaseRepository;
import com.example.elbuensaborbackend.repositories.MeasurementUnitRepository;
import com.example.elbuensaborbackend.services.MeasurementUnitService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public abstract class MeasurementUnitServiceImpl extends BaseServiceImpl<MeasurementUnit, Long> implements MeasurementUnitService {

    @Autowired
    private MeasurementUnitRepository measurementUnitRepository;

    public MeasurementUnitServiceImpl(BaseRepository<MeasurementUnit, Long> baseRepository) {
        super(baseRepository);
    }
}
