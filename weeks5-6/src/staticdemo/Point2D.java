package staticdemo;

// records are special kinds of classes:
// final, with immutable fields and generated methods .equals(Object), hashCode() and toString()
public record Point2D(int x, int y) implements Comparable<Point2D> {

    // records can have additional methods
    public Point2D withX(int x) { return new Point2D(x, y()); }

    public double magnitude() { return Math.sqrt(x*x + y*y); }

    // records can implement interfaces
    @Override
    public int compareTo(Point2D o) {
        return Double.compare(magnitude(), o.magnitude());
    }
}
