import java.util.LinkedList;
import java.util.List;

public class SudokuNode {
	SudokuState state;
	SudokuNode parent;
    List<Integer> currentMoveOptions;
    List<SudokuNode> children;

    //constructor
    public SudokuNode(SudokuState s, SudokuNode p) {
        state = s;
        parent = p;
        List<SudokuNode> c = new LinkedList<SudokuNode>();
        children = c;
    }
    
    public SudokuState getState() {
        return this.state;}
    public SudokuNode getParent() {
    	return this.parent;}
    public List<SudokuNode> getChildren(){
        return children;}

    public SudokuNode clone() {
    	SudokuNode newNode = this;
    	return newNode;
    }

   void generateChildren(){
	   int[][] b = state.getBoard();
	 		      List<Integer> moves = state.getPossibleMoves();
	 		      for (Integer move: moves) {
	 		        		b[state.currMoveRow(b)][state.currMoveCol(b)]=move;//finds index of first 0
	 		        		SudokuState nextState = new SudokuState(b, state.getMoves()+1);
	 		        		SudokuNode nextNode = new SudokuNode(nextState, this);
	 		        		children.add(nextNode);
	 		   }
   }
}