package isaac.junit.calculator;

import org.springframework.stereotype.Component;

@Component
public class CalculatorCheck {

    public static Boolean checkInputZero(Calculator calculator) {

        if (calculator.getFirstNm() == 0) {
            return false;
        }

        if (calculator.getSecondNm() == 0) {
            return false;
        }

        return true;
    }

}
