public class Cube extends ThreeDimensionalShape {
    private float height;

    public Cube(float height) {
        super("Volume", 3, height);
        this.height = height;
    }

    @Override
    public String getDescriptive() {
        return "Cube";
    }

    @Override
    public double getDimensions() {
        return Math.pow(height, 3);
    }
}