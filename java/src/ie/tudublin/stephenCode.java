package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class stephenCode extends PApplet {

    Minim minim;
    AudioPlayer player;
    AudioPlayer scale;
    AudioPlayer another;

    public void settings() {
        size(512, 200, P3D);
    }

    public void setup() {

        minim = new Minim(this);

        player = minim.loadFile("scale.wav");
        scale = minim.loadFile("scale.wav");
        another = minim.loadFile("tomp3.cc");
        // player.loop();
    }

    public void draw() {
        /*
         * background(0);
         * stroke(255);
         * 
         * 
         * Drawing the waveforms
         * the values returned by left.get() and right.get() will be between -1 and 1
         * so we need them scaled up to see the wave form
         * note that if the file is mono, left.get() and right.get() will return the
         * same value
         * 
         * for (int i = 0; i < player.bufferSize() - 1; i++) {
         * float x1 = map(i, 0, player.bufferSize(), 0, width);
         * float x2 = map(i + 1, 0, player.bufferSize(), 0, width);
         * line(x1, 50 + player.left.get(i) * 50, x2, 50 + player.left.get(i + 1) * 50);
         * line(x1, 150 + player.right.get(i) * 50, x2, 150 + player.right.get(i + 1) *
         * 50);
         * }
         * 
         * float posx = map(player.position(), 0, player.length(), 0, width);
         * stroke(0, 200, 0);
         * line(posx, 0, posx, height);
         * 
         * if (player.isPlaying()) {
         * text("press any key to pause playback", 10, 20);
         * } else {
         * text("Press any key to start playback", 10, 20);
         * 
         * }
         * 
         */

        background(255);
        fill(255, 0, 0);
        rect(25, 25, 50, 50);// 25,25 -- coords 50,50 -- 50 pixels wide 50 pixels tall

        fill(0, 255, 00);
        rect(125, 25, 50, 50);
    }

    public void mousePressed() {
        if (mouseX > 25 && mouseX < 75 && mouseY > 25 && mouseY < 75) {
            scale.rewind();
            scale.play();
        }

        if (mouseX > 125 && mouseX < 175 && mouseY > 25 && mouseY < 75) {
            scale.pause();
        }

    }

   public void keyPressed() {


    if (key == 'e'){
        scale.pause();
    }
    if(key == 'q'){
        scale.play();
    }
       /*
       if (player.isPlaying()) {
            player.pause();
        }

        else if (player.position() == player.length()) {
            player.rewind();
            player.play();

        } else {
            player.play();
        }
    }
        */ 
    }
}
