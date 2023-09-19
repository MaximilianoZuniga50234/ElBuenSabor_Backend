package com.example.elbuensaborbackend.services.Implementation;

import com.example.elbuensaborbackend.models.entities.Address;
import com.example.elbuensaborbackend.repositories.AddressRepository;
import com.example.elbuensaborbackend.repositories.BaseRepository;
import com.example.elbuensaborbackend.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl extends BaseServiceImpl<Address, Long> implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public AddressServiceImpl(BaseRepository<Address, Long> addressRepository) {
        super(addressRepository);
    }
}
