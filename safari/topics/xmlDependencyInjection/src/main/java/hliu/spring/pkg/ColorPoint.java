package hliu.spring.pkg;

public class ColorPoint extends Point {

    private Color color;

    public ColorPoint(Color color, Point point) {
        super(point);
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s Point @(%f, %f) ",color.name(),this.getX(), this.getY());
    }
}
