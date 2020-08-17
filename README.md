# Platformer-Test
My first ever graphics program I wrote in Java in a summer camp when I was in middle school. **See the PNG attached for a preview.**
I initially created this program in the Eclipse IDE (https://www.eclipse.org/oxygen/) but the posted files are a translated version run on BlueJ

**SPECIAL NOTE: This project was made in the BlueJ IDE for Java so if you intend to try it yourself I recommend following the instructions for installation below. I will also include code.txt that contains all the code in text form if you just want to look at that. Lastly, please be mindful that there is a lot of garbage code I just commented out; they serve no importance to the game in its current state**

**SPECIAL NOTE 2: This is summer camp project we were only allowed to work on for half a week. I want to leave it in its current state as much as I can even with the bugs because I feel this project was my launchpad towards pursuing Computer Science even with its imperfections. Bugs to take note of: Snapping to platforms if you jump directly under one and "floating" if you try to walk off a platform.**

INSTRUCTIONS FOR INSTALLATION:
--------------------------------------------------------------------------------------------------------------------------------------------
1. Install BlueJ for your machine from this link: https://bluej.org/
2. Download the files from master and store the files (README and code.txt not necessary) into a folder.
4. Open BlueJ and open project (Ctrl + O) and open the folder you created with files in Step 2.
5. This program uses libraries native to Eclipse so I included a .jar in the master called "processing-core-1.0.3__0.1.0.jar". At the top of BlueJ, navigated to Tools>Preferences>Libraries, click "Add File", then open the processing .jar file (should be in the folder you created in Step 2).
6. Restart BlueJ
7. Right click the module that appears that says "Game" and run "void main(String[] args)".
8. Enjoy!
--------------------------------------------------------------------------------------------------------------------------------------------

RULES/CONTROLS
--------------------------------------------------------------------------------------------------------------------------------------------
General Idea: This was mainly just a test (as said in the name "PlatformerTest") and my unassisted attempt at incorporating elementary physics concepts (like simulating gravity or vertical acceleration using numerical variables for the jumping mechanic).

WASD Control -  The "W", "A", and "D" keys control the movement of the ball or "player" displayed on the screen (see the social preview for a quick peek at what the applet looks like). For example, pressing the left arrow key 

Objective - Just for fun, I added spikes for the player to avoid and jump around (you "lose" if you touch them and have to restart the program). But again, the main purpose of the program is to test the movement I coded from scratch.
--------------------------------------------------------------------------------------------------------------------------------------------

My most prominent takeaways from this projects are the following:
- Implementing real life physical concepts into my program
- Using PApplet to create graphics
- Being able to translate programs between different IDEs that have different libraries
