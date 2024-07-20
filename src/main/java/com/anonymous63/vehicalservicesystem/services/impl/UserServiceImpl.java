package com.anonymous63.vehicalservicesystem.services.impl;

import com.anonymous63.vehicalservicesystem.dtos.UserDTO;
import com.anonymous63.vehicalservicesystem.exceptions.ResourceNotFoundException;
import com.anonymous63.vehicalservicesystem.models.User;
import com.anonymous63.vehicalservicesystem.repositories.UserRepo;
import com.anonymous63.vehicalservicesystem.services.UserService;
import com.anonymous63.vehicalservicesystem.utils.CustomeDtoNameResolver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        User user = this.modelMapper.map(userDTO, User.class);
        User saveUser = this.userRepo.save(user);
        return this.modelMapper.map(saveUser, UserDTO.class);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        return null;
    }

    @Override
    public void delete(Long id) { /* Deletes an entity by its ID. */ }

    @Override
    public UserDTO findById(Long id) {
        User user = this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(CustomeDtoNameResolver.resolve(UserDTO.class), "id", id));
        return this.modelMapper.map(user, UserDTO.class);
    }

    @Override
    public List<UserDTO> findAll() {
        return List.of();
    }

    @Override
    public List<UserDTO> disable() {
        return List.of();
    }

    @Override
    public List<UserDTO> enable() {
        return List.of();
    }

    @Override
    public String getEntityName() {
        return User.class.getClass().getSimpleName();
    }
}
