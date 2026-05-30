# Developer Guide - Understanding & Modifying the Code

## Welcome Developer! 👨‍💻

This guide will help you understand how the codebase works and how to modify it to your needs.

## Code Navigation

### 1. Understanding the Main Application Entry Point

**File**: `src/main/java/com/portfolio/Main.java`

```java
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Step 1: Create MainController (handles UI structure)
        mainController = new MainController();
        
        // Step 2: Create scene with root pane
        Scene scene = new Scene(mainController.getRoot(), 1400, 900);
        
        // Step 3: Load CSS styling
        String css = this.getClass().getResource("styles/styles.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        // Step 4: Configure and show window
        primaryStage.setTitle("Portfolio");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
```

**Key Concepts**:
- `Application` is JavaFX's base class for GUI apps
- `Stage` is the window
- `Scene` is the content inside the window
- CSS is applied to scene

### 2. Understanding MainController

**File**: `src/main/java/com/portfolio/controllers/MainController.java`

This is the "brain" of your application. It:
1. Creates the sidebar with navigation buttons
2. Creates the main content area
3. Switches between sections when you click buttons

**Key Methods**:
```java
private void createSidebar()      // Creates left navigation panel
private void createContentArea()  // Creates main scrollable content
private void switchSection()      // Switches between sections
private void loadSection()        // Loads a specific section
```

**How It Works**:
```
User clicks "About" button
         │
         ▼
NavButton.setOnAction() triggered
         │
         ▼
switchSection("about") called
         │
         ▼
loadSection(aboutController) called
         │
         ▼
ContentArea updated with AboutController.getSectionRoot()
         │
         ▼
Animation plays
         │
         ▼
User sees About section
```

### 3. Understanding Section Controllers

**File**: `src/main/java/com/portfolio/controllers/HeroController.java` (example)

Each section (Hero, About, Skills, etc.) has its own controller.

**Basic Structure**:
```java
public class HeroController extends SectionController {
    @Override
    public void initialize() {
        // 1. Create root container
        sectionRoot = new VBox();
        
        // 2. Configure styling
        sectionRoot.setStyle("-fx-background-color: #0a0e27;");
        
        // 3. Create content
        Label name = new Label("Joselin");
        sectionRoot.getChildren().add(name);
        
        // 4. Add animation
        AnimationUtil.fadeIn(sectionRoot, Constants.ANIMATION_SLOW);
    }
}
```

**Common Patterns**:

**Creating a Label**:
```java
Label title = new Label("Section Title");
title.setStyle("-fx-font-size: 32; -fx-text-fill: #ffffff;");
```

**Creating a Container**:
```java
VBox container = new VBox(10);  // 10px spacing between children
container.setPadding(new Insets(20));  // 20px padding inside
```

**Adding Hover Effect**:
```java
AnimationUtil.scaleOnHover(button, 1.05);  // 5% larger on hover
```

### 4. Understanding UIComponentFactory

**File**: `src/main/java/com/portfolio/utils/UIComponentFactory.java`

This is your "component library". Instead of creating styled components multiple times, use the factory.

**Available Components**:

```java
// Create a button
Button btn = UIComponentFactory.createPremiumButton("Click Me", 200, 50);

// Create a panel with glass effect
VBox panel = UIComponentFactory.createGlassPanel(400, 300);

// Create a label
Label title = UIComponentFactory.createSectionTitle("Title");

// Create a skill card
VBox skillCard = UIComponentFactory.createSkillCard("Java");
```

**Why Use Factory?**
- ✅ Consistent styling
- ✅ Less code repetition
- ✅ Easy to update (change once, applies everywhere)
- ✅ Professional appearance

### 5. Understanding Animations

**File**: `src/main/java/com/portfolio/utils/AnimationUtil.java`

This provides ready-to-use animation methods.

**Common Animations**:

