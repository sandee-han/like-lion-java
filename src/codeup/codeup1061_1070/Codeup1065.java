package codeup.codeup1061_1070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Codeup1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] arr = input.split(" ");

        for(int i = 0; i < arr.length; i++){
            if(Integer.parseInt(arr[i]) % 2 == 0){
                System.out.println(arr[i]);
            }
        }

    }
}
