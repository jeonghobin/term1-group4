import java.io.*;
import java.util.*;




public class Main {
	
  	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int[][] map = new int[19][19];
		int[] dx = {-1,-1,0,1,1,1,0,-1};
		int[] dy = {0,1,1,1,0,-1,-1,-1};
		for(int i=0;i<19;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<19;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean winner = false;
	    L:
		for(int i=0;i<19;i++) {
			for(int j=0;j<19;j++) {
				if(map[i][j]==0)continue;
				for(int k=1;k<=4;k++) {
				    int mx = i+dx[(k+4)%8];
				    int my = j+dy[(k+4)%8];
				    if(mx>=0&&mx<19&&my>=0&my<19&&map[mx][my]==map[i][j])continue;
				    int cnt=0;
				    int nx=i;
				    int ny=j;
				    for(int m=1;m<=5;m++) {
				    	nx+=dx[k];
				    	ny+=dy[k];
				    	if(nx>=0&&nx<19&&ny>=0&&ny<19&&map[nx][ny]==map[i][j])cnt++;
				    	else {
				    		break;
				    	}
				    }
				    if(cnt==4) {
				    	System.out.println(map[i][j]);
				    	System.out.println((i+1)+" "+(j+1));
				    	winner = true;
				    	break L;
				    }
				    
				}
				
			}
		}
		if(!winner)System.out.println(0);
		
	}
	


 	

}
