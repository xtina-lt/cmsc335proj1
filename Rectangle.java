public class Rectangle extends TwoDimensionalShape {
    private float width;
    private float length;

    public Rectangle(float length, float width) {
        super("area", 2, length);
        this.length = length;
        this.width = width;
    }

    @Override
    public String getDescriptive() {
        return " Rectangle ";
    }

    @Override
    public double getDimensions() {
        return length * width;
    }
}