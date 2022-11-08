package longestPalindrome;

public class Solution {
	
	/*
	 * 동적 프로그래밍을 활용하여 해결
	 * d[i][j] = s[i]부터 s[j]까지 팰린드롬인지(맞으면 1, 아니면 0)
	 * 작업을 완료한 후, i-j 값이 가장 크고, d[i][j] 값이 1인 경우를 추출하여 가장 긴 팰린드롬 구함
	 * */
	public String longestPalindrome(String s) {
		int n = s.length();
		int[][] d = new int[n][n];
		int dist = -1;
		int[] resultIdx = {0, 0};
		
		for(int i = 0; i < n ; i++) 
			for(int j = 0; j < n ; j++)
				d[i][j] = 0;
		
		for (int i = 0; i < n; i++) {
			d[i][i] = 1;
		}
		
		// 붙어있는 길이가 2인 문자열 팰린드롬 체크
		for(int i = 0; i < n - 1; i++) {
			if(s.charAt(i) == s.charAt(i+1))
				d[i][i+1] = 1;
		}
		
		// k = 간격
		// i = 시작점
		// j = 시작점에서부터의 간격
		for(int k = 2; k <= n - 1; k++) {
			for(int i = 0; i < n - k; i++) {
				int j = i + k;
				if(s.charAt(i) == s.charAt(j) && d[i+1][j-1] == 1) {
					d[i][j] = 1;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++)
				System.out.println(d[i][j]);
			System.out.println();
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(dist < Math.abs(i - j) && d[i][j] == 1) {
					dist = Math.abs(i - j);
					resultIdx[0] = i;
					resultIdx[1] = j;
				}
			}
		}
		
		return s.substring(resultIdx[0], resultIdx[1]+1);
    }
}
