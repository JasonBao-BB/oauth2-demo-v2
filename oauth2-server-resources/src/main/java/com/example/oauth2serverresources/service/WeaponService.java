package com.example.oauth2serverresources.service;

import com.example.oauth2serverresources.model.Weapon;

import java.util.List;

/**
 * Increment a value by delta and return the new value.
 *
 * @param delta the amount the value should be incremented by
 * @return the post-incremented value
 **/
public interface WeaponService {
    List<Weapon> findAll();
    Weapon findById(Integer id);
}
