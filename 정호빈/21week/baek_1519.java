import java.io.*;
import java.util.*;



public class Main {
	
	static int N, min;
	static int[] d;
	
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		d = new int[N+1];
		Arrays.fill(d, -1);
		for(int i=0;i<=N;i++) {
			recur(i);
		}
		System.out.println(d[N]==0?-1:d[N]);
		
		
	}

	private static int recur(int n) {
		// TODO Auto-generated method stub
		if(d[n]!=-1)return d[n];
		if(n<10) {
			d[n]=0;
			return d[n];
		}
		Set<String> set = new TreeSet<>();
		String str = String.valueOf(n);
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='0')continue;
			String res="";
			for(int j=i;j<str.length();j++) {
				res+=str.charAt(j);
				if(!res.equals(str)) set.add(res);
			}
		}
		Iterator<String> it = set.iterator();
		int min = Integer.MAX_VALUE;
		while(it.hasNext()) {
			int temp = Integer.parseInt(it.next());
			if(recur(n-temp)==0) {
				min = Math.min(min, temp);
			}
		}
		if(min != Integer.MAX_VALUE)d[n]=min;
		else d[n] = 0;
		return d[n];
	}
	

	
 	
 	

}
