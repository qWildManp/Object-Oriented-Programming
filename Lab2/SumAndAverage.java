
public class SumAndAverage {
	public static void main(String[] ags) {
		int count = 0;
		int sum = 0;
		float average;
		int j = 1;
		int k = 1;
		for(int i=1;i <= 100;i = i + 2) {//loop to show each odd number between 1 to 100
			count++;//count the number of odd number
			sum = sum+i;//sum all the value of odd number
		}
		average = sum/count;//calculate the average of the sum of odd number;
		System.out.println("SUM = "+sum+"  AVERAAGE = "+average);
		sum = 0;//reset the sum
		count = 0;//reset the count
		while(j<=100) {//loop to show each number that is divisible by 7;
			if(j % 7 ==0) {//check whether the number can be divided by 7
				count++;//count the number of the number that is divisible by 7
				sum = sum +j;//sum all of the value of these numbers
			}
			j++;
		}
		average = sum/count;//calculate the average
		System.out.println("SUM = "+sum+"  AVERAAGE = "+average);
		sum = 0;//reset the sum
		do {
			sum = sum + k*k;//sum the value of square number
			k++;
		}while(k<=100);
			System.out.println("SUM = "+sum);
	}

}