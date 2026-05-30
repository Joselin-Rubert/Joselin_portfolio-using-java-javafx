package com.portfolio.controllers;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import com.portfolio.utils.AnimationUtil;
import com.portfolio.utils.Constants;
import com.portfolio.utils.UIComponentFactory;
import java.io.File;

/**
 * About Section Controller
 * Displays personal background and professional interests
 */
public class AboutController extends SectionController {
    
    @Override
    public void initialize() {
        sectionRoot = new VBox(40);
        sectionRoot.setPadding(new Insets(Constants.PADDING_LARGE));
        sectionRoot.setStyle("-fx-background-color: #0a0e27;");
        
        // Section Title
        Label sectionTitle = UIComponentFactory.createSectionTitle("About Me");
        
        // About Content
        HBox contentBox = createAboutContent();
        
        sectionRoot.getChildren().addAll(
            sectionTitle,
            UIComponentFactory.createDivider(1200),
            contentBox
        );
        
        sectionRoot.setOpacity(0);
    }
    
    private HBox createAboutContent() {
        HBox contentBox = new HBox(60);
        contentBox.setAlignment(Pos.TOP_LEFT);
        contentBox.setPadding(new Insets(40, 0, 0, 0));
        
        // Profile Section (Left)
        VBox profileSection = createProfileSection();
        
        // Text Content (Right)
        VBox textContent = createTextContent();
        
        contentBox.getChildren().addAll(profileSection, textContent);
        return contentBox;
    }
    
    private VBox createProfileSection() {
        VBox section = new VBox(20);
        section.setAlignment(Pos.TOP_CENTER);
        
        // Profile Image - try to load from assets, fallback to placeholder
        Circle profileCircle = UIComponentFactory.createProfilePlaceholder(60);
        ImageView profileImage = loadProfileImage();
        if (profileImage != null) {
            AnimationUtil.scaleOnHover(profileImage, 1.1);
            section.getChildren().add(profileImage);
        } else {
            AnimationUtil.scaleOnHover(profileCircle, 1.1);
            section.getChildren().add(profileCircle);
        }
        
        // Profile Stats Cards
        HBox statsBox = createStatsCards();
        
        section.getChildren().add(statsBox);
        return section;
    }
    
    private HBox createStatsCards() {
        HBox statsBox = new HBox(15);
        statsBox.setAlignment(Pos.CENTER);
        
        VBox stat1 = createStatCard("10+", "mini/micro projects");
        VBox stat2 = createStatCard("5+", "Technologies");
        VBox stat3 = createStatCard("3", "Internships");
        
        statsBox.getChildren().addAll(stat1, stat2, stat3);
        return statsBox;
    }
    
    private VBox createStatCard(String number, String label) {
        VBox card = new VBox(10);
        card.setAlignment(Pos.CENTER);
        card.setPadding(new Insets(15));
        card.setStyle(
            "-fx-background-color: rgba(139, 92, 246, 0.15);" +
            "-fx-border-color: #8b5cf6;" +
            "-fx-border-width: 1;" +
            "-fx-border-radius: 10;" +
            "-fx-background-radius: 10;"
        );
        
        Label numberLabel = new Label(number);
        numberLabel.setStyle(
            "-fx-font-size: 24;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #8b5cf6;"
        );
        
        Label labelText = new Label(label);
        labelText.setStyle(
            "-fx-font-size: 12;" +
            "-fx-text-fill: #a0aec0;"
        );
        
        card.getChildren().addAll(numberLabel, labelText);
        AnimationUtil.scaleOnHover(card, 1.08);
        
        return card;
    }
    
    private VBox createTextContent() {
        VBox content = new VBox(20);
        content.setPrefWidth(600);
        
        // Subtitle
        Label subtitle = UIComponentFactory.createSubtitle("My Tech Journey");
        
        // Journey description
        Label journey = UIComponentFactory.createBodyText(
    "A passionate and adaptable Pre-Final Year Computer Science and Engineering student " +
    "eager to explore new technologies and continuously enhance technical skills. " +
    "Strongly interested in Java Development, Full Stack Development, and software engineering " +
    "with a mindset focused on innovation, problem-solving, and continuous learning."
);
        // Passion section
        Label passionTitle = UIComponentFactory.createSubtitle("Techical Interests");
        
        VBox passionList = createPassionList();
        
        // Call to action
        Label ctaText = new Label("Let's build something amazing together!");
        ctaText.setStyle(
            "-fx-font-size: 16;" +
            "-fx-text-fill: #06b6d4;" +
            "-fx-font-weight: 600;"
        );
        
        content.getChildren().addAll(
            subtitle,
            journey,
            passionTitle,
            passionList,
            new VBox(20), // Spacing
            ctaText
        );
        
        return content;
    }
    
    private VBox createPassionList() {
        VBox list = new VBox(12);
        
        String[] passions = {
            "Java Development",
            "Swing GUI Applications",
            "Full Stack Development",
            "Android App Development",
            "Web Development",
            "Building Impactful Solutions"
        };
        
        for (String passion : passions) {
            HBox item = new HBox(10);
            item.setAlignment(Pos.CENTER_LEFT);
            
            Label bullet = new Label("◆");
            bullet.setStyle("-fx-font-size: 12; -fx-text-fill: #8b5cf6;");
            
            Label text = new Label(passion);
            text.setStyle(
                "-fx-font-size: 14;" +
                "-fx-text-fill: #a0aec0;"
            );
            
            item.getChildren().addAll(bullet, text);
            list.getChildren().add(item);
        }
        
        return list;
    }
    
    /**
     * Load profile image from assets folder
     * Looks for profile.png, profile.jpg, or profile.jpeg
     */
    private ImageView loadProfileImage() {
        String[] imageNames = {"profile.png", "profile.jpg", "profile.jpeg"};
        
        for (String imageName : imageNames) {
            // Try from classpath (compiled resources)
            try {
                Image image = new Image(getClass().getResourceAsStream("/com/portfolio/assets/images/" + imageName));
                if (!image.isError()) {
                    ImageView imageView = new ImageView(image);
                    imageView.setFitWidth(120);
                    imageView.setFitHeight(120);
                    imageView.setPreserveRatio(true);
                    imageView.setSmooth(true);
                    // Make it circular
                    Circle clip = new Circle(60, 60, 60);
                    imageView.setClip(clip);
                    return imageView;
                }
            } catch (Exception e) {
                // Try next format
            }
            
            // Try from project source folder
            try {
                String sourceFile = System.getProperty("user.dir") + "/src/main/java/com/portfolio/assets/images/" + imageName;
                File file = new File(sourceFile);
                if (file.exists()) {
                    Image image = new Image(file.toURI().toString());
                    if (!image.isError()) {
                        ImageView imageView = new ImageView(image);
                        imageView.setFitWidth(120);
                        imageView.setFitHeight(120);
                        imageView.setPreserveRatio(true);
                        imageView.setSmooth(true);
                        Circle clip = new Circle(60, 60, 60);
                        imageView.setClip(clip);
                        return imageView;
                    }
                }
            } catch (Exception e) {
                // Try next format
            }
        }
        
        return null; // No profile image found, will use placeholder
    }
}
