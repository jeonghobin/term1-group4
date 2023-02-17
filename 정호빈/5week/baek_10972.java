import java.util.*;
import java.io.*;
public class Main {
	/*
  * A[i-1]< A[i] 를 만족하는 가장큰 i를 찾는다.
  * j>=i 이면서 A[j]>A[i-1] 인 가장큰 j를 찾는다. 
  * A[j]와 A[i-1]을 스왑한다.
  * A[i]부터 순열을 오름차순으로 정렬한다.
  */
	
  
  
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st =new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int mi=-1;
		for(int i=1;i<N;i++) {
			if(arr[i]>arr[i-1]) {
				mi=i;
			}
		}
		if(mi==-1)System.out.println(-1);
		else {
			int mj=-1;
			for(int i=mi+1;i<N;i++) {
				if(arr[mi-1]<arr[i]) {
					mj=i;
				}
			}
			if(mj==-1) {
				int temp = arr[mi-1];
				arr[mi -1] = arr[mi];
				arr[mi] = temp;
				Arrays.sort(arr,mi,N);
			}else {
				int temp = arr[mi-1];
				arr[mi-1] = arr[mj];
				arr[mj] = temp;
				Arrays.sort(arr,mi,N);
			}
			for(int i=0;i<N;i++)
			System.out.print(arr[i]+" ");
		}
	}


	
}
