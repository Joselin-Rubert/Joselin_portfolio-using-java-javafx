# Architecture & Design Documentation

## System Architecture

### MVC (Model-View-Controller) Pattern

This portfolio application uses the MVC architecture pattern for clean separation of concerns:

```
┌─────────────────────────────────────────────────────────────────┐
│                     PORTFOLIO APPLICATION                        │
└─────────────────────────────────────────────────────────────────┘
                                │
                    ┌───────────┴───────────┐
                    │                       │
              ┌─────▼─────┐         ┌──────▼──────┐
              │  VIEW      │         │ CONTROLLER  │
              │  (FXML)    │         │ (Java)      │
              │  (CSS)     │         │             │
              └────────────┘         └──────┬──────┘
                                             │
                                      ┌──────▼──────┐
                                      │   MODEL     │
                                      │ (Controllers)
                                      └─────────────┘
```

### Component Hierarchy

```
Main (Application Entry Point)
    │
    └── MainController (Main Layout Manager)
            │
            ├── Sidebar (Navigation)
            │   ├── HeroSection Button
            │   ├── AboutSection Button
            │   ├── SkillsSection Button
            │   └── ... (other sections)
            │
            └── ContentArea (Scrollable)
                ├── HeroController
                │   └── Hero Section UI
                │
                ├── AboutController
                │   └── About Section UI
                │
                ├── EducationController
                │   └── Education Section UI
                │
                ├── SkillsController
                │   └── Skills Section UI
                │
                ├── ExperienceController
                │   └── Experience Section UI
                │
                ├── ProjectsController
                │   └── Projects Section UI
                │
                ├── CertificationsController
                │   └── Certifications Section UI
                │
                ├── AchievementsController
                │   └── Achievements Section UI
                │
                ├── ContactController
                │   └── Contact Section UI
                │
                └── FooterController
                    └── Footer Section UI
```

## Design Patterns Used

### 1. **Factory Pattern** - `UIComponentFactory`
Creates consistent UI components across the application.

**Example**:
```java
// Instead of creating buttons multiple times with same styling
Button btn = UIComponentFactory.createPremiumButton("Click Me", 200, 50);
VBox panel = UIComponentFactory.createGlassPanel(300, 400);
```

**Benefits**:
- Ensures consistency
- Reduces code duplication
- Easy to update styling globally
- Maintainable and scalable

### 2. **Controller Pattern** - `SectionController`
Each section has its own controller inheriting from base `SectionController`.

**Structure**:
```java
public abstract class SectionController {
    protected VBox sectionRoot;
    public abstract void initialize();
    public VBox getSectionRoot() { /* ... */ }
    public void onSectionVisible() { /* animation */ }
    public void onSectionHidden() { /* cleanup */ }
}
```

**Benefits**:
- Separation of concerns
- Easy to manage multiple sections
- Consistent initialization flow
- Simple to add new sections

### 3. **Facade Pattern** - `AnimationUtil`
Provides simple interface for complex animations.

**Example**:
```java
// Complex: Create multiple transitions manually
// Simple: Use utility method
AnimationUtil.fadeIn(node, 500);
AnimationUtil.scaleOnHover(button, 1.05);
```

### 4. **Utility Pattern** - `Constants`
Centralized configuration for the entire application.

```java
public class Constants {
    public static final String PRIMARY_DARK = "#0a0e27";
    public static final int WINDOW_WIDTH = 1400;
    public static final int ANIMATION_FAST = 300;
    // ... all configuration in one place
}
```

## Class Relationships

```
SectionController (Abstract Base Class)
    │
    ├── HeroController
    ├── AboutController
    ├── EducationController
    ├── SkillsController
    ├── ExperienceController
    ├── ProjectsController
    ├── CertificationsController
    ├── AchievementsController
    ├── ContactController
    └── FooterController

MainController
    │
    ├── Uses: SectionController instances
    ├── Uses: BorderPane (Root)
    ├── Uses: Sidebar (VBox)
    └── Uses: ContentArea (ScrollPane)

Utility Classes:
    ├── AnimationUtil - Static methods for animations
    ├── UIComponentFactory - Static methods for UI components
    └── Constants - Static final constants
```

## Data Flow Diagram

```
User Interaction (Click Button)
            │
            ▼
    MainController
            │
            ├─► Check which section clicked
            │
            ▼
    Load SectionController
            │
            ├─► Initialize section
            │
            ├─► Get section root (VBox)
            │
            ▼
    Update ContentArea
            │
            ├─► Clear previous section
            │
            ├─► Add new section
            │
            ├─► Add footer
            │
            ▼
    Play Animation
            │
            └─► Display to User
```

## Styling Architecture

