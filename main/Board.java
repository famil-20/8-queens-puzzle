public class Board {
    private int size;
    private boolean[][] occupied;
    private Coord[][] map;
    public Board(int size) {
        this.size = size;
        this.map = new Coord[this.size][this.size];
        for(int i = 0; i < this.size; i++) {
            for(int j = 0; j < this.size; j++) {
                map[i][j] = new Coord(i, j);
            }
        }
        this.reset();
    }
    public void reset() {
        this.occupied = new boolean[this.size][this.size];
        for(int i = 0; i < this.size; i++) {
            for(int j = 0; j < this.size; j++) {
                occupied[i][j] = false;
            }
        }
    }
    public Coord get(int row, int col) {
        return this.map[row][col];
    }
    public int getSize() {
        return this.size;
    }
    public String toString() {
        var line = new Object() {
            public String draw() {
                String str = "";
                for(int c = 0; c < size; c++) {
                    str += "+---";
                }
                str += "+\n";
                return str;
            }
        };
        String str = line.draw();
        for(int i = 0; i < this.size; i++) {
            for(int j = 0; j < this.size; j++) {
                str += "|" + ((occupied[i][j])? " X " : "   ");
            }
            str += "|\n" + line.draw();
        }
        return str;
    }
    public void occupy(int row, int col) {
        this.occupied[row][col] = true;
    }
    public void unoccupy(int row, int col) {
        this.occupied[row][col] = false;
    }
    public boolean isOccupied(int row, int col) {
        return this.occupied[row][col];
    }
    public int countOccupied() {
        int count = 0;
        for(int i = 0; i < this.size; i++)
            for(int j = 0; j < this.size; j++)
                if(this.isOccupied(i, j)) count++;
        return count;
    }
}