```java
// Fade in effect (0% to 100% opacity)
AnimationUtil.fadeIn(node, 500);  // 500 milliseconds

// Fade out effect (100% to 0% opacity)
AnimationUtil.fadeOut(node, 500);

// Slide from left
AnimationUtil.slideInFromLeft(node, 100, 500);  // 100px distance

// Slide from bottom
AnimationUtil.slideInFromBottom(node, 100, 500);

// Scale on hover (grow when mouse enters)
AnimationUtil.scaleOnHover(node, 1.1);  // 10% larger

// Glow effect (infinite pulsing)
AnimationUtil.glowEffect(node, 1000);

// Pulse (heartbeat) animation
AnimationUtil.pulse(node, 500);
```

## How to Modify Content

### Change Hero Section Text

**File**: `src/main/java/com/portfolio/controllers/HeroController.java`

Find this line:
```java
addTypingEffect(nameLabel, "Joselin Sornapraisy R", 50);
```

Change to:
```java
addTypingEffect(nameLabel, "Your Name Here", 50);
```

### Add New Skill

**File**: `src/main/java/com/portfolio/controllers/SkillsController.java`

Find this array:
```java
String[] skills = {"Java", "Python", "C"};
```

Add your skill:
```java
String[] skills = {"Java", "Python", "C", "JavaScript"};
```

### Add New Project

**File**: `src/main/java/com/portfolio/controllers/ProjectsController.java`

Find this method call:
```java
grid.getChildren().add(createProjectCard(
    "Project Title",
    "Project description",
    new String[]{"Tech1", "Tech2"}
));
```

Copy and modify to add another:
```java
grid.getChildren().add(createProjectCard(
    "Your New Project",
    "Your project description",
    new String[]{"Your Tech", "Another Tech"}
));
```

### Change Colors

**File**: `src/main/java/com/portfolio/utils/Constants.java`

Change color constants:
```java
public static final String ACCENT_PURPLE = "#FF00FF";  // Magenta instead
public static final String PRIMARY_DARK = "#1a1a1a";   // Darker black
```

These changes affect the entire application!

### Change Animation Speed

**File**: `src/main/java/com/portfolio/utils/Constants.java`

```java
public static final int ANIMATION_FAST = 200;   // Faster (was 300)
public static final int ANIMATION_NORMAL = 350; // Faster (was 500)
public static final int ANIMATION_SLOW = 800;   // Slower (was 1000)
```

Or change specific usage:
```java
AnimationUtil.fadeIn(node, 200);  // Very fast
AnimationUtil.fadeIn(node, 1500); // Very slow
```

## Common Tasks

### Add a New Section

1. **Create Controller**:
```java
// File: NewSectionController.java
public class NewSectionController extends SectionController {
    @Override
    public void initialize() {
        sectionRoot = new VBox();
        // Build your section UI here
    }
}
```

2. **Add to MainController**:
```java
// In MainController.java
private NewSectionController newController;

// In initializeSectionControllers():
newController = new NewSectionController();
newController.initialize();

// In switchSection() method:
case "newsection" -> targetController = newController;
```

3. **Add Navigation Button**:
In `createSidebar()` method, add to sections array:
```java
String[] sections = {
    "Hero",
    "About",
    // ... other sections ...
    "New Section"  // Add this
};
```

### Add a Custom Button

```java
Button customBtn = UIComponentFactory.createGlowingButton("My Button", 150, 40);
customBtn.setStyle(customBtn.getStyle() + 
    "-fx-font-size: 16;" +
    "-fx-background-color: linear-gradient(to right, #FF00FF, #00FFFF);"
);
customBtn.setOnAction(e -> {
    System.out.println("Button clicked!");
    // Your action here
});
```

### Add a Custom Card

```java
VBox customCard = new VBox(10);
customCard.setStyle(
    "-fx-background-color: rgba(139, 92, 246, 0.15);" +
    "-fx-border-color: #8b5cf6;" +
    "-fx-border-width: 2;" +
    "-fx-padding: 15;"
);

Label title = new Label("Card Title");
title.setStyle("-fx-font-size: 18; -fx-text-fill: #ffffff;");

customCard.getChildren().add(title);
```

## Debugging Tips

### Print Debug Messages

Add to any method to see output in console:
```java
System.out.println("Hero section loaded!");
```

### Check Window Size

