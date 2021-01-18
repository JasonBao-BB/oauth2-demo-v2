package com.example.oauth2serverresources.dao;

import com.example.oauth2serverresources.model.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Increment a value by delta and return the new value.
 *
 * @param delta the amount the value should be incremented by
 * @return the post-incremented value
 **/
@Repository
public interface WeaponRepository extends JpaRepository<Weapon, Integer> {
}
