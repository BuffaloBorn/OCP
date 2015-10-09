package OCP;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static OCP.Exercises.*;
import static org.junit.Assert.*;

/**
 * Created by vitaly on 09.10.15.
 */
public class ExercisesTest {

    @Test
    public void testStringToWords() throws Exception {
        List<String> standard = Arrays.asList("A", "AA", "ABC", "89AA", "100");
        assertEquals(Collections.emptyList(), stringToWords("!@#$%^&   %##$^%$&$%^#& @#$%@#$~!@#$%^&*()+=/*|\\;:,.?'"));
        assertEquals(standard, stringToWords("A;AA,   =ABC,(*&89AA,)(&*100  "));
        assertEquals(standard, stringToWords("A;AA,    =ABC,(  *&  89AA,)  (&*100  "));
        assertEquals(Collections.singletonList("A"), stringToWords("  A "));
        assertEquals(Collections.singletonList("A"), stringToWords("  A "));
    }

    @Test
    public void testValidateExpressionTrue() throws Exception {
        List<String> validExpressions = new ArrayList<>();
        validExpressions.add("byte c = (byte) ((byte) a + b);");
        validExpressions.add("()");
        validExpressions.add("((()))");
        validExpressions.add("(((()))(()()))");
        validExpressions.add("()()()()()()(())((()))");

        validExpressions.forEach(s -> assertTrue(s, validateExpression(s)));
    }

    @Test
    public void testValidateExpressionFalse() throws Exception {
        List<String> inValidExpressions = new ArrayList<>();
        inValidExpressions.add("double d = 1 + (5 + 6 * (5 - 1))()((());");
        inValidExpressions.add(")()");
        inValidExpressions.add("(((");
        inValidExpressions.add(")");
        inValidExpressions.add(")");
        inValidExpressions.add(")(");
        inValidExpressions.add("(()-(()()-)())-((()())");
        inValidExpressions.add("({}(()");
        inValidExpressions.add("()-()-()-()-()-(()");

        inValidExpressions.forEach(s -> assertFalse(s, validateExpression(s)));
    }

}