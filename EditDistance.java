public class EditDistance {
	public static void main(String Args[]) {
		if(Args.length == 2) {
			String a = Args[0];
			String b = Args[1];
			System.out.println("kürzeste editier Distanze \nzwischen: " +a+ "\nund: " + b+ "\nbetraegt: " + distance(a,b));
		} else {
			System.out.println("falsche Eingabe");
		}
	}
	
	public static int distance (String a, String b) {
		
		int [] [] array = new int[a.length()+1] [b.length()+1];
		
		char [] ar = a.toCharArray();
		char [] br = b.toCharArray();
		
		
		array [0] [0] = 0;
		
		for (int i = 1; i<ar.length+1 ; i++) {
			array[i] [0] = i;
		}
		for (int i = 1; i<br.length+1 ; i++) {
			array[0] [i] = i;
		}
		
		int maxNumber = Math.max(2 * a.length(), 2*b.length());
		
		
		for(int i = 1; i<ar.length+1; i++) {
			for(int j = 1 ; j<br.length+1; j++) {
				array[i] [j] = maxNumber;
				if(i<ar.length && j<br.length) {
					if(ar[i] - br[j] == 0) {
						array[i] [j] = array[i-1] [j-1];
					}
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
		
		
		//________Ausgabe feld______
		for(int i = 0; i<ar.length+1; i++) {
			for(int j = 0 ; j<br.length+1; j++) {
				System.out.printf(" %2d ", array[i] [j]);
			}
			System.out.println();
		}
		//________________________
		
		
		return array[a.length()] [b.length()];
	}
}

//		Ausgabe
//		
//		  0   1   2   3   4   5 
//		  1   1   1   2   3   4 
//		  2   2   1   2   3   4 
//		  3   3   2   1   2   3 
//		  4   4   3   2   2   3 
//		  5   5   4   3   3   3 
//		  6   6   5   4   4   4 
//		kürzeste editier Distanze 
//		zwischen: baacda
//		und: abace
//		betraegt: 4
