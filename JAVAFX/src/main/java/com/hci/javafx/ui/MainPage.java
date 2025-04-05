package com.hci.javafx.ui;

import com.hci.javafx.recipe.Recipe;
import com.hci.javafx.recipe.RecipeService;
import com.hci.javafx.ui.component.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MainPage extends VBox {

    private SearchBar searchBar;
    private FilterComponent filterComponent;
    private CookTimeSelector cookTimeSelector;
    private IngredientSearchTab ingredientSearchTab;
    private RecipeGrid recipeGrid;
    private RecipeService recipeService;

    public MainPage() {
        this.getStylesheets()
                .add(Objects.requireNonNull(getClass()
                        .getResource("/com/hci/javafx/styles.css")).toExternalForm());
        this.getStyleClass().add("light-mode-gradient-background");
        this.setPadding(new Insets(0, 0, 20, 0));
        this.setSpacing(10);

        // Initialize recipe service
        recipeService = new RecipeService();

        showHeader();
        showSearchComponents();
        showFindRecipesButton();

        // Create scrollable recipe grid
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: transparent; -fx-background: transparent;");

        recipeGrid = new RecipeGrid();
        scrollPane.setContent(recipeGrid);

        VBox.setVgrow(scrollPane, Priority.ALWAYS);
        this.getChildren().add(scrollPane);
    }

    private void showHeader() {
        HeaderCard headerCard = new HeaderCard();
        this.getChildren().add(headerCard);
    }

    private void showSearchComponents() {
        // Add search bar
        searchBar = new SearchBar();
        searchBar.setPadding(new Insets(15, 15, 5, 15));
        this.getChildren().add(searchBar);

        // Add filter component
        filterComponent = new FilterComponent();
        this.getChildren().add(filterComponent);

        // Add cook time selector
        cookTimeSelector = new CookTimeSelector();
        this.getChildren().add(cookTimeSelector);

        // Add ingredient search component
        ingredientSearchTab = new IngredientSearchTab();
        ingredientSearchTab.setPadding(new Insets(5, 15, 15, 15));
        this.getChildren().add(ingredientSearchTab);
    }

    private void showFindRecipesButton() {
        VBox buttonContainer = new VBox();
        buttonContainer.setAlignment(Pos.CENTER);
        buttonContainer.setPadding(new Insets(10, 0, 10, 0));

        Button findRecipesButton = new Button("Find Recipes!");
        findRecipesButton.getStyleClass().add("light-mode-major-button");
        findRecipesButton.setOnAction(event -> performSearch());

        buttonContainer.getChildren().add(findRecipesButton);
        this.getChildren().add(buttonContainer);
    }

    private void performSearch() {
        List<String> ingredients = ingredientSearchTab.getIngredients().stream()
                .filter(ingredient -> !ingredient.isEmpty())
                .collect(Collectors.toList());

        int cookTime = cookTimeSelector.getCookTimeMinutes();
        String searchQuery = searchBar.getText();

        List<Recipe> searchResults;

        // Determine which search to perform based on provided criteria
        if (!searchQuery.isEmpty()) {
            // If search text provided, search by name
            searchResults = recipeService.searchByName(searchQuery);

            // Further filter by ingredients and cook time if provided
            if (!ingredients.isEmpty()) {
                searchResults = searchResults.stream()
                        .filter(recipe -> recipeService.searchByIngredients(ingredients).contains(recipe))
                        .collect(Collectors.toList());
            }

            // Filter by cook time
            searchResults = searchResults.stream()
                    .filter(recipe -> recipe.matchesPrepTime(cookTime))
                    .collect(Collectors.toList());
        } else if (!ingredients.isEmpty()) {
            // Search by ingredients and cook time
            searchResults = recipeService.searchByIngredientsAndPrepTime(ingredients, cookTime);
        } else {
            // Only filter by cook time
            searchResults = recipeService.searchByPrepTime(cookTime);
        }

        // Display search results
        recipeGrid.displayRecipes(searchResults);
    }
}