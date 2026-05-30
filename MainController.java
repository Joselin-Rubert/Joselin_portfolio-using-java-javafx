package com.portfolio.controllers;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import com.portfolio.utils.AnimationUtil;
import com.portfolio.utils.Constants;

/**
 * Main Application Controller
 * Manages the main window layout, sidebar navigation, and section switching
 */
public class MainController {
    
    private BorderPane root;
    private ScrollPane contentArea;
    private VBox sidebar;
    private VBox contentContainer;
    
    // Section Controllers
    private HeroController heroController;
    private AboutController aboutController;
    private EducationController educationController;
    private SkillsController skillsController;
    private ExperienceController experienceController;
    private ProjectsController projectsController;
    private CertificationsController certificationsController;
    private PresentationsController presentationsController;
    private ContactController contactController;
    private FooterController footerController;
    
    // Current Section
    private SectionController currentSection;
    
    public MainController() {
        initialize();
    }
    
    private void initialize() {
        // Create root layout
        root = new BorderPane();
        root.setStyle("-fx-background-color: #0a0e27;");
        
        // Create sidebar
        createSidebar();
        
        // Create content area
        createContentArea();
        
        // Set layout
        root.setLeft(sidebar);
        root.setCenter(contentArea);
    }
    
    private void createSidebar() {
        sidebar = new VBox();
        sidebar.setPrefWidth(Constants.SIDEBAR_WIDTH);
        sidebar.setStyle(
            "-fx-background-color: #1a1f3a;" +
            "-fx-border-color: rgba(139, 92, 246, 0.2);" +
            "-fx-border-width: 0 1 0 0;"
        );
        sidebar.setSpacing(15);
        sidebar.setPadding(new Insets(Constants.PADDING_LARGE));
        
        // Logo/Title
        Label logoLabel = new Label("Joselin");
        logoLabel.setStyle(
            "-fx-font-size: 24;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #8b5cf6;"
        );
        
        VBox logoBox = new VBox(logoLabel);
        logoBox.setPadding(new Insets(0, 0, 30, 0));
        
        // Navigation Buttons
        String[] sections = {
            "Hero",
            "About",
            "Education",
            "Skills",
            "Experience",
            "Projects",
            "Certifications",
            "Presentations",
            "Contact"
        };
        
        VBox navButtons = new VBox(10);
        navButtons.setPrefWidth(Constants.SIDEBAR_WIDTH - 40);
        
        for (String section : sections) {
            Button navBtn = createNavButton(section);
            navButtons.getChildren().add(navBtn);
        }
        
        // ScrollPane for nav buttons
        ScrollPane navScroll = new ScrollPane(navButtons);
        navScroll.setFitToWidth(true);
        navScroll.setStyle(
            "-fx-control-inner-background: transparent;" +
            "-fx-padding: 0;"
        );
        
        sidebar.getChildren().addAll(logoBox, navScroll);
    }
    
    private Button createNavButton(String sectionName) {
        Button btn = new Button(sectionName);
        btn.setPrefWidth(200);
        btn.setStyle(
            "-fx-padding: 15 20;" +
            "-fx-font-size: 14;" +
            "-fx-text-fill: #a0aec0;" +
            "-fx-background-color: transparent;" +
            "-fx-border-radius: 5;" +
            "-fx-background-radius: 5;" +
            "-fx-cursor: hand;"
        );
        btn.getStyleClass().add("nav-button");
        
        btn.setOnAction(e -> switchSection(sectionName.toLowerCase(), btn));
        
        return btn;
    }
    
    private void createContentArea() {
        contentContainer = new VBox();
        contentContainer.setStyle("-fx-background-color: #0a0e27;");
        contentContainer.setFillWidth(true);
        
        // Initialize all section controllers
        initializeSectionControllers();
        
        // Load Hero section by default
        loadSection(heroController);
        
        contentArea = new ScrollPane(contentContainer);
        contentArea.setFitToWidth(true);
        contentArea.setStyle(
            "-fx-control-inner-background: #0a0e27;" +
            "-fx-padding: 0;"
        );
    }
    
    private void initializeSectionControllers() {
        heroController = new HeroController();
        heroController.initialize();
        
        aboutController = new AboutController();
        aboutController.initialize();
        
        educationController = new EducationController();
        educationController.initialize();
        
        skillsController = new SkillsController();
        skillsController.initialize();
        
        experienceController = new ExperienceController();
        experienceController.initialize();
        
        projectsController = new ProjectsController();
        projectsController.initialize();
        
        certificationsController = new CertificationsController();
        certificationsController.initialize();
        
        presentationsController = new PresentationsController();
        presentationsController.initialize();
        
        contactController = new ContactController();
        contactController.initialize();
        
        footerController = new FooterController();
        footerController.initialize();
    }
    
    private void switchSection(String sectionName, Button btn) {
        SectionController targetController = null;
        
        switch (sectionName) {
            case "hero" -> targetController = heroController;
            case "about" -> targetController = aboutController;
            case "education" -> targetController = educationController;
            case "skills" -> targetController = skillsController;
            case "experience" -> targetController = experienceController;
            case "projects" -> targetController = projectsController;
            case "certifications" -> targetController = certificationsController;
            case "presentations" -> targetController = presentationsController;
            case "contact" -> targetController = contactController;
        }
        
        if (targetController != null) {
            loadSection(targetController);
            // Scroll to top
            contentArea.setVvalue(0);
        }
    }
    
    private void loadSection(SectionController controller) {
        // Remove current section if exists
        if (currentSection != null) {
            currentSection.onSectionHidden();
        }
        
        // Clear content area (except footer)
        contentContainer.getChildren().clear();
        
        // Add new section
        contentContainer.getChildren().add(controller.getSectionRoot());
        contentContainer.getChildren().add(footerController.getSectionRoot());
        
        // Play animation
        controller.onSectionVisible();
        
        currentSection = controller;
    }
    
    /**
     * Get the root BorderPane of the application
     */
    public BorderPane getRoot() {
        return root;
    }
}
