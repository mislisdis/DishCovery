package com.hci.javafx.ui;

import com.hci.javafx.MainApplication;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;

import java.util.Objects;

public class SplashScreen extends VBox {

    public SplashScreen() {
        this.getStylesheets()
                .add(Objects.requireNonNull(getClass()
                        .getResource("/com/hci/javafx/styles.css")).toExternalForm());

        // Set preferred dimensions for a more square-shaped appearance
        this.setPrefWidth(400);
        this.setPrefHeight(500);
        this.setMaxHeight(600);

        showSplashScreen();
    }

    private void showSplashScreen() {
        // Set spacing and alignment for the VBox
        this.setSpacing(30);  // Reduced spacing
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(30, 30, 30, 30));

        // Apply background style
        this.getStyleClass().add("light-mode-gradient-background");

        // Add logo at the top
        try {
            Image logoImage = new Image(Objects.requireNonNull(
                    getClass().getResourceAsStream("/com/hci/javafx/image/logos/DishCovery.png")));
            ImageView logoView = new ImageView(logoImage);

            // Set a reasonable size for the logo
            logoView.setFitWidth(250);
            logoView.setPreserveRatio(true);

            // Add logo to the top of VBox
            this.getChildren().add(logoView);
        } catch (Exception e) {
            System.err.println("Could not load logo image: " + e.getMessage());
        }

        // Spacer to push button to the bottom, but less height for squarer appearance
        VBox spacer = new VBox();
        spacer.setPrefHeight(100);  // Reduced height for more compact layout
        this.getChildren().add(spacer);

        // Create start button and add to bottom
        Button startButton = new Button("Get Started");
        startButton.getStyleClass().add("light-mode-major-button");
        startButton.setOnAction(event -> {
            MainApplication.getInstance().showMainPage();
        });

        // Add button to VBox
        this.getChildren().add(startButton);
    }
}