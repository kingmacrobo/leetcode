package algorithm;

import java.util.ArrayList;
import java.util.List;

public class KMP {
	public List<Integer> kmp(String original, String find) {
		List<Integer> result = new ArrayList<Integer>();
		int[] next = generateNext(find);
		int n = original.length(), m = find.length();
		int j = 0;
		for (int i = 0; i < n; ++i) {
			while (j > 0 && original.charAt(i) != find.charAt(j))
				j = next[j];
			if (original.charAt(i) == find.charAt(j)) ++j;
			if (j == m) {
				result.add(i-m+1);
				j = next[j];
			}
		}
		return result;
	}
	public int[] generateNext(String find) {
		int n = find.length(), j = 0;
		int[] next = new int[n+1];
		next[0] = next[1] = 0;
		for (int i = 1; i < n; ++i) {
			while (j > 0 && find.charAt(i) != find.charAt(j)) 
				j = next[j];
			if (find.charAt(i) == find.charAt(j)) ++j;
			next[i+1] = j;
		}
		return next;
	}
}
