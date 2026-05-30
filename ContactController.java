package com.portfolio.controllers;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import com.portfolio.utils.Constants;
import com.portfolio.utils.UIComponentFactory;

import java.awt.Desktop;
import java.net.URI;

/**
 * Contact Section Controller
 * Provides contact information and contact form
 */
public class ContactController extends SectionController {

    @Override
    public void initialize() {

        sectionRoot = new VBox(40);

        sectionRoot.setPadding(
            new Insets(Constants.PADDING_LARGE)
        );

        sectionRoot.setStyle(
            "-fx-background-color: #0a0e27;"
        );

        // Section Title
        Label sectionTitle =
            UIComponentFactory.createSectionTitle(
                "Let's Connect"
            );

        // Contact Content
        HBox contactContent =
            createContactContent();

        sectionRoot.getChildren().addAll(
            sectionTitle,
            UIComponentFactory.createDivider(1200),
            contactContent
        );

        sectionRoot.setOpacity(0);
    }

    /**
     * Create Contact Content
     */
    private HBox createContactContent() {

        HBox content = new HBox(60);

        content.setAlignment(Pos.TOP_LEFT);

        content.setPadding(
            new Insets(40, 0, 0, 0)
        );

        // Contact Info
        VBox contactInfo =
            createContactInfo();

        // Contact Form
        VBox contactForm =
            createContactForm();

        content.getChildren().addAll(
            contactInfo,
            contactForm
        );

        return content;
    }

    /**
     * Create Contact Information Section
     */
    private VBox createContactInfo() {

        VBox info = new VBox(30);

        info.setPrefWidth(350);

        // Title
        Label directLabel =
            UIComponentFactory.createSubtitle(
                "Get In Touch"
            );

        // Contact Items
        HBox emailBox =
            createContactItem(
                "Email",
                "joselinpraisy2006@gmail.com"
            );

        HBox phoneBox =
            createContactItem(
                "Phone",
                "+91 9952281540"
            );

        HBox locationBox =
            createContactItem(
                "Location",
                "Sawyerpuram,Thoothukudi Tamil Nadu, India"
            );

        // Social Links
        VBox socialBox =
            createSocialLinks();

        info.getChildren().addAll(
            directLabel,
            emailBox,
            phoneBox,
            locationBox,
            new VBox(10),
            socialBox
        );

        return info;
    }

    /**
     * Create Contact Item
     */
    private HBox createContactItem(
        String label,
        String value
    ) {

        HBox item = new HBox(15);

        item.setAlignment(Pos.CENTER_LEFT);

        // Text Container
        VBox textBox = new VBox(5);

        // Label
        Label labelText = new Label(label);

        labelText.setStyle(
            "-fx-font-size: 12;" +
            "-fx-text-fill: #8b5cf6;" +
            "-fx-font-weight: 600;"
        );

        // Value
        Label valueText = new Label(value);

        valueText.setStyle(
            "-fx-font-size: 14;" +
            "-fx-text-fill: #ffffff;" +
            "-fx-font-weight: 500;"
        );

        valueText.setWrapText(true);

        textBox.getChildren().addAll(
            labelText,
            valueText
        );

        item.getChildren().add(
            textBox
        );

        return item;
    }

    /**
     * Create Social Links
     */
    private VBox createSocialLinks() {

        VBox social = new VBox(15);

        // Label
        Label socialLabel = new Label("Follow Me");

        socialLabel.setStyle(
            "-fx-font-size: 14;" +
            "-fx-text-fill: #8b5cf6;" +
            "-fx-font-weight: 600;"
        );

        // Social Buttons Container
        HBox socialLinks = new HBox(15);

        socialLinks.setAlignment(
            Pos.CENTER_LEFT
        );

        String[] platforms = {
            "LinkedIn",
            "GitHub"
        };

        String[] urls = {
            "https://www.linkedin.com/in/joselin-sornapraisy",
            "https://github.com/Joselin-Rubert"
        };

        for (int i = 0; i < platforms.length; i++) {

            final int index = i;

            Button socialBtn =
                UIComponentFactory.createGlowingButton(
                    platforms[i],
                    100,
                    40
                );

            socialBtn.setOnAction(
                e -> openLink(urls[index])
            );

            socialLinks.getChildren().add(
                socialBtn
            );
        }

        social.getChildren().addAll(
            socialLabel,
            socialLinks
        );

        return social;
    }

