package code;

import java.util.LinkedList;
import java.util.List;

class SudokuMain {

	/* public boolean solve(SudokuNode starter) {
		 int [][] goalBoard = {
		            {4,3,1,2},
		            {1,2,4,3},
		            {2,1,3,4},
		            {3,4,2,1}
		            };
     	int[][] b= starter.getState().getBoard();
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
 		        	List<Integer> moves = curr.getState().applyValidAction();
 		        	for (Integer move: moves) {
 		        		if (curr.getState().isValid(move)) {
 		        			b[i][j]=move;
 		        			SudokuState nextS = new SudokuState(b, curr.getState().getMoves()+1);
 		        			SudokuNode nextN = new SudokuNode(nextS, curr);
 		        			if (solve(nextN)) {
 		        				return true;
 		        			}
 		        			else {
 		        				b[i][j]=0;
 		        			}
 		        		}
 		        		}
 		        	}
 		        	
 		        }
 		        	return false;
 		    }
 		}
 		return true;
 		}
     }*/
    public static void main (String[]args){
 
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
        SudokuState initialState = new SudokuState(board, 0);
        SudokuNode initialNode = new SudokuNode(initialState, null);
        initialState.printState();
        initialNode.generateChildren();
        for (SudokuNode child: initialNode.getChildren())
        {
        	child.getState().printState();
        	child.generateChildren();
        	  for (SudokuNode next: child.getChildren())
              {
        		  next.getState().printState();
        		  next.generateChildren();
        		  for (SudokuNode small: next.getChildren())
        	        {
        			  small.getState().printState();
        			  small.generateChildren();
        			  for (SudokuNode orange: small.getChildren())
          	        {
        				  orange.getState().printState();
          	        }
        	        }
              }
        	}
        }
    }


        /*initialState.initalize(goalBoard);
        

     
       /* Queue<SudokuNode> frontier = new LinkedList<>(); 
        frontier.add(initialNode);
		SudokuNode goal=null;
		Stack<SudokuState> path = new Stack<SudokuState>();
		SudokuNode curr;
        while (goal==null) { 
			 if (frontier.isEmpty()) { 
				 break;
			 }
			curr = frontier.poll();
			List<Integer> moves = curr.getState().applyValidAction(); 
				for (Integer move : moves) 
				{
					if (curr.getState().isGoal(goalBoard)) 
					 {
						 goal=current;
						 break;
					 }
					 else {
						curr.getState().applyValidAction();
						frontier.add(curr);
					 }
				}
			 }*/
        // iterate thru states
       /* while(frontier.isEmpty()!=true){
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
                                    List<Integer> newMoves = curr.getState().applyValidAction();//applyvalidaction returns a list, applyihgn this to curr gets new children
                                    children.addAll(newMoves);//children is now the list of new moves from this state
                                    for(int l=0; l<children.length(); l++){
                                        if(children.get(l)==null){
                                          curr.getParent();
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
        }*/