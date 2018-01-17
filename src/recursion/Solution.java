package recursion;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public List<List<String>> NQueen(int n){
		
		int[] rows = new int[n];
		int[] columns = new int[n];
		List<List<String>> result = new ArrayList<>();
		backtrack(result, rows, columns, 0, n);
		return result;
	}
	
	private void backtrack(List<List<String>> list, int[] rows, int[] columns, int row, int n){
		
		if(row == n){
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
			list.add(tempRes);
			return;
		}
		
		for(int column = 0; column < n; column++){
			boolean found = true;
			for(int queen = 0; queen < row; queen++){
				if(rows[queen] == row || columns[queen] == column || row-column == rows[queen]-columns[queen] || row+column == rows[queen]+columns[queen]){
					found = false;
					break;
				}
			}
			if(found){
				rows[row] = row;
				columns[row] = column;
				backtrack(list, rows, columns, row+1, n);
			}
		}
	}
	public static void main(String[] args) {

		Solution obj = new Solution();

		List<List<String>> result = (obj.NQueen(4));
		for(List<String> list : result){
			System.out.println(list);
		}
	}

}
