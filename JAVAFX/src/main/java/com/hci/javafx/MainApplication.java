package com.hci.javafx;

import com.hci.javafx.recipe.Recipe;
import com.hci.javafx.ui.LoginPage;
import com.hci.javafx.ui.MainPage;
import com.hci.javafx.ui.RecipeDisplay;
import com.hci.javafx.ui.SplashScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import lombok.Getter;

public class MainApplication extends Application {

    @Getter
    private static MainApplication instance;
    private Stage primaryStage;

    public void showLogin(){
        LoginPage lp = new LoginPage();
        Scene scene = new Scene(lp);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showSplashScreen(){
        SplashScreen ss = new SplashScreen();
        Scene scene = new Scene(ss);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showMainPage(){
        MainPage mp = new MainPage();
        mp.setPrefHeight(Screen.getPrimary().getVisualBounds().getHeight());

        ScrollPane sp = new ScrollPane(mp);
        sp.setFitToWidth(true);
        sp.setFitToHeight(true);

        Scene scene = new Scene(sp);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showRecipeDisplay(Recipe r){
        RecipeDisplay rd = new RecipeDisplay(r);

        ScrollPane scrollPane = new ScrollPane(rd);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        Scene scene = new Scene(scrollPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    @Override
    public void start(Stage primaryStage) {
        instance = this;
        this.primaryStage = primaryStage;

        primaryStage.setTitle("DishCovery");
        showLogin();
    }

    public static void main(String[] args) {
        launch(args);
    }
}