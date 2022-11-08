package longestPalindromeSubseq;

public class Solution {
	public int longestPalindromeSubseq(String s) {
		int n = s.length();
		int[][] d = new int[n][n];
		
		for(int i = 0; i < n; i++)
			d[i][i] = 1;
		
		for(int k = 1; k < n ; k++) {
			for(int i = 0; i < n - k; i++) {
				int j = i + k;
				if(s.charAt(i) == s.charAt(j)) {
					d[i][j] = 2 + d[i+1][j-1];
				}
				else {
					d[i][j] = Math.max(d[i+1][j], d[i][j-1]);
				}
			}
		}
		
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < n; j++)
//				System.out.println(d[i][j]);
//			System.out.println();
//		}
		
        return d[0][n - 1];
    }
}
