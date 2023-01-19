import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{

		Scanner sc=new Scanner(System.in);
		String number=sc.next();
		ArrayList<Integer> array = new ArrayList<>();
		for(int i=0;i<10;i++) {
			array.add(0);
		}
		
		for(int i=0;i<number.length();i++) {
			int num=Character.getNumericValue(number.charAt(i));
			array.set(num, array.get(num)+1);
		}
		
		int count=0;
		for(int i=0;i<10;i++) {
			if(i==6) {
				continue;
			}
			else if(i==9) {
				if((array.get(6)+array.get(9))%2==0) {
					count=Math.max(count, (array.get(6)+array.get(9))/2);
				}
				else {
					count=Math.max(count, 1+(array.get(6)+array.get(9))/2);
				}
				
			}
			else {
				count=Math.max(count, array.get(i));
			}
		}
		System.out.println(count);
	}
}
