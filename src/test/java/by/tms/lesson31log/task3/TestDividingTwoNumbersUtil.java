package by.tms.lesson31log.task3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDividingTwoNumbersUtil {

    @ParameterizedTest
    @CsvSource(value = {
            "2,1,2",
            "-1,-1,1",
            "6,3,2",
            "6,0,0",
            "1,2,0"
    })
    public void testgetResult(long a,long b,long result){

        Optional<Long> actual=DividingTwoNumbersUtil.getResult(a,b);
        Optional<Long> expected=(b==0)?Optional.empty():Optional.of(result);

        assertEquals(actual,expected);
    }


}
