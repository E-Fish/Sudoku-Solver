package code;
import java.util.Random;
import java.util.LinkedList;
import java.util.List;

public class SudokuState {
	int [][] board = new int [4][4]; //2D array
	int moves;
	List<Integer> possibleMoves = new LinkedList<Integer>();

	//constructor
	public SudokuState(int[][] board, int moves) {
        this.board = board;
        this.moves = moves;
    }
	
	public int[][] getBoard(){
		return this.board;
	}
	public int getMoves() {
		return this.moves;
	}
	
    //not needed rn but good to keep incase?
    boolean isValid(int num)
    {
    	int row = currMoveRow(board);
    	int col = currMoveRow(board);
    	//checks row
            for (int x=0; x<4; x++){
                if (board[row][x]==num) {
                  return false;
                }
            }
            //checks col
            for (int y=0; y<4; y++) {
                if (board[y][col]==num) {
                  return false;
                }
            }
            //checks box
           /*int r=row-row%2;
           int c=col-col%2;
            for (int i=0;i<2; i++){
                for (int j=0;j<2;j++){
                   if (board[r][c]==num)
                   return false; 
                }
            }*/
    	return true;
    }
	public int currMoveRow(int[][] board) {
        //it needs to sift through the whole array and notice when a value is zero
        int row=0;
		check:{for (int i = 0; i < board.length; i++) {
   	        for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    break check;
                	}
   	        }
		}
		}
		return row;
	}
	
	public int currMoveCol(int[][] board) {
        //it needs to sift through the whole array and notice when a value is zero
       int col=0;
       check:{for (int i = 0; i < board.length; i++) {
   	        for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    col = j;
                    break check;
                }
   	        }
   	    }
       }
		return col;
   	}
    
    // Edie: applyValidAction()
    public List<Integer> applyValidAction() {
    	//needs to see the other values in the row, column, and square of the current decision
 //   	int row = this.currMoveRow(board);
   // 	int col = this.currMoveCol(board);
    	for (int i=1; i<5; i++){
    		if (isValid(i))
    		{
    			//	System.out.println(i);
    			possibleMoves.add(i);
    		}
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
