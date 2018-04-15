/**
  Determine the boolean value of the statement 
  "it is possible to get from the starting position to the treasure"
  using recursive backtracking.
 */

public class MazeSolver {
    private Maze maze;
    private boolean solution;
    private Displayer displayer;
    
    private static final int[] DIRECTIONS = {Maze.EAST, Maze.SOUTH, Maze.WEST, Maze.NORTH};

    public MazeSolver(Maze mazeToBeSolved, int windowHeight) {
	maze = mazeToBeSolved;
	displayer = new Displayer(windowHeight);
	displayer.atTopOfWindow("solving maze:" + System.lineSeparator() + maze);
	solution = solveMaze();
    }

    private boolean solveMaze() {
		    
	if (maze.explorerIsOnA() == Maze.TREASURE)
	    return true;
	else if (maze.explorerIsOnA() == Maze.WALL)
	    return false;
	else {
		
	    Maze snapshot = new Maze(maze);
	    for (int direction : DIRECTIONS) {
		    
		maze.dropA(Maze.WALL);
		maze.go(direction); 
		displayer.atTopOfWindow(maze.toString());
		if (solveMaze())
		    return true;
		maze = new Maze(snapshot);
		displayer.atTopOfWindow(maze.toString());
		    
	    }

	    return false;
	}
    }

    public String toString() {
	if (solution)
	    return "A solution exists";
	else 
	    return "no solution";
    }
}
