package code;

import java.util.LinkedList;
import java.util.List;

public class SudokuNode {
	SudokuState state;
	SudokuNode parent;
    List<SudokuNode> children;
    
   
    public SudokuNode(SudokuState s, SudokuNode p) {
        this.state = s;
        this.parent = p;
        this.children = new LinkedList<SudokuNode>();
    }
    
    public SudokuState getState() {
        return this.state;
    }
    
    public SudokuNode getParent() {
    	return this.parent;
    }
    public SudokuNode clone() {
    	SudokuNode newNode = this;
    	return newNode;
    }
    
    public List<SudokuNode> getChildren(){
		return children;
	}
    //creates copy of board for generateChildren() so that board can be modified and returned without altering current
    private int[][] copyBoard(int[][] ogBoard) {
    	
        int[][] copy = new int[ogBoard.length][ogBoard[0].length];
        
        for (int i = 0; i < ogBoard.length; i++) {
            System.arraycopy(ogBoard[i], 0, copy[i], 0, ogBoard[0].length);
        }
        return copy;
    }
   
   void generateChildren(){
	   int[][] b= state.getBoard();
	 		      List<Integer> moves = state.applyValidAction();
	 		      for (Integer move: moves) {
	 		        		b[state.currMoveRow(b)][state.currMoveCol(b)]=move;
	 		        		SudokuState nextS = new SudokuState(b, state.getMoves()+1);
	 		        		SudokuNode nextN = new SudokuNode(nextS, this);
	 		        		children.add(nextN);
	 		   }
   }
}