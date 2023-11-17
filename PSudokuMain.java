import java.util.Arrays;
import java.util.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;
import java.util.Random;
import java.util.List;
import java.util.LinkedList;

class SudokuMain {
	public static void main (String[]array) {
	    int[][] goalBoard = {
	            {4, 3, 1, 2},
	            {1, 2, 4, 3},
	            {2, 1, 3, 4},
	            {3, 4, 2, 1}
	    };
	    

	    SudokuState initialState = new SudokuState(SudokuState.initalize(goalBoard), 0);
	    initialState.printState();
	    SudokuNode initialNode = new SudokuNode(initialState, null);
	    solve(initialNode, goalBoard);
	    
	    
	    
	    
	        /*// initial game state
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

	        
	        SudokuState initialState = new SudokuState(board,0);
	        SudokuNode initialNode = new SudokuNode(initialState, null);
	        List<SudokuNode> frontier = new ArrayList<SudokuNode>();
	        frontier.add(initialNode);
	        List<SudokuState> goalPath = new ArrayList<SudokuState>();
	        List<SudokuState> explored = new ArrayList<SudokuState>();
	    


	        // iterate thru states
	                    SudokuNode curr= initialNode;
	                        for(int j=0; j<4; j++){
	                            for(int k=0; k<4; k++){
	                                if(curr.getState().getBoard()[j][k]==0){//finds next blank
	                                	
	                                   // System.out.println("else");
	                                  //  List<Integer> newMoves = curr.getState().validAction();//applyvalidaction returns a list, applyihgn this to curr gets new children
	                                    //PIPPA COME BACK TO
	                                    //PIPPA WORKING HERE
	                                    
	                                 //   curr.getChildren().addAll(newMoves);//children is now the list of new moves from this state
	                                	curr.generateChildren();
	                                    List<SudokuNode> childNodes =  curr.getChildren();
	                                    if (childNodes.isEmpty()){
	                                        ///BACKTRACK
	                                    	//SudokuMain.solve(curr);
	                                        curr = curr.getParent();//will always work as long as board is solvable
	                                    }
	                                    else{
	                                        for (int n=0; n<childNodes.size(); n++){//if it has options to choose from
	                                            
	                                        	if(!explored.contains(childNodes.get(n).getState())){
	                                                
	                                        		if(childNodes.get(n).getState().isGoal(goalBoard)){
	                                                    
	                                        			goalPath.add(childNodes.get(n).getState());
	                                                    while(curr.parent != null){
	                                                        curr = curr.getParent();
	                                                        goalPath.add(curr.getState());
	                                                    }
	                                                    
	                                                    frontier.clear();//ends while loop
	                                                    System.out.println(goalPath);
	                                                    break; // i think this ends for loop?
	                                                }
	                                                else {
	                                                      explored.add(curr.getState());
	                                                      curr=childNodes.get(n);
	                                                }
	                                            }
	                                            break;
	                                        }
	                                    }
	                                }    
	                            }      
	                        }

	        System.out.println("done");*/
}  

public static boolean solve(SudokuNode starter, int [][] goalBoard) {

	int[][] b = starter.getState().getBoard();
	if (starter.getState().isGoal(goalBoard)) {
		System.out.println("done");
		return true;
	}
	else {
	SudokuNode curr = starter;
	{
		for(int i=0;i<b.length;i++)
	    {
	        for(int j=0;j<b.length;j++)
	        {
	        	if (b[i][j]==0) {
	        	List<Integer> moves = curr.getState().possibleMoves();
	        	for (Integer move : moves) {
	        		if (curr.getState().isValid(move)) {
	        			b[i][j]=move;
	        			SudokuState nextState = new SudokuState(b, curr.getState().getMoves()+1);
	        			SudokuNode nextNode = new SudokuNode(nextState, curr);
	        			nextState.printState();
	        			if (solve(nextNode, goalBoard)) {
	        				return true;
	        			}
	        			else {
	        				b[i][j]=0;
	        			}
	        		}
	        		}
	        	}
	        	
	        }
	        //return false;
	    }
	}
	return true;
	}
}
}
