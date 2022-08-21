public class Queen extends Piece{
    Queen(String name, Board world, Coord positiion){
        super(name, world, positiion);
    }
    
    Queen(String name, Board world, int row, int column){
        super(name, world, row, column);
    }
}
