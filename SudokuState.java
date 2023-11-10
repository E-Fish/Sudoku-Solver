public class SudokuState {
	int [][] board = new int [4][4]; //2D array
	int moves;

    // Edie: create an isValid()

	//constructor
	public SudokuState(int[][] board, int moves) {
        this.board = board;
        this.moves = moves;
    }
	   
    // Edie: applyValidAction()
    public SudokuState applyValidAction() {

    }
    // Edie: take a solved board and create an unsolved board from it initalize()
    public SState initalize(int[][] goalBoard) {
        int[][] newInitialBoard = goalboard;

        Random rand = new Random();

		for (int row = 0; row < goalBoard.length; row++) {
            for (int col = 0; col < goalBoard[row].length; col++) {
                sb.append(board[row][col]);
                sb.append(' ');
                if (col==1) {
                	sb.append("|");
                	sb.append(' ');
                }
            }
            if (row==1) {
            	sb.append('\n');
            	sb.append("---------");
            }
            sb.append('\n'); // Add a newline after each row
        }
 
        //swaps the blank and whichever was chosen to swap with it
        if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length) {
        	
        	int temp = board[newRow][newCol];
            board[newRow][newCol] = 0;
            board[blankX][blankY] = temp;
            
            
        }

		return newInitialBoard;
    }

    // Edie: define the goal state isGoal()
    boolean isGoal() { 
	    	
   	   for (int i = 0; i < board.length; i++) {
   		   
   	       for (int j = 0; j < board[i].length; j++) {
   	           if (board[i][j] != goalBoard[i][j]) {
   	               return false;
   	           }
   	       }
   	   }

   	    return false;
    }	    

	    //return true when this state and other are equivalent states
    public boolean equals(Object o) {
	    	
    	SState other = (SState)o;
    	if (this.moves == other.moves && this.board == other.board) {
    		return true;
    	}
    	return false;
    }
	
    //change toString() to put lines between the numbers to look like a real board
      public String toString() {
    	StringBuilder sb = new StringBuilder();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                sb.append(board[row][col]);
                sb.append(' ');
                if (col==1) {
                	sb.append("|");
                	sb.append(' ');
                }
            }
            if (row==1) {
            	sb.append('\n');
            	sb.append("---------");
            }
            sb.append('\n'); // Add a newline after each row
        }
        
        return sb.toString();
    }
	    
    public void printState() {
        System.out.println(this.toString());
    }
}
