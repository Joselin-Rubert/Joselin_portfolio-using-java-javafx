package com.portfolio.controllers;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import com.portfolio.utils.AnimationUtil;
import com.portfolio.utils.Constants;
import com.portfolio.utils.UIComponentFactory;

import java.nio.file.Paths;

/**
 * Hero Section Controller
 * Premium Portfolio Hero Section
 */
public class HeroController extends SectionController {

    private Label nameLabel;
    private Label titleLabel;
    private Label descriptionLabel;

    @Override
    public void initialize() {

        sectionRoot = new VBox(30);

        sectionRoot.setPadding(
            new Insets(Constants.PADDING_LARGE)
        );

        sectionRoot.setAlignment(
            Pos.CENTER_LEFT
        );

        sectionRoot.setStyle(
            "-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, #0a0e27, #1a1f3a);"
        );

        // Create Hero Content
        createHeroContent();

        // Fade Animation
        sectionRoot.setOpacity(0);

        AnimationUtil.fadeIn(
            sectionRoot,
            Constants.ANIMATION_SLOW
        );
    }

    /**
     * Create Hero Section Content
     */
    private void createHeroContent() {

        // Name Label
        nameLabel = new Label();

        nameLabel.setStyle(
            "-fx-font-size: 56;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #ffffff;"
        );

        addTypingEffect(
            nameLabel,
            "Joselin Sornapraisy R",
            50
        );

        // Title Label
        titleLabel = new Label();

        titleLabel.setStyle(
            "-fx-font-size: 28;" +
            "-fx-text-fill: #8b5cf6;" +
            "-fx-font-weight: 600;"
        );

        addTypingEffect(
            titleLabel,
            "Pre-Final Year CSE Student | Aspiring Full Stack Developer | Java Developer",
            30
        );

        // Description
        descriptionLabel =
            UIComponentFactory.createBodyText(
                "A passionate Computer Science student focused on building impactful software solutions " +
                "through Java, Web Development, Swing GUI applications, and Full Stack technologies."
            );

        descriptionLabel.setStyle(
            "-fx-font-size: 16;" +
            "-fx-text-fill: #a0aec0;" +
            "-fx-wrap-text: true;"
        );

        // Resume Button Only
        HBox buttonBox = createButtonBox();

        // Add Components
        sectionRoot.getChildren().addAll(
            nameLabel,
            titleLabel,
            descriptionLabel,
            createDivider(),
            buttonBox
        );
    }

    /**
     * Create Resume Button
     */
    private HBox createButtonBox() {

        HBox buttonBox = new HBox(20);

        buttonBox.setAlignment(
            Pos.CENTER_LEFT
        );

        buttonBox.setPadding(
            new Insets(30, 0, 0, 0)
        );

        // Resume Button
        Button resumeBtn =
            UIComponentFactory.createGlowingButton(
                "Download Resume",
                200,
                50
            );

        resumeBtn.getStyleClass().add(
            "primary-button"
        );

        resumeBtn.setOnAction(
            e -> downloadResume()
        );

        buttonBox.getChildren().add(
            resumeBtn
        );

        return buttonBox;
    }

    /**
     * Divider
     */
    private VBox createDivider() {

        VBox divider = new VBox();

        divider.setPrefHeight(2);

        divider.setStyle(
            "-fx-background-color: linear-gradient(to right, transparent, #8b5cf6, transparent);"
        );

        divider.setPadding(
            new Insets(20, 0, 20, 0)
        );

        return divider;
    }

    /**
     * Typing Effect Animation
     */
    private void addTypingEffect(
        Label label,
        String text,
        int speed
    ) {

        Thread typingThread = new Thread(() -> {

            for (int i = 0; i <= text.length(); i++) {

                final String displayText =
                    text.substring(0, i);

                javafx.application.Platform.runLater(
                    () -> label.setText(displayText)
                );

                try {

                    Thread.sleep(speed);

                } catch (InterruptedException e) {

                    Thread.currentThread().interrupt();
                }
            }
        });

        typingThread.setDaemon(true);

        typingThread.start();
    }

    /**
     * Resume Download Action
     */
    private void downloadResume() {
        System.out.println("Resume open initiated...");
        
        try {
            String[] resumeNames = {"resume.pdf", "Resume.pdf", "Joselin_Resume.pdf"};

            for (String resumeName : resumeNames) {
                java.nio.file.Path resumePath = Paths.get(
                    System.getProperty("user.dir"),
                    "src", "main", "java", "com", "portfolio", "assets", "documents", resumeName
                );

                java.io.File resumeFile = resumePath.toFile();

                if (resumeFile.exists()) {
                    if (!java.awt.Desktop.isDesktopSupported()) {
                        System.err.println("Desktop open is not supported on this platform.");
                        return;
                    }

                    java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

                    if (!desktop.isSupported(java.awt.Desktop.Action.OPEN)) {
                        System.err.println("Desktop OPEN action is not supported on this platform.");
                        return;
                    }

                    desktop.open(resumeFile);
                    System.out.println("Opened resume: " + resumeFile.getAbsolutePath());
                    return;
                }
            }

            System.err.println("Resume file not found in assets/documents folder");
        } catch (Exception e) {
            System.err.println("Error opening resume: " + e.getMessage());
            e.printStackTrace();
        }
    }
}