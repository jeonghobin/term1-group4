import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;
		int N = Integer.parseInt(br.readLine());
		//3가지 경우의 수가 있음
		//둘다 마이너스 둘다 플러스 하나 마이너스 하나 플러스
		int[] arr = new int[N];
		boolean[] visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		Map<Integer,Integer> map = new TreeMap<Integer, Integer>();
		int cnt=0;
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		for(int i=0;i<N;i++) {
			int s = 0;
			int e = arr.length-1;
			while(s<e) {
				if(s==i) {
					s++;
					continue;
				}
				if(e==i) {
					e--;
					continue;
				}
				int sum = arr[s]+arr[e];
				if(sum==arr[i]) {
					cnt++;
					break;
				}else if(sum>arr[i]) {
					e--;
					continue;
				}else if(sum<arr[i]) {
					s++;
					continue;
				}
			}
		}
		
		
		System.out.println(cnt);
		
	}
	
}
