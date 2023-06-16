import java.io.*;
import java.util.*;



public class Main {
	
	static int n,m,k,max=0;
	static int[] arr;
	static int[][] qst;
	
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		qst = new int[m][k];
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<k;j++) {
				qst[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		arr = new int[n];
		recur(0,1);
		System.out.println(max);
	}


	private static void recur(int cur,int cnt) {
		// TODO Auto-generated method stub
		if(cur==n) {
			int maxcnt=0;
			for(int i=0;i<m;i++) {
				int fcnt=0;
				for(int j=0;j<k;j++) {
					for(int l=0;l<n;l++) {
						if(arr[l]==qst[i][j]) {
							fcnt++;
							break;
						}
					}
				}
				if(fcnt==k)maxcnt++;
			}
			max = Math.max(maxcnt, max);
			return;
		}
		
		for(int i=cnt;i<=2*n;i++) {
			arr[cur]=i;
			recur(cur+1,i+1);
		}
	}

	
 	
 	

 	


	
	

}
