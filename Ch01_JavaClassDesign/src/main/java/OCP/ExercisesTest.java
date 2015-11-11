package OCP;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by vitaly on 09.10.15.
 */
public class ExercisesTest {
    private static Decision decision = new Decision();

    @Test
    public void testStringToWords() throws Exception {
        List<String> standard = Arrays.asList("A", "AA", "ABC", "89AA", "100");
        assertEquals(Collections.emptyList(), decision.stringToWords("!@#$%^&   %##$^%$&$%^#& @#$%@#$~!@#$%^&*()+=/*|\\;:,.?'"));
        assertEquals(standard, decision.stringToWords("A;AA,   =ABC,(*&89AA,)(&*100  "));
        assertEquals(standard, decision.stringToWords("A;AA,    =ABC,(  *&  89AA,)  (&*100  "));
        assertEquals(Collections.singletonList("A"), decision.stringToWords("  A "));
        assertEquals(Collections.singletonList("A"), decision.stringToWords("  A "));
    }

    @Test
    public void testValidateExpressionTrue() throws Exception {
        List<String> validExpressions = new ArrayList<>();
        validExpressions.add("byte c = (byte) ((byte) a + b);");
        validExpressions.add("()");
        validExpressions.add("((()))");
        validExpressions.add("(((()))(()()))");
        validExpressions.add("()()()()()()(())((()))");

        validExpressions.forEach(s -> assertTrue(s, decision.validateExpression(s)));
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

        inValidExpressions.forEach(s -> assertFalse(s, decision.validateExpression(s)));
    }

}