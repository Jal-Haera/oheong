package d3.n7272;

import java.util.Scanner;

public class N7272 {
	static char[] oneHole = {'A','D','O','P','Q','R'};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int TC = 1; TC <= T; TC++) {
			String s1 = sc.next();
			String s2 = sc.next();
			String s1New = ""; String s2New = "";
			if(s1.length() != s2.length()) {
				System.out.printf("#%d DIFF\n",TC);
				continue;
			}
			
			for(int i = 0; i < s1.length(); i++) {
				s1New += confirm(s1.charAt(i));
				s2New += confirm(s2.charAt(i));
			}
			
			if(s1New.equals(s2New)){
				System.out.printf("#%d SAME\n",TC);
			}else {
			
				System.out.printf("#%d DIFF\n",TC);
			}
		}
	}
	
	static int confirm(char c) {
		if('A' > c || 'Z' < c) {
			return -1;
		}else {
			for(char a = 'A'; a <= 'Z'; a++) {
				for(int i = 0; i < oneHole.length; i++) {
					if(c == 'B') return 2;
					if(c == oneHole[i]) return 1;
				}
			}
		}		
		return 0;
	}
}
