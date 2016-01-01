package com.github.odininon.puzzlesolver;

/**
 * Created by odin on 12/31/2015.
 */
public class Square {
    private int x;
    private int y;

    private boolean filled;

    public Square(int x, int y) {
        this(x, y, false);
    }

    public Square(int x, int y, boolean filled) {
        this.x = x;
        this.y = y;
        this.filled = filled;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return "(X: " + x + ", Y: " + y + ", Filled: " + filled + ")";
    }

    public void toggle() {
        this.filled = !this.filled;
    }

    public void draw() {
        String character = (filled) ? "X" : "-";

        System.out.print(character);
    }

    public boolean isFilled() {
        return filled;
    }
}
