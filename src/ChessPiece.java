public abstract class ChessPiece {
    String colour; //colour of chesspiece
    boolean check = true;

    public ChessPiece(String colour) {
        this.colour = colour;

    }

    public abstract String getColour();

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public abstract String getSymbol();

    protected boolean checkPos(int pos) { return pos >= 0 && pos <= 7; }

    protected int getMax(int a, int b) { return Math.max ( a, b ); }

    protected int getMin(int a, int b) { return Math.min ( a, b ); }

}
