public class QuestionNine {

  public static int numIslands(char[][] grid) {
    int islands = 0;
    for(int i = 0; i < grid.length;i++){
      for(int j = 0; j < grid[0].length;j++){
        if(grid[i][j] == '1'){//if an island
          islandCleaner(grid, i, j);//mark rest of island as visited
          islands++;
        }
      }
    }
    return islands;
  }

  private static void islandCleaner(char[][] grid, int row, int column){
    if(!(0 <= row && row < grid.length) || !(0 <= column && column < grid[0].length) || grid[row][column] == '0'){
      return; //boundary conditions violated of piece of water.
    }
    grid[row][column] = '0'; //clean current cell
    islandCleaner(grid, row + 1, column); //look to clean cell above
    islandCleaner(grid, row - 1, column); //look to clean cell below
    islandCleaner(grid, row, column + 1); // look to clean cell right
    islandCleaner(grid, row, column - 1); // look to clean cell left
  }




















}
