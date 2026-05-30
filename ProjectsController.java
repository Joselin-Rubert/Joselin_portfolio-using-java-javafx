package com.portfolio.controllers;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import com.portfolio.utils.AnimationUtil;
import com.portfolio.utils.Constants;
import com.portfolio.utils.UIComponentFactory;

/**
 * Projects Section Controller
 * Displays portfolio projects with descriptions and technology stacks
 */
public class ProjectsController extends SectionController {
    
    @Override
    public void initialize() {
        sectionRoot = new VBox(40);
        sectionRoot.setPadding(new Insets(Constants.PADDING_LARGE));
        sectionRoot.setStyle("-fx-background-color: #0a0e27;");
        
        // Section Title
        Label sectionTitle = UIComponentFactory.createSectionTitle("PROJECTS");
        
        // Projects Grid
        VBox projectsGrid = createProjectsGrid();
        
        sectionRoot.getChildren().addAll(
            sectionTitle,
            UIComponentFactory.createDivider(1200),
            projectsGrid
        );
        
        sectionRoot.setOpacity(0);
    }
    
    private VBox createProjectsGrid() {
        VBox grid = new VBox(30);
        grid.setPadding(new Insets(40, 0, 0, 0));
        
        // Project 1: Hospital Management System Android App
        grid.getChildren().add(createProjectCard(
            "Hospital Management System Android App",
            "Developed Android-based hospital management application for patient records and appointment scheduling.",
            new String[]{"Java", "XML"}
        ));
        
        // Project 2: Booking Management System
        grid.getChildren().add(createProjectCard(
            "Booking Management System",
            "Built web-based booking system with CRUD operations and Admin Control functionalities.",
            new String[]{"PHP", "HTML", "CSS", "MySQL"}
        ));
        
        // Project 3: Hospital Management System
        grid.getChildren().add(createProjectCard(
            "Hospital Management System",
            "Designed desktop-based hospital management application with efficient database connectivity and record handling.",
            new String[]{"Java", "JDBC", "OOP"}
        ));
        
        // Project 4: Online Shopping System
        grid.getChildren().add(createProjectCard(
            "Online Shopping System",
            "Developed shopping application with billing and cart management functionalities.",
            new String[]{"Python", "Data Structures"}
        ));
        
        // Project 5: Vaccine Registration System
        grid.getChildren().add(createProjectCard(
            "Vaccine Registration System",
            "Created console-based registration system using file handling concepts.",
            new String[]{"C Programming"}
        ));
        
        // Project 6: BMI Calculator
        grid.getChildren().add(createProjectCard(
            "BMI Calculator",
            "Built BMI calculation application with categorized health result analysis.",
            new String[]{"Python"}
        ));
        
        return grid;
    }
    
    private VBox createProjectCard(String title, String description, String[] technologies) {
        VBox card = new VBox(12);
        card.setPadding(new Insets(25));
        card.setStyle(
            "-fx-background-color: rgba(26, 31, 58, 0.5);" +
            "-fx-border-color: rgba(139, 92, 246, 0.3);" +
            "-fx-border-width: 1;" +
            "-fx-border-radius: 15;" +
            "-fx-background-radius: 15;"
        );
        
        // Project Title
        Label titleLabel = new Label(title);
        titleLabel.setStyle(
            "-fx-font-size: 18;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #ffffff;"
        );
        
        // Description
        Label descLabel = new Label(description);
        descLabel.setStyle(
            "-fx-font-size: 14;" +
            "-fx-text-fill: #a0aec0;" +
            "-fx-wrap-text: true;"
        );
        
        // Technologies
        HBox techBox = new HBox(10);
        techBox.setAlignment(Pos.TOP_LEFT);
        Label techLabel = new Label("Tech Stack: ");
        techLabel.setStyle(
            "-fx-font-size: 13;" +
            "-fx-text-fill: #8b5cf6;" +
            "-fx-font-weight: 600;"
        );
        
        HBox tagBox = new HBox(8);
        tagBox.setAlignment(Pos.CENTER_LEFT);
        for (String tech : technologies) {
            Label tag = new Label(tech);
            tag.setStyle(
                "-fx-background-color: rgba(139, 92, 246, 0.2);" +
                "-fx-border-color: #06b6d4;" +
                "-fx-border-width: 1;" +
                "-fx-border-radius: 15;" +
                "-fx-background-radius: 15;" +
                "-fx-padding: 5 12;" +
                "-fx-text-fill: #06b6d4;" +
                "-fx-font-size: 12;"
            );
            tagBox.getChildren().add(tag);
        }
        
        // Add all to card
        card.getChildren().addAll(
            titleLabel,
            descLabel,
            techBox
        );
        card.getChildren().add(tagBox);
        
        // Hover animation
        AnimationUtil.scaleOnHover(card, 1.02);
        
        return card;
    }
}
