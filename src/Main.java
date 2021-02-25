import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Main {
	
	public static String bubbleSort(double[] array) {
		String format = "";
		int changes = 0;
		int cont = 0;
		double average = 0.0;
		
		for(int i = 1; i<array.length; i++) {
			for(int j=0; j<array.length-i; j++) {
				if(array[j]>array[j+1]) {
					double temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					changes++;
				}
			}
			cont++;
		}
		
		DecimalFormat  df = new DecimalFormat("0.0#");
		average = (double)changes/cont;
		double finalAverage = Math.floor(average * 100) / 100;
		format = (df.format(finalAverage) + "-" + Arrays.toString(array).replace("[", "").replace("]", "").replace(",", ""));
		return format.replace(",", ".");
	}
	
	public static double[] stringToDouble(String[] stringArray) {
		
		double[] doubleArray = new double[stringArray.length];
		for(int i = 0; i<stringArray.length; i++) {
			doubleArray[i] = Double.parseDouble(stringArray[i]);
		}
		return doubleArray;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int lines = Integer.parseInt(br.readLine());
		String thisLine = br.readLine();
		
		for(int i = 1; i<=lines; i++) {
			String[] stringArray = thisLine.split(" ");
			double[] doubleArray = stringToDouble(stringArray);
			bw.write(bubbleSort(doubleArray));
			bw.newLine();
			bw.flush();
			thisLine = br.readLine();
		}
		
		br.close();
		bw.close();
	}

}
