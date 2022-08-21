public class Coord {
    int row, col;
    public Coord(int i, int j) {
        this.row = i;
        this.col = j;
    }
    public String toString() {
        return "(" + this.row + ", " + this.col + ")";
    }
}