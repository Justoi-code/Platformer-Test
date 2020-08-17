 import processing.core.PApplet;
 import processing.core.PFont;

public class PlatformerTest extends PApplet {
    
    public static void main(String[] args) {
        /*String[] pArgs = {"PlatformerTest"};
        PlatformerTest mp = new PlatformerTest ();
        PApplet.runSketch(pArgs, mp);*/
        // OLD DRIVER CODE ABOVE
        
        PlatformerTest mp = new PlatformerTest ();
        PApplet.main(new String[] { "PlatformerTest", "PlatformerTest"});
    }
    
    public Ball player;
    public platform platform1;
    public platform platform2;
    public spike spike1;
    public spike spike2;
    public spike spike3;
    
    boolean startTimer = false;
    boolean jStartTimer = false;
    
    int timer;
    int jTimer;
    int startTime;
    int jStartTime;
    int score;
    //int scoreReset;
    
    public void settings() {
        
        size(800, 600);
        
    }

    public void setup() {
        
        size(800,600);
        
        player = new Ball(width/2, height - 10);
        platform1 = new platform(0, height *2/3);
        platform2 = new platform(width - 250, height *2/3);
        
        spike1 = new spike(0, height *2/3 - 10);
        spike2 = new spike(0, height);
        spike3 = new spike(width - 250, height *2/3 - 10);
        
        //int startTime = millis();
        //int jStartTime = millis();
    }   

    public void draw() {
        
        background(212, 255, 242);
        player.drawBall();
        player.update();
        
        platform1.drawPlatform();
        platform2.drawPlatform();
        
        spike1.drawSpike();
        spike2.drawSpike();
        spike3.drawSpike();
        
        spike1.checkBounds(0, 250);
        spike2.checkBounds(0, width);
        spike3.checkBounds(width - 250, width);
        
        spike1.update();
        spike2.update();
        spike3.update();
        
        Time();
        jumpTime();
        //scoring();    NOT WELL IMPLEMENTED
        
        if(player.isDead == true) {
            //textSize(50);
            PFont font = createFont("SourceSansPro-Bold", 50);
            textFont(font);
            text("GAME OVER", 275, height *1/3, 500, 500);
            score = 0;
        }
    }
    
    public void scoring() {
        if(player.isDead == false) {
            score = second();
            //textSize(25);
            PFont font = createFont("SourceSansPro-Bold", 25);
            textFont(font);
            text("Score: " + score, width - 150, 25, 200, 200);
            if(second() == 60) {
                score += 60;
            }
        }
    }
    
    public void keyPressed() {
        if(key == 'a' || key == 'A') {
            player.moveLeft = true;
            startTimer = true;
        }
        if(key == 'd' || key == 'D') {
            player.moveRight = true;
            startTimer = true;
        }
        if(key == 'w' || key == 'W') {
            player.landPlatform = false;
            jStartTimer = true;
            player.jump = true;
        }       
    }
    
    public void keyReleased() {
        if(key == 'a' || key == 'A') {
            player.moveLeft = false;
            startTimer = false;
        }
        if(key == 'd' || key == 'D') {
            player.moveRight = false;
            startTimer = false;
        }
    }
    
    public int Time() {

        if (startTimer == false) {
            startTime = millis();
            timer = millis() - startTime;
            }
        if(startTimer == true) {
            timer = millis() - startTime;
            //System.out.println(timer);
        }
        return timer;
    }
    
    public int jumpTime() {

        if (jStartTimer == false) {
            jStartTime = millis();
            jTimer = millis() - jStartTime;
            }
        if(jStartTimer == true) {
            jTimer = millis() - jStartTime;
            //System.out.println(jTimer);
        }
        return jTimer;
    }
    
    public class Ball {
            
        float xPos;
        float yPos;
        
        boolean moveLeft;
        boolean moveRight;
        //boolean slowLeft;
        //boolean slowRight;
        boolean jump;
        boolean landPlatform;
        boolean falling;
        boolean isDead;
        
