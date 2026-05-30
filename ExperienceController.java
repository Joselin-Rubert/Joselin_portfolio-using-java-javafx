package com.portfolio.controllers;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import com.portfolio.utils.AnimationUtil;
import com.portfolio.utils.Constants;
import com.portfolio.utils.UIComponentFactory;

/**
 * Experience Section Controller
 * Displays internship and work experience with animated glassmorphism cards
 */
public class ExperienceController extends SectionController {
    
    @Override
    public void initialize() {
        sectionRoot = new VBox(40);
        sectionRoot.setPadding(new Insets(Constants.PADDING_LARGE));
        sectionRoot.setStyle("-fx-background-color: #0a0e27;");
        
        // Section Title
        Label sectionTitle = UIComponentFactory.createSectionTitle("Internship Experience");
        
        // Experience Content
        VBox experienceContent = createExperienceContent();
        
        sectionRoot.getChildren().addAll(
            sectionTitle,
            UIComponentFactory.createDivider(1200),
            experienceContent
        );
        
        sectionRoot.setOpacity(0);
    }
    
    private VBox createExperienceContent() {
        VBox content = new VBox(30);
        content.setPadding(new Insets(40, 0, 0, 0));
        
        // Experience 1: Digisailor
        content.getChildren().add(createExperienceCard(
            "Digisailor",
            "Student Intern - Web Development",
            "2025-1 month",
            "Developed an Attendance and Outpass Management System using Firebase Authentication, " +
            "Database integration, CRUD operations, and Geolocation API with responsive frontend " +
            "implementation for secure and efficient student management."
        ));
        
        // Experience 2: Postulate Info Tech
        content.getChildren().add(createExperienceCard(
            "Postulate Info Tech Private Limited",
            "Student Intern - Full Stack App Development",
            "2025-1 month",
            "Completed foundational Flutter and Full Stack App Development training with exposure " +
            "to mobile app development concepts."
        ));
        
        // Experience 3: ClinchEdge
        content.getChildren().add(createExperienceCard(
            "ClinchEdge Workforce Technologies, Bangalore",
            "Student Intern - Java Developer",
            "2026-present 1-month",
            "Developed a Student Management System using Java, Swing GUI, and JDBC concepts with " +
            "database connectivity and CRUD operations."
        ));
        
        // Experience 4: Cisco Virtual Internships
        content.getChildren().add(createExperienceCard(
            "Cisco Virtual Internships",
            "Virtual Intern - AI & Data Analytics",
            "2026-present",
            "Participating in AI and Data Analytics focused virtual internships. Learning concepts related to Modern AI, " +
            "Customer Review Analysis, and Data Analytics Essentials."
        ));
        
        return content;
    }
    
    private VBox createExperienceCard(String company, String position, String period, String description) {
        VBox card = UIComponentFactory.createGlassPanel(1100, 200);
        card.setStyle(
            "-fx-background-color: rgba(26, 31, 58, 0.5);" +
            "-fx-border-color: rgba(139, 92, 246, 0.3);" +
            "-fx-border-width: 2;" +
            "-fx-border-radius: 15;" +
            "-fx-background-radius: 15;" +
            "-fx-padding: 25;"
        );
        
        // Company Name
        Label companyLabel = new Label(company);
        companyLabel.setStyle(
            "-fx-font-size: 20;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #06b6d4;"
        );
        
        // Position Title
        Label positionLabel = new Label(position);
        positionLabel.setStyle(
            "-fx-font-size: 18;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #ffffff;"
        );
        
        // Period
        Label periodLabel = new Label(period);
        periodLabel.setStyle(
            "-fx-font-size: 13;" +
            "-fx-text-fill: #8b5cf6;" +
            "-fx-font-weight: 600;"
        );
        
        // Description
        Label descriptionLabel = new Label(description);
        descriptionLabel.setStyle(
            "-fx-font-size: 14;" +
            "-fx-text-fill: #a0aec0;" +
            "-fx-wrap-text: true;"
        );
        
        card.getChildren().addAll(
            companyLabel,
            positionLabel,
            periodLabel,
            new VBox(8), // Spacing
            descriptionLabel
        );
        
        // Hover animation
        AnimationUtil.scaleOnHover(card, 1.02);
        
        return card;
    }
}
