package com.nocountry.powerfit.controller;

import com.nocountry.powerfit.model.entity.User;
import com.nocountry.powerfit.model.exception.AttributeException;
import com.nocountry.powerfit.model.request.LoginRequest;
import com.nocountry.powerfit.model.request.RegisterRequest;
import com.nocountry.powerfit.model.response.AuthResponse;
import com.nocountry.powerfit.model.response.MessageDto;
import com.nocountry.powerfit.service.abstraction.AuthService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @ApiOperation(value = "Registro de usuario", notes = "Devuelve info del usuario")
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) throws IOException{
        AuthResponse response =authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @ApiOperation(value = "Login de usuario", notes = "Devuelve info del usuario y un token")
    @PostMapping("/login")
    private ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request){
        AuthResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/create")
    public ResponseEntity<MessageDto> create(@Valid @RequestBody RegisterRequest request) throws AttributeException {
        User userEntity = authService.create(request);
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, "user " + userEntity.getEmail() + " have been created"));
    }
}
