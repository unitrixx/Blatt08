import java.util.*;

public class EditDistance2 {
	public static void main(String Args[]) {
		if(Args.length == 2) {
			String a = Args[0];
			String b = Args[1];
			System.out.println("Kuerzeste Editierdistanz \nzwischen: " +a+ "\nund: " + b+ "\nbetraegt: " + distance(a,b));
		} else {
			System.out.println("Falsche Eingabe!!");
		}
	}
	
	public static int distance (String a, String b) {
		
		int[][] array = new int[a.length() + 1][b.length() + 1];
		
		char[] ar = a.toCharArray();
		char[] br = b.toCharArray();
		
		array[0][0] = 0;
		
		for (int i = 1; i < ar.length + 1 ; i++) {
			array[i][0] = i;
		}

		for (int j = 1; j < br.length + 1 ; j++) {
			array[0][j] = j;
		}
		
		int maxNumber = Math.max(2 * a.length(), 2 * b.length());
		
		
		for(int i = 1; i < ar.length + 1; i++) {
			for(int j = 1 ; j < br.length + 1; j++) {
				array[i][j] = maxNumber;
				if( ar[i-1] == br[j-1] ) {
					array[i][j] = array[i-1][j-1];
				}
				if( array[i][j] > array[i-1][j-1] + 1 ) {
					array[i][j] = array[i-1][j-1] + 1;
				}
				if( array[i][j] > array[i][j-1] + 1 ) {
					array[i][j] = array[i][j-1] + 1;
				}
				if( array[i][j] > array[i-1][j] + 1 ) {
					array[i][j] = array[i-1][j] + 1;
				}			
			}
		}
		
		
		//*******Ausgabe Feld*******//
		for(int i = 0; i < ar.length + 1; i++) {
			for(int j = 0 ; j < br.length + 1; j++) {
				System.out.printf(" %2d ", array[i][j]);
			}
			System.out.println();
		}
		//**************************//
		
		printEditOperations(array, a, b);

		return array[a.length()][b.length()];
	}

	public static void printEditOperations(int[][] array, String a, String b){
		
		int i = a.length();
		int j = b.length();
		
		Stack<Integer> out = new Stack<>();
		
		while (i > 0 && j > 0) {
			
			if (array[i-1][j-1] == array[i][j] -1){
				out.push(1); // 1 = ersetzen
				j--;
				i--;
			}
			else if (array[i][j-1] == array[i][j] - 1){
				out.push(2); // 2 = einfügen
				j--;
			}
			else if (array[i-1][j] == array[i][j] -1){
				out.push(3); // 3 = löschen
				i--;
			}
			else if (array[i-1][j-1] == array[i][j]){
				out.push(0); // 0 = beibehalten
				j--;
				i--;
			}

		}
		while (j > 0){
			out.push(2);
			j--;							
		}
		while (i > 0){
			out.push(3);
			i--;							
		}

		while (!out.isEmpty())
			System.out.println(out.pop());
	
	}
}
