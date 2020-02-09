package d3.n2805;

import java.util.Scanner;

public class N2805 {
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int TC = 1; TC <= T; TC++) {
			int answer = 0;
			// NÀº Ç×»ó È¦¼ö
			int N = sc.nextInt();
			boolean flag = false;
			map = new int[N][N];
			
			int left = 0; int right = 0;
			for(int i = 0; i < N; i++) {
				String s = sc.next();
				for(int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
				int base = N / 2;
				
				
				if(left == 0 && i != 0) {
					flag = true;
				}
				
				if(flag) {
					left = base - (N - 1 - i);
					right = base + (N - 1 - i);
					for(int k = left; k <= right; k++) answer += map[i][k];
				}else {
					left = base - i;
					right = base + i;
					for(int k = left; k <= right; k++) answer += map[i][k];
				}
			}
			
			System.out.printf("#%d %d\n",TC,answer);
		}
	}

}
