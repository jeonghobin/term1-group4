package day0210;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Baek9012 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T=Integer.parseInt(br.readLine());
		
		L: for(int t=1;t<=T;t++) {
			String word=br.readLine();
			Stack<Character> stack = new Stack<Character>();
			int leng=word.length();
			
			for(int i=0;i<leng;i++) {
				char input=word.charAt(i);
				if(input=='(') {
					stack.push(input);
				}
				else {
					if(stack.size()==0) {
						bw.write("NO\n");
						continue L;
					}
					else {
						stack.pop();
					}
				}
			}
			if(stack.size()==0) {
				bw.write("YES\n");
			}
			else {
				bw.write("NO\n");
			}
		}
		bw.close();	
	}
}