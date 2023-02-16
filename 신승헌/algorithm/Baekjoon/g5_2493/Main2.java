package algo.bj.g5_2493;

import java.io.*;
import java.util.*;

class Node {
	int value;
	int idx;

	public Node(int idx, int value) {

		this.value = value;
		this.idx = idx;
	}
}

public class Main2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		Stack<Node> s = new Stack<>();
		Stack<Node> temp = new Stack<>();

		st = new StringTokenizer(br.readLine());
		int idx = 0;

		while (st.hasMoreElements()) {
			idx++;
			int now = Integer.parseInt(st.nextToken());
			while (true) {
				if (s.size() == 0) {
					sb.append(0 + " ");
					s.push(new Node(idx, now));
					break;
				}

				if (now > s.peek().value) {
					s.pop();
				} else {
					sb.append(s.peek().idx + " ");
					s.push(new Node(idx, now));
					break;
				}
			}

		}
		System.out.println(sb);
	}
}
