package com.nocountry.powerfit.repository;

import com.nocountry.powerfit.model.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillRepository extends JpaRepository<Bill, Long>{

}
