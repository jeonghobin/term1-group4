import java.util.*;
import java.io.*;
public class Main {

	// 백준 3673 나눌 수 있는 부분순열
  // 모든 부분 순열의 합에서 d로 나눠지는 부분순열 들의 갯수를 출력하는 문제

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;
		int N = Integer.parseInt(br.readLine());
		Map<Long,Long> map = new HashMap<>();
		for(int q=0;q<N;q++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			if(d==1) {
				System.out.println(n*(n+1)/2);
				continue;
			}
			long[] arr = new long[n+1];
			long[] prefix = new long[n+1];
			map.put(0L, 1L);
			long cnt=0;
			for(int i=1;i<=n;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				prefix[i] = prefix[i-1]+arr[i];
				cnt+=map.getOrDefault(prefix[i]%d, 0L);
				map.put(prefix[i]%d, map.getOrDefault(prefix[i]%d, 0L)+1L);
			}
			System.out.println(cnt);
			map.clear();
		}
			
			
	}
		
		
}
