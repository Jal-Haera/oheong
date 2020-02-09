package d3.n1234;

import java.util.Scanner;

public class N1234 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int TC = 1; TC <= 10; TC++) {
			String answer = "";
			char[] crr;
			int pos = sc.nextInt();
			String s = sc.next();
			crr = s.toCharArray();
			while(true) {
				boolean flag = false;
				for(int i = 1; i < pos; i++) {
					if(crr[i] == crr[i - 1]) {
						flag = true;
					}
					if(flag) {
						if(i == pos - 1) { 
							pos = pos - 2;
							continue;
						}
						
						for(int j = i; j < pos - 1; j++) {
							crr[j - 1] = crr[j + 1];
						}
						pos = pos - 2;
						break;
					}
				}
				
				int cnt = -1;
				for(int i = 1; i < pos; i++) {
					if(crr[i] == crr[i - 1]) {
						cnt++;
					}
				}
				if(cnt == -1) break;
			}
			
			for(int i = 0; i < pos; i++) {
				answer += crr[i];
			}
			
			System.out.printf("#%d %s\n",TC, answer);
		}
	}

}
