import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
    	
    	Arrays.sort(ar);
    	int previousSock=-1;
    	int sameSockCounter=0;
    	int pairCounter=0;
    	for (int i = 0; i < ar.length; i++) {
    		int currentSock;
    		if (i == 0) {
    			currentSock = ar[i];
    			previousSock = currentSock;
    			sameSockCounter++;
    			continue;
    		}
    		currentSock = ar[i];
    		if (currentSock == previousSock) {
    			sameSockCounter++;
    			continue;
    		} else {
    			previousSock = currentSock;
    			int noOfPair = sameSockCounter / 2;
    			pairCounter += noOfPair;
    			sameSockCounter = 0;
    			sameSockCounter++;
    		}
    	}
    	int noOfPair = sameSockCounter / 2;
		pairCounter += noOfPair;
    	return pairCounter;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        System.out.println(String.valueOf(result));


        scanner.close();
    }
}
