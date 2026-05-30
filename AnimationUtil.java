package com.portfolio.utils;

import javafx.animation.*;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 * Utility class for creating reusable animations
 * Provides smooth transitions and effects for the portfolio
 */
public class AnimationUtil {
    
    /**
     * Fade in animation
     * @param node The node to animate
     * @param duration Duration in milliseconds
     */
    public static void fadeIn(Node node, int duration) {
        FadeTransition fadeIn = new FadeTransition(Duration.millis(duration), node);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }
    
    /**
     * Fade out animation
     * @param node The node to animate
     * @param duration Duration in milliseconds
     */
    public static void fadeOut(Node node, int duration) {
        FadeTransition fadeOut = new FadeTransition(Duration.millis(duration), node);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        fadeOut.play();
    }
    
    /**
     * Slide in from left animation
     * @param node The node to animate
     * @param distance Distance to slide
     * @param duration Duration in milliseconds
     */
    public static void slideInFromLeft(Node node, double distance, int duration) {
        node.setTranslateX(-distance);
        TranslateTransition slideIn = new TranslateTransition(Duration.millis(duration), node);
        slideIn.setToX(0);
        slideIn.play();
    }
    
    /**
     * Slide in from bottom animation
     * @param node The node to animate
     * @param distance Distance to slide
     * @param duration Duration in milliseconds
     */
    public static void slideInFromBottom(Node node, double distance, int duration) {
        node.setTranslateY(distance);
        TranslateTransition slideIn = new TranslateTransition(Duration.millis(duration), node);
        slideIn.setToY(0);
        slideIn.play();
    }
    
    /**
     * Scale animation on hover
     * @param node The node to animate
     * @param scale Scale factor (1.1 = 10% larger)
     */
    public static void scaleOnHover(Node node, double scale) {
        node.setOnMouseEntered(e -> {
            ScaleTransition scaleUp = new ScaleTransition(Duration.millis(300), node);
            scaleUp.setToX(scale);
            scaleUp.setToY(scale);
            scaleUp.play();
        });
        
        node.setOnMouseExited(e -> {
            ScaleTransition scaleDown = new ScaleTransition(Duration.millis(300), node);
            scaleDown.setToX(1.0);
            scaleDown.setToY(1.0);
            scaleDown.play();
        });
    }
    
    /**
     * Glow effect animation
     * @param node The node to animate
     * @param duration Duration in milliseconds
     */
    public static void glowEffect(Node node, int duration) {
        ScaleTransition glow = new ScaleTransition(Duration.millis(duration), node);
        glow.setFromX(1.0);
        glow.setFromY(1.0);
        glow.setToX(1.05);
        glow.setToY(1.05);
        glow.setCycleCount(Timeline.INDEFINITE);
        glow.setAutoReverse(true);
        glow.play();
    }
    
    /**
     * Rotate animation
     * @param node The node to animate
     * @param duration Duration in milliseconds
     */
    public static void rotate(Node node, int duration) {
        RotateTransition rotate = new RotateTransition(Duration.millis(duration), node);
        rotate.setByAngle(360);
        rotate.setCycleCount(Timeline.INDEFINITE);
        rotate.play();
    }
    
    /**
     * Sequential fade and translate animation
     * @param node The node to animate
     * @param duration Duration in milliseconds
     */
    public static void fadeAndSlide(Node node, int duration) {
        FadeTransition fade = new FadeTransition(Duration.millis(duration), node);
        fade.setFromValue(0.0);
        fade.setToValue(1.0);
        
        TranslateTransition translate = new TranslateTransition(Duration.millis(duration), node);
        translate.setFromY(30);
        translate.setToY(0);
        
        ParallelTransition parallel = new ParallelTransition(fade, translate);
        parallel.play();
    }
    
    /**
     * Pulse animation (like a heartbeat)
     * @param node The node to animate
     * @param duration Duration in milliseconds
     */
    public static void pulse(Node node, int duration) {
        ScaleTransition scale = new ScaleTransition(Duration.millis(duration), node);
        scale.setFromX(1.0);
        scale.setFromY(1.0);
        scale.setToX(1.1);
        scale.setToY(1.1);
        scale.setCycleCount(Timeline.INDEFINITE);
        scale.setAutoReverse(true);
        scale.play();
    }
}