        public Ball(int startX, int startY) {
            xPos = startX;
            yPos = startY;
        }
        
        public void drawBall() {
            if(isDead == false) {
                strokeWeight(1);
                fill (0, 0, 0);
                ellipse(xPos, yPos, 25, 25);    
            }
        }
        
        public void checkBounds() {
            if(xPos < 25) {
                xPos = 25;
                moveLeft = false;
            }
            if(xPos > width - 25) {
                xPos = width - 25;
                moveRight = false;
            }
            if (this.yPos > height -12) {
                this.jump = false;
                this.yPos = height -12;
                jStartTimer = false;
                this.falling = false;
            }
        }
        
        public void update() {
            if(this.moveLeft == true) {
                this.xPos -= 16;
                if(timer > 250) {
                    this.xPos -= 2;
                    if(timer > 250) {
                        this.xPos -= 2;
                    }
                }
            }
            if(this.moveRight == true) {
                this.xPos += 16;
                if(timer > 250) {
                    this.xPos += 2;
                    if(timer > 250) {
                        this.xPos += 2;
                    }
                }
            }
            if(this.jump == true) {
                player.yPos -= 30;
                jumping(100, 20);
                jumping(200, 10);
                this.falling = true;
            }
            
            if(this.falling == true) {
                if(landPlatform == false) {
                    jumping(300, 10);
                    jumping(400, 20);
                } else if(landPlatform == true) {
                    //jumping(300, 10);
                    this.yPos = height *2/3 - 20;
                    this.jump = false;
                }
                
                
            }
            checkBounds();
            checkCollisions();
        }
        public void jumping(int airTime, int posChange) {
            if(jTimer > airTime) {
                this.yPos += posChange;
            }
        }
        public void checkCollisions() {
            if(this.xPos > width - 250 || this.xPos < 250) {
                if(this.yPos + 25 > height *2/3 - 20 && this.yPos + 25 < height *2/3 + 20) {
                    //this.falling = false;
                    jStartTimer = false;
                    this.landPlatform = true;
                    //this.yPos = height *2/3 - 15;
                }
            }
            if(this.xPos > 250 && this.xPos < width - 250) {
                this.falling = true;
                this.landPlatform = false;
            }
            spikeCollision(spike1);
            spikeCollision(spike2);
            spikeCollision(spike3);
        }
        public void spikeCollision(spike spikeNumber) {
            if(this.xPos + 25 > spikeNumber.xPos && this.xPos < spikeNumber.xPos + 78) {
                if(this.yPos < spikeNumber.yPos + 26 && this.yPos +25 > spikeNumber.yPos) {
                    isDead = true;
                    //System.out.println("Ouch!");
                }
            }
        }
    }
    
    public class platform {
        
        float xPos;
        float yPos;
        
        
        public platform(int startX, int startY) {
            xPos = startX;
            yPos = startY;
        }
        
        public void drawPlatform() {
            strokeWeight(20);
            fill(0, 0, 0);
            line(xPos, yPos, xPos + 250, yPos);
        }
    }
    
    public class spike {
        
        int speed = 3;
        
        float xPos;
        float yPos;
        
        public spike(float startX, float startY) {
            xPos = startX;
            yPos = startY;
        }
        
        public void drawSpike() {
            strokeWeight(2);
            fill(0,0,0);
            triangle(xPos, yPos, xPos + 26, yPos, xPos + 13, yPos - 26);
            triangle(xPos + 26, yPos, xPos + 52, yPos, xPos + 39, yPos - 26);
            triangle(xPos + 52, yPos, xPos + 78, yPos, xPos + 65, yPos - 26);
            //triangle total width = 78; triangle total height = 26
        }
        public void update() {
            this.xPos += this.speed;
            
        }
        public void checkBounds(int leftWall, int rightWall) {
            if(this.xPos < leftWall) {
                this.speed *= -1;
            }
            if(this.xPos > rightWall - 78) {
                this.speed *= -1;
            }
        }
    }
}