import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
    private String name;
    private Coord position;
    List<Coord> currentPossibleMoves = new ArrayList<Coord>();
    Board world;

    /*Constructors*/
    Piece(String name, Board world, Coord positiion){
        this.name = name;
        this.world = world;
        if(positiion.row < world.getSize() && positiion.col < world.getSize()){
            this.position = positiion;
        }
        else{
            System.out.println("Please enter position that is on the board of size " + world.getSize() + "!");
            System.exit(0);
        }
        /*Listing all possible moves*/
        updateCurrentPossibleMoves();

        this.world.occupy(this.position.row, this.position.col);
    }

    Piece(String name, Board world, int row, int column){
        this.name = name;
        this.world = world;
        if(row < world.getSize() && column < world.getSize()){
            this.position = new Coord(row, column);
        }
        else{
            System.out.println("Please enter position that is on the board of size " + world.getSize() + "!");
            System.exit(0);
        }
        /*Listing all possible moves*/
        updateCurrentPossibleMoves();
        
        this.world.occupy(this.position.row, this.position.col);
    }

    /*Class methods*/
    public Coord getPosition() {
        return position;
    }

    public boolean canAttackMe(Piece Other){
        for (int i = 0; i < this.currentPossibleMoves.size(); i++) {
            for (int j = 0; j < Other.currentPossibleMoves.size(); j++) {
                if(this.position.row == Other.currentPossibleMoves.get(j).row && this.position.col == Other.currentPossibleMoves.get(j).col){
                    return true;
                }
            }
        }
        return false;
    }

    // public boolean canAttackMe(Piece piece){
    //     if (this.position.col == piece.position.col || this.position.row == piece.position.row ||
    //             Math.abs(this.position.row-piece.position.row) == Math.abs(this.position.col-piece.position.col))
    //         return true;
    //     return false;
    // }

    public void moveTo(Coord position){
        if(position.row < world.getSize() && position.col < world.getSize()){
            this.world.unoccupy(this.position.row, this.position.col);
            this.position = new Coord(position.row, position.col);
            this.world.occupy(this.position.row, this.position.col);
            updateCurrentPossibleMoves();
        }
        else{
            System.out.println("Please enter position that is on the board of size " + world.getSize() + "!");
        }
    }
    public void moveTo(int row, int column){
        if(row < world.getSize() && column < world.getSize()){
            this.world.unoccupy(this.position.row, this.position.col);
            this.position = new Coord(row, column);
            this.world.occupy(this.position.row, this.position.col);
            updateCurrentPossibleMoves();
        }
        else{
            System.out.println("Please enter position that is on the board of size " + world.getSize() + "!");
        }
    }
    
    public List<Coord> getCurrentPossibleMoves() {
        return currentPossibleMoves;
    }

    public String toString(){
        return "Name: " + this.name + "\n" + "Current position: " + this.position;
    }
    
    /*Updating currentPossibleMoves*/
    private void updateCurrentPossibleMoves(){
        currentPossibleMoves = new ArrayList<Coord>();
        for (int i = 0; i < this.world.getSize(); i++) {
            this.currentPossibleMoves.add(new Coord(this.position.row, i));
            this.currentPossibleMoves.add(new Coord(i, this.position.col));
            if(this.position.row + i < this.world.getSize() && this.position.row + i > 0 && this.position.col+i < this.world.getSize() && this.position.col+i > 0){
                this.currentPossibleMoves.add(new Coord(this.position.row+i, this.position.col+i));
            }
            if(this.position.row + i < this.world.getSize() && this.position.row + i > 0 && this.position.col-i < this.world.getSize() && this.position.col-i > 0){
                this.currentPossibleMoves.add(new Coord(this.position.row+i, this.position.col-i));
            }
            if(this.position.row - i < this.world.getSize() && this.position.row - i > 0 && this.position.col+i < this.world.getSize() && this.position.col+i > 0){
                this.currentPossibleMoves.add(new Coord(this.position.row-i, this.position.col+i));
            }
            if(this.position.row - i < this.world.getSize() && this.position.row - i > 0 && this.position.col-i < this.world.getSize() && this.position.col-i > 0){
                this.currentPossibleMoves.add(new Coord(this.position.row-i, this.position.col-i));
            }
        }
    }
}