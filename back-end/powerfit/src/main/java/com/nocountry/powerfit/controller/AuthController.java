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
import org.springframework.validation.BindingResult;
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
    public ResponseEntity<?> create(@Valid @RequestBody RegisterRequest request, BindingResult bindingResult) throws AttributeException {
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getFieldErrors()
                    .stream()
                    .map(error -> error.getDefaultMessage())
                    .reduce("", (accumulator, message) -> accumulator + " " + message);
            return ResponseEntity.badRequest().body(errorMessage.trim());
        }
        try {
            User userEntity = authService.create(request);
            return ResponseEntity.ok(new MessageDto(HttpStatus.OK, "User " + userEntity.getEmail() + " has been created"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }
}
