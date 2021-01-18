package com.example.oauth2serverresources.service;

import com.example.oauth2serverresources.dao.WeaponRepository;
import com.example.oauth2serverresources.model.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Increment a value by delta and return the new value.
 *
 * @param delta the amount the value should be incremented by
 * @return the post-incremented value
 **/
@Service
public class WeaponServiceImpl implements WeaponService{

    @Autowired
    private WeaponRepository weaponRepository;

    @Override
    public List<Weapon> findAll() {
        return weaponRepository.findAll();
    }

    @Override
    public Weapon findById(Integer id) {
        return weaponRepository.findById(id).orElse(null);
    }
}
