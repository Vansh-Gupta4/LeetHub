class Solution {
  public int uniquePaths(int m, int n) {

	return uniquePathsTopDownDP(0, 0, m, n, new int[m][n]);
}

private int uniquePathsTopDownDP(int currRow, int currCol, int m, int n, int[][] storage) {

	if (currRow == m - 1 && currCol == n - 1) {
		return 1;
	}

	if (currRow >= m || currCol >= n) {
		return 0;
	}

	if (storage[currRow][currCol] != 0) {
		return storage[currRow][currCol];
	}

	int moveDownCounts = uniquePathsTopDownDP(currRow + 1, currCol, m, n, storage);

	int moveRightCounts = uniquePathsTopDownDP(currRow, currCol + 1, m, n, storage);

	int totalCounts = moveDownCounts + moveRightCounts;

	storage[currRow][currCol] = totalCounts;

	return totalCounts;
}
}