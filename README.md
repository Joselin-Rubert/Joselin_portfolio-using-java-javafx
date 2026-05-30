# Joselin's Premium JavaFX Portfolio Application

A ultra-modern, premium, and visually stunning desktop portfolio application built with Java and JavaFX. This application features a dark futuristic theme with glassmorphism design, smooth animations, and professional UI/UX.

## 🎨 Features

### Design & UI
- **Dark Futuristic Theme**: Black, purple, and blue gradient aesthetics
- **Glassmorphism Design**: Modern frosted glass effect panels
- **Neon Glow Effects**: Interactive glowing buttons and hover animations
- **Smooth Animations**: Fade, slide, and scale transitions
- **Premium Typography**: Modern font styling and hierarchy
- **Responsive Layout**: Adapts to different screen sizes
- **Sidebar Navigation**: Easy section switching with visual feedback

### Sections Included
1. **Hero Dashboard** - Landing section with typing effect and CTA buttons
2. **About Me** - Personal background and professional interests
3. **Education** - Academic timeline with animated cards
4. **Skills & Expertise** - Programming languages and tools showcase
5. **Internship Experience** - Work experience with glassmorphic cards
6. **Projects** - Portfolio projects with tech stacks
7. **Certifications** - Professional certifications display
8. **Achievements & Presentations** - Academic achievements
9. **Contact** - Contact information and message form
10. **Footer** - Copyright and social links

### Technical Features
- Beginner-friendly clean code with comments
- Reusable UI component factory
- Centralized animation utilities
- Professional Java coding practices
- Modular controller architecture
- CSS-based styling system

## 🛠️ Technology Stack

- **Language**: Java 11+
- **UI Framework**: JavaFX 17+
- **Styling**: JavaFX CSS
- **Architecture**: MVC (Model-View-Controller)
- **Design Pattern**: Factory Pattern for UI Components

## 📁 Project Structure

```
portfolio/
├── src/
│   └── main/
│       └── java/
│           └── com/portfolio/
│               ├── Main.java                           # Application Launcher
│               ├── controllers/
│               │   ├── SectionController.java          # Base controller
│               │   ├── MainController.java             # Main layout controller
│               │   ├── HeroController.java             # Hero section
│               │   ├── AboutController.java            # About section
│               │   ├── EducationController.java        # Education section
│               │   ├── SkillsController.java           # Skills section
│               │   ├── ExperienceController.java       # Experience section
│               │   ├── ProjectsController.java         # Projects section
│               │   ├── CertificationsController.java   # Certifications section
│               │   ├── AchievementsController.java     # Achievements section
│               │   ├── ContactController.java          # Contact section
│               │   └── FooterController.java           # Footer section
│               ├── utils/
│               │   ├── Constants.java                  # Configuration constants
│               │   ├── AnimationUtil.java              # Animation utilities
│               │   └── UIComponentFactory.java         # Reusable UI components
│               └── styles/
│                   └── styles.css                      # JavaFX CSS styling
├── README.md                                           # Documentation
└── SETUP_GUIDE.md                                      # Setup instructions
```

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 11 or higher
- JavaFX SDK 17 or higher
- IDE: IntelliJ IDEA, Eclipse, or VS Code (with Java extensions)

### Installation & Setup

#### Option 1: Using IntelliJ IDEA (Recommended)

1. **Open IntelliJ IDEA**
   - Click "Open" and navigate to the `portfolio` folder

2. **Configure JavaFX**
   - Go to `File → Project Structure → Libraries`
   - Click `+` → Java
   - Navigate to your JavaFX SDK folder and select it
   - Click "OK" and "Apply"

3. **Set VM Options**
   - Go to `Run → Edit Configurations`
   - Select "Application" and click the `+` button
   - Name it "Portfolio"
   - Set Main class to: `com.portfolio.Main`
   - Add to VM options: `--module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml`
   - Click "OK"

4. **Run the Application**
   - Click the green "Run" button or press Shift+F10

#### Option 2: Using Eclipse

1. **Open Eclipse**
   - Import the project: `File → Import → General → Existing Projects into Workspace`
   - Select the `portfolio` folder

2. **Configure JavaFX**
   - Right-click project → `Build Path → Configure Build Path`
   - Go to "Libraries" tab
   - Click "Add Library" → "JavaFX SDK"
   - Select your JavaFX SDK path

3. **Create Run Configuration**
   - Go to `Run → Run Configurations`
   - Create new "Java Application"
   - Main class: `com.portfolio.Main`
   - Arguments → VM arguments: `--module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml`

4. **Run**
   - Click "Run"

#### Option 3: Using Your IDE

1. Configure your IDE to use JavaFX by adding the JavaFX SDK library or module path.
2. Set the main class to `com.portfolio.Main`.
3. Use your IDE run configuration to launch the application.

### Finding Your JavaFX SDK Path

**Windows**:
```
C:\Users\YourUsername\Downloads\javafx-sdk-17
```

