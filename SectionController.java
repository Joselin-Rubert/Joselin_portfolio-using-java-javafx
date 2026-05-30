package com.portfolio.controllers;

import javafx.scene.layout.VBox;

/**
 * Base controller for all sections
 * Provides common functionality for section management
 */
public abstract class SectionController {
    
    protected VBox sectionRoot;
    
    /**
     * Initialize the section
     */
    public abstract void initialize();
    
    /**
     * Get the root node of this section
     */
    public VBox getSectionRoot() {
        return sectionRoot;
    }
    
    /**
     * Called when section becomes visible
     */
    public void onSectionVisible() {
        if (sectionRoot != null) {
            sectionRoot.setOpacity(0);
            com.portfolio.utils.AnimationUtil.fadeIn(sectionRoot, com.portfolio.utils.Constants.ANIMATION_NORMAL);
        }
    }
    
    /**
     * Called when section becomes hidden
     */
    public void onSectionHidden() {
        // Override if needed
    }
}
