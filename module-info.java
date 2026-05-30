/**
 * Module definition for Portfolio Application
 * Java 9+ Module System Support
 * 
 * This file is optional but recommended for Java 9+ projects
 * Place this in: src/main/java/module-info.java
 */

module portfolio {
    // JavaFX modules
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires java.desktop;
    
    // Exports
    exports com.portfolio;
    exports com.portfolio.controllers;
    exports com.portfolio.utils;
}
