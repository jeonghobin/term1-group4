package baek;

import java.io.*;
import java.util.*;
public class Swea1247 {

	static int[][] map;
	static int min=Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			min=Integer.MAX_VALUE;
			
			int n=Integer.parseInt(br.readLine());
			
			int[] arr=new int[n+2];
			for(int i=0;i<arr.length;i++) {
				arr[i]=i;
			}
			map=new int[n+2][2];
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<=1;j++) {
					if(i==0) {
						map[i][j]=Integer.parseInt(st.nextToken());
					}
					else if(i==1) {
						map[n+1][j]=Integer.parseInt(st.nextToken());
					}
					else if(i>1&&i<n+2){
						map[i-1][j]=Integer.parseInt(st.nextToken());
					}
				}
			}
			recursive(arr,new int[arr.length], 1, new boolean[arr.length]);
			bw.write("#"+t+" "+min+"\n");
			bw.flush();
		}
	}
	private static void recursive(int[] arr, int[] sel, int k, boolean[] v) {
		if(k==sel.length-1) {
			sel[arr.length-1]=arr.length-1;
		
			int sum=0;
			for(int i=0;i<sel.length-1;i++) {
				sum+=(Math.abs(map[sel[i]][0]-map[sel[i+1]][0]))+(Math.abs(map[sel[i]][1]-map[sel[i+1]][1]));
			}
			min=Math.min(min, sum);
			return;
		}
		for(int i=1;i<arr.length-1;i++) {
			if(v[i]==false) {
				v[i]=true;
				sel[k]=i;
				recursive(arr,sel,k+1,v);
				v[i]=false;
			}
		}
	}
}

