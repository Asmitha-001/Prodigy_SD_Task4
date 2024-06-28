class task_4
{
    static int[][] Sudoku=
    {
        {9, 5, 6, 2, 0, 0, 0, 0, 0},
        {0, 0, 0, 9, 7, 3, 0, 0, 0},
        {8, 0, 7, 0, 5, 0, 2, 4, 0},
        {0, 8, 4, 0, 2, 5, 6, 0, 3},
        {0, 0, 0, 0, 8, 7, 0, 0, 0},
        {3, 1, 2, 0, 0, 0, 0, 0, 8},
        {0, 0, 0, 0, 0, 0, 9, 8, 0},
        {0, 0, 8, 7, 0, 0, 0, 1, 2},
        {0, 4, 9, 8, 3, 2, 7, 5, 6}
    };
    static void sudoku()
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                System.out.print(" "+Sudoku[i][j]);
            }
            System.out.println(" ");
        }
    }
    static void solvegame() 
    {
        int row = 0, col = 0;
        boolean empty = false;
        for (row = 0; row < 9; row++) 
        {
            for (col = 0; col < 9; col++) 
            {
                if (Sudoku[row][col] == 0) 
                {
                    empty = true;
                    break;
                }
            }
            if (empty) 
            {
                break;
            }
        }
        if (!empty) 
        {
            sudoku();
            return;
        }
        for (int n = 1; n <= 9; n++) 
        {
            if (num(row, col, n)) 
            {
                Sudoku[row][col] = n;
                solvegame();
                Sudoku[row][col] = 0;
            }
        }
    }
    static boolean num(int row, int col, int n) 
    {
        for(int i=0;i<9;i++) 
        {
            if(Sudoku[row][i]==n) 
            {
                return false;
            }
        }
        for(int i=0;i<9;i++) 
        {
            if(Sudoku[i][col]==n) 
            {
                return false;
            }
        }
        int startingrow = row-row%3;
        int startingcol = col-col%3;
        for(int i=startingrow;i<startingrow+3;i++) 
        {
            for(int j=startingcol;j<startingcol+3;j++) 
            {
                if (Sudoku[i][j]==n) 
                {
                    return false;
                }
            }
        }
        return true;
    }
        public static void main(String args[])
    {
        System.out.println("Sudoku puzzle (Before Solving)= ");
        sudoku();
        System.out.println("Solving in progress...");
        System.out.println("Sudoku puzzle (After Solving):");
        solvegame();
    }
}
