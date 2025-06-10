public class Testicle {
    // can be healthy or not healthy
    // boolean healthy;

    private int colorCode;
    private boolean isLumpy;

    public Testicle(int colour, boolean lump) {
        this.colorCode = colour;
        this.isLumpy = lump;
    }

    public int getColor() {
        return this.colorCode;
    }

    public void setColor(int color) {
        this.colorCode = color;
    }

    public boolean isHealthy() {
        return !this.isLumpy && this.colorCode == 1;
    }

    // NOT PART OF THIS CLASS -- IGNORE
    public static void main() {
        Testicle davidTesticle = new Testicle(1, false);

        davidTesticle.setColor(2);
        // davidTesticle.colorCode = 3;

        davidTesticle.getColor();
        // int meow = davidTesticle.colorCode

    }

}
