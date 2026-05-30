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
 * Education Section Controller
 * Displays education background with animated timeline
 */
public class EducationController extends SectionController {
    
    @Override
    public void initialize() {
        sectionRoot = new VBox(40);
        sectionRoot.setPadding(new Insets(Constants.PADDING_LARGE));
        sectionRoot.setStyle("-fx-background-color: #0a0e27;");
        
        // Section Title
        Label sectionTitle = UIComponentFactory.createSectionTitle("Education");
        
        // Timeline Content
        VBox timelineContent = createTimeline();
        
        sectionRoot.getChildren().addAll(
            sectionTitle,
            UIComponentFactory.createDivider(1200),
            timelineContent
        );
        
        sectionRoot.setOpacity(0);
    }
    
    private VBox createTimeline() {
        VBox timeline = new VBox(30);
        timeline.setPadding(new Insets(40, 0, 0, 0));
        
        // Education Entry 1
        VBox entry1 = createEducationEntry(
            "Kamaraj College of Engineering and Technology",
            "B.E Computer Science and Engineering",
             "2024 - 2028",
            "CGPA: 8.9"
        );
        VBox entry2 = createEducationEntry(
            "Kamaraj Matriculation Higher Secondary School, Kovilpatti",
            "HSC",
            "2024",
            "86.5"
        );
        VBox entry3 = createEducationEntry(
            "Kamaraj Matriculation Higher Secondary School, Kovilpatti",
            "SSLC",
            "2022",
            "92.8"
        );
        
        // You can add more education entries here
        
        timeline.getChildren().addAll(entry1, entry2, entry3);
        return timeline;
    }
    
    private VBox createEducationEntry(String institution, String degree, String year, String gpa) {
        VBox entry = new VBox(12);
        entry.setPadding(new Insets(25));
        entry.setStyle(
            "-fx-background-color: rgba(26, 31, 58, 0.5);" +
            "-fx-border-color: rgba(139, 92, 246, 0.3);" +
            "-fx-border-width: 1;" +
            "-fx-border-radius: 15;" +
            "-fx-background-radius: 15;"
        );
        
        // Timeline marker
        HBox markerBox = new HBox(15);
        markerBox.setAlignment(Pos.CENTER_LEFT);
        
        // Glowing circle marker
        VBox marker = new VBox();
        marker.setPrefSize(16, 16);
        marker.setStyle(
            "-fx-background-color: #8b5cf6;" +
            "-fx-border-radius: 50;" +
            "-fx-background-radius: 50;" +
            "-fx-border-color: rgba(139, 92, 246, 0.5);" +
            "-fx-border-width: 2;"
        );
        AnimationUtil.scaleOnHover(marker, 1.3);
        
        Label yearLabel = new Label(year);
        yearLabel.setStyle(
            "-fx-font-size: 13;" +
            "-fx-text-fill: #06b6d4;" +
            "-fx-font-weight: 600;"
        );
        
        markerBox.getChildren().addAll(marker, yearLabel);
        
        // Institution name
        Label institutionLabel = new Label(institution);
        institutionLabel.setStyle(
            "-fx-font-size: 18;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #ffffff;"
        );
        
        // Degree
        Label degreeLabel = new Label(degree);
        degreeLabel.setStyle(
            "-fx-font-size: 16;" +
            "-fx-text-fill: #8b5cf6;" +
            "-fx-font-weight: 600;"
        );
        
        // GPA
        HBox gpaBox = new HBox(8);
        Label gpaPrefix = new Label("GPA:");
        gpaPrefix.setStyle(
            "-fx-font-size: 14;" +
            "-fx-text-fill: #a0aec0;"
        );
        Label gpaValue = new Label(gpa);
        gpaValue.setStyle(
            "-fx-font-size: 14;" +
            "-fx-text-fill: #06b6d4;" +
            "-fx-font-weight: bold;"
        );
        gpaBox.getChildren().addAll(gpaPrefix, gpaValue);
        
        entry.getChildren().addAll(
            markerBox,
            institutionLabel,
            degreeLabel,
            gpaBox
        );
        
        // Hover animation
        AnimationUtil.scaleOnHover(entry, 1.02);
        
        return entry;
    }
}
