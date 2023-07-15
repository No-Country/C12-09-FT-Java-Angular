package com.nocountry.powerfit.service.abstraction;

import com.nocountry.powerfit.model.entity.User;
import com.nocountry.powerfit.model.response.BillResponse;

import java.util.List;

public interface IBillService {
    BillResponse    getById(Long id);
    List<BillResponse> getAll();
    List<BillResponse> findByName(User user);
}
