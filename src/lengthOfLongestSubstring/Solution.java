package lengthOfLongestSubstring;

import java.util.HashMap;

public class Solution {
	public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int result = 0;
		int left = 0;
		int right = 0;
		
		while(right < s.length()) {
			// 현재 인덱스가 반복된 문자인 경우
			// 두 번째 조건: 이미 지정된 왼쪽 지점보다 지금 가져올 문자의 인덱스 크거나 같아야 함
			if(map.containsKey(s.charAt(right)) && left <= map.get(s.charAt(right))) {
				left = map.get(s.charAt(right)) + 1;
				map.put(s.charAt(right), right++);
			}
			// 반복된 문자가 아닐 경우, map에 인덱스 값 저장 및 최대 길이 값 갱신 작업
			else {
				map.put(s.charAt(right), right++);
				result = Math.max(result, right - left);
			}
		}
		
        return result;
    }
}
