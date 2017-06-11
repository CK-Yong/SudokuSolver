/**
 * Created by ckyoung on 14-Apr-17.
 */
public class Sudoku {
    String seed;
    int[][] seedArray;

    public Sudoku(String InputtedSeed) {
        seed = InputtedSeed;
        seedArray = new int[9][9];
        generateSolutionSpace();
    }

    public void generateSolutionSpace() {
        char[] charSeed = seed.toCharArray();
        int j = 0;
        for (int i = 0; i < seed.length(); i++) {
            if (i % 9 == 0 && i != 0) {
                j++;
            }
            seedArray[j][i % 9] = Character.getNumericValue(charSeed[i]);
        }
    }

    public boolean solve(int row, int column) {
        int nextRow = row;
        int nextColumn = column + 1;
        if (nextColumn > 8) {
            nextColumn = 0;
            nextRow++;
        }
        if (seedArray[row][column] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (isLegal(i, row, column)) {
                    seedArray[row][column] = i;
                    if (nextRow >= 9) {
                        return true;
                    }
                    if (solve(nextRow, nextColumn)) {
                        return true;
                    } else {
                        seedArray[row][column] = 0;
                    }
                }
            }
            return false;
        } else {
            return solve(nextRow, nextColumn);
        }
    }

    private boolean isLegal(int value, int row, int column) {
        for (int i = 0; i < seedArray.length; i++) {
            if (seedArray[row][i] == value) {
                return false;
            }
        }
        for (int i = 0; i < seedArray.length; i++) {
            if (seedArray[i][column] == value) {
                return false;
            }
        }
        if (checkBox(value, row, column)) {
            return false;
        }
        return true;
    }

    private boolean checkBox(int value, int row, int column) {
        for (int j = (row / 3) * 3; j < (row / 3) * 3 + 3; j++) {
            for (int i = (column / 3) * 3; i < (column / 3) * 3 + 3; i++) {
                if (seedArray[j][i] == value) {
                    return true;
                }
            }
        }
        return false;
    }

    public void print() {
        for (int i = 0; i < seedArray.length; i++) {
            if (i == 0) {
                System.out.println(" --- --- --- --- --- --- --- --- --- ");
            }
            for (int j = 0; j < seedArray.length; j++) {
                if (j == 0) {
                    System.out.print("| ");
                }

                if (seedArray[i][j] != 0) {
                    System.out.print(seedArray[i][j]);
                } else {
                    System.out.print(" ");
                }
                System.out.print(" | ");
            }
            System.out.println();
            System.out.println(" --- --- --- --- --- --- --- --- --- ");
        }
    }
}
