package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;;

public class stephenCode extends PApplet {

    Minim minim;
    AudioPlayer player;

    public void settings() {
        size(512, 200, P3D);
    }

    public void setup() {

        minim = new Minim(this);

        player = minim.loadFile("heroplanet.mp3");
    }

    public void draw() {
        background(0);
        stroke(255);

        /*
         * Drawing the waveforms
         * the values returned by left.get() and right.get() will be between -1 and 1
         * so we need them scaled up to see the wave form
         * note that if the file is mono, left.get() and right.get() will return the
         * same value
         */
        for (int i = 0; i < player.bufferSize() - 1; i++) {
            float x1 = map(i, 0, player.bufferSize(), 0, width);
            float x2 = map(i + 1, 0, player.bufferSize(), 0, width);
            line(x1, 50 + player.left.get(i) * 50, x2, 50 + player.left.get(i + 1) * 50);
            line(x1, 150 + player.right.get(i) * 50, x2, 150 + player.right.get(i + 1) * 50);
        }

        float posx = map(player.position(), 0, player.length(), 0, width);
        stroke(0, 200, 0);
        line(posx, 0, posx, height);

        if (player.isPlaying()) {
            text("press any key to pause playback", 10, 20);
        } else {
            text("Press any key to start playback", 10, 20);

        }

    }

    public void keyPressed() {

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

}