    private void openLink(String url) {
        try {
            if (!Desktop.isDesktopSupported()) {
                System.err.println("Desktop browsing is not supported on this platform.");
                return;
            }

            Desktop desktop = Desktop.getDesktop();
            if (!desktop.isSupported(Desktop.Action.BROWSE)) {
                System.err.println("Desktop browse action is not supported.");
                return;
            }

            desktop.browse(new URI(url));
        } catch (Exception e) {
            System.err.println("Error opening URL: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Create Contact Form
     */
    private VBox createContactForm() {

        VBox form = new VBox(15);

        form.setPrefWidth(400);

        form.setPadding(
            new Insets(25)
        );

        form.setStyle(
            "-fx-background-color: rgba(26, 31, 58, 0.5);" +
            "-fx-border-color: rgba(139, 92, 246, 0.3);" +
            "-fx-border-width: 1;" +
            "-fx-border-radius: 15;" +
            "-fx-background-radius: 15;"
        );

        // Name
        Label nameLabel = new Label("Name *");

        nameLabel.setStyle(
            "-fx-font-size: 13;" +
            "-fx-text-fill: #8b5cf6;" +
            "-fx-font-weight: 600;"
        );

        TextField nameField = new TextField();

        nameField.setPromptText(
            "Your name"
        );

        nameField.setPrefHeight(40);

        nameField.getStyleClass().add(
            "text-field"
        );

        // Email
        Label emailLabel = new Label("Email *");

        emailLabel.setStyle(
            "-fx-font-size: 13;" +
            "-fx-text-fill: #8b5cf6;" +
            "-fx-font-weight: 600;"
        );

        TextField emailField = new TextField();

        emailField.setPromptText(
            "Your email"
        );

        emailField.setPrefHeight(40);

        emailField.getStyleClass().add(
            "text-field"
        );

        // Message
        Label messageLabel = new Label("Message *");

        messageLabel.setStyle(
            "-fx-font-size: 13;" +
            "-fx-text-fill: #8b5cf6;" +
            "-fx-font-weight: 600;"
        );

        TextArea messageArea = new TextArea();

        messageArea.setPromptText(
            "Your message..."
        );

        messageArea.setPrefRowCount(5);

        messageArea.setWrapText(true);

        messageArea.getStyleClass().add(
            "text-area"
        );

        // Submit Button
        Button submitBtn =
            UIComponentFactory.createGlowingButton(
                "Send Message",
                350,
                45
            );

        submitBtn.getStyleClass().add(
            "primary-button"
        );

        submitBtn.setOnAction(
            e -> handleFormSubmit(
                nameField,
                emailField,
                messageArea
            )
        );

        form.getChildren().addAll(
            nameLabel,
            nameField,
            emailLabel,
            emailField,
            messageLabel,
            messageArea,
            new VBox(10),
            submitBtn
        );

        return form;
    }

    /**
     * Handle Form Submission
     */
    private void handleFormSubmit(
        TextField nameField,
        TextField emailField,
        TextArea messageArea
    ) {

        String name =
            nameField.getText();

        String email =
            emailField.getText();

        String message =
            messageArea.getText();

        if (
            name.isEmpty() ||
            email.isEmpty() ||
            message.isEmpty()
        ) {

            System.out.println(
                "Please fill all fields"
            );

        } else {

            System.out.println(
                "Form submitted: " +
                name +
                ", " +
                email
            );

            // Clear Fields
            nameField.clear();
            emailField.clear();
            messageArea.clear();
        }
    }
}
