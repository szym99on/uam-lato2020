import java.util.Objects;

public class Point implements Cloneable{

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point startP) {
        x = startP.x;
        y = startP.y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }



    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public void setX(int i) {
        x = i;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public void setY(int i) {
        y=i;
    }
}
