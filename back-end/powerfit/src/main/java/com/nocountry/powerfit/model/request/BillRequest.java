package com.nocountry.powerfit.model.request;

import com.nocountry.powerfit.model.entity.User;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class BillRequest {
    private Long id;
    @NotEmpty(message = "El usuario no debe estar vacio.")
    private User user;
    private LocalDateTime date;
}
