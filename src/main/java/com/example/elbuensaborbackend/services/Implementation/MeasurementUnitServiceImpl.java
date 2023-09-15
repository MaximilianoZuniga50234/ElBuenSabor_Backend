package com.example.elbuensaborbackend.services.Implementation;

import com.example.elbuensaborbackend.entities.MeasurementUnit;
import com.example.elbuensaborbackend.repositories.BaseRepository;
import com.example.elbuensaborbackend.repositories.MeasurementUnitRepository;
import com.example.elbuensaborbackend.services.MeasurementUnitService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class MeasurementUnitServiceImpl extends BaseServiceImpl<MeasurementUnit, Long> implements MeasurementUnitService {

    @Autowired
    private MeasurementUnitRepository measurementUnitRepository;

    public MeasurementUnitServiceImpl(BaseRepository<MeasurementUnit, Long> baseRepository) {
        super(baseRepository);
    }

    public boolean leave(Long id) throws Exception {
        try{
            if(measurementUnitRepository.existsById(id)) {
                MeasurementUnit existingMeasurementUnit = measurementUnitRepository.findById(id).get();
                existingMeasurementUnit.setActive(false);
                measurementUnitRepository.save(existingMeasurementUnit);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
