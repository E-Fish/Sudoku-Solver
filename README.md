# Sudoku Solver (Recursive Backtracking)

A Java implementation of a 4x4 Sudoku solver built with the classmates Pippa and Stacy. The program generates a random, uniquely solvable puzzle from a fixed solution board, then solves it using a **recursive backtracking algorithm**, printing each intermediate board state along the way.

## How It Works

1. **Puzzle Generation**: Starting from a known solved 4x4 board, `SudokuState.initalize()` randomly clears a fixed number of cells to create a solvable, unsolved puzzle.
2. **State Representation**: Each `SudokuState` object stores the current board, the number of moves made so far, and the logic needed to validate and generate legal moves.
3. **Move Validation**: `isValid()` checks a candidate number against the current row, column, and 2x2 box to confirm it doesn't violate Sudoku rules.
4. **Possible Move Generation**: `possibleMoves()` returns the list of legal numbers (1 through 4) that could be placed in the next empty cell.
5. **Recursive Backtracking**: `SudokuMain.solve()` finds the next empty cell, tries each legal move recursively, and backtracks (resetting the cell to empty) whenever a branch fails to lead to a solution.
6. **Goal Check**: `isGoal()` compares the current board against the original solved board to confirm when the puzzle is complete.
7. **Move Tracking**: Each recursive call prints the board state and the move made, so the full solving process is visible step by step in the console.

## Skills Demonstrated

- **Recursive Backtracking**: Implemented a classic constraint-satisfaction search that tries a move, recurses, and undoes the move if it doesn't lead to a solution.
- **Constraint Validation**: Checked row, column, and box constraints on every candidate move, matching real Sudoku rules.
- **Object-Oriented Design**: Split puzzle state (`SudokuState`), search tree structure (`SudokuNode`), and program execution (`SudokuMain`) into distinct classes.
- **2D Array Manipulation**: Deep-copied and mutated board state safely across recursive calls to avoid corrupting earlier search branches.
- **Randomized Puzzle Generation**: Used randomization to produce a new, unique starting puzzle on every run.
- **Team Collaboration**: Built and debugged collaboratively with two other developers, including exploring an alternate frontier-based search approach alongside the final backtracking solution.

## Running the Program

```
javac SudokuNode.java SudokuState.java SudokuMain.java
java SudokuMain
```

The program prints a randomly generated unsolved 4x4 board, then solves it, printing each move and the resulting board state until the puzzle is complete.

## Example Output

```
Initial unique board:
4 3 | 1 2 
1 2 | 4 3 
---------
2 1 | 3 4 
3 4 | 2 1 

4 3 | 1 2 
1 2 | 4 3 
---------
2 1 | 3 4 
3 4 | 2 1 

Move made: 4  Total moves: 1

...

Board solved!
```

## Notes

This project also includes a second, in-progress solving approach (frontier-based search using `SudokuNode.generateChildren()`) that was explored during development but not used in the final solution. It's left commented out in `SudokuMain.java` to preserve that work.
