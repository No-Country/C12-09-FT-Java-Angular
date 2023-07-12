package com.nocountry.powerfit.service;

import com.nocountry.powerfit.model.entity.Image;
import com.nocountry.powerfit.repository.IImageRepository;

public class ImageServiceImpl {

    IImageRepository iImageRepository;

    public Image findById(Long id) {
        return iImageRepository.findById(id.intValue()).orElseThrow();
    }
}
