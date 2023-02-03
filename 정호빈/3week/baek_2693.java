import java.util.*;
import java.io.*;
	
public class Main {
	
    // 백준 2693 N번째중 큰 수 
    // 정렬해서 3번째 큰수 출력
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	Integer[] arr = new Integer[10];
        	for(int j=0;j<10;j++) {
        		arr[j] = Integer.parseInt(st.nextToken());
        	}
        	Arrays.sort(arr, Collections.reverseOrder());
        	System.out.println(arr[2]);
        }
        
        
    }

}
