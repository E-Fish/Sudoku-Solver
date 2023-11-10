import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class SudokuNode {
	SState state;
    SNode parent;
    List<SNode> children;
    
    //NOTES TO MR CAMPBELL WHEN GRADING: 
    		//1. input a board of your choice in the initalBoard below 
    		//by replacing what is there with your board
    
    		//2. go to about PNode.java line 63 with PState initialState = new PState(initialBoard, 3, 0, 0, 0); and substitute
    		//the blankX=(your blank's row) and blankY=(your blank's column) using public PState(int[][] board, int blankX, int blankY, int moves, int heuristic)
    

    public SudokuNode(SState s, SNode p) {
        this.state = s;
        this.parent = p;
        this.children = new LinkedList<SNode>();
    }
    
    public SState getState() {
        return ;;
    }
    
    boolean generateMoves(int blankX, int blankY) { 
    	
    	int[][] moves = {
    	        {blankX - 1, blankY}, //blank moves up
    	        {blankX + 1, blankY}, //down
    	        {blankX, blankY - 1}, //left
    	        {blankX, blankY + 1}  //right
    	    };

   	    for (int i = 0; i < moves.length; i++) {
   	        int amtRowMoved = moves[i][0];
   	        int amtColMoved = moves[i][1];

   	        if (isValid(amtRowMoved, amtColMoved)) {
   	        	
   	            int[][] newBoard = copyBoard(this.state.board); //copy the current state's board
   	            this.applyAction(newBoard, amtRowMoved - blankX, amtColMoved - blankY, blankX, blankY);

   	            SState newState = new SState(newBoard, amtRowMoved, amtColMoved, this.state.moves + 1, 0); //create a new state
   	            this.children.add(new SNode(newState, this)); //add this new state to linked list
   	            
   	        }
   	    }

   	    if (!children.isEmpty()) {
   	    	return true;
   	    }
   	    else {
   	    	return false;
   	    }

    }
    
    //creates copy of board for generateChildren() so that board can be modified and returned without altering current
    private int[][] copyBoard(int[][] ogBoard) {
    	
        int[][] copy = new int[ogBoard.length][ogBoard[0].length];
        
        for (int i = 0; i < ogBoard.length; i++) {
            System.arraycopy(ogBoard[i], 0, copy[i], 0, ogBoard[0].length);
        }
        return copy;
    }
    
    boolean isValid(int amtRowMoved, int amtColMoved) { 
    	
    	//verify that no switches happen outside of the bounderies
        //still need to brainstorm more ways it could go wring
    	if (amtRowMoved >= 0 && amtRowMoved < state.board.length && amtColMoved >= 0 && amtColMoved < state.board[0].length) {
    		return true;
    	}
    	else {
    		return false;
    	}
 
    }
      
}