**macOS**:
```
~/Downloads/javafx-sdk-17
```

**Linux**:
```
/home/username/Downloads/javafx-sdk-17
```

## 💻 Usage

Once the application is running:

1. **Navigate Using Sidebar**
   - Click any section name on the left sidebar to jump to that section
   - The sidebar highlights the current section

2. **Interact with Components**
   - Hover over buttons for glow effects
   - Click buttons to interact (download resume, contact, etc.)
   - Scroll to view all content

3. **Explore Features**
   - Watch typing animations in Hero section
   - See smooth transitions between sections
   - Experience glassmorphism design effects

## 📝 Customization Guide

### Change Personal Information

Edit the following controllers to update content:

**Hero Section** (`HeroController.java`):
```java
addTypingEffect(nameLabel, "Your Name", 50);
```

**Skills Section** (`SkillsController.java`):
```java
String[] skills = {"Your Skill 1", "Your Skill 2"};
```

**Projects Section** (`ProjectsController.java`):
```java
grid.getChildren().add(createProjectCard(
    "Your Project Title",
    "Your project description",
    new String[]{"Tech1", "Tech2"}
));
```

### Customize Colors

Edit `Constants.java` to change the color scheme:

```java
public static final String PRIMARY_DARK = "#0a0e27";
public static final String ACCENT_PURPLE = "#8b5cf6";
public static final String ACCENT_BLUE = "#3b82f6";
```

### Modify Animations

Edit `AnimationUtil.java` to adjust animation speeds and effects:

```java
public static void fadeIn(Node node, int duration) {
    // Change 'duration' to make animations faster/slower
}
```

### Update Styling

Edit `styles.css` to customize:
- Button styles
- Color schemes
- Border radius
- Effects and shadows
- Typography

## 🎯 Learning Resources

### Understanding the Code Structure

1. **Main.java** - Application entry point, scene setup
2. **MainController.java** - Manages sidebar navigation and section switching
3. **SectionController.java** - Base class for all section controllers
4. **Individual Controllers** - Handle specific sections (Hero, About, etc.)
5. **UIComponentFactory.java** - Creates reusable UI components
6. **AnimationUtil.java** - Provides animation methods
7. **Constants.java** - Stores configuration values

### Key Concepts

- **Factory Pattern**: `UIComponentFactory` creates consistent components
- **Controller Pattern**: Each section has its own controller
- **Animation Thread**: Uses JavaFX Platform.runLater for smooth animations
- **CSS Styling**: All styling is centralized in `styles.css`
- **Separation of Concerns**: Logic separated from UI

## 🐛 Troubleshooting

### Issue: CSS styles not applied
**Solution**: Ensure `styles.css` is in `src/main/java/com/portfolio/styles/` directory

### Issue: JavaFX modules not found
**Solution**: Add `--module-path` to VM options with correct JavaFX SDK path

### Issue: Typing animation too fast/slow
**Solution**: Edit the delay parameter in `addTypingEffect()` method (in milliseconds)

### Issue: Application window too small
**Solution**: Increase `Constants.WINDOW_WIDTH` and `Constants.WINDOW_HEIGHT`

## 📦 Building for Distribution

To create a distributable JAR file:

1. **In IntelliJ IDEA**:
   - `File → Project Structure → Artifacts`
   - Click `+` → JAR → From modules with dependencies
   - Set Main class to `com.portfolio.Main`
   - Build → Build Artifacts → Build JAR

## 🔐 Best Practices

✅ **Do**:
- Keep UI logic in controllers
- Use Constants for configuration
- Use AnimationUtil for consistent animations
- Add comments for important code sections
- Test on different screen sizes

❌ **Don't**:
- Hardcode values directly in code
- Mix styling in Java code
- Create complex nested layouts
- Use Thread directly (use Platform.runLater)

## 📄 License

This portfolio application is free to use and modify for personal and professional purposes.

## 🤝 Support

For questions or issues:
1. Check the troubleshooting section
2. Review code comments
3. Consult JavaFX official documentation
4. Check the setup guide

## 🎓 Educational Value

This project is designed to be:
- **Beginner-friendly**: Clean, commented code
- **Educational**: Demonstrates Java/JavaFX best practices
- **Professional**: Production-ready design patterns
- **Extensible**: Easy to add new sections or features

## 🌟 Features to Enhance

Potential improvements:
- [ ] Add dark/light theme toggle
- [ ] Implement actual email sending
- [ ] Add PDF resume download
- [ ] Create portfolio database
- [ ] Add blog section
- [ ] Implement search functionality
- [ ] Add multiple language support
- [ ] Create mobile responsive version (with scaling)

## 👨‍💻 About

**Developed by**: Joselin Sornapraisy R
**Title**: Pre-Final Year CSE Student | Aspiring Full Stack Developer | Java Developer
**Focus**: Java Development, Web Technologies, Full Stack Development

---

**Version**: 1.0
**Last Updated**: May 27, 2026
**Built With**: ❤️ by Joselin using Java and JavaFX
