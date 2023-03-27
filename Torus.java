public class Torus extends ThreeDimensionalShape {
    private float minorRadius;
    private float majorRadius;

    public Torus(float minorRadius, float majorRadius) {
        super("volume", 3, minorRadius);
        this.minorRadius = minorRadius;
        this.majorRadius = majorRadius;
    }

    @Override
    public String getDescriptive() {
        return "Torus";
    }

    @Override
    public double getDimensions() {
        if (minorRadius <= majorRadius) {
            return (Math.PI * (Math.pow(minorRadius, 2)) * (2 * Math.PI * majorRadius));
        } else if (minorRadius >= majorRadius)
            System.out.println("Minor Radius can not be larger than Major Radius!");
            return 0;
    }
}
