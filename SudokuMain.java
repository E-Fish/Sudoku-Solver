import java.util.Arrays;
import java.util.*;
import java.util.Queue;
import java.util.Random;

class PSudokuMain {
    public static void main (String[]array){
        // initial game state
          int [][] board = { // [row][column]
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
        
        SudokuState initialState = new SudokuState(board, 0);
        SudokuNode initialNode = new SudokuNode(initialState, null);
        List<SudokuNode> frontier = new ArrayList<SudokuNode>();
        frontier.add(initialNode);
        List<SudokuState> goalPath = new ArrayList<SudokuState>();
    
        // iterate thru states
        while(frontier.isEmpty()!=true){
            for(int i=0; i<frontier.size()-1; i++){//for each node in frontier
                 SudokuNode curr = frontier.get(i);
                 //iterate through its array, find next blank, come up with moves, chose move
                    if(curr.board.isGoal(curr)){
                        goalPath.add(curr);
                        while(curr.parent != null){
                            curr = curr.p;
                            goalPath.add(curr.s);
                        }
                        frontier.clear();//ends while loop
                        System.out.println(goalPath);
                        break; // i think this ends for loop?
                    }
                    else{ 
                        for(int j=0; j<4; i++){
                            for(int k=0; k<4; k++){
                                if(curr.board[i][j]==0){
                                    List newMoves = curr.ApplyValidAction();//applyvalidaction returns a list, applyihgn this to curr gets new children
                                    children.addAll(newMoves);//children is now the list of new moves from this state
                                    for(int l=0; l<children.length(); l++){
                                        if(children.get(l)==null){
                                            //go back to repository
                                            //trigger stacy code?
                                        }
                                        else{
                                            Random random = new Random();
                                            int randomElement = children.get(random.nextInt(children.size()));
                                            int[][] newBoard = board.clone();
                                            newBoard[i][j] = randomElement;

                                            PSudokuState newState = new PSudokuState(newBoard,moves+1);
                                            PSudokuNode newNode = new PSudokuNode(newState, curr);
                                            frontier.add(newNode);
                                        }
                                    }
                                }
                            }
                        }
                    }
            }    
        }
    }
}
