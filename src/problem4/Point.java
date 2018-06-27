package problem4;

/**
 * @author huylv
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;

    }

    public double distance(Point p1, Point p2) {
        double kc;
        kc = Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
        return kc;
    }

    public double distance(Point point) {
        double kc;
        kc = Math.sqrt(Math.pow(this.x - point.getX(), 2) + Math.pow(this.y - point.getY(), 2));
        return kc;
    }

    public double distance(int x, int y) {
        double kc;
        kc = Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
        return kc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
