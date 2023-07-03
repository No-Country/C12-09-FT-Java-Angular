package com.nocountry.powerfit.service.abstraction;

import com.nocountry.powerfit.model.request.UserRequest;

public interface UserService {
    //UserResponse getUserById(Long id);
    //UserResponse updateUser(UserRequest request);
    Void deleteUser(Long id);
}
