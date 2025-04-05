package com.hci.javafx.ui.component;

import javafx.scene.control.TextField;

import java.util.Objects;

public class SearchBar extends TextField {

    public SearchBar() {
        this.getStylesheets()
                .add(Objects.requireNonNull(getClass()
                        .getResource("/com/hci/javafx/styles.css")).toExternalForm());
        this.getStyleClass().add("search-bar");
        this.setPromptText("Search");
    }
}
