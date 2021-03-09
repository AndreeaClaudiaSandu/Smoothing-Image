public class SubClass extends Smoothing{
    private int boxNumber;

    public SubClass(int hRadius, int vRadius, int iterations, int boxNumber) {
        super(hRadius, vRadius, iterations);
        this.boxNumber = boxNumber;
    }

    public SubClass() {
    }

    public int getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(int boxNumber) {
        this.boxNumber = boxNumber;
    }
}
