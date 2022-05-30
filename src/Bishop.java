public class Bishop extends ChessPiece{
    public Bishop(String colour) {
        super ( colour );
    }
    @Override
    public String getColour() {
        return this.colour;
    }
    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line != toLine && column != toColumn && // start not final position ?
        getMax ( line,toLine )-getMin ( line,toLine )==getMax ( column,toColumn )-getMin ( column,toColumn ) && // move along diagonal ?
        checkPos ( line ) && checkPos ( toLine )&&checkPos ( column )&& checkPos ( toColumn ) && // if within the board ?
                // final square is empty or has another chesspiece but the opposite colour
                (chessBoard.board[toLine][toColumn]==null||!chessBoard.board[toLine][toColumn].colour.equals ( this.colour ))&&
                //start is not empty?
                chessBoard.board[line][column]!=null){
            // from-upper-left to right bottom
            if ((column == getMin (column,toColumn)&& line==getMax ( line,toLine ) ) ||
                    (toColumn==getMin ( column,toColumn ) && toLine== getMax ( line,toLine ))) {
                //
                int fromL = getMax ( line,toLine );
                int fromC = getMin ( column,toColumn );
                int toL = getMin ( line,toLine );
                int toC = getMax ( column,toColumn );
                // position that Bishop will pass to final square
                int[][] positions = new int[toC-fromC][1];
                // number of columns = number or lines passed by Bishop
                for (int i =1;i<toC-fromC;i++){
                    if(chessBoard.board[fromL-i][fromC+i] == null){
                        positions[i-1]=new int[]{fromL -i,fromC+i};
                    } else if(!chessBoard.board[fromL-i][fromC+i].colour.equals ( this.colour )&&fromL-i==toLine){
                        positions[i-1]=new int[]{fromL-i,fromC+i};
                    } else {
                        return false;
                    }
                }
                return true;
            }else { // from upper right to bottom left
                int fromL = getMin ( line,toLine );
                int fromC = getMin ( column,toColumn );
                int toL = getMax ( line,toLine );
                int toC = getMax ( column,toColumn );
                // position that Bishop will pass to final square
                int[][] positions = new int[toC-fromC][1];
                // number of columns = number or lines passed by Bishop
                for (int i =1;i<toC-fromC;i++){
                    if(chessBoard.board[fromL+i][fromC+i] == null){
                        positions[i-1]=new int[]{fromL +i,fromC+i};
                    } else if(!chessBoard.board[fromL+i][fromC+i].colour.equals ( this.colour )&&fromL-i==toLine){
                        positions[i-1]=new int[]{fromL+i,fromC+i};
                    } else {
                        return false;
                    }
                }
                return true;
            }
        }else  return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
} //
