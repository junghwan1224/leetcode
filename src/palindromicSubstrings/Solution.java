package palindromicSubstrings;

public class Solution {
	
	/*
	 * 동적 프로그래밍을 활용하여 해결
	 * d[i][j] = s[i]부터 s[j]까지 팰린드롬인지(맞으면 1, 아니면 0)
	 * 작업을 완료한 후, d[i][j] 값이 1인 경우를 구하여 갯수 세기
	 * */
	public int countSubstrings(String s) {
		int n = s.length();
		int[][] d = new int[n][n];
		int cnt = 0;
		
		for(int i = 0; i < n; i++) {
			d[i][i] = 1;
		}
		
		for(int i = 0; i < n - 1; i++) {
			if(s.charAt(i) == s.charAt(i+1))
				d[i][i+1] = 1;
		}
		
		for(int k = 2; k <= n - 1; k++) {
			for(int i = 0; i < n - k; i++) {
				int j = i + k;
				if(s.charAt(i) == s.charAt(j) && d[i+1][j-1] == 1) {
					d[i][j] = 1;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(d[i][j] == 1)
					cnt++;
			}
		}
        return cnt;
    }
}
