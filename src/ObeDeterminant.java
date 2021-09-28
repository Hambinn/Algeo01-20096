public class ObeDeterminant {
    static float detPower(int b, int ex){
        float result = 1;
        while (ex != 0){
            result *= b;
            ex -= 1;
        }
        return result;
    }

    static float determinant(float[][] M){
        int switchCount = 0;
        float det;
        for (int d = 0; d < M.length - 1; d++){
            if (M[d][d] == 0){
                switchCount += 1;
                GaussElimination.switchRow(M, d);
            }
            for (int r = 1 + d; r < M.length; r++){
                GaussElimination.rowOperation(M, r, d, d);
            }
        }

        float diagonalMult = 1;
        for (int d = 0; d < M.length; d++){
            diagonalMult *= M[d][d];
        }
        det = detPower(-1, switchCount) * diagonalMult;
        return det;
    }
}
