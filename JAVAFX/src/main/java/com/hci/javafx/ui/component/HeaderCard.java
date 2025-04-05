package com.hci.javafx.ui.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

import java.util.Objects;

public class HeaderCard extends HBox {

    public HeaderCard() {
        this.getStylesheets()
                .add(Objects.requireNonNull(getClass()
                        .getResource("/com/hci/javafx/styles.css")).toExternalForm());

        this.setAlignment(Pos.CENTER_LEFT);
        this.setPadding(new Insets(10, 15, 10, 15));

        createLogo();
        createMenuButton();
    }

    private void createLogo() {
        try {
            // Load the DishCovery logo
            Image logoImage = new Image(Objects.requireNonNull(
                    getClass().getResourceAsStream("/com/hci/javafx/image/logos/DishCovery.png")));

            ImageView logoView = new ImageView(logoImage);
            logoView.setFitHeight(40);
            logoView.setPreserveRatio(true);

            this.getChildren().add(logoView);

            // Add spacer
            Region spacer = new Region();
            HBox.setHgrow(spacer, Priority.ALWAYS);
            this.getChildren().add(spacer);

        } catch (Exception e) {
            System.err.println("Could not load logo: " + e.getMessage());
        }
    }

    private void createMenuButton() {
        // Create menu button (hamburger icon)
        Button menuButton = new Button();
        menuButton.setStyle("-fx-background-color: transparent;");

        // use text instead
        menuButton.setText("≡");
        menuButton.setStyle("-fx-background-color: transparent; -fx-font-size: 20px; -fx-text-fill: #CB003D;");

        menuButton.setOnAction(event -> {
            // Menu action goes here
            System.out.println("Menu button clicked");
        });

        this.getChildren().add(menuButton);
    }
}