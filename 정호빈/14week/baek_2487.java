import java.util.*;
import java.io.*;
public class Main {

	static int N,cnt;
	static boolean[] v;
	static List<Integer>[] g;
	static List<Integer> list= new ArrayList<Integer>();
	private static int flag;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		g = new LinkedList[N+1];
		v = new boolean[N+1];
		for(int i=1;i<=N;i++) {
			g[i] = new LinkedList<Integer>();
		}
		for(int i=1;i<=N;i++) {
			g[i].add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i=1;i<=N;i++) {
			if(v[i])continue;
			cnt=1;
			flag=0;
			dfs(i,i);
			list.add(cnt);
		}
		int a = list.get(0);
		for(int j:list) {
			int max = Math.max(a, j);
			int min = Math.min(a, j);
			int rs = GCD(max,min);
			a = max/rs*min;
		}
		System.out.println(a);
	}
	private static int GCD(int max, int min) {
		if(min==0)return max;
		return GCD(min,max%min);
	}
	private static void dfs(int i,int num) {
		if(flag==1)return;
		v[i] = true;
		for(int j:g[i]) {
			if(num==j) {
				flag=1;
				continue;
			}
			if(v[j])continue;
			cnt++;
			dfs(j,num);
		}
	}

}
