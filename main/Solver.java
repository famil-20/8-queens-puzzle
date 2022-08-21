public class Solver {
    private int iterator;
    private Piece[] queens;
    private boolean solved = false;
    private boolean fullySolved = false;


    Solver(Piece[] queensIn, int length){
        this.iterator = 1;
        this.queens = new Piece[length];
        for (int i = 0; i < queens.length; i++) {
            this.queens[i] = queensIn[i];
        }        
    }
    
    public boolean checkFullySolved(){
        for (int i = this.queens.length-1;i>=0;i--) {
            if (this.queens[i].getPosition().col+1<this.queens[i].world.getSize()){
                this.iterator = i;
                this.queens[this.iterator].moveTo(this.iterator, this.queens[this.iterator].getPosition().col+1);
                this.solved = false;
                return false;
            }
        }
        return true;
    }

    public void notFoundGoDown () {
        if (iterator-1 == 0) {
            this.queens[iterator].moveTo(iterator, 0);
            solveRoot();
        }
        else {
            this.queens[iterator].moveTo(iterator, 0);
            if (this.iterator != 0) {
                this.iterator -= 1;
                if (this.queens[iterator].getPosition().col+1 < this.queens[iterator].world.getSize()){
                    this.queens[iterator].moveTo(iterator, this.queens[iterator].getPosition().col+1);
                }
                else {
                    notFoundGoDown();
                }
            }
            else {
                this.solved = true;
            }
        }        
    }
    
    public void foundGoUp () {
        if (this.iterator+1 < this.queens.length){
            this.iterator += 1;
        }
        else{
            this.solved = true;
        }
    }
    
    public boolean checkCanStayHere () {
        for (int i = 0; i < this.iterator; i++) {
            if (this.queens[iterator].canAttackMe(this.queens[i])) {
                return false;
            }
        }
        return true;
    }

    public void solve () {
        while (!this.fullySolved) {
            while (!solved) {
                if (this.checkCanStayHere()) {
                    this.foundGoUp();
                }
                else{
                    if (this.queens[iterator].getPosition().col+1 == this.queens[iterator].world.getSize()) {
                        notFoundGoDown();
                    }
                    else {
                        this.queens[iterator].moveTo(iterator, this.queens[iterator].getPosition().col+1);
                    }
                }
            }
            System.out.println(this.queens[0].world);
            this.fullySolved = checkFullySolved();
        }
    }

    public void solveRoot () {
        if (this.queens[0].getPosition().col+2 != this.queens[0].world.getSize()) {
            this.queens[0].moveTo(0, this.queens[0].getPosition().col+1);
        }
        else {
            System.out.println("These were all the solutions!");
            System.exit(0);
        }
    }
}