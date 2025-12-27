package com.examly.springapp.service;

import com.examly.springapp.model.Profile;
import com.examly.springapp.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {
    
    @Autowired
    private ProfileRepo repo;
    
    @Override
    public Profile saveProfile(Profile profile) {
        return repo.save(profile);
    }
    
    @Override
    public List<Profile> getAllProfiles() {
        return repo.findAll();
    }
    
    @Override
    public Profile getProfileById(Long id) {
        return repo.findById(id).orElse(null);
    }
    
    @Override
    public Profile updateProfile(Long id, Profile profile) {
        profile.setId(id);
        return repo.save(profile);
    }
    
    @Override
    public void deleteProfile(Long id) {
        repo.deleteById(id);
    }
    
    @Override
    public List<Profile> getProfilesByName(String firstName) {
        return repo.findByFirstName(firstName);
    }
    
    @Override
    public List<Profile> getProfilesByNameAndAddress(String firstName, String address) {
        return repo.findByFirstNameAndAddress(firstName, address);
    }
}
