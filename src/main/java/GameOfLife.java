public class GameOfLife {
    private final double initialProbabilityOfBeingAlive = 0.5;
    private final int rowCount;
    private final int columnCount;
    private boolean[][] grid;

    public int getColumnCount() {
        return columnCount;
    }

    public int getRowCount() {
        return rowCount;
    }

    public boolean getCell(int i, int j) {
        return grid[i][j];
    }

    public GameOfLife(int columnCount, int rowCount) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;

        grid = new boolean[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                grid[i][j] = Math.random() < initialProbabilityOfBeingAlive;
            }
        }
    }

    public int boolToInt(boolean b) {
        return (b) ? 1 : 0;
    }

    private int col_up(int col) {
        return (col + 1 >= this.getColumnCount()) ? 0 : col + 1;
    }

    private int col_dn(int col) {
        return (col - 1 < 0) ? grid[0].length - 1 : col - 1;
    }

    private int row_up(int row) {
        return (row + 1 >= this.getRowCount()) ? 0 : row + 1;
    }

    private int row_dn(int row) {
        return (row - 1 < 0) ? grid.length - 1 : row - 1;
    }

    public void updateGameOfLife() {
        boolean[][] newGrid = new boolean[this.rowCount][this.columnCount];

        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < columnCount; col++) {
                int sumAliveNeighbors = boolToInt(grid[row_up(row)][col_dn(col)])
                        + boolToInt(grid[row_up(row)][col])
                        + boolToInt(grid[row_up(row)][col_up(col)])
                        + boolToInt(grid[row][col_dn(col)])
                        + boolToInt(grid[row][col_up(col)])
                        + boolToInt(grid[row_dn(row)][col_dn(col)])
                        + boolToInt(grid[row_dn(row)][col])
                        + boolToInt(grid[row_dn(row)][col_up(col)]);

                // Rule 1: Any live cell with two or three live neighbours survives.
                if (grid[row][col] && (sumAliveNeighbors == 2 || sumAliveNeighbors == 3)) {
                    newGrid[row][col] = true;
                } else {
                    // Rule 2: Any dead cell with three live neighbours becomes a live cell.
                    // Rule 3: All other live cells die in the next generation. Similarly,
                    // all other dead cells stay dead.
                    newGrid[row][col] = !grid[row][col] && sumAliveNeighbors == 3;
                }
            }
        }
        grid = newGrid;
    }
}
