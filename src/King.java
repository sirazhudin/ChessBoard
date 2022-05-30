public class King extends ChessPiece{
    public King(String colour) {
        super ( colour );
    }

    @Override
    public String getColour() {
        return this.colour;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPos ( line ) && checkPos ( column ) && checkPos ( toLine ) && checkPos ( toColumn ) {
            if (Math.abs(line -toLine)>1 || Math.abs ( column-toColumn )>1) return false;
            if(isUnderAttack(chessBoard,toLine,toColumn)) return false
            if(chessBoard.board[toLine][toColumn]!=null){
                return !chessBoard.board[toLine][toColumn].getColour ().equals ( colour );
            }
            return true;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}
