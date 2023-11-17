import java.util.Arrays;
import java.util.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;
import java.util.Random;
import java.util.List;
import java.util.LinkedList;

class PSudokuMain {

    // STACY METHOD HERE
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
        List<SudokuState> explored = new ArrayList<SudokuNode>();
    


        // iterate thru states
                    SudokuNode curr= initialNode;
                        for(int j=0; j<4; i++){
                            for(int k=0; k<4; k++){
                                if(curr.getState().getBoard()[j][k]==0){//finds next blank
                                   // System.out.println("else");
                                  //  List<Integer> newMoves = curr.getState().validAction();//applyvalidaction returns a list, applyihgn this to curr gets new children
                                    //PIPPA COME BACK TO
                                    //PIPPA WORKING HERE
                                    
                                 //   curr.getChildren().addAll(newMoves);//children is now the list of new moves from this state
                                    List<SudokuNodes> childNodes =  curr.generateChildren();
                                    if (childNodes.isEmpty()){
                                        ///BACKTRACK
                                        curr = curr.getParent();//will always work as long as board is solvable
                                    }
                                    else{
                                        for (int n=0; n<childNodes.size(); n++){//if it has options to choose from
                                            if(!explored.contains(childNodes.get(n).getState())){
                                                if(childNode.get(n).getState().isGoal(goalBoard)){
                                                    goalPath.add(childNode.get(n).getState());
                                                    while(curr.parent != null){
                                                        curr = curr.getParent();
                                                        goalPath.add(curr.getState());
                                                    }
                                                    frontier.clear();//ends while loop
                                                    System.out.println(goalPath);
                                                    break; // i think this ends for loop?
                                                }
                                                 else{
                                                      explored.add(curr.getState());
                                                      curr=childNodes.get(n);
                                                        }
                                            }
                                            break;
                                        }
                                        }
                                }    
                            }

                                    
                                 //for random generating
                                 /*  for(int l=0; l<curr.getChildren().size(); l++){
                                        if(curr.getChildren().get(l)==null){
                                            //STACY START HERE!!!
                                            //go back to repository
                                            //trigger stacy code?
                                        }
                                        
                                        */
                                      
                        }
                        
                    
                
             
        
        System.out.println("done");
            //generate possible moves, add to children frontier
            // randomly choose a move
        // 
        // fir
    }
}