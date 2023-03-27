public class Triangle extends TwoDimensionalShape {
    private float base;
    private float height;

    public Triangle(float base, float height) {
        super("area", 2, base);
        this.base = base;
        this.height = height;
    }

    @Override
    public String getDescriptive() {
        return "Triangle";
    }

    @Override
    public double getDimensions() {
        return (base * height / 2);
    }
}
