import java.util.*;
import java.io.*;
public class Main {
	
  // 백준 2467 용액
  // 두수의 합이 0에 가장 가까운 두수를 출력 여러개면 어 느것을 출력해도 ㄱㅊ
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[]arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int s=0,e=N-1;
		if(arr[s]>0) {
			System.out.println(arr[0]+" "+arr[1]);
			return;
		}
		if(arr[e]<0) {
			System.out.println(arr[N-2]+" "+arr[N-1]);
			return;
		}
		int min = Integer.MAX_VALUE,mins=s,mine=e;
		while(s<e) {
			int a = arr[s]+arr[e];
			if(Math.abs(a)<Math.abs(min)) {
				min=a;
				mins=s;
				mine=e;
			}
			else {
				if(a>0) {
					e--;
				}
				else {
					s++;
				}
			}
		}
		System.out.println(arr[mins]+" "+arr[mine]);
	}
}
