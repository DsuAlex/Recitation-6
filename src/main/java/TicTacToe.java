/**
 * This class implements the game we all love to
 * not play.
 *
 * @author (M Rasamny)
 * @version (03 / 13 / 2018)
 */
public class TicTacToe {
    // instance variables
    private GamePiece[][] board;
    private GamePiece[] player;
    private int nextPlayerIndex;
    private int numOfMoves;
    /**
     * This class implements the game we all love to
     * not play.
     *
     * @author (M Rasamny)
     * @version (03 / 13 / 2018)
     */

    ////this is the actual board below
    public TicTacToe(GamePiece p1, GamePiece p2) {
        board = new GamePiece[3][3];
        clear();
        player = new GamePiece[2];
        player[0] = new GamePiece(p1);
        player[1] = new GamePiece(p2);
        nextPlayerIndex = 0;
        numOfMoves = 0;
    }


    /**
     * Returns true if the location is an integer that represents one of the squares on the board ; false otherwise
     *
     * @param location the integer representation of the square.
     * @return true if the location is an integer that represents one of the squares on the board ; false otherwise
     */
    public boolean isValid(int location) {
        return location >= 0 & location < 9;
    }

    /**
     * Returns true if the location is NOT occupied by a game piece; false otherwise
     *
     * @param location the integer representation of the square.
     * @return true if the location is NOT occupied by a game piece; false otherwise
     */
    public boolean isEmpty(int location) {
        return board[location / 3][location % 3] == null;
    }

    /**
     * Returns the number of moves remaining on the board
     *
     * @return the number of moves remaining on the board
     */
    public int movesRemaining() {
        // TODO: add code here
        return 9 - numOfMoves;
    }

    /**
     * Returns the game piece at the provided location
     *
     * @param location the integer representation of the square
     * @return the game piece at the provided location
     */
    public GamePiece getPiece(int location) {
        if ( board[location / 3][location % 3] == null){
            return null;
        }
        return new GamePiece(board[location / 3][location % 3]);

    }

    /**
     * Returns the winner's GamePiece or null if there is no winner at the time the method is invoked
     *
     * @return the winner's GamePiece or null if there is no winner at the time the method is invoked
     */
    public GamePiece getWinner() {
        GamePiece winner = null;

        int[][] combos = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}
        };

        // TODO: add code here
        for(int i = 0; i < combos.length; i++){
            GamePiece piece = getPiece(combos[i][0]);
            if (piece == null || getPiece(combos[i][1]) == null || getPiece(combos[i][2]) == null){
                continue;
            }
            else if(piece.getPiece() == getPiece(combos[i][1]).getPiece() & piece.getPiece() == getPiece(combos[i][2]).getPiece()){
                winner = piece;
                break;
            }
        }
        return winner;
    }

    /**
     * Indicates the current player by returning the current player's game piece
     * @return the current player's game piece.
     */
    public GamePiece getCurrentPlayer() {
        return new GamePiece(player[nextPlayerIndex]);
    }

    /**
     * Places a game piece at the provided location if and only if the location is valid and is empty.  Returns
     * true if the operation is successful; false otherwise
     * @param location the integer representation of the square.
     * @return true if it is able to place a game piece at the specified location; false otherwise
     */
    public boolean add(int location) {
        if (isValid(location) && isEmpty(location)) {
            board[location / board.length][location % board.length] = player[nextPlayerIndex];
            nextPlayerIndex = nextPlayerIndex > 0 ? 0 : 1;
            numOfMoves++;
            return true;
        }
        return false;
    }

    /**
     * Clears the board of all game pieces
     */
    public void clear() {
        // set all elements of 2d array to null
        // TODO: add code here
        board = new GamePiece[3][3];
        numOfMoves = 0;
    }

    /**
     * Returns a string representation of the board
     * @return a string representation of the board
     */
    @Override
    public String toString() {
        String s = "";

        // TODO: add code here

        s +="-\n";
        for(int row =0; row< board.length; row++){
            for (int col = 0; col< board[0].length; col++){
                s+= "|"+ ((row* board[row].length)+col);
            }
            s+="|\n";
            for (int col = 0; col< board[0].length; col++){
                s+= "--";
            }
            s+="|\n";

        }
        return s;
    }

}

