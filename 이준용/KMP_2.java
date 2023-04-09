package KMP;

public class KMP_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[] makeTable(String pattern){
		int n=pattern.length();
		int[]table=new int[n];
		
		int idx=0;
		for(int i=1;i<n;i++) {
			while(idx>0&&pattern.charAt(i)!=pattern.charAt(idx)) {
				idx=table[idx-1];
			}
			if(pattern.charAt(i)==pattern.charAt(idx)) {
				idx++;
				table[i]=idx;
			}
		}
		return table;
	}
	
	public static void KMP(String parent, String pattern) {
		int n1=parent.length();
		int n2=pattern.length();
		
		int[]table=makeTable(pattern);
		
		int idx=0;
		
		for(int i=0;i<n1;i++) {
			while(idx>0&&parent.charAt(i)!=pattern.charAt(idx)) {
				idx=table[idx-1];
			}
			if(parent.charAt(i)==pattern.charAt(idx)) {
				if(idx==n2-1) {
					System.out.println(i-idx+1);
					idx=table[idx];
				}
				else {
					idx++;
				}
			}
		}
	}
}
