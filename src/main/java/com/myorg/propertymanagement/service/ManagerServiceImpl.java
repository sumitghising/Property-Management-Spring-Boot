package com.myorg.propertymanagement.service;

import com.myorg.propertymanagement.dto.ManagerDTO;
import com.myorg.propertymanagement.model.Manager;
import com.myorg.propertymanagement.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class ManagerServiceImpl implements  ManagerService {
    @Autowired
    ManagerRepository managerRepository;

    public  static final Map<String, Long> loggedInUsers = new HashMap<>();

    public Manager createManager(ManagerDTO dto){
        return managerRepository.save(new Manager(dto));
    }

    public String login(ManagerDTO manager){
        Manager loggedManager =  managerRepository.findByEmailAndPassword(manager.getEmail(), manager.getPassword()).orElseThrow(()-> new IllegalArgumentException("Invalid email or password"));
        String token = randomStringGenerator();
        loggedInUsers.put(token, loggedManager.getId());
        System.out.println(loggedInUsers);
        return token;
    }


    //Only for demo purpose since we are not using JWT yet
    public String randomStringGenerator(){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int length = 8;
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }
        return randomString.toString();
    }
}
