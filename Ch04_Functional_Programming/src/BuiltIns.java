import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class BuiltIns {

	public static void main(String... arg){
		
		// Implementing Supplier
		System.out.println("=== Implementing Supplier ====");
		Supplier<ArrayList<String>> s1 = ArrayList<String>::new;
		ArrayList<String> a1 = s1.get();
		System.out.println(a1);
		System.out.println(s1);
		
		// Implementing Consumer
		System.out.println("=== Implementing Consumer ====");
		Consumer<String> c1 = System.out::println;
		Consumer<String> c2 = x -> System.out.println(x);
		
		c1.accept("Annie");
		c2.accept("Annie");
		
		// Implementing BiConsumer
		System.out.println("=== Implementing BiConsumer ====");
		Map<String, Integer> map = new HashMap<>();
		BiConsumer<String, Integer> b1 = map::put;
		BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);
		
		b1.accept("chicken", 7);
		b2.accept("chick", 1);
		
		System.out.println(map);
		
		// Implementing Predicate
		System.out.println("=== Implementing Predicate ====");
		Predicate<String> p1 = String::isEmpty;
		Predicate<String> p2 = x -> x.isEmpty();
		
		System.out.println(p1.test(""));
		System.out.println(p2.test(""));
		
		// Implementing BiPredicate
		System.out.println("=== Implementing BiPredicate ====");
		BiPredicate<String, String> bp1 = String::startsWith;
		BiPredicate<String, String> bp2 = (string, prefix) -> string.startsWith(prefix);
		
		System.out.println(bp1.test("chicken", "chick"));
		System.out.println(bp2.test("chicken", "chick"));
		
		// Implementing Function and BiFunction
		System.out.println("=== Implementing Function ====");
		Function<String, Integer> f1 = String::length;
		Function<String, Integer> f2 = x -> x.length();
		
		System.out.println(f1.apply("cluck")); // 5
		System.out.println(f2.apply("cluck")); // 5
		
		// Implementing Function and BiFunction
		System.out.println("=== Implementing BiFunction ====");
		BiFunction<String, String, String> bf1 = String::concat;
		BiFunction<String, String, String> bf2 = (string, toAdd) -> string.concat(toAdd);
		
		System.out.println(bf1.apply("baby ", "chick")); // baby chick
		System.out.println(bf2.apply("baby ", "chick")); // baby chick
		
		// Implementing UnaryOperator
		UnaryOperator<String> u1 = String::toUpperCase;
		UnaryOperator<String> u2 = x -> x.toUpperCase();
		
		System.out.println(u1.apply("chirp"));
		System.out.println(u2.apply("chirp"));
		
		// Implementing BinaryOperator
		BinaryOperator<String> bo1 = String::concat;
		BinaryOperator<String> bo2 = (string, toAdd) -> string.concat(toAdd);
		
		System.out.println(bo1.apply("baby ", "chick")); // baby chick
		System.out.println(bo2.apply("baby ", "chick")); // baby chick
		
		
	} 
}
