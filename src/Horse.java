public class Horse extends ChessPiece{


    public Horse(String colour) {
        super ( colour );
    }

    @Override
    public String getColour() {
        return this.colour;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
       // Проверить существование координат
        if(checkPos ( line ) && checkPos ( column ) && checkPos ( toLine ) && checkPos ( toColumn )){
            //Стартовая координата не должна совпадать с конечной
            if (line!=toLine&&column!=toColumn &&
            //Конечная клетка должна быть пустая or/или цвет фигуры должен совпадать с цветом игрока
                    (chessBoard.board[toLine][toColumn]==null || !chessBoard.board[toLine][toColumn].colour.equals ( this.colour ))
            // Start position is not empty
                    && chessBoard.board[line][column]!=null) {
                return false;
            }
                // all possible positions for this chess piece (Horse) to move to
                int[][] positions = new int [][]{
                        {line -2,column-1},{line - 2, column+1},
                        {line +2,column-1},{line + 2, column+1},
                        {line -1,column-2},{line - 1, column+2},
                        {line +1,column-2},{line + 1, column+2}};
            // verify if to-position is one of the possibble positions
            for(int i =0; i< positions.length;i++){
                if(positions[i][0] == toLine && positions[i][1]==toColumn)
                    return true;
            }
        }else return false;
        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
