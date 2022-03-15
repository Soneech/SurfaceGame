package ru.pavlenty.surfacegame2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class Friend {
    private Bitmap bitmap;
    private int x;
    private int y;
    private int speed = 0;
    private int maxY;
    private int minY;
    private int maxX;

    private final int MIN_SPEED = 3;
    private final int MAX_SPEED = 20;

    public Friend(Context context, int screenX, int screenY) {
        speed = randomSpeed();
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.friend);
        maxY = screenY - bitmap.getHeight();
        minY = 0;
        maxX = screenX;

        x = screenX;
        y = randomHeight();
    }

    public void update() {
        if (speed > MAX_SPEED) {
            speed = MAX_SPEED;
        }

        if (speed < MIN_SPEED) {
            speed = MIN_SPEED;
        }

        x -= speed;

        if (y < minY) {
            y = minY;
        }
        if (y > maxY) {
            y = maxY;
        }
        if (x < -bitmap.getWidth()) {
            x = maxX;
            y = randomHeight();
            speed = randomSpeed();
        }
    }

    public int randomHeight() {
        return (int)(Math.random() * maxY);
    }

    public int randomSpeed() {
        return (int)(Math.random() * MAX_SPEED);
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }
}
