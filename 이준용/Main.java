package FloydWarchall;

import java.util.*;
import java.io.*;


public class Main {
    
    static int N,M,goal=0,cnt=0,goal2=0;
    static boolean[] v;
    static int[][]d;
    static List<int[]>[] g;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++) {
            //st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            g = new LinkedList[N+1];
            d = new int[N+1][N+1];
            cnt=0;
            for(int i=1;i<=N;i++) {
                g[i] = new LinkedList<int[]>();
                Arrays.fill(d[i], 10000000);
                d[i][i]=0;
            }
            
            for(int i=0;i<M;i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                g[a].add(new int[] {b,1});
            }
            
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    // TODO Auto-generated method stub
                    return o1[1]-o2[1];
                }
            });
            for(int i=1;i<=N;i++) {
                v = new boolean[N+1];
                pq.add(new int[] {i,0});
                while(!pq.isEmpty()) {
                    int[] p = pq.poll();
                    if(v[p[0]])continue;
                    v[p[0]] = true;
                    for(int[] next : g[p[0]]) {
                        if(!v[next[0]]&&d[i][next[0]]>d[i][p[0]]+next[1]) {
                            d[i][next[0]] = d[i][p[0]]+next[1];
                            pq.add(new int[] {next[0],d[i][next[0]]});
                        }
                    }
                }
            }
            
            for(int i=1;i<=N;i++) {
                goal=0;
                for(int j=1;j<=N;j++) {
                    if(d[i][j]>0&&d[i][j]<=N)goal++;
                    if(d[j][i]>0&&d[j][i]<=N)goal++;
                }
                if(goal==N-1)cnt++;
            }
            
        
            System.out.print("#"+t+" "+cnt);
            
            
            
            
        }
        
    }



    

    
    
    
    
}