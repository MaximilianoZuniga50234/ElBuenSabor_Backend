package com.example.elbuensaborbackend.services.Implementation;

import com.example.elbuensaborbackend.models.dtos.UserDTO;
import com.example.elbuensaborbackend.models.entities.User;
import com.example.elbuensaborbackend.repositories.*;
import com.example.elbuensaborbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private AddressRepository addressRepository;

    public UserServiceImpl(BaseRepository<User, Long> baseRepository) {
        super(baseRepository);
    }

    public List<UserDTO> getUsersDTOs() {
        List<User> users = userRepository.findAll();
        List<UserDTO> usersDTO = new ArrayList<>();

        users.forEach(user -> {
            UserDTO userDto = new UserDTO();
            userDto.setId(user.getId());
            userDto.setEmail(user.getPerson().getEmail());
            userDto.setFullName(user.getPerson().getName() + " " + user.getPerson().getLastName());
            userDto.setTelephone(user.getPerson().getPhoneNumber());
            userDto.setRole(user.getRole().getRole());
            userDto.setAddresses(addressRepository.addressByPerson(user.getPerson()));
            userDto.setOrders(purchaseOrderRepository.ordersByUser(user));
            userDto.setInvoices(invoiceRepository.invoicesByUser(user));
            usersDTO.add(userDto);
        });
        return usersDTO;
    }
}
