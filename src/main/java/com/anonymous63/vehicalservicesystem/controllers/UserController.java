package com.anonymous63.vehicalservicesystem.controllers;

import com.anonymous63.vehicalservicesystem.dtos.UserDTO;
import com.anonymous63.vehicalservicesystem.payloads.responses.APIResponse;
import com.anonymous63.vehicalservicesystem.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<APIResponse<UserDTO>> createUser(@RequestBody @Valid UserDTO userDTO) {
        UserDTO saveUser = this.userService.save(userDTO);
        APIResponse<UserDTO> response = APIResponse.<UserDTO>builder()
                .status(true)
                .message("User created successfully")
                .results(saveUser)
                .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
