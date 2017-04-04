package trees;

public class SegmentTree {

	private void buildTree(int[] input, int[] segTree, int low, int high, int pos){
		
		if( low == high) {
			segTree[pos] = input[low];
			return;
		}
		int mid = (low + high)/2;
		buildTree(input,segTree,low,mid,2*pos+1);
		buildTree(input,segTree,mid+1,high,2*pos+2);
		segTree[pos] = Math.min(segTree[2*pos+1], segTree[2*pos+2]);
		
	}
	
	private int[] constructSegmentTree(int input[]){
		
		int treeSize = 0;
		int inputSize = input.length;
		if(!isPowerOf2(inputSize)){
			treeSize = nextPowerOfTwo(inputSize)*2-1;
		}else{
			treeSize = inputSize*2-1;
		}
		
		int segTree[] = new int[treeSize];
		
		for(int i = 0; i < treeSize; i++){
			segTree[i] = Integer.MAX_VALUE;
		}
		
		buildTree(input, segTree, 0, inputSize-1, 0);
		return segTree;
	}
	
	
	private boolean isPowerOf2(int size){
		
		int count = 0;
		
		// counts the number of bits that are set. Brian Kernighan’s Algorithm
		while(size != 0){
			
			size &= (size-1); 
			count++;
		}
		if(count == 1) return true;
		else
			return false;
		
	}
	
	private int nextPowerOfTwo(int number){
		
		int value = 1;
		
		while(value <= number){
			
			value = value << 1;
		}
		return value;
	}
	
	public static void main(String args[]){
		
		SegmentTree obj = new SegmentTree();
		int [] input = {-1,0,3,6};
		int [] seg = obj.constructSegmentTree(input);
		
		for(int i = 0; i < seg.length; i++){
			
			System.out.print(seg[i] + " ");
		}
	}
}
