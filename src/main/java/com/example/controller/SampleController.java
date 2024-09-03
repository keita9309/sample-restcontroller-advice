package com.example.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.BadBloodTypeException;
import com.example.model.Person;

@RestController
public class SampleController {
    @GetMapping(value = "/{bloodType}")
    public ResponseEntity<Object> hello(@PathVariable String bloodType) {
        Person p = new Person();
        p.setFirstName("first");
        p.setMiddleName("middle");
        p.setLastName("last");
        p.setAge(24);
        boolean isBoodType = isBloodType(bloodType);

        if (isBoodType) {
            p.setBloodType(bloodType);
        }
        return ResponseEntity.status(HttpStatus.OK).body(p);
    }

    private boolean isBloodType(String bloodType) throws BadBloodTypeException{
        List<String> ageList = new ArrayList<String>(Arrays.asList("A","B","AB","O"));
        if (!ageList.contains(bloodType)) {
            throw new BadBloodTypeException("BadBloodTypeExceptionが発生しました");
        }
        return true;
    }
}
