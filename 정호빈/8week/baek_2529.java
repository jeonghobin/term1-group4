import java.util.*;
import java.io.*;

public class Main {
	static String Ans="";
	static List<String> rs = new ArrayList<String>();
	static int N;
	static char[] chr;
	private static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		chr = new char[N];
		visited = new boolean[10];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			chr[i] = st.nextToken().charAt(0);
		}
		for(int i=0;i<10;i++) {
			String temp =Ans;
			Ans+=i;
			visited[i] = true;
			recur(0);
			Ans=temp;
			visited[i] = false;
		}
		System.out.println(rs.get(rs.size()-1)+"\n"+rs.get(0));
	}

	private static void recur(int cnt) {
		if(cnt==N) {
			rs.add(Ans);
			return;
		}
		if(chr[cnt]=='>') {
			for(int i=0;i<10;i++) {
				if(Ans.charAt(cnt)-'0'<=i||visited[i]) continue;
				String temp =Ans;
				Ans+=i;
				visited[i] = true;
				recur(cnt+1);
				Ans=temp;
				visited[i] = false;
			}
		}else {
			for(int i=0;i<10;i++) {
				if(Ans.charAt(cnt)-'0'>=i||visited[i]) continue;
				String temp =Ans;
				Ans+=i;
				visited[i]=true;
				recur(cnt+1);
				Ans=temp;
				visited[i]=false;
			}
		}
	}

}
