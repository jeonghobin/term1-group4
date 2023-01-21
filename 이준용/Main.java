package backalgo;

//백준 2564 경비원
//그냥 구현했습니다ㅜ
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int mapx=sc.nextInt();
		int mapy=sc.nextInt();
		int n=sc.nextInt();
		ArrayList<Integer> xarray = new ArrayList<>();
		ArrayList<Integer> yarray = new ArrayList<>();
		int sum=0;
		int dongx=0;
		for(int i=1;i<=(n+1);i++) {		//동근이는 4
			int x=sc.nextInt();
			int y=sc.nextInt();
			if(i==n+1) {
				dongx=x;
			}
			if(x==1) {
				xarray.add(0);
				yarray.add(y);
			}
			else if(x==2) {
				xarray.add(mapy);
				yarray.add(y);
			}
			else if(x==3) {
				xarray.add(y);
				yarray.add(0);
			}
			else if(x==4) {
				xarray.add(y);
				yarray.add(mapx);
			}
		}
		int dx=xarray.get(n);
		int dy=yarray.get(n);
		for(int i=0;i<n;i++) {
			int sx=xarray.get(i);
			int sy=yarray.get(i);
			if(dongx==1||dongx==2) {
				if(dx==sx) {
					sum+=Math.abs(dy-sy);
				}
				else if(Math.abs(dx-sx)==mapy) {
					sum+=mapy+Math.min((dy+sy), (2*mapx-dy-sy));
				}
				else {
					if(dx==0) {
						if(dy>sy) {
							sum+=dy+sx;
						}
						else {
							sum+=-dy+mapy+sx;
						}
					}
					else {
						if(dy>sy) {
							sum+=dy+mapy-sx;
						}
						else {
							sum+=mapx-dy+mapy-sx;
						}
					}
				}
			}
			else {
				if(dy==sy) {
					sum+=Math.abs(dx-sx);
				}
				else if(Math.abs(dy-sy)==mapx) {
					sum+=mapx+Math.min((dx+sx), (2*mapy-dx-sx));
				}
				else {
					if(dx==0) {
						if(dx>sx) {
							sum+=dx+sy;
						}
						else {
							sum+=-dx+mapx+sy;
						}
					}
					else {
						if(dx>sx) {
							sum+=dx+mapx-sy;
						}
						else {
							sum+=mapy-dx+mapx-sy;
						}
					}
				}
			}
		}
		System.out.println(sum);
	}
}
