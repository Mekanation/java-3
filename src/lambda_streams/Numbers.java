package lambda_streams;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Numbers {
    static List<Integer> nums = Arrays.asList(10,100,1000,5,50,500,3,30,300,7,70,700,1,10,100,25,250,2500);

    public static void main(String[] args) {
        //Part I :complete the static class methods that have been set up in this Numbers class java file.  Use streams to compute the results whenever possible.
        System.out.println(nums);

        //Part II - refactor all of the class methods to accept lambda expressions. You can put the lambda functions directly inside the method calls,
        // //or defined them first, then pass them into the methods. give them the same names as the static methods,
        // //but add the word 'lambda' in front of every lambda function:
        /* e.g.

        added(() -> {});

        OR

        lambdaAdd = () -> {};
        added(lambdaAdd);

        isOdd(() -> {});

        OR

        lambdaOdd = () -> {};
        isOdd(lambdaOdd);
        etc...

        */
        System.out.println(isPrime(5));
        System.out.println(isPrime(6));
        System.out.println(isOdd(5));
        System.out.println(isOdd(4));
        System.out.println(isEven(4));
        System.out.println(isEven(5));
        System.out.println(added(nums));
        System.out.println(subtracted(nums));
        System.out.println(multiplied(nums));
        System.out.println(divided(nums));
        System.out.println(findMax(nums));
        System.out.println(findMin(nums));
        System.out.println(compare(2,1,nums));
        System.out.println(append(2000));
        System.out.println(nums);


        System.out.println("=============Begin Lambda Calls================");
        lambdaBoolean lio = (i) -> i % 2 != 0;
        boolean isOdd = lio.isBoolean(nums.get(2));
        System.out.println(isOdd);

        lambdaBoolean lie = (i) -> i % 2 == 0;
        boolean isEven = lie.isBoolean(nums.get(2));
        System.out.println(isEven);

        lambdaBoolean lip = (i) -> {
            if(i%2 == 0) return false;
            for(int n=3; n*n<=i; n+=2){
                if(i%n==0)
                    return false;
            }
            return true;
        };
        boolean isPrime = lip.isBoolean(nums.get(3));
        System.out.println(isPrime);

        lambdaBigInt sum = (i) -> BigInteger.valueOf(nums.stream().mapToInt(w -> w).sum());
        BigInteger lambdaAdded = sum.mathOperation(nums);
        System.out.println(lambdaAdded);

        lambdaBigInt subtract = (i) -> BigInteger.valueOf(nums.stream().mapToInt(w -> -w).sum());
        BigInteger lambdaSubtracted = subtract.mathOperation(nums);
        System.out.println(lambdaSubtracted);

        lambdaBigInt multiplies = (i) -> nums.stream().map(BigInteger::valueOf).reduce(BigInteger.ONE,BigInteger::multiply);
        BigInteger lambdaMultiplied = multiplies.mathOperation(nums);
        System.out.println(lambdaMultiplied);

        lambdaBigInt divides = (i) -> nums.stream().map(BigInteger::valueOf).reduce(BigInteger.ONE,BigInteger::divide);
        BigInteger lambdaDivided = divides.mathOperation(nums);
        System.out.println(lambdaDivided);

        lambdaIntList maxValue = (nums) -> nums.stream().max(Comparator.comparing(Integer::valueOf)).get();
        int lambdaIntList = maxValue.mathOperation(nums);
        System.out.println(lambdaIntList);

        lambdaIntList minValue = (nums) -> nums.stream().min(Comparator.comparing(Integer::valueOf)).get();
        int lambdaIntList2 = minValue.mathOperation(nums);
        System.out.println(lambdaIntList2);

        lambdaCompare compare = (i,j) -> Integer.compare(nums.indexOf(i), nums.indexOf(j));
        int lambdaCompare = compare.compare(nums.get(2), nums.get(1));
        System.out.println(lambdaCompare);

        lambdaAppend append = (n) -> {
            Stream<Integer> testStream = nums.stream();
            Stream<Integer> newStream = Stream.concat(testStream, Stream.of(n));

            nums = newStream.collect(Collectors.toList());
            return n;
        };

        int lambdaAppend = append.append(5000);
        System.out.println(lambdaAppend);
        System.out.println(nums);







    }
    interface lambdaBoolean{
        boolean isBoolean(int i);
    }

    interface lambdaIntList{
        int mathOperation(List<Integer> nums);
    }

    interface lambdaBigInt{
        BigInteger mathOperation(List<Integer> nums);
    }

    interface lambdaCompare{
        int compare(int i, int j);
    }

    interface lambdaAppend{
        int append(int n);
    }


    static boolean isOdd(int i) {
        //determine if the value at the index i is odd.  return true if yes, return false if  no.
        return i % 2 != 0;
    }

    static boolean isEven(int i) {
        //determine if the value at the index i is even.  return true if yes, return false if  no.
        return i % 2 == 0;
    }

    static boolean isPrime(int i) {
         //determine if the value at the index i is a prime number.  return true if yes, return false if no.
        if(i%2 == 0) return false;
        for(int n=3; n*n<=i; n+=2){
            if(i%n==0)
                return false;
        }
        return true;
    }

    static int added(List<Integer> nums) {
        //add all the elements in the list.  return the sum.

        return nums.stream()
                .mapToInt(w -> w)
                .sum();
    }

    static int subtracted(List<Integer> nums) {
        //subtract all the elements in the list. return the remainder.

        return nums.stream()
                .mapToInt(w -> -w)
                .sum();

    }

    static BigInteger multiplied(List<Integer> nums) {


        return nums.stream()
               .map(BigInteger::valueOf)
                .reduce(BigInteger.ONE,BigInteger::multiply);
    }

    static float divided(List<Integer> nums) {
        BigInteger divided = nums.stream()
                .map(BigInteger::valueOf)
                .reduce(BigInteger.ONE,BigInteger::divide);

        return divided.floatValue();
    }

    static int findMax(List<Integer> nums) {
         //return the maximum value in the list.
       return nums.stream()
               .max(Comparator.comparing(Integer::valueOf))
               .get();



    }

    static int findMin(List<Integer> nums) {
        //return the minimum value in the list.
        return nums.stream()
                .min(Comparator.comparing(Integer::valueOf))
                .get();
    }

    static int compare(int i, int j, List<Integer> nums) {
        //compare the values stored in the array at index position i and j.  
        //if the value at i is greater, return 1.  if the value at j is greater, return -1.  if the two values are equal, return 0.
        if(nums.indexOf(i) > nums.indexOf(j)){
            return 1;
        }else if(nums.indexOf(i) < nums.indexOf(j)){
            return -1;
        }
        return 0;
    }

    static int append(int n) {
        //add a new value to the values list. return that value after adding it to the list.
        Stream<Integer> testStream = nums.stream();
        Stream<Integer> newStream = Stream.concat(testStream, Stream.of(n));

        nums = newStream.collect(Collectors.toList());
        return n;
    }

}



