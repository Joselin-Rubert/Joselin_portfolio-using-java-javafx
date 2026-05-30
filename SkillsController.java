package com.portfolio.controllers;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import com.portfolio.utils.Constants;
import com.portfolio.utils.UIComponentFactory;

/**
 * Skills Section Controller
 * Displays technical skills with animated cards and progress indicators
 */
public class SkillsController extends SectionController {
    
    @Override
    public void initialize() {
        sectionRoot = new VBox(40);
        sectionRoot.setPadding(new Insets(Constants.PADDING_LARGE));
        sectionRoot.setStyle("-fx-background-color: #0a0e27;");
        
        // Section Title
        Label sectionTitle = UIComponentFactory.createSectionTitle("Skills & Expertise");
        
        // Skills Content
        VBox skillsContent = createSkillsContent();
        
        sectionRoot.getChildren().addAll(
            sectionTitle,
            UIComponentFactory.createDivider(1200),
            skillsContent
        );
        
        sectionRoot.setOpacity(0);
    }
    
    private VBox createSkillsContent() {
        VBox content = new VBox(50);
        content.setPadding(new Insets(40, 0, 0, 0));
        
        // Programming Languages
        content.getChildren().addAll(
            createSkillCategory("Programming Languages", 
                new String[]{"Java", "Python", "C"})
        );
        
        // Web Technologies
        content.getChildren().addAll(
            createSkillCategory("Web Technologies",
                new String[]{"HTML", "CSS", "JavaScript"})
        );
        
        // Database & Tools
        content.getChildren().addAll(
            createSkillCategory("Database & Tools",
                new String[]{"MySQL", "Firebase", "JDBC", "Swing GUI"})
        );
        
        return content;
    }
    
    private VBox createSkillCategory(String categoryName, String[] skills) {
        VBox category = new VBox(20);
        
        // Category Title
        Label categoryTitle = UIComponentFactory.createSubtitle(categoryName);
        
        // Skills Flow Pane
        FlowPane skillsPane = new FlowPane(15, 15);
        skillsPane.setAlignment(Pos.TOP_LEFT);
        
        for (String skill : skills) {
            VBox skillCard = createSkillCard(skill);
            skillsPane.getChildren().add(skillCard);
        }
        
        category.getChildren().addAll(categoryTitle, skillsPane);
        return category;
    }
    
    private VBox createSkillCard(String skillName) {
        VBox card = new VBox();
        card.setPadding(new Insets(15, 20, 15, 20));
        card.setAlignment(Pos.CENTER);
        card.setPrefSize(150, 100);
        card.setStyle(
            "-fx-background-color: rgba(139, 92, 246, 0.12);" +
            "-fx-border-color: #8b5cf6;" +
            "-fx-border-width: 2;" +
            "-fx-border-radius: 12;" +
            "-fx-background-radius: 12;"
        );
        
        Label skillLabel = new Label(skillName);
        skillLabel.setStyle(
            "-fx-font-size: 16;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #ffffff;"
        );
        
        // Highlight Java and Swing GUI
        if (skillName.equals("Java") || skillName.equals("Swing GUI")) {
            card.setStyle(
                "-fx-background-color: rgba(139, 92, 246, 0.25);" +
                "-fx-border-color: #8b5cf6;" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 12;" +
                "-fx-background-radius: 12;" +
                "-fx-effect: dropshadow(gaussian, rgba(139, 92, 246, 0.4), 10, 0.0, 0, 0);"
            );
            skillLabel.setStyle(
                "-fx-font-size: 16;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #06b6d4;"
            );
        }
        
        card.getChildren().add(skillLabel);
        
        // Hover effect
        card.setOnMouseEntered(e -> {
            card.setStyle(
                "-fx-background-color: rgba(139, 92, 246, 0.25);" +
                "-fx-border-color: #06b6d4;" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 12;" +
                "-fx-background-radius: 12;" +
                "-fx-effect: dropshadow(gaussian, rgba(139, 92, 246, 0.6), 15, 0.0, 0, 0);"
            );
        });
        
        card.setOnMouseExited(e -> {
            card.setStyle(
                "-fx-background-color: rgba(139, 92, 246, 0.12);" +
                "-fx-border-color: #8b5cf6;" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 12;" +
                "-fx-background-radius: 12;"
            );
        });
        
        return card;
    }
}
