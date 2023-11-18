
import java.util.List;

class SudokuMain {
	public static void main (String[]array) {
		int[][] goalBoard = {
                {4, 3, 1, 2},
                {1, 2, 4, 3},
                {2, 1, 3, 4},
                {3, 4, 2, 1}
        };
		
		//brand new unique initial board is generated every time the program is run
	    SudokuState initialState = new SudokuState(SudokuState.initalize(goalBoard), 0);
	    System.out.println("Initial unique board:");
	    initialState.printState();
	    System.out.println("");
	    SudokuNode initialNode = new SudokuNode(initialState, null);
	    solve(initialNode, goalBoard);
	    System.out.println("Board solved!");

}  

public static boolean solve(SudokuNode starter, int [][] goalBoard) {
	int[][] b = starter.getState().getBoard();

    if (starter.getState().isGoal(goalBoard)) {
        return true;
    } 
    else {
    	
        SudokuNode curr = starter;

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (b[i][j] == 0) {
                	
                    List<Integer> moves = curr.getState().possibleMoves();
                    for (Integer move : moves) {
                        if (curr.getState().isValid(move)) {
                        	
                            b[i][j] = move;
                            SudokuState nextState = new SudokuState(b, curr.getState().getMoves() + 1);
                            SudokuNode nextNode = new SudokuNode(nextState, curr);
                            nextState.printState();
                            System.out.println("Move made: " + move);
                            System.out.println("");
                            if (solve(nextNode, goalBoard)) {
                                if (nextNode.getState().isGoal(goalBoard)) {
                                return true;
                                }
                            } 
                            else {
                                b[i][j] = 0;
                            }   
                        }
                    }
                }
            }
        }
    }
        return false;
	}
}
