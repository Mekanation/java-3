package lambda_streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Animals {
    //This class will be using streams.
    static List<String> animals = Arrays.asList("peacoCK","rabbit","chiwawa","OranguTAN","vipeR","cobra","paNDa","bUffalo","DeeR","maLLard");

    public static void main(String[] args) {
        System.out.println("original animals : " + animals);

        //clean up the animals array by using the capsFirst() method. follow instructions in the method definition. 
        List<String> cleaned = capsFirst(animals, false);
        System.out.println("Cleaned: " + cleaned);
       
        //do not modify these addAnimal() method invocations
        addAnimal("rEIndeeR");
        addAnimal("Platypus");
        addAnimal("frOg");
        addAnimal("lEOpArD");
        //---------------------------------------

        capsFirst(animals,true);
        System.out.println("Default animals: " + animals);

        List<String> lowered = lowerFirst(animals,false);
        System.out.println(lowered);

        flipAnimals(true);
        System.out.println(animals);

        System.out.println("This is the non modified animals list: " + flipAnimals(false));
        sortAnimals(true);
        System.out.println("This is the modified animals list: " + animals);
        System.out.println("This is the non modified animals list: " + sortAnimals(false));

        //===========================Lambdas================================





    }



    static List<String> capsFirst(List<String> animalList, boolean mutate) {
        //clean up the animals list so that the first letter is capitalized, and all the other letters are lowercased. Use a stream to accomplish this task.
        // Also, the 2nd parameter of this function is a boolean.  use this boolean 'flag' to determine whether or not to 'mutate'
        // the original animals array stored as a static class field.
        // if the flag is set to 'true', mutate the animals and return the animals out of the function.
        // if it is false, create a copy of the animals, perform your stream operations on the copy, and return the copy of animals out of the function,
        // WITHOUT modifying the original animals array.

        return getStrings(animalList, mutate, animals.stream().map(Animals::stringSanitizer), animalList.stream().map(Animals::stringSanitizer));


    }

    static void addAnimal(String animal) {
        //add an animal to the animal list.

        Stream<String> testStream = animals.stream();
        Stream<String> newStream = Stream.concat(testStream, Stream.of(animal));

        animals = newStream.collect(Collectors.toList());

    };

    static List<String> lowerFirst(List<String> animalList, boolean mutate) {
        //lowercase the first letter, and uppercase the rest of the letters, using streams.  Also, depending on the value of the boolean flag 'mutate', mutate the original animals list, or perform your stream operations on a 'copy' of the animals list.  return the list out of hte function in both cases.
        return getStrings(animalList, mutate, animals.stream().map(Animals::stringSanitizerLowered), animalList.stream().map(Animals::stringSanitizerLowered));
    }

    private static List<String> getStrings(List<String> animalList, boolean mutate, Stream<String> stringStream, Stream<String> stringStream2) {
        Stream<String> newStream;
        if(mutate) {

            newStream = stringStream;


            animals=newStream.collect(Collectors.toList());

        }else{
            newStream = stringStream2;


            animalList=newStream.collect(Collectors.toList());

        }
        return animalList;
    }

    static List<String> flipAnimals(boolean mutate) {
        //reverse the order of the animals in the animal list.  If the boolean parameter is true, reverse the static animals array list by mutating the array.  if the mutate boolean is false, flip a 'copy' of the animals list, then return that list of flipped animals, WITHOUT mutating the static animals array. return the flipped list in both cases.
        if(mutate){

            Collections.reverse(animals);


            return animals;
        }
        else{
            Stream<String> animalStream = animals.stream();
            List<String> list2 = animalStream.collect(Collectors.toList());
            Collections.reverse(list2);
            return list2;
        }


    }

    static List<String> sortAnimals(boolean mutate) {
    //sort the animals in alphabetical order.  If the boolean parameter is true, mutating the animals list.
    // if the mutate boolean is false, sort a 'copy' of the animals list, then return that list of sorted animals,
    // WITHOUT mutating the static animals array. return the sorted list in both cases.
        if(mutate){
            List<String> list = animals;
            List<String> collect = list.stream().sorted().collect(Collectors.toList());
            animals = collect;
            return animals;
        }else {
            List<String> list = animals;
            return list.stream().sorted().collect(Collectors.toList());
        }

    }

    static String stringSanitizer(String s){
        String s1 = s.toLowerCase();
        String s2 = s1.substring(0,1).toUpperCase();
        return s2 + s1.substring(1);

    }

    static String stringSanitizerLowered(String s){
        String s1 = s.toUpperCase();
        String s2 = s1.substring(0,1).toLowerCase();
        return s2 + s1.substring(1);

    }


}
