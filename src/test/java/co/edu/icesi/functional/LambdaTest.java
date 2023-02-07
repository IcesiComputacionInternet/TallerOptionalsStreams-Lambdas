package co.edu.icesi.functional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LambdaTest {


    private final LambdaExample lambdaExample = new LambdaExample();


    @Test
    public void testStringToIntFunction() {
        String testStringValue = Integer.MAX_VALUE + "";
        int expected = Integer.MAX_VALUE;
        int result = lambdaExample.stringToIntFunction().apply(testStringValue);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    public void testRandomStringSupplier(int length) {
        String randomizedString = lambdaExample.randomStringSupplier(length).get();
        Pattern onlyLowCaseLettersPattern = Pattern.compile("[a-z]*");
        Matcher onlyLowCaseLettersMatcher = onlyLowCaseLettersPattern.matcher(randomizedString);
        assertEquals(length, randomizedString.length());
        assertTrue(onlyLowCaseLettersMatcher.matches());
    }

    @Test
    public void testContainsRepeatedCharacters() {
        List<String> listOfStringsToTest = List.of("a", "aa", "aabb", "abc", "Aa");
        List<String> expectedList = List.of("a", "abc");
        List<String> resultList = listOfStringsToTest.stream().filter(lambdaExample.containsRepeatedCharacters()).toList();

        assertEquals(expectedList, resultList);
    }


}
