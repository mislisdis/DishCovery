package com.hci.javafx.recipe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecipeService {

    @Getter
    private List<Recipe> recipes;
    private static final String RECIPE_JSON_PATH = "/com/hci/javafx/recipes.json";

    public RecipeService() {
        loadRecipes();
    }

    private void loadRecipes() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            recipes = mapper.readValue(
                    getClass().getResourceAsStream(RECIPE_JSON_PATH),
                    new TypeReference<List<Recipe>>() {}
            );
        } catch (IOException e) {
            System.err.println("Error loading recipes: " + e.getMessage());
            recipes = new ArrayList<>();
        }
    }

    public List<Recipe> searchByIngredients(List<String> ingredients) {
        List<String> lowerCaseIngredients = ingredients.stream()
                .map(String::toLowerCase)
                .toList();

        return recipes.stream().filter(recipe -> {
            // Convert recipe ingredients to lowercase
            List<String> recipeLowerCaseIngredients = recipe.getIngredients().stream()
                    .map(String::toLowerCase)
                    .toList();

            boolean hasAnyIngredient = false;
            for (String ingredient : lowerCaseIngredients) {
                for (String recipeIngredient : recipeLowerCaseIngredients) {
                    if (recipeIngredient.contains(ingredient)) {
                        hasAnyIngredient = true;
                        break;
                    }
                }
                if (hasAnyIngredient) break;
            }
            return hasAnyIngredient;
        }).collect(Collectors.toList());
    }

    // Search recipes by name (case-insensitive)
    public List<Recipe> searchByName(String name) {
        String lowerCaseName = name.toLowerCase();
        return recipes.stream()
                .filter(recipe -> recipe.getName().toLowerCase().contains(lowerCaseName))
                .collect(Collectors.toList());
    }

    // Search recipes by preparation time using Recipe.matchesPrepTime
    public List<Recipe> searchByPrepTime(int prepTime) {
        return recipes.stream()
                .filter(recipe -> recipe.matchesPrepTime(prepTime))
                .collect(Collectors.toList());
    }

    // Search recipes by ingredients and preparation time
    public List<Recipe> searchByIngredientsAndPrepTime(List<String> ingredients, int prepTime) {
        // First, filter recipes by ingredients
        List<Recipe> ingredientMatchedRecipes = searchByIngredients(ingredients);
        // Then, filter those by prep time
        return ingredientMatchedRecipes.stream()
                .filter(recipe -> recipe.matchesPrepTime(prepTime))
                .collect(Collectors.toList());
    }
}
