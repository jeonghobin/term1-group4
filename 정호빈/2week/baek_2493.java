import java.util.*;
import java.io.*;


class Node{
	int idx;
	int num;
	
	public Node(int idx,int num) {
		this.idx = idx;
		this.num = num;
	}
}

public class Main {
	
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
