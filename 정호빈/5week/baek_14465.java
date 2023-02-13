import java.io.*;
import java.util.*;

public class Main { 
	 
   //백준 14465 소가 길을 건너간 이유
	// 슬라이딩 윈도우를 활용
  
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st ;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] visited = new int[N+1];
        int[] prefix = new int[N+1];
        for(int i=0;i<B;i++) {
        	int a = Integer.parseInt(br.readLine());
        	visited[a]=1;
        }
        for(int i=1;i<=N;i++) {
        	prefix[i] = prefix[i-1]+visited[i];
        }
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=N-K+1;i++) {
        	int a = prefix[i+K-1]-prefix[i-1];
        	min = min>a? a:min;
        }
        System.out.println(min);
        
    }

}
