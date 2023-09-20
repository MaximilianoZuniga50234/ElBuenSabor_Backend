package com.example.elbuensaborbackend.services.Implementation;

import com.example.elbuensaborbackend.models.dtos.UserDTO;
import com.example.elbuensaborbackend.models.entities.Product;
import com.example.elbuensaborbackend.models.entities.User;
import com.example.elbuensaborbackend.repositories.*;
import com.example.elbuensaborbackend.services.CloudinaryService;
import com.example.elbuensaborbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    @Autowired
    private CloudinaryService cloudinaryService;

    public UserServiceImpl(BaseRepository<User, Long> baseRepository) {
        super(baseRepository);
    }

    public List<UserDTO> getUsersDTOs() throws Exception {
        try{
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
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public User createWithImage(User user, Optional<MultipartFile> image) throws Exception {
        try {
            if (image.isPresent()) {
                Map<String, ?> result = cloudinaryService.upload(image.get());
                user.setProfilePictureUrl(result.get("secure_url").toString());
            }else{
                user.setProfilePictureUrl("https://res.cloudinary.com/dycogxoko/image/upload/v1695236534/assets%20for%20elBuenSabor/cnw3rfld20mwipmfdngl.png");
            }
            user = userRepository.save(user);
            return user;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public User updateWithImage(User user, Optional<MultipartFile> image, Long id) throws Exception {
        try {
            Optional<User> oldUser = userRepository.findById(id);
            if (oldUser.isEmpty()) {
                throw new Exception("No se encontró el producto con el id: " + id);
            }
            if (image.isPresent()) {
                Map<String, ?> result = cloudinaryService.upload(image.get());
                user.setProfilePictureUrl(result.get("secure_url").toString());
            }
            User existingUser = oldUser.get();
            user.setId(existingUser.getId());
            existingUser = user;
            return userRepository.save(existingUser);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
