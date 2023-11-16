import java.util.Arrays;
import java.util.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;
import java.util.Random;
import java.util.List;
import java.util.LinkedList;

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
        
        SudokuState initialState = new SudokuState(board,0);
        SudokuNode initialNode = new SudokuNode(initialState, null);
        List<SudokuNode> frontier = new ArrayList<SudokuNode>();
        frontier.add(initialNode);
        List<SudokuState> goalPath = new ArrayList<SudokuState>();
    
        // iterate thru states
        while(frontier.isEmpty()!=true){
            System.out.println("while");
            for(int i=0; i<frontier.size(); i++){//for each node in frontier
                 SudokuNode curr = frontier.get(i);
                 //iterate through its array, find next blank, come up with moves, chose move
                    if(curr.getState().getBoard() == goalBoard){
                        System.out.print("if");
                        goalPath.add(curr.getState());
                        while(curr.parent != null){
                            curr = curr.getParent();
                            goalPath.add(curr.getState());
                        }
                        frontier.clear();//ends while loop
                        System.out.println(goalPath);
                        break; // i think this ends for loop?
                    }
                    else{ 
                        for(int j=0; j<4; i++){
                            for(int k=0; k<4; k++){
                                if(curr.getState().getBoard()[i][j]==0){
                                    System.out.println("else");
                                  //  List<Integer> newMoves = curr.getState().validAction();//applyvalidaction returns a list, applyihgn this to curr gets new children
                                    //PIPPA COME BACK TO
                                    //PIPPA WORKING HERE
                                    curr.generateChildren();
                                 //   curr.getChildren().addAll(newMoves);//children is now the list of new moves from this state
                                    for(int l=0; l<curr.getChildren().size(); l++){
                                        if(curr.getChildren().get(l)==null){
                                            //go back to repository
                                            //trigger stacy code?
                                        }
                                        else{
                                            Random random = new Random();
                                            int randomIndex = random.nextInt(curr.getChildren().size());
                                            SudokuNode randomNode = curr.getChildren().get(randomIndex);//children is a list of nodes
                                          //  int[][] newBoard= board.clone();
                                          //  newBoard[i][j] = randomNode;

                                          //  SudokuState newState = new SudokuState(newBoard,curr.getState().getMoves()+1);
                                          //  SudokuNode newNode = new SudokuNode(newState, curr);
                                            frontier.add(randomNode);
                                        }
                                    }
                                }
                            }
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