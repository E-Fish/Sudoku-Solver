import java.util.Arrays;
import java.util.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;

class SudokuMain {
    public static void main (String[]array){
        // initial game state
          int [][] initalBoard = { // [row][column]
            {4,0,1,0},
            {0,2,0,0},
            {0,0,3,0},
            {0,0,0,1}
            };

        //goal state
        int [][] goalBoard = {
            {4,3,1,2},
            {1,2,4,3},
            {2,1,3,4},
            {3,4,2,1}
            };
      
        //goalBoard.initalize();
        
        SudokuState initialState = new SudokuState(initialBoard,0);
        SudokuNode initialNode = new SudokuNode(initialState, null);
        List<SudokuNode> frontier = new ArrayList<SudokuNode>();
        frontier.add(initialNode);
        List<SudokuState> goalPath = new ArrayList<SudokuState>();
    
        // iterate thru states
        while(frontier.isEmpty()!=true){
            SudokuNode curr = frontier.get(0);
            curr.generateChildren();

            for(int i=0, i<4, i++){
                for(int j=0, j<4, i++){
                    if(a[i][j]==0){//at first blank
                    Sudoku
                }
                }
                
            }
            
        }
        
            //generate possible moves, add to children frontier

            // randomly choose a move

        // 


        // fir
    }
}
}
