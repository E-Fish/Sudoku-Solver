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
    	return parent;
    }
    public SudokuNode clone() {
    	SudokuNode newNode = this;
    	return newNode;
    }
    
    public List<SudokuNode> getChildren(){
		return children;
	}

    void generateChildren() {
        int[][] board = state.getBoard();

        List<Integer> moves = state.possibleMoves();
        for (Integer move : moves) {
            int[][] newBoard = copyBoard(board); 
            newBoard[state.currMoveRow(newBoard)][state.currMoveCol(newBoard)] = move;
            SudokuState nextState = new SudokuState(newBoard, state.getMoves()+1);
            SudokuNode nextNode = new SudokuNode(nextState, this);
            children.add(nextNode);
        }
    }

    private int[][] copyBoard(int[][] ogBoard) {
        int[][] copy = new int[ogBoard.length][ogBoard[0].length];

        for (int i = 0; i < ogBoard.length; i++) {
            System.arraycopy(ogBoard[i], 0, copy[i], 0, ogBoard[0].length);
        }

        return copy;
    }
}
