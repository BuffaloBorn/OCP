package local_inner_class;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Vitaly on 06.09.2015.
 */
public class LambdaTest {
    public static void main(String[] args) {
//        List<Character> characters = Arrays.stream("as;ldfjasdfasldfjas".toCharArray());
        "as;ldfjasdfasldfjas".chars().filter(value -> value == 'a').mapToObj(c -> (char) c).forEach(c -> {
            System.out.print(c + ", ");});

    }
}
