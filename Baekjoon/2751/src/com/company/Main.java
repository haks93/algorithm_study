package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        new Main().go();
    }

    public void go(){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try{
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            int[] copyArr = arr.clone();
            mergeSplit(arr, 0, n-1, copyArr);
            for (int i = 0; i < n; i++) {
                System.out.println(copyArr[i]);
            }
            br.close();
            bw.close();
        } catch (IOException e){
            e.getStackTrace();
        }
    }

    public void mergeSplit(int[] arr, int first, int last, int[] copyArr){
        if(last - first < 2)
            return;

        int mid = (first + last)/2;

        mergeSplit(arr, first, mid - 1, copyArr);
        mergeSplit(arr, mid, last, copyArr);
        merge(arr, first, mid, last, copyArr);
    }

    public void merge(int[] arr, int first, int mid, int last, int[] copyArr){
        int ifirst = first, jfirst = mid;
        int current = first;

        while(ifirst < mid && jfirst <= last){
            if(arr[ifirst] < arr[jfirst])
                copyArr[current] = arr[ifirst++];
            else
                copyArr[current] = arr[jfirst++];
            current++;
        }

        //TODO: after while, insert reminder.
        arr = copyArr.clone();
    }
}
