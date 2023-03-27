public class Square extends TwoDimensionalShape {
    private float length;

    public Square(float length) {
        super("area", 2, length);
        this.length = length;
    }

    @Override
    public String getDescriptive() {
        return "Square";
    }

    @Override
    public double getDimensions() {
        return (length * length);
    }
}
