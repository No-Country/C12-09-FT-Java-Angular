package com.nocountry.powerfit.service;

import com.nocountry.powerfit.model.entity.User;
import com.nocountry.powerfit.model.response.BillResponse;
import com.nocountry.powerfit.repository.IBillRepository;
import com.nocountry.powerfit.service.abstraction.IBillService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillServiceImp  implements IBillService {
    @Autowired
    IBillRepository iBillRepository;

    @Override
    public BillResponse getById(Long id) {
        return null;
    }

    @Override
    public List<BillResponse> getAll() {
        return null;
    }

    @Override
    public List<BillResponse> findByName(User user) {
        return null;
    }
}
