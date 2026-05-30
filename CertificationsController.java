package com.portfolio.controllers;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import com.portfolio.utils.AnimationUtil;
import com.portfolio.utils.Constants;
import com.portfolio.utils.UIComponentFactory;

/**
 * Certifications Section Controller
 * Displays professional certifications with elegant glowing cards
 */
public class CertificationsController extends SectionController {
    
    @Override
    public void initialize() {
        sectionRoot = new VBox(40);
        sectionRoot.setPadding(new Insets(Constants.PADDING_LARGE));
        sectionRoot.setStyle("-fx-background-color: #0a0e27;");
        
        // Section Title
        Label sectionTitle = UIComponentFactory.createSectionTitle("Certifications");
        
        // Certifications Grid
        FlowPane certificationsGrid = createCertificationsGrid();
        
        sectionRoot.getChildren().addAll(
            sectionTitle,
            UIComponentFactory.createDivider(1200),
            certificationsGrid
        );
        
        sectionRoot.setOpacity(0);
    }
    
    private FlowPane createCertificationsGrid() {
        FlowPane grid = new FlowPane(30, 30);
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setPadding(new Insets(40, 0, 0, 0));
        
        // Certification 1
        grid.getChildren().add(createCertificationCard(
            "Cybersecurity Essentials",
            "Cisco Networking Academy"
        ));
        
        // Certification 2
        grid.getChildren().add(createCertificationCard(
            "Java Programming",
            "Infosys Springboard"
        ));
        
        // Certification 3
        grid.getChildren().add(createCertificationCard(
            "Python Programming",
            "Infosys Springboard"
        ));
        
        return grid;
    }
    
    private VBox createCertificationCard(String title, String issuer) {
        VBox card = new VBox(12);
        card.setPrefSize(280, 180);
        card.setPadding(new Insets(20));
        card.setAlignment(Pos.TOP_LEFT);
        card.setStyle(
            "-fx-background-color: rgba(139, 92, 246, 0.1);" +
            "-fx-border-color: #8b5cf6;" +
            "-fx-border-width: 2;" +
            "-fx-border-radius: 12;" +
            "-fx-background-radius: 12;"
        );
        
        // Certificate Icon (Unicode)
        Label icon = new Label("📜");
        icon.setStyle("-fx-font-size: 32;");
        
        // Title
        Label titleLabel = new Label(title);
        titleLabel.setStyle(
            "-fx-font-size: 16;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #06b6d4;" +
            "-fx-wrap-text: true;"
        );
        
        // Issuer
        Label issuerLabel = new Label(issuer);
        issuerLabel.setStyle(
            "-fx-font-size: 13;" +
            "-fx-text-fill: #a0aec0;" +
            "-fx-wrap-text: true;"
        );
        
        card.getChildren().addAll(icon, titleLabel, issuerLabel);
        
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
                "-fx-background-color: rgba(139, 92, 246, 0.1);" +
                "-fx-border-color: #8b5cf6;" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 12;" +
                "-fx-background-radius: 12;"
            );
        });
        
        AnimationUtil.scaleOnHover(card, 1.08);
        
        return card;
    }
}
