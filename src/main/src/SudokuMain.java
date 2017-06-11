/**
 * Created by ckyoung on 14-Apr-17.
 */
public class SudokuMain {
    public static void main(String[] args) {
        String seed = "000820090500000000308040007100000040006402503000090010093004000004035200000700900";

        for (int i = 0; i < args.length; i++) {
            if (args[i] != null) {
                seed = args[i];
            }
        }

        Sudoku sudoku = new Sudoku(seed);

        System.out.println("Problem to be solved:");
        sudoku.print();
        long timeStart = System.currentTimeMillis();
        boolean SudokuSolved = sudoku.solve(0, 0);
        long timeStop = System.currentTimeMillis();
        if(SudokuSolved == true) {
            float timeExpired = (timeStop - timeStart) / 1000F;
            System.out.println("Problem solved in " + timeExpired + " seconds");
            sudoku.print();
        } else {
            System.out.println("Error. Sudoku may be unsolvable.");
        }
    }
}
