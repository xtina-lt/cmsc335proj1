public abstract class ThreeDimensionalShape extends Shape {
    private float volume;

    public ThreeDimensionalShape(String measure, int dimensions, float volume) {
        super("volume", 3);
        this.volume = volume;
    }

    public double getMeasurement() {
        return volume;
    }
}