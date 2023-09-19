package com.example.elbuensaborbackend.services;

import com.example.elbuensaborbackend.models.entities.MeasurementUnit;

public interface MeasurementUnitService extends BaseService<MeasurementUnit,Long>{
    boolean leave(Long id) throws Exception;
}
