package com.nocountry.powerfit.service;

import com.nocountry.powerfit.model.entity.User;
import com.nocountry.powerfit.model.exception.InvalidCredentialsException;
import com.nocountry.powerfit.model.mapper.UserMapper;
import com.nocountry.powerfit.model.request.LoginRequest;
import com.nocountry.powerfit.model.request.RegisterRequest;
import com.nocountry.powerfit.model.response.AuthResponse;
import com.nocountry.powerfit.repository.IUserRepository;
import com.nocountry.powerfit.service.abstraction.AuthService;
import com.nocountry.powerfit.model.exception.UserAlreadyExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthServiceImp implements AuthService {

    private final IUserRepository userRepository;
    private final UserMapper userMapper;
    private final Logger LOGGER = LoggerFactory.getLogger(AuthServiceImp.class);
    //private final AuthenticationManager

    private User getUser(String email){
        User user = userRepository.findByEmail(email);
        if(user == null /*|| !user.isEnabled()*/){
            throw new InvalidCredentialsException("Invalid email or password");
        }
        return user;
    }
    @Override
    public AuthResponse register(RegisterRequest registerRequest) throws IOException {
        Boolean isUserExists = userRepository.findByEmail(registerRequest.getEmail()) != null;
        if(isUserExists){
            throw new UserAlreadyExistException("Email is already in use");
        }
        User createUser = userRepository.save(userMapper.RegisterToDto(registerRequest));
        //JWT implementar
        AuthResponse response = userMapper.dtoToEntity(createUser);
        return response;
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        //authenticate(loginRequest)
        User user = getUser(loginRequest.getEmail());
        LOGGER.warn("Email:" + user.getEmail());
        AuthResponse mapper = userMapper.dtoToEntity(user);
        //JWT
        return mapper;
    }

    /*private void authenticate(LoginRequest loginRequest){
        try {
            authenticationManager.authenticate(new UsernamePasswordAutehnticationToken(
                    loginRequest.getEmail(),
                    loginRequest.getPassword()
            ));
        }catch (Exception e){
            throw new InvalidCredentialsException("Invalid email or password")
        }
    }*/
}
