public class main {
    //  Helper functions
    //  Matrix multiplication Function
    //  Precondition:   firstMatrix and secondMatrix are 2D integer array that represents
    //                  the two matrices we want to multiply
    //  Postcondition:  We return the multiplication of both matrices (2D Integer arrays)
    public static int[][] multiplyMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        int[][] result = new int[firstMatrix.length][secondMatrix[0].length];

        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                int cell = 0;
                for (int i = 0; i < secondMatrix.length; i++) {
                    cell += firstMatrix[row][i] * secondMatrix[i][col];
                }
                result[row][col] = cell;
            }
        }

        return result;
    }
    //  Copy Function
    //  Precondition:   adj is a 2D integer array that represents an adjacency matrix
    //  Postcondition:  We return temp which is a 2D Integer array that holds the same
    //                  values adj has.
    public static int[][] copy(int[][] adj){
        int[][] temp = new int[adj.length][adj[0].length];

        for(int i = 0; i<adj.length; i++){
            for(int j = 0; j < adj[0].length; j++){
                temp[i][j] = adj[i][j];
            }
        }

        return temp;
    }
    //  Matrix Printer Function
    //  Precondition:   matrix is a 2D integer array that represents an adjacency matrix
    //  Postcondition:  We print the contents of the matrix
    public static void printMatrix(int[][] matrix){
        for(int r = 0; r < matrix.length; r++){
            for(int c = 0; c < matrix[0].length; c++){
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
    //  Get Reachability Matrix Function
    //  Precondition:   adj is a 2D integer array that represents an adjacency matrix
    //  Postcondition:  We return the reachability matrix calculated by adding up the
    //                  temp matrix throughout the loop
    public static int[][] getReachability(int[][] adj){
        int[][] temp = copy(adj);
        int[][] reach = copy(adj);

        for(int i = 1; i < adj.length; i++){
            temp = multiplyMatrices(adj, temp);

            for(int r = 0; r < temp.length; r++){
                for(int c = 0; c < temp[0].length; c++){
                    reach[r][c] += temp[r][c];
                }
            }
        }

        return reach;
    }
    //  Get LengthN (LN) Matrix Function
    //  Precondition:   adj is a 2D integer array that represents an adjacency matrix
    //  Postcondition:  We return the matrix containing the adjacency matrix of Length N
    public static int[][] getLengthN(int[][] adj){
        int[][] temp = copy(adj);

        for(int i = 1; i < adj.length; i++){
            temp = multiplyMatrices(adj, temp);
        }

        return temp;
    }
    //  Get Path Function
    //  Precondition:   adj is a 2D integer array that represents an adjacency matrix
    //  Postcondition:  We return the sum of the numbers in adj matrix
    public static int getPath(int[][] matrix){
        int sum = 0;

        for(int r = 0; r < matrix.length; r++){
            for(int c = 0; c < matrix[0].length; c++){
                sum += matrix[r][c];
            }
        }

        return sum;
    }
    //  Get Cycles Function
    //  Precondition:   adj is a 2D integer array that represents an adjacency matrix
    //  Postcondition:  We return the sum of the cycles (diagonal) numbers in adj matrix
    public static int getCycle(int[][] matrix){
        int sum = 0;

        for(int i = 0; i < matrix.length; i++){
            sum += matrix[i][i];
        }

        return sum;
    }

    //  Functions
    //  Print Input Matrix
    //  Precondition:   adj is a 2D integer array that represents an adjacency matrix
    //  Postcondition:  We print the content of adj
    public static void printInputMatrix(int[][] adj){
        System.out.println("Input Matrix:");
        printMatrix(adj);
        System.out.println();
    }
    //  Print Reachability Matrix
    //  Precondition:   adj is a 2D integer array that represents an adjacency matrix
    //  Postcondition:  We print the content of the reachability matrix
    public static void printReach(int[][] adj){
        int[][] reach = getReachability(adj);
        System.out.println("Reachability Matrix:");
        printMatrix(reach);
        System.out.println();
    }
    //  Print In-Degrees
    //  Precondition:   adj is a 2D integer array that represents an adjacency matrix
    //  Postcondition:  We print the In-degree of each node in adj
    public static void inDegrees(int[][] adj){
        System.out.println("In-degrees:");
        for(int c = 0; c < adj.length; c++){
            int sum = 0;
            for(int r = 0; r < adj.length; r++){
                sum += adj[r][c];
            }
            System.out.println("Node " + (c + 1) + " in-degree is " + sum);
        }
        System.out.println();
    }
    //  Print Out-Degrees
    //  Precondition:   adj is a 2D integer array that represents an adjacency matrix
    //  Postcondition:  We print the Out-degrees of each node in adj
    public static void outDegrees(int[][] adj){
        System.out.println("Out-degrees:");
        for(int r = 0; r < adj.length; r++){
            int sum = 0;
            for(int c = 0; c < adj.length; c++){
                sum += adj[r][c];
            }
            System.out.println("Node " + (r + 1) + " in-degree is " + sum);
        }
        System.out.println();
    }
    //  Print total number of loops
    //  Precondition:   adj is a 2D integer array that represents an adjacency matrix
    //  Postcondition:  We print the number of cycles in adj
    public static void totalLoop(int[][] adj){
        int sum = getCycle(adj);

        System.out.println("Total number of self-loops: " + sum);
    }
    //  Print total number of cycles of Length N
    //  Precondition:   adj is a 2D integer array that represents an adjacency matrix
    //  Postcondition:  We print the total number of cycles in the adjacency matrix of Length N
    public static void totalCyclesN(int[][] adj){
        int[][] lengthN = getLengthN(adj);
        int sum = getCycle(lengthN);

        System.out.println("Total number of cycles of length " + adj.length + " edges: " + sum);
    }
    //  Print total number of paths of Length 1
    //  Precondition:   adj is a 2D integer array that represents an adjacency matrix
    //  Postcondition:  We print the total number of paths in the adjacency matrix of Length 1
    public static void totalPathsOne(int[][] adj){
        int sum = getPath(adj);

        System.out.println("Total number of paths of length 1 edges: " + sum);
    }
    //  Print total number of paths of Length N
    //  Precondition:   adj is a 2D integer array that represents an adjacency matrix
    //  Postcondition:  We print the total number of paths in the adjacency matrix of Length N
    public static void totalPathsN(int[][] adj){
        int[][] lengthN = getLengthN(adj);
        int sum = getPath(lengthN);

        System.out.println("Total number of paths of length " + adj.length + " edges: " + sum);
    }
    //  Print total number of paths of Length 1 to N
    //  Precondition:   adj is a 2D integer array that represents an adjacency matrix
    //  Postcondition:  We print the total number of paths in the adjacency matrix of Length 1 to Length N
    public static void totalPathsOneToN(int[][] adj){
        int[][] reach = getReachability(adj);
        int sum = getPath(reach);

        System.out.println("Total number of paths of length 1 to " + reach.length + " edges: " + sum);
    }
    //  Print total number of cycles of Length 1 to N
    //  Precondition:   adj is a 2D integer array that represents an adjacency matrix
    //  Postcondition:  We print the total number of cycles in the adjacency matrix of Length 1 to Length N
    public static void totalCycleOneToN(int[][] adj){
        int[][] reach = getReachability(adj);
        int sum = getCycle(reach);

        System.out.println("Total number of cycles of length 1 to " + reach.length + " edges: " + sum);
    }

    public static void main(String[] args) {
        //  Insert adjacency matrix
        int[][] adj = {
                {0, 1, 1},
                {1, 0, 0},
                {0, 1, 0}
        };

        printInputMatrix(adj);
        printReach(adj);
        inDegrees(adj);
        outDegrees(adj);
        totalLoop(adj);
        totalCyclesN(adj);
        totalPathsOne(adj);
        totalPathsN(adj);
        totalPathsOneToN(adj);
        totalCycleOneToN(adj);
    }
}
