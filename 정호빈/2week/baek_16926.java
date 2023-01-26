import java.util.*;
import java.io.*;

// 배열돌리기1 16926 백준 -> 배열을 받고 해당 배열을 반시계방향으로 돌리는 문제 
public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] dy = {0,1,0,-1};
		int[] dx = {1,0,-1,0};
    // 사각형이 몇겹인지 판단
		int cnt = Math.min(N, M)/2;
		// 작은수가 짝수 이걸 이용해서 몇개의 사각형을 돌릴지 결정
		// R만큼 반복 방향벡터 사용 한번돌고 초기화 해주면됨
		// 시작점을 알아야하고 끝점을 알아야하고 이전점을 알아야하고 다음점을 알아야함
		// 방향을 알아야함 시작점에 있는값만 미리빼놓고 덮어쓴다음 마지막에 넣어줌
		while(cnt>0) {
			for(int i=0;i<R;i++) {
				int d=0;
				int sx = cnt-1,px=cnt-1,x=sx,Lx=M-cnt;
				int sy = cnt-1,py=cnt-1,y=sy,Ly=N-cnt;
				int temp=arr[sy][sx];
				do{ // 움직이는 좌표가 해당 사각형 밖이면 방향을 바꿈
					if(x+dx[d]<=Lx&&y+dy[d]<=Ly&&x+dx[d]>=sx&&y+dy[d]>=sy) {
						x+=dx[d];
						y+=dy[d];
					}
					else {
          // 방향 바꾸기
						d++;
						if(d==4) d%=4; 
						continue;
					}
					arr[py][px] = arr[y][x];
					py = y;
					px = x;
          //시작점을 제외하고 다 옮겼으면 마무리
				}while(sx!=x||sy!=y-1);
        // 빼놓았던 시작점 삽입
				arr[sy+1][sx] =temp;
			}
			cnt--;
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		
		
 	}

}
