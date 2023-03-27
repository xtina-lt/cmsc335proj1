public abstract class Shape {
    protected final int dimensions;
    protected final String measurement;

    public Shape(String measurement, int dimensions) {
        this.dimensions = dimensions;
        this.measurement = measurement;
    }

    public double getDimensions() {
        return dimensions;
    }

    @Override
    public String toString() {
        return String.format("The %s of the %d-dimension shape %s is %.2f", measurement, dimensions,getDescriptive(), getDimensions());
    }

    public abstract String getDescriptive();
}
