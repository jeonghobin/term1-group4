import java.util.*;
import java.io.*;

// 해당 인덱스를 표시하기 위해 idx와 num을 객체로 만듬
class Node{
	int idx;
	int num;
	
	public Node(int idx,int num) {
		this.idx = idx;
		this.num = num;
	}
}

public class Main {
	
	// 접근방법 1. 우선 모든 경우의수를 확인한다.  ->  시간초과
	// 접근방법 2. 규칙을 찾는다. -> 9 5 10 8    9는 5보다 크다 5는 10보다 작다 10은 8보다 크다
	// 그래서 8은 5 9는 확인할 필요도없다
	// 그래서 스택을 이용하여 지금까지 탐색한 것중에서 제일 큰 탑이 1번째의 스택에 차있도록하고 뒤에있던 숫자는 신경쓰지않도록한다.
	// 6 9 5 7 4 ->>    6 -> 9 -> 9 5 -> 9 7
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		Stack<Node> stk = new Stack<Node>();
		int cnt = 0;
		for(int i=0;i<N;i++) {
			int a = Integer.parseInt(st.nextToken());
			
			while(!stk.empty()) {
				if(stk.peek().num<a) {
						stk.pop();
				}
				else {
					bw.write(stk.peek().idx+" ");
					break;
				}
			}
			if(stk.empty()) {
				bw.write("0 ");
			}
			stk.push(new Node(i+1,a));
		}
		
		bw.flush();
		bw.close();
		
 	}

}
