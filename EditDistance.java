public class EditDistance {
	public static void main(String Args[]) {
		String a = "baacda";
		String b = "abace";
		
		distance(a,b);
	}
	
	
	public static int distance (String a, String b) {
		
		int [] [] array = new int[a.length()] [b.length()];
		
		char [] ar = a.toCharArray();
		char [] br = b.toCharArray();
		
		array [0] [0] = 0;
		
		for (int i = 1; i<ar.length ; i++) {
			array[i] [0] = i;
		}
		for (int i = 1; i<br.length ; i++) {
			array[0] [i] = i;
		}
		
		int maxNumber = Math.max(2 * a.length(), 2*b.length());
		
		
		for(int i = 1; i<ar.length; i++) {
			for(int j = 1 ; j<br.length; j++) {
				array[i] [j] = maxNumber;
				if(ar[i] - br[j] == 0) {
					array[i] [j] = array[i-1] [j-1];
				}
				if(array[i] [j] > array[i-1] [j-1]+1) {
					array[i] [j] = array[i-1] [j-1]+1;
				}
				if(array[i] [j]> array[i] [j-1]+1) {
					array[i] [j] = array[i] [j-1]+1;
				}
				if(array[i] [j]> array[i-1] [j]+1) {
					array[i] [j] = array[i-1] [j]+1;
				}
			}
		}
		
		
		

		for(int i = 0; i<ar.length; i++) {
			for(int j = 0 ; j<br.length; j++) {
				System.out.printf(" %2d ", array[i] [j]);
			}
			System.out.println();
		}
		
		return 1;
	}
}

//		  Ausgabe
//		  0   1   2   3   4 
//		  1   1   1   2   3 
//		  2   2   1   2   3 
//		  3   3   2   1   2 
//		  4   4   3   2   2 
//		  5   5   4   3   3 


