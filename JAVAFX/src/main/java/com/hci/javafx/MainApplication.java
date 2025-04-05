package com.hci.javafx;

import com.hci.javafx.ui.MainPage;
import com.hci.javafx.ui.SplashScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;

public class MainApplication extends Application {

    @Getter
    private static MainApplication instance;
    private Stage primaryStage;

    public void showSplashScreen(){
        SplashScreen ss = new SplashScreen();
        Scene scene = new Scene(ss);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showMainPage(){
        MainPage mp = new MainPage();
        Scene scene = new Scene(mp);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    @Override
    public void start(Stage primaryStage) {
        instance = this;
        this.primaryStage = primaryStage;

        primaryStage.setTitle("DishCovery");
        showSplashScreen();
    }

    public static void main(String[] args) {
        launch(args);
    }
}