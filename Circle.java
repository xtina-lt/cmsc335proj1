public class Circle extends TwoDimensionalShape {
    private float radius;

    public Circle(float radius) {
        super("Area", 2, radius);
        this.radius = radius;
    }

    @Override
    public String getDescriptive() {
        return "Circle";
    }

    @Override
    public double getDimensions() {
        return (Math.PI * (Math.pow(radius, 2)));
    }
}
