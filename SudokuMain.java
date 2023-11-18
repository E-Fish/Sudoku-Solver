import java.util.List;

class SudokuMain {
	public static void main (String[]array) {
		int[][] goalBoard = {
                {4, 3, 1, 2},
                {1, 2, 4, 3},
                {2, 1, 3, 4},
                {3, 4, 2, 1}
        };

        boolean solved = false;

        while (!solved) {
            SudokuState initialState = new SudokuState(SudokuState.initalize(goalBoard), 0);
            initialState.printState();
            SudokuNode initialNode = new SudokuNode(initialState, null);
            solved = solve(initialNode, goalBoard);
        }

}  

public static boolean solve(SudokuNode starter, int [][] goalBoard) {

	int[][] b = starter.getState().getBoard();

    if (starter.getState().isGoal(goalBoard)) {
        System.out.println("done");
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
