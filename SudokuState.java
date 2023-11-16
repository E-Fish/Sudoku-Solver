import java.util.Random;
import java.util.List;

public class SudokuState {
	int [][] board = new int [4][4]; //2D array
	int moves;
    List<Integer> possibleMoves;

	//constructor
	public SudokuState(int[][] board, int moves) {
        this.board = board;
        this.moves = moves;
    }

    //not needed rn but good to keep incase?
    /*boolean isValid(int [][], int num, int row, int, col, int box)
    {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (input[i].equals(input[j]) && i != j) {
                    return true;
                }
            }
        }
        return false;

       for (int i=0;i<board.length;i++)
       {
            
       }
    }*/
    
	/*public int currMoveRow(int[][] board) {
        //it needs to sift through the whole array and notice when a value is zero
        for (int i = 0; i < board.length; i++) {
   	        for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    int row = i;
                    return row;
                	}
   	            }
   	        }
   	    }
	public int currMoveCol(int[][] board) {
        //it needs to sift through the whole array and notice when a value is zero
        for (int i = 0; i < board.length; i++) {
   	        for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    int col = j;
                    return col;
                }
   	        }
   	    }
   	}*/
    
    // Edie: applyValidAction()
    public List<Integer> applyValidAction(int[][] initialBoard, int row, int col) {
    	//needs to see the other values in the row, column, and square of the current decision
    	for (int i=1; i<5; i++){
            for (int x=0; x<board.length; x++){
                if (board[x][col]==i-1) {
                  break;
                }
            }
            for (int y=0; y<board.length; y++) {
                if (board[row][y]==i-1) {
                    break;
                }
            }
            int r=row-row%2;
            int c=col-col%2;
            for (int e=0;e<r+2; e++){
                for (int f=0;f<c+2;f++){
                   if (board[e][f]==i)
                   break; 
                }
            }
            possibleMoves.add(i);
        }
        return possibleMoves;

    }
    
    
    // Edie: take a solved board and create an unsolved board from it initalize()
    public static int[][] initalize(int[][] goalBoard) {

        //makes copy of goal board so we don't alter it and can go back and check it later for if its the correct answer if we want
        int[][] newInitialBoard = new int[goalBoard.length][];
        for(int i = 0; i < goalBoard.length; i++)
        {
        	newInitialBoard[i] = new int[goalBoard[i].length];
        	for (int j = 0; j < goalBoard[i].length; j++)
        	{
        		newInitialBoard[i][j] = goalBoard[i][j];
        	}
        }
        
        int rows = goalBoard.length;
        int cols = goalBoard[0].length;

        //deciding how many we want to delete
        int amtToDelete = 10;
        
        //randomly chooses cells in the array as many times as we want cells switched to zero and switches them to zero
        Random random = new Random();
        for (int i = 0; i < amtToDelete; i++) {
            int rowNum = random.nextInt(rows);
            int colNum = random.nextInt(cols);
            newInitialBoard[rowNum][colNum] = 0;
        }

        return newInitialBoard;

    }

    // Edie: define the goal state isGoal()
    boolean isGoal(int [][] goalBoard) { 
    	int[][] newGoalBoard = new int[goalBoard.length][];
        for(int i = 0; i < goalBoard.length; i++)
        {
        	newGoalBoard[i] = new int[goalBoard[i].length];
        	for (int j = 0; j < goalBoard[i].length; j++)
        	{
        		newGoalBoard[i][j] = goalBoard[i][j];
        	}
        }
	    	    
   	    for (int i = 0; i < board.length; i++) {
   	        for (int j = 0; j < board[i].length; j++) {
   	            if (board[i][j] != newGoalBoard[i][j]) {
   	                return false;
   	            }
   	        }
   	    }
   	    return true;

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
