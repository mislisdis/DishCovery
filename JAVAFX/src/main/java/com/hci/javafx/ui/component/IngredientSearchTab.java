package com.hci.javafx.ui.component;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IngredientSearchTab extends VBox {

    TextField searchField1, searchField2;

    public IngredientSearchTab() {
        this.getStylesheets()
                .add(Objects.requireNonNull(getClass()
                        .getResource("/com/hci/javafx/styles.css")).toExternalForm());

        Label title = new Label("Ingredients");
        title.getStyleClass().add("ingredients-text");
        this.getChildren().add(title);

        searchField1 = new TextField();
        searchField1.getStyleClass().add("ingredient-placeholder");
        searchField1.setPromptText("e.g eggs");
        this.getChildren().add(searchField1);

        searchField2 = new TextField();
        searchField2.getStyleClass().add("ingredient-placeholder");
        searchField2.setPromptText("e.g butter");
        this.getChildren().add(searchField2);
    }

    public List<String> getIngredients() {
        List<String> ingredients = new ArrayList<>();
        ingredients.add(searchField1.getText());
        ingredients.add(searchField2.getText());
        return ingredients;
    }
}
