public class Pawn extends ChessPiece{
    public Pawn(String colour) {
        super ( colour );
    }

    @Override
    public String getColour() {
        return this.colour;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPos ( line ) && checkPos ( column ) && checkPos ( toLine ) && checkPos ( toColumn )&&
            //Стартовая координата не должна совпадать с конечной and colour should be same
        chessBoard.board[toLine][toColumn]==null //|| !chessBoard.board[toLine][toColumn].colour.equals ( this.colour ))
                    // Start position is not empty
                    && chessBoard.board[line][column] != null) {
                if (column == toColumn) { // moving along same column
                    int dir; //direction to go to
                    int start;
                    if (colour.equals ( "White" )) { //for white pieces
                        dir = 1;
                        start = 1; // start square line
                    } else { /// for black pieces direction is negative
                        dir = -1;
                        start = 6; // start square line
                    }
                    if (line + dir == toLine) { // verify if moved along same line
                        return chessBoard.board[toLine][toColumn] == null; // if the square is free
                    }
                    if (line == start && line + 2 == toLine) { //next if the square is free and there is nothing on the way
                        return chessBoard.board[toLine][toColumn] == null && chessBoard.board[line + dir][column] == null;
                    }
                }
            } else { // if take a piece with pawn
                if ((column - toColumn == 1 || column - toColumn == -1) && // if
                        (line - toLine == 1 || line - toLine == -1) &&
                        chessBoard.board[toLine][toColumn] != null) {
                    return !chessBoard.board[toLine][toColumn].getColour ( ).equals ( colour );
                } else return false;
            }
            return false;
        }


    @Override
    public String getSymbol() {
        return "P";
    }
}
