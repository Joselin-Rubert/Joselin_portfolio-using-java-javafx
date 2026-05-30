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
 * Presentations Section Controller
 * Displays key presentations and speaking engagements
 */
public class PresentationsController extends SectionController {

    @Override
    public void initialize() {
        sectionRoot = new VBox(30);
        sectionRoot.setPadding(new Insets(Constants.PADDING_LARGE));
        sectionRoot.setStyle("-fx-background-color: #0a0e27;");

        Label sectionTitle = UIComponentFactory.createSectionTitle("Presentations");
        VBox presentationsList = createPresentationsList();

        sectionRoot.getChildren().addAll(
            sectionTitle,
            UIComponentFactory.createDivider(1200),
            presentationsList
        );

        sectionRoot.setOpacity(0);
        AnimationUtil.fadeIn(sectionRoot, Constants.ANIMATION_NORMAL);
    }

    private VBox createPresentationsList() {
        VBox list = new VBox(20);
        list.setPadding(new Insets(30, 0, 0, 0));

        list.getChildren().addAll(
            createPresentationCard(
                "NLP Innovations",
                "Delivered a presentation on natural language processing advances at a national level symposium, covering sentiment analysis and conversational AI.",
                "NLP, AI, National Symposium"
            ),
            createPresentationCard(
                "BCI Research",
                "Presented brain-computer interface research and practical applications at a national symposium, highlighting signal processing and human-machine interaction.",
                "BCI, Neuroscience, National Symposium"
            ),
            createPresentationCard(
                "Fog Computing Architecture",
                "Explained fog computing architecture and edge intelligence during a national symposium presentation, focusing on distributed compute and low-latency systems.",
                "Fog Computing, Edge AI, National Symposium"
            )
        );

        return list;
    }

    private VBox createPresentationCard(
        String title,
        String description,
        String tags
    ) {
        VBox card = new VBox(12);
        card.setPadding(new Insets(20));
        card.setStyle(
            "-fx-background-color: rgba(26, 31, 58, 0.55);" +
            "-fx-border-color: rgba(139, 92, 246, 0.3);" +
            "-fx-border-width: 1;" +
            "-fx-border-radius: 15;" +
            "-fx-background-radius: 15;"
        );

        Label titleLabel = new Label(title);
        titleLabel.setStyle(
            "-fx-font-size: 18;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #ffffff;"
        );

        Label descriptionLabel = new Label(description);
        descriptionLabel.setStyle(
            "-fx-font-size: 14;" +
            "-fx-text-fill: #a0aec0;" +
            "-fx-wrap-text: true;"
        );
        descriptionLabel.setWrapText(true);

        HBox tagBox = new HBox(8);
        tagBox.setAlignment(Pos.CENTER_LEFT);
        Label tagLabel = new Label(tags);
        tagLabel.setStyle(
            "-fx-font-size: 13;" +
            "-fx-text-fill: #8b5cf6;"
        );
        tagBox.getChildren().add(tagLabel);

        card.getChildren().addAll(titleLabel, descriptionLabel, tagBox);
        AnimationUtil.scaleOnHover(card, 1.02);

        return card;
    }
}
