public class Cylinder extends ThreeDimensionalShape {
    private float radius;
    private float height;

    public Cylinder(float radius, float height) {
        super("Volume", 3, radius);
        this.radius = radius;
        this.height = height;
    }

    @Override
    public String getDescriptive() {
        return "Cylinder";
    }

    @Override
    public double getDimensions() {
        return (Math.PI * Math.pow(radius, 2) * height);
    }
}