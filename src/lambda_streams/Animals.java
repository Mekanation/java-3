package lambda_streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Animals {
    //This class will be using streams.
    static List<String> animals = Arrays.asList("peacoCK", "rabbit", "chiwawa", "OranguTAN", "vipeR", "cobra", "paNDa",
            "bUffalo", "DeeR", "maLLard");

    public static void main(String[] args) {
        System.out.println("original animals : " + animals);

        // Lambda caps
        lambdaCapsLower lc = (animaList, mutate) -> {
            if (mutate) {

                Stream<String> myStream = animals.stream();

                animals = myStream.map(String::toLowerCase)
                        .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                        .collect(Collectors.toList());
            } else {
                return animaList.stream().map(String::toLowerCase)
                        .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                        .collect(Collectors.toList());
            }

            return animals;
        };
        //Lambda lower
        lambdaCapsLower ll = (animaList, mutate) -> {
            if (mutate) {

                Stream<String> myStream = animals.stream();

                animals = myStream.map(String::toUpperCase)
                        .map(name -> name.substring(0, 1).toLowerCase() + name.substring(1))
                        .collect(Collectors.toList());
            } else {
                return animaList.stream().map(String::toUpperCase)
                        .map(name -> name.substring(0, 1).toLowerCase() + name.substring(1))
                        .collect(Collectors.toList());
            }

            return animaList;
        };
        //Lambda animal Add
        lambdaStringAnimal aa = (animal) -> {
            Stream<String> myStream = animals.stream();
            Stream<String> myStream2 = Stream.concat(myStream, Stream.of(animal));

            animals = myStream2.collect(Collectors.toList());
            return animal;
        };
        //Lambda flip and sort
        lambdaCapsLower fa = (animals, mutate) -> {
            if (mutate) {
                Collections.reverse(animals);

                return animals;

            } else {
                Stream<String> myStream = animals.stream();

                List<String> mylist = myStream.collect(Collectors.toList());
                Collections.reverse(mylist);

                return mylist;
            }

        };
        lambdaCapsLower sa = (animals, mutate) -> {
            Stream<String> myStream = animals.stream();

            if (mutate) {

                animals = myStream.sorted(Comparator.naturalOrder()).collect(Collectors.toList());

            } else {
                return myStream.sorted(Comparator.naturalOrder()).collect(Collectors.toList());
            }

            return animals;

        };

        addAnimal("rEIndeeR", aa);
        addAnimal("Platypus", aa);
        addAnimal("frOg" , aa);
        addAnimal("lEOpArD", aa);

        System.out.println(capsFirst(animals, true, lc));
        System.out.println(animals);
        System.out.println(lowerFirst(animals, true, ll));
        System.out.println(animals);
        System.out.println(flipAnimals(true, fa));
        System.out.println(animals);
        System.out.println(sortAnimals(true, sa));
        System.out.println(animals);
    }
    interface lambdaCapsLower {
       List<String> capsLower(List<String> animaList, boolean mutate);
    }
    interface lambdaStringAnimal{
        String addAnimal(String animal);
    }
    static List<String> capsFirst(List<String> animaList, boolean mutate, lambdaCapsLower operation) {
        return operation.capsLower(animaList, mutate);
    }
    static List<String> lowerFirst(List<String> animaList, boolean mutate, lambdaCapsLower operation) {
        return operation.capsLower(animaList, mutate);
    }
    static String addAnimal(String animal, lambdaStringAnimal operation) {
        return operation.addAnimal(animal);
    };
    static List<String> flipAnimals(boolean mutate, lambdaCapsLower operation) {
        return operation.capsLower(animals,mutate);
    }
    static List<String> sortAnimals(boolean mutate, lambdaCapsLower operation) {
        return operation.capsLower(animals,mutate);
    }

}