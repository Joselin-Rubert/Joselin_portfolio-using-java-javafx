package com.portfolio.controllers;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import com.portfolio.utils.Constants;

/**
 * Footer Section Controller
 * Premium Footer Section
 */
public class FooterController extends SectionController {

    @Override
    public void initialize() {

        sectionRoot = new VBox();

        sectionRoot.setStyle(
            "-fx-background-color: rgba(26, 31, 58, 0.6);" +
            "-fx-border-color: rgba(139, 92, 246, 0.2);" +
            "-fx-border-width: 1 0 0 0;"
        );

        sectionRoot.setPadding(
            new Insets(Constants.PADDING_LARGE)
        );

        sectionRoot.setAlignment(
            Pos.CENTER
        );

        // Footer Content
        HBox footerContent =
            createFooterContent();

        sectionRoot.getChildren().add(
            footerContent
        );
    }

    /**
     * Create Footer Content
     */
    private HBox createFooterContent() {

        HBox content = new HBox();

        content.setAlignment(
            Pos.CENTER
        );

        content.setPadding(
            new Insets(20)
        );

        Label footerText = new Label(
            "Designed & Developed with ❤ by Joselin Sornapraisy R"
        );

        footerText.setStyle(
            "-fx-font-size: 14;" +
            "-fx-text-fill: #a0aec0;" +
            "-fx-font-weight: 500;"
        );

        content.getChildren().add(footerText);

        return content;
    }
}