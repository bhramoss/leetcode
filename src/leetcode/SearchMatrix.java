package leetcode;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix == null ) return false;
        int rows = matrix.length;
        if(rows == 0) return false; 
        int columns = matrix[0].length;
        if(columns == 0) return false;
        for(int i = 0; i < rows; i++){
            if(matrix[i][columns-1] >= target){
                if(binarySearch(matrix[i],0,columns,target) != -1){
                    return true;
                }else{
                    return false;
                }
            }else{
                continue;
            }
        }
        return false;
    }
    
    private int binarySearch(int input[], int low, int high, int target){
        
        while(low < high){
            
            int mid = low + ( high-low)/2;
            if(input[mid] == target){
                return mid;
            }
            if(target < input[mid]){
                return binarySearch(input, low, mid, target);
            }else if(target > input[mid]){
                return binarySearch(input, mid+1, high, target);
            }
        }
        return -1;
    }
    
    public static void main(String[] args){
    	
    	SearchMatrix obj = new SearchMatrix();
    	int input[][] = {{1}};
    	System.out.println(obj.searchMatrix(input, 5));
    }
}