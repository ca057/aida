package de.christianost.aida.sketch.processing;

import de.christianost.aida.sketch.Sketch;
import processing.core.PApplet;

public class ProcessingSketch extends PApplet implements Sketch {
    private int width;
    private int height;

    private float ax;
    private float ay;
    private float az;
    private Point lastPoint;


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

        Point p = new Point(
                Calculations.mapXAccelerationToCoordinate(width, ax * 1.2f),
                Calculations.mapYAccelerationToCoordinate(height, ay * 1.2f)
        );

        if (lastPoint != null && lastPoint.equals(p)) {
            stroke(204, 102, 51);
            stroke(lerpColor(10, 10, .33f));
            line(lastPoint.getX(), lastPoint.getY(), p.getX(), p.getY());
        }
        lastPoint = p;

        ellipse(p.getX(), p.getY(), 10, 10);

    }

    @Override
    public void toImage() {
        // should return an image
    }

    public void setAcceleration(float ax, float ay, float az) {
        this.ax = ax;
        this.ay = ay;
        this.az = az;
    }
}
