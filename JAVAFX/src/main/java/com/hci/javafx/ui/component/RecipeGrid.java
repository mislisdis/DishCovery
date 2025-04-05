package com.hci.javafx.ui.component;

import com.hci.javafx.recipe.Recipe;
import javafx.geometry.Insets;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.util.List;
import java.util.Objects;

public class RecipeGrid extends VBox {

    private FlowPane flowPane;

    public RecipeGrid() {
        this.getStylesheets()
                .add(Objects.requireNonNull(getClass()
                        .getResource("/com/hci/javafx/styles.css")).toExternalForm());

        // Initialize the flow pane for recipe cards
        flowPane = new FlowPane();
        flowPane.setPadding(new Insets(20));
        flowPane.setHgap(15);
        flowPane.setVgap(15);
        flowPane.setPrefWrapLength(400); // Set preferred wrap width

        this.getChildren().add(flowPane);
    }

    /**
     * Clear existing recipe cards and display new ones
     */
    public void displayRecipes(List<Recipe> recipes) {
        // Clear existing cards
        flowPane.getChildren().clear();

        // Add recipe cards for each recipe
        for (Recipe recipe : recipes) {
            RecipeCard recipeCard = new RecipeCard(recipe);

            // Make cards clickable to show details
            recipeCard.setOnMouseClicked(event -> {
                // Trigger recipe detail view (to be implemented)
                showRecipeDetails(recipe);
            });

            flowPane.getChildren().add(recipeCard);
        }
    }

    /**
     * Show details for a specific recipe
     */
    private void showRecipeDetails(Recipe recipe) {
        // This would open a recipe detail page
        System.out.println("Show details for recipe: " + recipe.getName());
        // Implementation of detailed view would go here
    }
}