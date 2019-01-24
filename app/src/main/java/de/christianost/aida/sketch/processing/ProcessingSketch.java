package de.christianost.aida.sketch.processing;

import de.christianost.aida.hardware.AccelerometerListener;
import de.christianost.aida.sketch.Sketch;
import processing.core.PApplet;

public class ProcessingSketch extends PApplet implements Sketch {
    private int width;
    private int height;
    private AccelerometerListener accelerometerListener;
    private Point lastPoint;

    public ProcessingSketch(int width, int height, AccelerometerListener accelerometerListener) {
        this.width = width;
        this.height = height;
        this.accelerometerListener = accelerometerListener;
    }

    public void settings() {
        size(this.width, this.height);
    }

    public void draw() {
        if (mousePressed) {
            ellipse(mouseX, mouseY, 50, 50);
        }

        Float[] accelerometerValues = accelerometerListener.getLatestValues();

        Point p = new Point(
                Calculations.mapXAccelerationToCoordinate(width, accelerometerValues[0] * 1.2f),
                Calculations.mapYAccelerationToCoordinate(height, accelerometerValues[1] * 1.2f)
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
}
