package de.christianost.aida.sketch.processing;

import de.christianost.aida.sketch.Sketch;
import processing.core.PApplet;

public class ProcessingSketch extends PApplet implements Sketch {
    private int width;
    private int height;

    public ProcessingSketch(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void settings() {
        size(this.width, this.height);
    }

    public void draw() {
        if (mousePressed) {
            ellipse(mouseX, mouseY, 50, 50);
        }
    }

    @Override
    public void toImage() {
        // should return an image
    }

}
