package ru.mentee.power.leetcode;

public class LiveCodingDemo {
    public static void printFizzBuzz(int n){
        for (int i = 0; i <= n; i++){
            if(i % 3 == 0 && i % 5 == 0){
                System.out.println("FizzBuzz");
            }
            else if ((i % 3) == 0) {
                System.out.println("Fizz");
            }
            else if ((i % 5) == 0) {
                System.out.println("Buzz");
            }
            else {
                System.out.println(i);
            }
        }
    }

    public static int sumEven(int[] numbers){
        int sum = 0;

        if(numbers == null){
            return sum;
        }

        for( int num : numbers){
            if(num % 2 == 0){
                sum += num;
            }
        }

        return sum;
    }

    public static int findMax(int[] numbers){
        if (numbers == null){
            return 0;
        }

        int maxNum = numbers[0];

        for (int num : numbers){
            if(num > maxNum){
                maxNum = num;
            }
        }

        return maxNum;
    }

    static void main() {
        printFizzBuzz(15);
        System.out.println(sumEven(new int[]{2,1,2,1,1,1,1,1}));
        System.out.println(findMax(new int[]{1,2,3,4,5,6,7,8}));
    }
}
