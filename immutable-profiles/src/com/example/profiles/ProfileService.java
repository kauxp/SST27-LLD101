package com.example.profiles;

import java.util.Objects;

/**
 * Assembles profiles with scattered, inconsistent validation.
 */
public class ProfileService {

    // returns a fully built profile but mutates it afterwards (bug-friendly)
    public UserProfile createMinimal(String id, String email) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("bad id");
        if (email == null || !email.contains("@")) throw new IllegalArgumentException("bad email");

        // UserProfile p = new UserProfile(id, email);
        UserProfile p2 = new UserProfile.Builder().setId(id).setEmail(email).build();
        // later code keeps mutating...
        return p2;
    }

    public UserProfile addDisplayName(UserProfile p, String displayName) {
        Objects.requireNonNull(p, "profile");
        if (displayName != null && displayName.length() > 100) {
            // silently trim (inconsistent policy)
            displayName = displayName.substring(0, 100);
        }
        return new UserProfile.Builder().setId(p.getId()).setEmail(p.getEmail()).setPhone(p.getPhone()).setDisplayName(displayName).setAddress(p.getAddress()).setMarketingOptIn(p.isMarketingOptIn()).setTwitter(p.getTwitter()).setGithub(p.getGithub()).build();
    }
}
