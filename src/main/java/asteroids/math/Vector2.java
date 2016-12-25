package asteroids.math;

public class Vector2 {
    private int x, y;

    public Vector2(){
        this.x = 0;
        this.y = 0;
    }

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void translate(int dx, int dy){
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void bound(int minWidth, int maxWidth, int minHeight, int maxHeight) {
        if(x < minWidth)
            x = minWidth;
        else if(x > maxWidth)
            x = maxWidth;
        if(y < minHeight)
            y = minHeight;
        else if(y > maxHeight)
            y = maxHeight;
    }
}
