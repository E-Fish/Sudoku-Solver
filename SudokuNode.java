
import java.util.LinkedList;
import java.util.List;

public class SudokuNode {
	SState state;
    SNode parent;
    List<SNode> children;
    
   
    public SudokuNode(SState s, SNode p) {
        this.state = s;
        this.parent = p;
        this.children = new LinkedList<SNode>();
    }
    
    public SState getState() {
        return ;
    }
    
    
    //creates copy of board for generateChildren() so that board can be modified and returned without altering current
    private int[][] copyBoard(int[][] ogBoard) {
    	
        int[][] copy = new int[ogBoard.length][ogBoard[0].length];
        
        for (int i = 0; i < ogBoard.length; i++) {
            System.arraycopy(ogBoard[i], 0, copy[i], 0, ogBoard[0].length);
        }
        return copy;
    }
    
    /*boolean isValid(int amtRowMoved, int amtColMoved) { 
    	
    	//verify that no switches happen outside of the bounderies
        //still need to brainstorm more ways it could go wring
    	if (amtRowMoved >= 0 && amtRowMoved < state.board.length && amtColMoved >= 0 && amtColMoved < state.board[0].length) {
    		return true;
    	}
    	else {
    		return false;
    	}
 
    }*/
      
}
