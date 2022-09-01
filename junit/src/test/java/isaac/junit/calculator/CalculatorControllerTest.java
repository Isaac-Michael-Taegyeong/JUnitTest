package isaac.junit.calculator;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

@TestMethodOrder(OrderAnnotation.class)
class CalculatorControllerTest {

    private CalculatorController calculatorController;

    @Mock
    private CalculatorService calculatorService;

    private static MockedStatic<CalculatorCheck> calculatorCheck;

    @BeforeEach
    public void initTest() throws Exception {
        MockitoAnnotations.openMocks(this);
        calculatorCheck = mockStatic(CalculatorCheck.class);
        calculatorController = new CalculatorController(calculatorService);
    }

    @AfterEach
    public void endTest() throws Exception {
        calculatorCheck.close();
    }

    @Test
    @Order(1)
    public void shouldReturnCalculatorPlusSuccess() throws Exception {
        // given
        Calculator calculator = new Calculator();

        //
        given(CalculatorCheck.checkInputZero(calculator)).willReturn(true);

        //
        int resultPlus = 0;
        given(calculatorService.calculatorPlus(calculator)).willReturn(resultPlus);

        // when
        String successPlus = calculatorController.calculatorPlus(calculator);

        // then
        assertThat(successPlus, is(Integer.toString(resultPlus)));

    }

    @Test
    @Order(2)
    public void shouldReturnCalculatorPlusFailed() throws Exception {
        // given
        Calculator calculator = new Calculator();

        //
        given(CalculatorCheck.checkInputZero(calculator)).willReturn(false);

        //
        String resultPlus = "Input Number has a zero";

        // when
        String failedPlus = calculatorController.calculatorPlus(calculator);

        // then
        assertThat(failedPlus, is(resultPlus));

    }

    @Test
    @Order(3)
    public void shouldReturnCalculatorMinusSuccess() throws Exception {
        // given
        Calculator calculator = new Calculator();

        //
        given(CalculatorCheck.checkInputZero(calculator)).willReturn(true);

        //
        int resultMinus = 0;
        given(calculatorService.calculatorMinus(calculator)).willReturn(resultMinus);

        // when
        String successMinus = calculatorController.calculatorMinus(calculator);

        // then
        assertThat(successMinus, is(Integer.toString(resultMinus)));

    }

    @Test
    @Order(4)
    public void shouldReturnCalculatorMinusFailed() throws Exception {
        // given
        Calculator calculator = new Calculator();

        //
        given(CalculatorCheck.checkInputZero(calculator)).willReturn(false);

        //
        String resultMinus = "Input Number has a zero";

        // when
        String failedMinus = calculatorController.calculatorMinus(calculator);

        // then
        assertThat(failedMinus, is(resultMinus));

    }

    @Test
    @Order(5)
    public void shouldReturnCalculatorMultiplySuccess() throws Exception {
        // given
        Calculator calculator = new Calculator();

        //
        given(CalculatorCheck.checkInputZero(calculator)).willReturn(true);

        //
        int resultMultiply = 0;
        given(calculatorService.calculatorMinus(calculator)).willReturn(resultMultiply);

        // when
        String successMinus = calculatorController.calculatorMultiply(calculator);

        // then
        assertThat(successMinus, is(Integer.toString(resultMultiply)));

    }

    @Test
    @Order(6)
    public void shouldReturnCalculatorMultiplyFailed() throws Exception {
        // given
        Calculator calculator = new Calculator();

        //
        given(CalculatorCheck.checkInputZero(calculator)).willReturn(false);

        //
        String resultMultiply = "Input Number has a zero";

        // when
        String failedMinus = calculatorController.calculatorMultiply(calculator);

        // then
        assertThat(failedMinus, is(resultMultiply));

    }

    @Test
    @Order(7)
    public void shouldReturnCalculatorDivideSuccess() throws Exception {
        // given
        Calculator calculator = new Calculator();

        //
        given(CalculatorCheck.checkInputZero(calculator)).willReturn(true);

        //
        int resultDivide = 0;
        given(calculatorService.calculatorMinus(calculator)).willReturn(resultDivide);

        // when
        String successDivide = calculatorController.calculatorDivide(calculator);

        // then
        assertThat(successDivide, is(Integer.toString(resultDivide)));

    }

    @Test
    @Order(7)
    public void shouldReturnCalculatorDivideFailed() throws Exception {
        // given
        Calculator calculator = new Calculator();

        //
        given(CalculatorCheck.checkInputZero(calculator)).willReturn(false);

        //
        String resultDivide = "Input Number has a zero";

        // when
        String failedDivide = calculatorController.calculatorDivide(calculator);

        // then
        assertThat(failedDivide, is(resultDivide));

    }

}