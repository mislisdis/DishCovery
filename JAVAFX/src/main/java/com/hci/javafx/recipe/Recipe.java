package com.hci.javafx.recipe;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Recipe {

    private String name;
    private boolean vegetarian;
    private int calories;
    private int prep_time;
    private String difficulty;
    private List<String> ingredients;
    private List<String> steps;
    private String image_path;

    public Recipe() {
        this.ingredients = new ArrayList<>();
        this.steps = new ArrayList<>();
    }

    public boolean matchesPrepTime(int cookTime) {
        return cookTime <= prep_time;
    }
}
