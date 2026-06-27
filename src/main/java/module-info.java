module org.example.shouldwork {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.security.auth;
    requires java.logging;


    opens org.example.shouldwork to javafx.fxml;
    exports org.example.shouldwork.model;
    exports org.example.shouldwork.dto;
    opens org.example.shouldwork.dto to javafx.fxml;
    exports org.example.shouldwork.dao;
    opens org.example.shouldwork.dao to javafx.fxml;

    opens org.example.shouldwork.controllers to javafx.fxml;
    exports org.example.shouldwork.controllers;
}