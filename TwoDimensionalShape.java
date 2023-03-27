public abstract class TwoDimensionalShape extends Shape {
    private float area;

    public TwoDimensionalShape(String measurement, int dimensions, float area) {
    super("area", 2);
        this.area = area;
    }
    public double getmeasurementment() {
        return area;
    }
}
