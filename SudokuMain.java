package code;

	import java.util.ArrayList;
	import java.util.Stack;
	import java.util.List;
	

	class SudokuMain {

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
	        Stack<SudokuState> goalPath = new Stack<SudokuState>();
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
	                                    	System.out.println("none");
	                                        curr = curr.getParent();//will always work as long as board is solvable
	                                    }
	                                    else{
	                                       for(SudokuNode move: childNodes){//if it has options to choose from
	                                    	   {
	                                            if(!explored.contains(move.getState())){
	                                                if(move.getState().isGoal(goalBoard)){
	                                                    goalPath.add(move.getState());
	                                                    while(curr.parent != null) {
	                                                        goalPath.add(curr.getState());
	                                                        curr = curr.getParent();
	                                                    }
	                                                    frontier.clear();//ends while loop
	                                                    break; // i think this ends for loop?
	                                                }
	                                                 else{
	                                                      explored.add(curr.getState());
	                                                      curr=move;
	                                                        }
	                                            }
	                                            break;
	                                        }
	                                        }
	                                }    
	                            }
	                           while(!goalPath.isEmpty()) {
	                        	   goalPath.pop().printState();
	                           }
	                	     
	                        }
	                           
	                        }
	                        System.out.println("done");
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
	                                      
	                        
	        
	            //generate possible moves, add to children frontier
	            // randomly choose a move
	        
	/* public static boolean solve(SudokuNode starter) {
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
 		        	curr.generateChildren();
 		        	List<SudokuNode> next = curr.getChildren();
 		        	for (SudokuNode move :next) {
 		        		if (move.)
 		        	}

 		    }
 		}
 		return true;
 		}
     }
 
    public static void main (String[]args){
 
        // initial game state
          int [][] board = { // [row][column]
            {4,0,1,0},
            {0,2,0,0},
            {0,0,3,0},
            {0,0,0,1}
            };

        //goal state
       /* int [][] goalBoard = {
            {4,3,1,2},
            {1,2,4,3},
            {2,1,3,4},
            {3,4,2,1}
            };*/
   /*     SudokuState initialState = new SudokuState(board, 0);
        SudokuNode initialNode = new SudokuNode(initialState, null);
        initialState.printState();
        initialNode.generateChildren();
        if (solve(initialNode)!=true)
        	{
        	System.out.println("done");
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