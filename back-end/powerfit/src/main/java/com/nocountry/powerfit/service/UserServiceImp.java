package com.nocountry.powerfit.service;

import com.nocountry.powerfit.model.entity.User;
import com.nocountry.powerfit.model.exception.UserAlreadyExistException;
import com.nocountry.powerfit.model.mapper.UserMapper;
import com.nocountry.powerfit.model.request.UserRequest;
import com.nocountry.powerfit.model.response.UserResponse;
import com.nocountry.powerfit.repository.IUserRepository;
import com.nocountry.powerfit.service.abstraction.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final IUserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id).get();
        if(user != null){
            return userMapper.dtoToEntityUser(user);
        }
        throw new EntityNotFoundException("User does not exist");
    }

    @Override
    public UserResponse updateUser(UserRequest updateRequest) {
        boolean isUserExists = userRepository.existsById(updateRequest.getId());
        boolean isEmailExist = userRepository.existsByEmail(updateRequest.getEmail());
        if(!isUserExists){
            throw new EntityNotFoundException("User does not exist");
        }else if(isEmailExist){
            throw new UserAlreadyExistException("Email is already in use");
        }else{
            User userUpdate = userMapper.updateToDto(updateRequest);
            userRepository.save(userUpdate);
            UserResponse response = userMapper.dtoToEntityUser(userUpdate);
            return response;
        }
    }

    @Override
    public void deleteUser(Long id) {
        Boolean isUserExists = userRepository.existsById(id);
        if(!isUserExists){
            throw new EntityNotFoundException("User does not exist");
        }
        userRepository.deleteById(id);

    }
}
