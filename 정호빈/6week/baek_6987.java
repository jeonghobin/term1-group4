import java.util.*;
import java.io.*;
public class Main {

    static int[][] map = new int[6][3];
    static boolean flag=false,flag2=true;
    static int[] t1,t2;

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st ;
        t1 = new int[15];		
		t2 = new int[15];
		int cnt2=0;
		for(int i=0;i<5;i++) {
			for(int j=i+1;j<6;j++) {
				t1[cnt2]=i;
				t2[cnt2++]=j;
			}
		}
        
        for(int i=0;i<4;i++) {
            st = new StringTokenizer(br.readLine());
            flag2 = true;
            for(int j=0;j<6;j++) {
            	int sum=0;
                for(int k=0;k<3;k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                    sum+=map[j][k];
                }
                if(sum!=5) flag2=false;
            }
            
            flag=false;
            solve(0);
            if(flag&&flag2) {
            	System.out.print(1+" ");
            }else {
            	System.out.print(0+" ");
            }
           
        }

    }

private static void solve(int cnt) {
    if(flag==true)return;
    if(cnt==15) {
        flag=true;
        return;
    }
    int r = t1[cnt];
    int c = t2[cnt];
    if(map[r][0]>0&&map[c][2]>0) {
    	map[r][0]--;
    	map[c][2]--;
    	solve(cnt+1);
    	map[r][0]++;
    	map[c][2]++;
    }
    if(map[r][1]>0&&map[c][1]>0) {
    	map[r][1]--;
    	map[c][1]--;
    	solve(cnt+1);
    	map[r][1]++;
    	map[c][1]++;
    }
    if(map[r][2]>0&&map[c][0]>0) {
    	map[r][2]--;
    	map[c][0]--;
    	solve(cnt+1);
    	map[r][2]++;
    	map[c][0]++;
    }
    
}


}
