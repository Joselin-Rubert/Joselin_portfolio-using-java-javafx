package com.portfolio.utils;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

/**
 * Factory class for creating reusable UI components
 * Ensures consistent styling and behavior across the application
 */
public class UIComponentFactory {
    
    /**
     * Create a premium styled button
     * @param text Button label
     * @param width Button width
     * @param height Button height
     * @return Styled button
     */
    public static Button createPremiumButton(String text, double width, double height) {
        Button button = new Button(text);
        button.setPrefWidth(width);
        button.setPrefHeight(height);
        button.setStyle(
            "-fx-font-size: " + Constants.FONT_SIZE_SMALL + ";" +
            "-fx-text-fill: " + Constants.TEXT_PRIMARY + ";" +
            "-fx-cursor: hand;" +
            "-fx-border-radius: 10;" +
            "-fx-background-radius: 10;" +
            "-fx-padding: " + Constants.PADDING_SMALL + ";"
        );
        button.getStyleClass().add("premium-button");
        
        // Add hover animation
        AnimationUtil.scaleOnHover(button, 1.05);
        
        return button;
    }
    
    /**
     * Create a glowing button with gradient
     * @param text Button label
     * @param width Button width
     * @param height Button height
     * @return Glowing button
     */
    public static Button createGlowingButton(String text, double width, double height) {
        Button button = createPremiumButton(text, width, height);
        button.getStyleClass().add("glowing-button");
        return button;
    }
    
    /**
     * Create a glassmorphism panel
     * @param width Panel width
     * @param height Panel height
     * @return VBox with glass effect
     */
    public static VBox createGlassPanel(double width, double height) {
        VBox panel = new VBox();
        panel.setPrefWidth(width);
        panel.setPrefHeight(height);
        panel.setPadding(new Insets(Constants.PADDING_MEDIUM));
        panel.setStyle(
            "-fx-background-color: rgba(26, 31, 58, 0.4);" +
            "-fx-border-color: rgba(139, 92, 246, 0.2);" +
            "-fx-border-width: 1;" +
            "-fx-border-radius: 15;" +
            "-fx-background-radius: 15;"
        );
        return panel;
    }
    
    /**
     * Create a section title label
     * @param text Title text
     * @return Styled title label
     */
    public static Label createSectionTitle(String text) {
        Label title = new Label(text);
        title.setStyle(
            "-fx-font-size: " + Constants.FONT_SIZE_LARGE + ";" +
            "-fx-text-fill: " + Constants.TEXT_PRIMARY + ";" +
            "-fx-font-weight: bold;"
        );
        return title;
    }
    
    /**
     * Create a subtitle label
     * @param text Subtitle text
     * @return Styled subtitle label
     */
    public static Label createSubtitle(String text) {
        Label subtitle = new Label(text);
        subtitle.setStyle(
            "-fx-font-size: " + Constants.FONT_SIZE_MEDIUM + ";" +
            "-fx-text-fill: " + Constants.ACCENT_PURPLE + ";"
        );
        return subtitle;
    }
    
    /**
     * Create a body text label
     * @param text Body text
     * @return Styled text label
     */
    public static Label createBodyText(String text) {
        Label body = new Label(text);
        body.setWrapText(true);
        body.setStyle(
            "-fx-font-size: " + Constants.FONT_SIZE_SMALL + ";" +
            "-fx-text-fill: " + Constants.TEXT_SECONDARY + ";"
        );
        return body;
    }
    
    /**
     * Create a skill card with tag style
     * @param skillName Skill name
     * @return Styled skill card
     */
    public static VBox createSkillCard(String skillName) {
        VBox card = new VBox();
        card.setPadding(new Insets(Constants.PADDING_MEDIUM));
        card.setStyle(
            "-fx-background-color: rgba(139, 92, 246, 0.15);" +
            "-fx-border-color: " + Constants.ACCENT_PURPLE + ";" +
            "-fx-border-width: 1;" +
            "-fx-border-radius: 10;" +
            "-fx-background-radius: 10;"
        );
        
        Label label = new Label(skillName);
        label.setStyle(
            "-fx-text-fill: " + Constants.TEXT_PRIMARY + ";" +
            "-fx-font-size: " + Constants.FONT_SIZE_SMALL + ";"
        );
        card.getChildren().add(label);
        
        AnimationUtil.scaleOnHover(card, 1.08);
        
        return card;
    }
    
    /**
     * Create a circular profile image placeholder
     * @param radius Circle radius
     * @return Circle shape
     */
    public static Circle createProfilePlaceholder(double radius) {
        Circle circle = new Circle(radius);
        circle.setStyle(
            "-fx-fill: rgba(139, 92, 246, 0.3);" +
            "-fx-stroke: " + Constants.ACCENT_PURPLE + ";" +
            "-fx-stroke-width: 2;"
        );
        return circle;
    }
    
    /**
     * Create a horizontal divider with gradient
     * @param width Divider width
     * @return HBox divider
     */
    public static HBox createDivider(double width) {
        HBox divider = new HBox();
        divider.setPrefWidth(width);
        divider.setPrefHeight(2);
        divider.setStyle(
            "-fx-background-color: linear-gradient(to right, transparent, " + 
            Constants.ACCENT_PURPLE + ", transparent);"
        );
        return divider;
    }
}
