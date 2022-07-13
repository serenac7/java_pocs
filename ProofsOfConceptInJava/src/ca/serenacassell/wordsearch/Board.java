package ca.serenacassell.wordsearch;

public class Board {
    private char[][] theBoard;
    private BoardCoordinates currentLocation;

    Board(char[][] theBoard){
        this.theBoard = theBoard;
        this.currentLocation = new BoardCoordinates(0,0);
    }

    public BoardCoordinates updateLocationOnBoard(){
        if (this.theBoard != null){

            //Make sure we haven't hit the end of the line or the end of the board.
            if ((this.currentLocation.getY() + 1) < this.theBoard[0].length)
                this.currentLocation.updateCoordinates(this.currentLocation.getX(), this.currentLocation.getY() + 1);

            else if (this.currentLocation.getX() + 1 < this.theBoard.length)
                this.currentLocation.updateCoordinates(this.currentLocation.getX() + 1, 0);

            else
                this.currentLocation = null;

        }else
            this.currentLocation = null;

        return this.currentLocation;
    }

    public BoardCoordinates getCurrentLocation(){
        return this.currentLocation;
    }

    public void resetLocation(BoardCoordinates newLocation){
        this.currentLocation = newLocation;
    }

    public char getChar(){
        return this.getChar(this.currentLocation.getX(), this.currentLocation.getY());
    }

    public char getChar(BoardCoordinates coordinates){
        return this.getChar(coordinates.getX(), coordinates.getY());
    }

    /**
     * Will attempt to return the character at the indicated location.
     * Developer MUST validate that x and y are 0 or greater.
     * @param x
     * @param y
     * @return
     */
    public char getChar(int x, int y){
        return this.theBoard[x][y];
    }

    public void print(){
        for (int i=0;i<this.theBoard.length;i++){
            char[] row = this.theBoard[i];

            System.out.print(" ROW " + (i+1));
            for (int j=0;j<row.length;j++){
                System.out.print("  " + row[j]);
            }
            System.out.println(" ");
        }
    }
}
