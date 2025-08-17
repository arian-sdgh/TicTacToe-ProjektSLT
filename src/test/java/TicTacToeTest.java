import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.*;

public class TicTacToeTest {

    @Test
    public void getMarker_shouldReturnCorrectMarker_Positive() {
        Player player = new Player('X');
        assertEquals('X', player.getMarker(), "Marker should be X");
    }

    @Test
    public void getMarker_shouldNotReturnIncorrectMarker_Negative() {
        Player player = new Player('O');
        assertNotEquals('X', player.getMarker(), "Marker should not be X");
    }

    @Test
    public void isCellEmpty_shouldReturnTrueForEmptyCell_Positive() {
        Board board = new Board();
        assertTrue(board.isCellEmpty(0, 0), "Empty cell should return true");
    }

    @Test
    public void isCellEmpty_shouldReturnFalseForOccupiedCell_Negative() {
        Board board = new Board();
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0), "Occupied cell should return false");
    }

    @Test
    public void place_shouldPutMarkerInCorrectPosition_Positive() {
        Board board = new Board();
        board.place(0, 0, 'X');
        assertEquals('X', board.getCells()[0][0], "Cell should contain X");
    }

    @Test
    public void place_shouldNotPutWrongMarker_Negative() {
        Board board = new Board();
        board.place(1, 1, 'O');
        assertNotEquals('X', board.getCells()[1][1], "Cell should not contain X");
    }

    @Test
    public void clear_shouldEmptyAllCells_Positive() {
        Board board = new Board();
        board.place(1, 1, 'X');
        board.clear();
        assertTrue(board.isCellEmpty(1, 1), "Board should be empty after clear");
    }

    @Test
    public void clear_shouldNotBeEmptyBeforeCallingClear_Negative() {
        Board board = new Board();
        board.place(2, 2, 'O');
        assertFalse(board.isCellEmpty(2, 2), "Cell should not be empty before clear");
    }

    @Test
    public void isFull_shouldReturnTrueWhenBoardFilled_Positive() {
        Board board = new Board();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertTrue(board.isFull(), "Full board should return true");
    }

    @Test
    public void isFull_shouldReturnFalseWhenBoardNotFull_Negative() {
        Board board = new Board();
        board.place(0, 0, 'X');
        assertFalse(board.isFull(), "Partially filled board should return false");
    }

    @Test
    public void getCells_shouldReturnCorrectBoardState_Positive() {
        Board board = new Board();
        board.place(0, 2, 'X');
        char[][] cells = board.getCells();
        assertEquals('X', cells[0][2], "getCells should reflect placed marker");
    }

    @Test
    public void getCells_shouldNotReturnIncorrectMarker_Negative() {
        Board board = new Board();
        char[][] cells = board.getCells();
        assertNotEquals('X', cells[2][2], "Empty cell should not contain X");
    }
}
