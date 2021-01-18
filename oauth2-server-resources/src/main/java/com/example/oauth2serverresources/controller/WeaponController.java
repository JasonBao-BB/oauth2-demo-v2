package com.example.oauth2serverresources.controller;

import com.example.oauth2serverresources.model.Weapon;
import com.example.oauth2serverresources.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/weapon")
public class WeaponController {

    @Autowired
    private WeaponService weaponService;

    @GetMapping("")
    public ResponseEntity<List<Weapon>> findAllWeapon(){
        List<Weapon> weapons = weaponService.findAll();
        return new ResponseEntity<>(weapons, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Weapon> findById(@PathVariable("id") Integer id){
        Weapon weapon = weaponService.findById(id);
        return new ResponseEntity<>(weapon, HttpStatus.OK);
    }
}
