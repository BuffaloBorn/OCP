package streams;

import java.util.Collection;

/**
 * Created by vitaly on 22.09.15.
 */
class Person {
    public static enum Sex{MALE, FEMALE}
    String name;
    Sex gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }
}
public class Exercises {
//    A sequence of aggregate operations is known as a PIPELINE .
//    Each pipeline contains zero or more INTERMEDIATE operations.
//    Each pipeline ends with a TERMINAL operation.
//    What kind of operation produces another stream as its output? INTERMEDIATE
//    Describe one way in which the forEach aggregate operation differs from the enhanced for statement or iterators. IT'S A INTERNAL ITERATION
//    True or False: A stream is similar to a collection in that it is a data structure that stores elements. FALSE
//    Identify the intermediate and terminal operations in this code:
//    double average = roster
//            .stream()
//            .filter(p -> p.getGender() == Person.Sex.MALE) I
//            .mapToInt(Person::getAge) I
//            .average() T
//            .getAsDouble();
//    The code p -> p.getGender() == Person.Sex.MALE is an example of what? LAMBDA EXPRESSION
//    The code Person::getAge is an example of what? METHOD REFERENCE
//    Terminal operations that combine the contents of a stream and return one value are known as what? REDUCTION
//    Name one important difference between the Stream.reduce method and the Stream.collect method. (SINGLE/MULTIPLE)???
//    If you wanted to process a stream of names, extract the male names, and store them in a new List, would Stream.reduce or Stream.collect be the most appropriate operation to use? COLLECT
//    True or False: Aggregate operations make it possible to implement parallelism with non-thread-safe collections. TRUE
//    Streams are always serial unless otherwise specified. How do you request that a stream be processed in parallel? PARALELSTREAM
//    Exercises
//
//    Write the following enhanced for statement as a pipeline with lambda expressions. Hint: Use the filter intermediate operation and the forEach terminal operation.
//            for (Person p : roster) {
//        if (p.getGender() == Person.Sex.MALE) {
//            System.out.println(p.getName());
//        }
//    }
    public static void pirntMalesNames(Collection<Person> roster) {
        roster.stream().filter(person -> person.getGender() == Person.Sex.MALE).forEach(System.out::println);
    }
//    Convert the following code into a new implementation that uses lambda expressions and aggregate operations instead of nested for loops. Hint: Make a pipeline that invokes the filter, sorted, and collect operations, in that order.
//            List<Album> favs = new ArrayList<>();
//    for (Album a : albums) {
//        boolean hasFavorite = false;
//        for (Track t : a.tracks) {
//            if (t.rating >= 4) {
//                hasFavorite = true;
//                break;
//            }
//        }
//        if (hasFavorite)
//            favs.add(a);
//    }
//    Collections.sort(favs, new Comparator<Album>() {
//        public int compare(Album a1, Album a2) {
//            return a1.name.compareTo(a2.name);
//        }});
//
    public static void main(String[] args) {
//        1
//        2
//        3
//        4
//        5
//        6
//        7
//        8
//        9
    }
}
