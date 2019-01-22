package de.christianost.aida.sketch.processing;

class Point {
    private int x = 0;
    private int y = 0;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX () {
        return this.x;
    }

    public int getY () {
        return this.y;
    }

    public String toString() {
        return "X: " + this.getX() + "; Y: " + this.getY();
    }

    public boolean equals(Point p) {
        return x != p.getX() && y != p.getY();
    }
}
