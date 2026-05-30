package com.portfolio;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.portfolio.controllers.MainController;
import com.portfolio.utils.Constants;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;

/**
 * Portfolio Application Main Entry Point
 * Launches the premium JavaFX portfolio application for Joselin Sornapraisy R
 * 
 * FEATURES:
 * - Dark futuristic theme with purple/blue gradients
 * - Glassmorphism design with neon glow effects
 * - Smooth animations and transitions
 * - Responsive sidebar navigation
 * - Premium dashboard appearance
 * - Professional recruiter-friendly design
 * 
 * TO RUN:
 * 1. Ensure JavaFX is installed and configured
 * 2. Run this application as a JavaFX application
 * 3. Navigate through sections using the sidebar
 */
public class Main extends Application {
    
    private MainController mainController;
    
    @Override
    public void start(Stage primaryStage) {
        try {
            mainController = new MainController();
            
            
            Scene scene = new Scene(mainController.getRoot(), Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
            
            URL cssResource = getClass().getResource("/com/portfolio/styles/styles.css");
            if (cssResource == null) {
                File fallbackCss = Paths.get(
                    System.getProperty("user.dir"),
                    "src",
                    "main",
                    "java",
                    "com",
                    "portfolio",
                    "styles",
                    "styles.css"
                ).toFile();
                if (fallbackCss.exists()) {
                    cssResource = fallbackCss.toURI().toURL();
                }
            }
            if (cssResource != null) {
                scene.getStylesheets().add(cssResource.toExternalForm());
            } else {
                System.err.println("Warning: stylesheet not found. Running without external CSS.");
            }
            
            primaryStage.setTitle("Joselin Sornapraisy R - Portfolio");
            primaryStage.setScene(scene);
            primaryStage.setWidth(Constants.WINDOW_WIDTH);
            primaryStage.setHeight(Constants.WINDOW_HEIGHT);
            primaryStage.setMinWidth(1200);
            primaryStage.setMinHeight(800);
           
            primaryStage.show();
            
            System.out.println("═══════════════════════════════════════════════════════════");
            System.out.println("  Welcome to Joselin's Premium Portfolio Application");
            System.out.println("  Version 1.0 | Built with JavaFX");
            System.out.println("═══════════════════════════════════════════════════════════");
            System.out.println();
            System.out.println("📚 FEATURES:");
            System.out.println("  ✓ Dark Futuristic Theme");
            System.out.println("  ✓ Glassmorphism Design");
            System.out.println("  ✓ Smooth Animations");
            System.out.println("  ✓ Interactive Components");
            System.out.println("  ✓ Responsive Layout");
            System.out.println();
            System.out.println("🧭 NAVIGATION:");
            System.out.println("  Use the sidebar to navigate through different sections");
            System.out.println();
            System.out.println("═══════════════════════════════════════════════════════════");
            
        } catch (Exception e) {
            System.err.println("Error starting application:");
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
