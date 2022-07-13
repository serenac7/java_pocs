package ca.serenacassell.wordsearch;

public class BoardCoordinates{
    private int x;
    private int y;

    BoardCoordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public BoardCoordinates copy(){
        return new BoardCoordinates(this.x, this.y);
    }

    public boolean equals(BoardCoordinates coordinate){
        if (this.equals(coordinate))
            return true;
        else if (this.getX() == coordinate.getX() && this.getY() == coordinate.getY())
            return true;
        else
            return false;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void updateCoordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String getPrintOutput(){
        return "("+ (this.x + 1) + ", "+ (this.y + 1) + ")";
    }
}
