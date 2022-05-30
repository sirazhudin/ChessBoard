public class Rook extends ChessPiece{
    public Rook(String colour) {
        super ( colour );
    }

    @Override
    public String getColour() {
        return this.colour;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPos ( line ) && checkPos ( toLine ) && checkPos ( column ) && checkPos ( toColumn ) {  //&& // if within the board ?
            if(column == toColumn){
                for (int i = getMin ( line, toLine ); i < getMax ( line,toLine );i++) {
                    if (chessBoard.board[i][column] != null) { //cannot move to where it is
                        if (chessBoard.board[i][column] == this && i == getMax ( line, toLine )) return false;
                            //cannot move to square where there is a chess-piece of same colour
                        else if (chessBoard.board[i][column].getColour ( ).equals ( this.colour ) && i == toLine)
                            return false;
                            //can cut chess piece of the opposite colour
                        else if (!chessBoard.board[i][column].getColour ( ).equals ( this.colour ) && i == toLine)
                            return true;
                    }
                }

               if(chessBoard.board[toLine][column] != null){
                   //cannot move ot a square that is engaged with a piece of same colour
                   if(chessBoard.board[toLine][column].getColour ().equals ( this.colour )&&chessBoard.board[toLine][column]!=this)
                       return false;
                   else return !chessBoard.board[toLine][column].getColour ().equals ( this.colour)&&chessBoard.board[toLine][column]!=this;
               } else return true;
            } else if (line==toLine) {
                for (int i = getMin ( toColumn, column ); i < getMax ( column,toColumn );i++){
                    if(chessBoard.board[line][i]!=null){ //cannot move to where it is
                        if(chessBoard.board[line][i] == this && i == getMax ( column,toColumn ))return false;
                        else if (chessBoard.board[line][i].getColour ().equals ( this.colour )&& i == toColumn)
                            return false;
                        else if(!chessBoard.board[line][i].getColour ().equals ( this.colour )&&i==toColumn)
                            return true;
                    }
                }
                if(chessBoard.board[toLine][toColumn]!=null){
                    if(chessBoard.board[toLine][toColumn].getColour ().equals ( this.colour )&& chessBoard.board[toLine][toColumn]!=this)
                        return false;
                    else return !chessBoard.board[toLine][toColumn].getColour ().equals ( this.colour) && chessBoard.board[toLine][toColumn]!=this;
                }else return true;
            }
        }
    }
    @Override
    public String getSymbol() {
        return "R";
    }
}
