public class ChessBoard {
    public ChessPiece[][] board = new ChessPiece[8][8];

    String nowPlayer;

    public ChessBoard(String nowPlayer) {
        this.nowPlayer = nowPlayer;
    }

    public String getNowPlayerColour() {
        return this.nowPlayer;
    }

    public boolean moveToPosition(int startLine, int startColumn, int endLine, int endColumn) {
        // 1. verify that this field exists on the chess board.
        if (checkPos ( startLine ) && checkPos ( startColumn )) {
            //2. if colour of the active player matches the colour of chess-piece then move is possible
            if (!nowPlayer.equals ( board[startLine][startColumn].getColour ( ) )) return false;
            // 3. next verify if this chess-piece can be moved to the position
            if (board[startLine][startColumn].canMoveToPosition ( this, startLine, startColumn, endLine, endColumn )) {
                //4. verify if this position is available for Castling (Рокировка) also if the current chess-piece is King or Rook
                if (board[startLine][startColumn].getSymbol ( ).equals ( "K" ) || board[startLine][startColumn].getSymbol ( ).equals ( "R" )) {
                    //5. verify if this piece was not yet moved ?
                    board[startLine][startColumn].check = false;
                }// если фигура может быть сдвинута на занданное поле то перемешаем фигуру
                board[endLine][endColumn] = board[startLine][startColumn];
                // remove chess piece from the start point
                board[startLine][startColumn] = null;
                //change player
                this.nowPlayer = this.getNowPlayerColour ( ).equals ( "White" ) ? "Black" : "White";
                return true;
            } else return false;
        } else return false;
    }

    public void printBoard() {//print board in console
        System.out.println ( "Turn " + nowPlayer );
        System.out.println ( );
        System.out.println ( "Player 2(Black)" );
        System.out.println ( );
        System.out.println ( "\t0\t1\t2\t3\t4\t5\t6\t7" );

        for (int i = 7; i > -1; i--) {
            System.out.print ( i + "\t" );
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print ( ".." + "\t" );
                } else {
                    System.out.print ( board[i][j].getSymbol ( ) + board[i][j].getColour ( ).substring ( 0, 1 ).toLowerCase ( ) + "\t" );
                }
            }
            System.out.println ( );
            System.out.println ( );
        }
        System.out.println ( "Player 1(White)" );

    }

    public boolean castling0() { //long Castling white side
        if (nowPlayer.equals ( "White" )) {
            if (board[0][0] == null || board[0][4] == null) return false;
            if (board[0][0].getSymbol ( ).equals ( "R" ) && board[0][4].getSymbol ( ).equals ( "K" ) &&
                    board[0][1] == null && board[0][2] == null && board[0][3] == null) {
                if (board[0][0].getColour ( ).equals ( "White" ) && board[0][4].getColour ( ).equals ( "White" ) &&
                    board[0][0].check && board[0][4].check && !new King ( "White" ).isUnderAttack ( this, 0, 2 )) { //not under attack
                    board[0][4] = null;
                    board[0][2] = new King ( "White" ); //move King
                    board[0][2].check = false;
                    board[0][0] = null;
                    board[0][3] = new Rook ( "White" ); //Move Rook
                    board[0][3].check = false;
                    nowPlayer = "Black";
                    return true;
                } else return false;
            } else return false;
        } else { // black side
            if (board[7][0] == null || board[7][4] == null) return false;
            if (board[7][0].getSymbol ( ).equals ( "R" ) && board[7][4].getSymbol ( ).equals ( "K" ) &&
                    board[7][1] == null && board[7][2] == null && board[7][3] == null) {
                if (board[7][0].getColour ( ).equals ( "Black" ) && board[7][4].getColour ( ).equals ( "Black" ) &&
                        board[7][0].check && board[7][4].check && !new King ( "Black" ).isUnderAttack ( this, 7, 2 )) { //not under attack
                    board[7][4] = null;
                    board[7][2] = new King ( "Black" ); //move King
                    board[7][2].check = false;
                    board[7][0] = null;
                    board[7][3] = new Rook ( "Black" ); //Move Rook
                    board[7][3].check = false;
                    nowPlayer = "White";
                    return true;
                } else return false;
            } else return false;
        }
    }
    public boolean castling7() { //short Castling White side
        if (nowPlayer.equals ( "White" )) {
            if (board[0][7] == null || board[0][4] == null) return false;
            if (board[0][7].getSymbol ( ).equals ( "R" ) && board[0][4].getSymbol ( ).equals ( "K" ) &&
                    board[0][5] == null && board[0][6]  == null) {
                if (board[0][7].getColour ( ).equals ( "White" ) && board[0][4].getColour ( ).equals ( "White" ) &&
                        board[0][7].check && board[0][4].check && !new King ( "White" ).isUnderAttack ( this, 0, 6 )) { //not under attack
                    board[0][4] = null;
                    board[0][6] = new King ( "White" ); //move King
                    board[0][6].check = false;
                    board[0][7] = null;
                    board[0][5] = new Rook ( "White" ); //Move Rook
                    board[0][5].check = false;
                    nowPlayer = "Black";
                    return true;
                } else return false;
            } else return false;
        } else { // black side
            if (board[7][7] == null || board[7][4] == null) return false;
            if (board[7][7].getSymbol ( ).equals ( "R" ) && board[7][4].getSymbol ( ).equals ( "K" ) &&
                    board[7][5] == null && board[7][6] == null ) {
                if (board[7][7].getColour ( ).equals ( "Black" ) && board[7][4].getColour ( ).equals ( "Black" ) &&
                        board[7][7].check && board[7][4].check &&
                        !new King ( "Black" ).isUnderAttack ( this, 7, 6 )) { //not under attack
                    board[7][4] = null;
                    board[7][6] = new King ( "Black" ); //move King
                    board[7][6].check = false;
                    board[7][7] = null;
                    board[7][5] = new Rook ( "Black" ); //Move Rook
                    board[7][5].check = false;
                    nowPlayer = "White";
                    return true;
                } else return false;
            } else return false;
        }
    }
    public boolean checkPos(int pos){
        return pos>=0 && pos<=7;
    }

}
