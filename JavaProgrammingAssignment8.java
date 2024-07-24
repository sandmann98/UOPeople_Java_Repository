import java.util.Arrays;

public class BenchmarkingSortingAlgorithms {
	public static void main(String[] args) {
		// Calculate the benchmarks of two different classification techniques
		int maxArraySize = 10000; 	//The  array size.
		int[] sortingArray1 = new int [maxArraySize];	 //The first array.
		int[] sortingArray2 = new int [maxArraySize]; 	//The second array
			//class constructor
		for (int i = 0; i < sortingArray1.length; i++) {
			
		//The filling it have two arrays with the same random numbers.
			
		sortingArray1[i] = (int)(Integer.MAX_VALUE * Math.random());
		sortingArray2[i] = sortingArray1[i];
		}
		long startTimeArray1 = System.currentTimeMillis(); 		
		
		//It starts computing for the time of selection it arranges.

		
		selectionSort(sortingArray1);
		//The arranging Array1 with selectionSort
		long runTimeArray1 = System.currentTimeMillis() - startTimeArray1; 	
		//The time to run the selectionSort.
		
		
		long startTimeArray2 = System.currentTimeMillis(); 
		//It starts computing in the time for Array.sort
		Arrays.sort(sortingArray2); 
		//The arranging Array2 with Arrays.sort
		long runTimeArray2 = System.currentTimeMillis() - startTimeArray2; 
		//It times to run Array.sort
		
		System.out.println("Selection sort time(sec):"+runTimeArray1/1000.0); 
		System.out.println("Selection sort time(sec):"+runTimeArray2/1000.0); 
		
	}
	static void selectionSort(int[] A) {
		//The sort of A in increasing in order, using selection sort.
		
		for(int lastPlace = A.length-1; lastPlace > 0; lastPlace--){
			
			//It finds the biggest item among on it A[0], A[1], ...,
			//The A[last place], and move it into the position last place in  exchange it with the number
			//that is currently position in the last place.
			
			int maxLoc = 0;// Location of largest item seen so far.
			for (int j = 1; j <= lastPlace; j++)
			{
				if(A[j] > A[maxLoc]) {
					
			//The since A[j] is larger than the maximum., J is the new location of the maximum value.
			maxLoc = j;
				
				}
			}
			
		
			int temp = A[maxLoc];		 // Swap largest item with A[lastPlace].
			A[maxLoc] = A[lastPlace];
			A[lastPlace] = temp;
			
		}// end of for loop
	}
}