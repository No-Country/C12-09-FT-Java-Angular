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

    private final IUserRepository IUserRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse getUserById(Long id) {
        User user = IUserRepository.findById(id).get();
        if(user != null){
            return userMapper.dtoToEntityUser(user);
        }
        throw new EntityNotFoundException("User does not exist");
    }

    @Override
    public UserResponse updateUser(UserRequest updateRequest) {
        boolean isUserExists = IUserRepository.existsById(updateRequest.getId());
        boolean isEmailExist = IUserRepository.existsByEmail(updateRequest.getEmail());
        if(!isUserExists){
            throw new EntityNotFoundException("User does not exist");
        }else if(isEmailExist){
            throw new UserAlreadyExistException("Email is already in use");
        }else{
            User userUpdate = userMapper.updateToDto(updateRequest);
            IUserRepository.save(userUpdate);
            UserResponse response = userMapper.dtoToEntityUser(userUpdate);
            return response;
        }
    }

    @Override
    public void deleteUser(Long id) {
        Boolean isUserExists = IUserRepository.existsById(id);
        if(!isUserExists){
            throw new EntityNotFoundException("User does not exist");
        }
        IUserRepository.deleteById(id);

    }

    @Override
    public UserResponse getUserInfo() {
//        Object userInstance = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        try {
//            if (userInstance instanceof User) {
//                String username = ((User) userInstance).getUsername();
//            }
//        } catch (Exception e) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        return userRepository.findByEmail(userInstance.toString());
        return null;
    }
}
