public class Sphere extends ThreeDimensionalShape {
    private float radius;

    public Sphere(float radius) {
        super("volume", 3, radius);
        this.radius = radius;
    }

    @Override
    public String getDescriptive() {
        return "Sphere";
    }

    @Override
    public double getDimensions() {
    return ((1.3333) * Math.PI * (Math.pow(radius, 3)));
    }
}