Add to Main.java in start() method:
```java
primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> 
    System.out.println("Width: " + newVal)
);
```

### Test Animations

Add to any node to test animation:
```java
AnimationUtil.fadeIn(myNode, 5000);  // 5 second animation (easier to see)
```

### Check CSS Application

If styles not working:
1. Check file exists: `src/main/java/com/portfolio/styles/styles.css`
2. Rebuild project (Clean → Build)
3. Check console for CSS loading errors

## Code Organization Tips

### Good Practice 1: Use Constants
```java
// Good
AnimationUtil.fadeIn(node, Constants.ANIMATION_NORMAL);

// Bad
AnimationUtil.fadeIn(node, 500);  // What does 500 mean?
```

### Good Practice 2: Use Factory
```java
// Good
Button btn = UIComponentFactory.createPremiumButton("Click", 200, 50);

// Bad
Button btn = new Button("Click");
btn.setPrefWidth(200);
btn.setPrefHeight(50);
btn.setStyle("-fx-font-size: 14; -fx-text-fill: #ffffff; ...");
```

### Good Practice 3: Meaningful Names
```java
// Good
VBox experienceSection = new VBox();

// Bad
VBox vb = new VBox();
```

### Good Practice 4: Comments
```java
// Good
// Create profile image with hover animation
Circle profileImage = UIComponentFactory.createProfilePlaceholder(120);
AnimationUtil.scaleOnHover(profileImage, 1.1);

// Bad (no explanation)
Circle c = UIComponentFactory.createProfilePlaceholder(120);
AnimationUtil.scaleOnHover(c, 1.1);
```

## Testing Your Changes

### Quick Testing Checklist

After making changes:
1. ✅ Compile successfully (no errors)
2. ✅ Application starts without exceptions
3. ✅ All sections load correctly
4. ✅ Sidebar navigation works
5. ✅ Animations play smoothly
6. ✅ Styling looks correct
7. ✅ New content appears as expected

### Common Issues & Fixes

| Issue | Solution |
|-------|----------|
| Buttons not appearing | Check if added to `getChildren()` |
| Text not visible | Check text color vs background color |
| Animation not playing | Check node is added to scene first |
| CSS not applied | Rebuild project and check file path |
| Sidebar buttons unresponsive | Check event handler is set |

## Performance Optimization

### Tips for Better Performance

1. **Avoid Complex Nested Layouts**
   ```java
   // Simpler is better
   VBox container = new VBox(10);  // Good
   
   // Avoid deep nesting
   VBox v1 = new VBox();
   HBox h1 = new HBox();
   VBox v2 = new VBox();
   // ... too complex
   ```

2. **Reuse Controllers**
   - Controllers are created once and reused
   - No memory leaks from recreation

3. **Lazy Load if Needed**
   - Sections initialize only when first visited
   - Good for large applications

4. **Limit Animation Overlaps**
   - Don't start too many animations simultaneously
   - Use `Animation.setRate()` to adjust speed

## Version Control (Git Tips)

### Important Files to Commit
```
src/main/java/    ← All Java source files
README.md         ← Documentation
QUICK_START.md    ← Getting started guide
```

### Files to Ignore
```
bin/              ← Compiled files (regenerated)
.classpath        ← IDE configuration
.project          ← IDE configuration
*.class           ← Compiled classes
```

## Resources for Learning

- **JavaFX Documentation**: https://openjfx.io/
- **JavaFX CSS Reference**: https://docs.oracle.com/javase/8/javafx/api/javafx/scene/doc-files/cssref.html
- **CSS Basics**: https://developer.mozilla.org/en-US/docs/Web/CSS
- **Java Basics**: https://docs.oracle.com/javase/tutorial/

## Getting Help

1. **Read Code Comments** - Most important sections have comments
2. **Check Similar Sections** - Look at existing controllers for patterns
3. **Search Code** - Use IDE search (Ctrl+F) to find usage examples
4. **Console Output** - Check console for error messages
5. **Stack Overflow** - Search JavaFX questions

---

**Now you're ready to modify and extend the portfolio! Happy coding! 🚀**
