# Quick Start Guide - Joselin's Portfolio Application

## 🚀 5-Minute Quick Start

### For IntelliJ IDEA Users (Easiest)

1. **Open the Project**
   - Launch IntelliJ IDEA
   - Click "Open" and select the `portfolio` folder
   - Wait for indexing to complete

2. **Configure JavaFX** (One-time setup)
   - Press `Ctrl+Alt+Shift+S` (Windows/Linux) or `Cmd+;` (macOS)
   - Click "Libraries" on the left
   - Click `+` button → "Java"
   - Navigate to your JavaFX SDK folder and select it
   - Click "OK" → "Apply" → "OK"

3. **Add Run Configuration**
   - Click "Run" in top menu → "Edit Configurations"
   - Click `+` → "Application"
   - Name: `Portfolio`
   - Main class: `com.portfolio.Main`
   - VM options: `--module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml`
   - Click "OK"

4. **Run It!**
   - Select "Portfolio" from the run dropdown
   - Click the green play button (or press Shift+F10)
   - Your portfolio application opens! 🎉

## ❓ Troubleshooting

**Issue**: "Cannot find module javafx.controls"
- **Fix**: Ensure your IDE run configuration includes the JavaFX SDK library and the correct VM arguments for your environment.

**Issue**: CSS styles not loading (gray buttons)
- **Fix**: Ensure `styles.css` is in `src/main/java/com/portfolio/styles/` and is loaded by your application.

- **Fix**: Run from the project root directory, or rebuild the project

**Issue**: "Main class not found"
- **Fix**: Ensure all source files are compiled. Check `bin` folder has `com/portfolio/Main.class`

## 🎨 Customization

Want to change content quickly?

### Edit Hero Section
File: `src/main/java/com/portfolio/controllers/HeroController.java`
Change line with your name:
```java
addTypingEffect(nameLabel, "Your Name Here", 50);
```

### Change Colors
File: `src/main/java/com/portfolio/utils/Constants.java`
```java
public static final String ACCENT_PURPLE = "#8b5cf6";  // Purple color
public static final String ACCENT_BLUE = "#3b82f6";    // Blue color
```

### Update Skills
File: `src/main/java/com/portfolio/controllers/SkillsController.java`
```java
String[] passions = {
    "Your Skill 1",
    "Your Skill 2",
    // Add more skills here
};
```

## 📁 Project Structure at a Glance

```
portfolio/
├── src/main/java/com/portfolio/
│   ├── Main.java .......................... Application launcher
│   ├── controllers/ ....................... UI logic for sections
│   │   └── MainController.java ........... Sidebar & navigation
│   ├── utils/ ............................ Helper classes
│   │   ├── Constants.java ............... Colors & sizes
│   │   ├── AnimationUtil.java .......... Animation effects
│   │   └── UIComponentFactory.java .... Reusable components
│   └── styles/
│       └── styles.css ................... All styling
├── README.md ............................. Full documentation
├── SETUP_GUIDE.md ....................... Detailed setup
└── IDE run instructions .................. No CLI scripts
```

## 🎯 What to Explore

1. **Animation Effects** - See smooth transitions between sections
2. **Hover Interactions** - Move mouse over buttons for glow effects
3. **Responsive Design** - Resize window to see layout adaptation
4. **Sidebar Navigation** - Click different sections in sidebar
5. **Form Interaction** - Try filling the contact form
6. **Color Scheme** - Notice the purple/blue/cyan color palette

## 💡 Tips

✅ **Did you know?**
- Hover over any button for a glowing effect
- Click sidebar items to jump to sections
- All colors are in `Constants.java` - easy to customize
- Each section is a separate controller - easy to understand
- All animations are in `AnimationUtil.java` - easy to modify

## 📚 Learning Path

1. Start with `Main.java` - understand the entry point
2. Look at `MainController.java` - see how sections are managed
3. Check `HeroController.java` - understand how sections work
4. Review `styles.css` - see how styling is applied
5. Explore `UIComponentFactory.java` - learn reusable components
6. Try modifying colors and content - make it your own!

## 🔧 Common Modifications

### Change Application Window Size
Edit `Constants.java`:
```java
public static final int WINDOW_WIDTH = 1400;   // Change width
public static final int WINDOW_HEIGHT = 900;   // Change height
```

### Modify Animation Speed
Edit `Constants.java`:
```java
public static final int ANIMATION_FAST = 300;      // milliseconds
public static final int ANIMATION_NORMAL = 500;
public static final int ANIMATION_SLOW = 1000;
```

Or use in controllers:
```java
AnimationUtil.fadeIn(node, Constants.ANIMATION_FAST);  // Fast
AnimationUtil.fadeIn(node, Constants.ANIMATION_SLOW);  // Slow
```

### Add New Section

1. Create new controller: `NewSectionController.java`
   - Extend `SectionController`
   - Implement `initialize()` method

2. Add to `MainController.java`:
   - Add field: `private NewSectionController newController;`
   - Initialize in `initializeSectionControllers()`
   - Add case in `switchSection()`

## ✨ Features Overview

- **Dark Theme** ✓ Black background with purple accents
- **Glassmorphism** ✓ Frosted glass effect panels
- **Smooth Animations** ✓ Fade, slide, scale transitions
- **Glow Effects** ✓ Purple/blue neon highlights
- **Sidebar Navigation** ✓ Easy section switching
- **Responsive Layout** ✓ Adapts to window size
- **Professional Design** ✓ Recruiter-friendly appearance
- **Clean Code** ✓ Well-commented and organized
- **Beginner-Friendly** ✓ Easy to understand and modify

## 🎓 Educational Value

This project teaches:
- JavaFX fundamentals
- UI design patterns
- Animation techniques
- CSS styling in Java
- Component architecture
- Professional code structure
- Best practices for GUI applications

## 🚀 Next Steps

1. ✅ Get it running
2. 🎨 Customize colors and content
3. 🔧 Modify existing sections
4. ➕ Add new sections
5. 📦 Deploy as a standalone application

## 📞 Need Help?

- Check `SETUP_GUIDE.md` for detailed setup instructions
- Read `README.md` for complete documentation
- Review code comments in source files
- Check console output for error messages

---

**Ready to showcase your portfolio? Let's go! 🚀**

Built with ❤️ using Java and JavaFX
