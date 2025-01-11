package com.solvd.onlineshop.enums;

public enum Gender {
    MALE("Male", "Men's clothing"),
    FEMALE("Female", "Women's clothing"),
    UNISEX("Unisex", "Clothing suitable for both genders");

    private final String gender;
    private final String description;

   private Gender(String gender, String description) {
        this.gender = gender;
        this.description = description;
    }

    public String getGender() {
        return gender;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.gender + ": " + this.description;
    }
}

