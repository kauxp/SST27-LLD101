package com.example.profiles;

/**
 * Mutable and confusing. Multiple constructors + setters.
 */
public class UserProfile {
    private String id;
    private String email;
    private String phone;
    private String displayName;
    private String address;
    private boolean marketingOptIn;
    private String twitter;
    private String github;

    public UserProfile(Builder builder) {
        this.id = builder.id;
        this.email = builder.email;
        this.phone = builder.phone;
        this.displayName = builder.displayName;
        this.address = builder.address;
        this.marketingOptIn = builder.marketingOptIn;
        this.twitter = builder.twitter;
        this.github = builder.github;
    }

    
    // getters
    public String getId() { return id; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getDisplayName() { return displayName; }
    public String getAddress() { return address; }
    public boolean isMarketingOptIn() { return marketingOptIn; }
    public String getTwitter() { return twitter; }
    public String getGithub() { return github; }

    public static class Builder{
        private String id;
        private String email;
        private String phone;
        private String displayName;
        private String address;
        private boolean marketingOptIn;
        private String twitter;
        private String github;
        public Builder setId(String id) { 
            this.id = id; 
            return this; 
        }
        public Builder setEmail(String email) { 
            this.email = email; 
            return this; 
        }
        public Builder setPhone(String phone) { 
            this.phone = phone; 
            return this; 
        }
        public Builder setDisplayName(String displayName) { 
            this.displayName = displayName; 
            return this; 
        }
        public Builder setAddress(String address) { 
            this.address = address; 
            return this; 
        }
        public Builder setMarketingOptIn(boolean marketingOptIn) { 
            this.marketingOptIn = marketingOptIn; 
            return this; 
        }
        public Builder setTwitter(String twitter) { 
            this.twitter = twitter; 
            return this; 
        }
        public Builder setGithub(String github) { 
            this.github = github; 
            return this; 
        }
        public UserProfile build() {
            return new UserProfile(this);
        }
    }
}
