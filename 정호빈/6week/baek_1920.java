import java.util.*;
import java.io.*;
public class Main {
	
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;
		int N = Integer.parseInt(br.readLine());
		Map<Integer,Integer> map = new TreeMap<Integer, Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int a = Integer.parseInt(st.nextToken());
			map.put(a,1);
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int a = Integer.parseInt(st.nextToken());
			if(map.getOrDefault(a, 0)==1) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
		
		
	}

	
}
