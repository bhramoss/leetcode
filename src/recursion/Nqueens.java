package recursion;

import java.util.ArrayList;
import java.util.List;

public class Nqueens {

    public List<List<String>> solveNQueens(int n) {
		int[] rows = new int[n];
		int[] columns = new int[n];
		List<List<String>> result = new ArrayList<>();
		solveNQueensUtil(n, 0, rows, columns, result);
		return result;
    }

	private void solveNQueensUtil(int n, int row, int rows[], int columns[], List<List<String>> result) {

		if (n == row) {
			StringBuilder builder = new StringBuilder();
			List<String> tempRes = new ArrayList<>();
			for(int i = 0; i < n; i ++){
				for(int j = 0; j < n; j++){
					if(columns[i] == j){
						builder.append("Q");						
					}else{
						builder.append(".");
					}
				}
			tempRes.add(builder.toString());
			builder = new StringBuilder();
			}
			result.add(tempRes);
			return;
		}

		for (int col = 0; col < n; col++) {

			boolean found = true;
			for (int queen = 0; queen < row; queen++) {
				if (columns[queen] == col || rows[queen]+ columns[queen]== row + col
						|| rows[queen]- columns[queen]== row - col) {
					found = false;
					break;
				}
			}
			if (found) {
				columns[row] = col;
				rows[row] = row;
				solveNQueensUtil(n, row + 1, rows,columns, result);
			}
		}
	}

	public boolean solveNQueensMethod2(int n) {

		Position position[] = new Position[n];

		if (solveUtilMethod2(n, 0, position)) {
			return true;
		}
		return false;
	}

	private boolean solveUtilMethod2(int n, int row, Position[] position) {

		if (n == row) {
			return true;
		}

		for (int col = 0; col < n; col++) {

			boolean found = true;

			for (int queen = 0; queen < row; queen++) {

				if (position[queen].column == col || position[queen].row - position[queen].column == row - col
						|| position[queen].row + position[queen].column == row + col) {
					found = false;
					break;
				}
			}
			if (found) {
				position[row] = new Position(row, col);
				if (solveUtilMethod2(n, row + 1, position)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {

		Nqueens obj = new Nqueens();

		List<List<String>> result = (obj.solveNQueens(4));
		for(List<String> list : result){
			System.out.println(list);
		}
	}

	class Position {

		int row;
		int column;

		public Position() {

		}

		public Position(int row, int column) {
			this.row = row;
			this.column = column;
		}
	}
}
