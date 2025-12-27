package com.examly.springapp.service;

import com.examly.springapp.model.Profile;

import java.util.List;

public interface ProfileService {
    Profile saveProfile(Profile profile);
    List<Profile> getAllProfiles();
    Profile getProfileById(Long id);
    Profile updateProfile(Long id, Profile profile);
    void deleteProfile(Long id);
    List<Profile> getProfilesByName(String firstName);
    List<Profile> getProfilesByNameAndAddress(String firstName, String address);
}
