package d5.n1247;

import java.util.Scanner;

class Pair{
	int x;
	int y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class N1247 {
	static Pair[] xy;
	static boolean[] check;
	static int N, min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int T = 1; T <= TC; T++) {
			int answer = 0;
			min = 10000;
			N = sc.nextInt();

			xy = new Pair[N + 2];
			check = new boolean[N + 2];

			// ÁÂÇ¥ÀÔ·Â
			for(int i = 0; i < N+2; i++) {
				xy[i] = new Pair(sc.nextInt(), sc.nextInt());
			}
			// index -- 0: È¸»ç, 1: Áý, N°³: °í°´
			dfs(0, 0);
			answer = min;
			System.out.printf("#%d %d\n", T, answer);
		}
	}

	static void dfs(int idx, int sum) {
		check[idx] = true;
		int cnt = 0;
		for(int i = 0; i <= N + 1; i++) {
			if(check[i]) cnt++;
		}
		if(cnt == N + 1) {
			int x = Math.abs(xy[idx].x - xy[1].x);
			int y = Math.abs(xy[idx].y - xy[1].y);
			sum += (x + y);
			if(sum < min) min = sum;
			return;
		}

		int dist = 0;
		for(int i = 0; i <= N+1; i++) {
			if(i == 1) continue;
			if(!check[i]) {
				int xTemp = Math.abs(xy[idx].x - xy[i].x);
				int yTemp = Math.abs(xy[idx].y - xy[i].y);
				dist = xTemp + yTemp;
				dfs(i, sum + dist);
				check[i] = false;
			}
		}
		return;
	}
}