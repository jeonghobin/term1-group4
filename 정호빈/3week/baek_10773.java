import java.util.*;
import java.io.*;

// 백준 10773 제로
// 스택을 활용하여 푸는 문제
// 숫자를 입력하면 스택에 넣고 0을 입력하면 스택을 pop함

public class Main {
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> st = new Stack<Integer>();
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			int a = Integer.parseInt(br.readLine());
			if(a!=0) {
				st.push(a);
			}
			else {
				st.pop();
			}
		}
		
		int rs =0;
		while(!st.empty()) {
			rs+=st.pop();
		}
		System.out.println(rs);
		
	}
	
	
}