```
styles.css (Single Source of Truth)
    │
    ├── Root Styling
    │   └── Font, background, text color
    │
    ├── Container Styling
    │   ├── Main container
    │   ├── Sidebar styling
    │   └── Content area
    │
    ├── Component Styling
    │   ├── Button styles
    │   │   ├── .primary-button (gradient)
    │   │   ├── .secondary-button (outline)
    │   │   └── .glowing-button (neon glow)
    │   │
    │   ├── Text styling
    │   │   ├── .section-title
    │   │   ├── .card-title
    │   │   └── .body-text
    │   │
    │   └── Card styling
    │       ├── .glass-panel
    │       ├── .card
    │       └── .skill-card
    │
    └── Effects
        ├── Hover states
        ├── Animations
        ├── Box shadows
        └── Gradients
```

## Module Structure

```
com.portfolio
    │
    ├── Main.java (Entry Point)
    │   └── Launches application
    │
    ├── controllers/
    │   ├── SectionController.java (Abstract Base)
    │   ├── MainController.java (Layout Manager)
    │   │
    │   └── Section Controllers:
    │       ├── HeroController
    │       ├── AboutController
    │       ├── EducationController
    │       ├── SkillsController
    │       ├── ExperienceController
    │       ├── ProjectsController
    │       ├── CertificationsController
    │       ├── AchievementsController
    │       ├── ContactController
    │       └── FooterController
    │
    ├── utils/
    │   ├── Constants.java
    │   │   └── Configuration constants
    │   │
    │   ├── AnimationUtil.java
    │   │   └── Static animation methods
    │   │
    │   └── UIComponentFactory.java
    │       └── Static component creation methods
    │
    └── styles/
        └── styles.css
            └── All styling
```

## Execution Flow

```
1. User launches application
   │
   ▼
2. JVM calls Main.start(Stage primaryStage)
   │
   ▼
3. Main.java initializes:
   - Creates scene
   - Loads CSS
   - Sets window properties
   - Shows stage
   │
   ▼
4. MainController initializes:
   - Creates sidebar
   - Creates content area
   - Initializes all section controllers
   │
   ▼
5. HeroSection loaded by default:
   - Fade in animation plays
   - Typing effect on name starts
   │
   ▼
6. User interacts (clicks sidebar button):
   - Sidebar button handler triggered
   - MainController.switchSection() called
   - New section controller loaded
   - Animation plays
   │
   ▼
7. User scrolls/interacts:
   - Section content displayed
   - Hover animations work
   - Interactive elements respond
   │
   ▼
8. User closes window:
   - JavaFX cleans up resources
   - Application exits
```

## Key Design Decisions

### 1. **Thread-Safe Animations**
Using `Platform.runLater()` for thread-safe UI updates:
```java
Platform.runLater(() -> label.setText(displayText));
```

### 2. **Centralized Constants**
All magic numbers and colors in `Constants.java`:
- Easy to maintain
- Global consistency
- Simple theme changes

### 3. **Abstract Base Controller**
`SectionController` provides:
- Common initialization
- Consistent animation behavior
- Standard lifecycle methods

### 4. **CSS-Based Styling**
All styling in `styles.css`:
- Separates design from logic
- Professional approach
- Easy to modify
- Reusable styles

### 5. **Factory for Components**
`UIComponentFactory` ensures:
- Consistent styling
- Reduced code duplication
- Easy updates
- Professional appearance

## Performance Considerations

### Optimizations Applied

1. **Lazy Component Creation**
   - Sections created on demand (not at startup)
   - Reduces initial load time

2. **CSS Styling**
   - More efficient than programmatic styling
   - Easier to maintain and update

3. **Animation Throttling**
   - Single animation per element (not overlapping)
   - Smooth performance

4. **Resource Management**
   - No memory leaks from animations
   - Proper cleanup in onSectionHidden()

### Memory Usage
- Single instance of each controller
- No unnecessary object creation
- CSS cached by JavaFX
- Efficient layout calculations

## Extensibility Points

### Adding New Section

1. Create `NewSectionController.java`:
```java
public class NewSectionController extends SectionController {
    @Override
    public void initialize() {
        sectionRoot = new VBox();
        // Build UI
    }
}
```

2. Add to `MainController.java`:
```java
private NewSectionController newController;

// In initializeSectionControllers()
newController = new NewSectionController();
newController.initialize();

// In switchSection()
case "newsection" -> targetController = newController;
```

3. Add button to sidebar in `createSidebar()`

### Modifying Styling

1. Edit `styles.css`
2. Add new CSS class
3. Apply with `getStyleClass().add("className")`

### Adding Animations

1. Create method in `AnimationUtil.java`
2. Use in controllers: `AnimationUtil.newAnimation(node, duration)`

## Testing Considerations

### Unit Testing
```java
// Test AnimationUtil independently
@Test
public void testFadeInAnimation() { /* ... */ }

// Test UIComponentFactory
@Test
public void testButtonCreation() { /* ... */ }
```

### Integration Testing
```java
// Test section controllers
@Test
public void testHeroControllerInitialization() { /* ... */ }
```

### GUI Testing
- Manual interaction testing
- Animation smoothness verification
- Styling consistency check

---

**Architecture Summary**: This application follows SOLID principles with clean separation of concerns, making it easy to understand, maintain, and extend.
