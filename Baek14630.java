package baek;

import java.io.*;
import java.util.*;

public class Baek14630 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static class Point implements Comparable<Point>{
		int e,w;

		public Point(int e, int w) {
			super();
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.w-o.w;
		}
	}
	
	static int N;
	static String[] input;
	static ArrayList<Point>[]array;
	static int[]dist;
	
	static int S,E;

	public static void main(String[] args) throws IOException {
		N=Integer.parseInt(br.readLine());
		input=new String[N];
		for(int i=0;i<N;i++) {
			input[i]=br.readLine();
		}
		array=new ArrayList[N];
		for(int i=0;i<N;i++) {
			array[i]=new ArrayList<>();
		}
		
		for(int i=0;i<N;i++) {
			String a=input[i];
			for(int j=0;j<N;j++) {
				if(i==j)continue;
				
				String b=input[j];
				int w=0;
				
				for(int l=0;l<a.length();l++) {
					w+=Math.pow(Character.getNumericValue(a.charAt(l))-Character.getNumericValue(b.charAt(l)), 2);
				}
				array[i].add(new Point(j, w));
			}
		}
		
		st=new StringTokenizer(br.readLine());
		S=Integer.parseInt(st.nextToken())-1;
		E=Integer.parseInt(st.nextToken())-1;
		
		dist=new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		PriorityQueue<Point>q=new PriorityQueue<>();
		dist[S]=0;
		q.add(new Point(S, 0));
		while(!q.isEmpty()) {
			Point p=q.poll();
			if(dist[p.e]<p.w) continue;
			
			for(Point np:array[p.e]) {
				int nw=dist[p.e]+np.w;
				if(nw<dist[np.e]) {
					dist[np.e]=nw;
					q.add(new Point(np.e, nw));
				}
			}
		}
		bw.write(dist[E]+"");
		bw.close();
	}
}
