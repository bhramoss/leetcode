package trees;

public class SegmentTree {

	private void buildSegmentTree(int[] input, int[] segTree, int low, int high, int pos) {

		if (low == high) {
			segTree[pos] = input[low];
			return;
		}
		int mid = (low + high) / 2;
		buildSegmentTree(input, segTree, low, mid, 2 * pos + 1);
		buildSegmentTree(input, segTree, mid + 1, high, 2 * pos + 2);
		segTree[pos] = Math.min(segTree[2 * pos + 1], segTree[2 * pos + 2]);
	}

	public int rangeMinQuery(int[] segTree, int qlow, int qhigh, int low, int high, int pos) {

		// total overlap
		if (qlow <= low && qhigh >= high) {
			return segTree[pos];
		} else if (qlow > high || qhigh < low) {
			return Integer.MAX_VALUE;
		} else {
			int mid = (low + high) / 2;
			return Math.min(rangeMinQuery(segTree, qlow, qhigh, low, mid, 2 * pos + 1),
					rangeMinQuery(segTree, qlow, qhigh, mid + 1, high, 2 * pos + 2));
		}
	}

	private int[] constructSegmentTree(int[] input) {
		int length = input.length;
		int size = 0;
		if (isPowerOf2(length)) {
			size = length * 2 - 1;
		} else {
			size = nextPowerOf2(length) * 2 - 1;
		}
		int[] segmenttree = new int[size];
		buildSegmentTree(input, segmenttree, 0, length - 1, 0);
		return segmenttree;
	}

	// Brian Kernighan’s Algorithm
	private boolean isPowerOf2(int num) {
		int count = 0;
		while (num != 0) {
			num &= num - 1;
			count++;
		}
		return count == 1 ? true : false;
	}

	private int nextPowerOf2(int num) {

		int value = 1;
		while (value <= num) {
			value <<= 1;
		}
		return value;
	}

	public static void main(String[] args) {
		SegmentTree obj = new SegmentTree();
		System.out.println(obj.isPowerOf2(5));
		System.out.println(obj.nextPowerOf2(5));
		int[] input = { -1, 2, 4, 0 };
		int[] result = obj.constructSegmentTree(input);
		System.out.println(obj.rangeMinQuery(result, 1, 2, 0, input.length - 1, 0));
	}
}
