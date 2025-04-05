module com.hci.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires com.fasterxml.jackson.databind;


    opens com.hci.javafx to javafx.fxml, com.fasterxml.jackson.databind;
    opens com.hci.javafx.ui to com.fasterxml.jackson.databind;
    opens com.hci.javafx.recipe to com.fasterxml.jackson.databind;
    opens com.hci.javafx.ui.component to com.fasterxml.jackson.databind;
    exports com.hci.javafx;
}