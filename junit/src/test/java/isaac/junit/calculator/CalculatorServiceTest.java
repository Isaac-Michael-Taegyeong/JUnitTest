package isaac.junit.calculator;

import org.junit.jupiter.api.*;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    public void initTest() throws Exception {
        MockitoAnnotations.openMocks(this);
        calculatorService = new CalculatorService();
    }

    @AfterEach
    public void endTest() throws Exception {

    }

    @Test
    @Order(1)
    public void shouldReturnCalculatorPlus() throws Exception {
        // given
        Calculator calculator = new Calculator();
        calculator.setFirstNm(1);
        calculator.setSecondNm(1);

        // when
        int successPlus = calculatorService.calculatorPlus(calculator);

        // then
        assertThat(successPlus, is(2));

    }

    @Test
    @Order(2)
    public void shouldReturnCalculatorMinus() throws Exception {
        // given
        Calculator calculator = new Calculator();
        calculator.setFirstNm(1);
        calculator.setSecondNm(1);

        // when
        int successPlus = calculatorService.calculatorMinus(calculator);

        // then
        assertThat(successPlus, is(0));

    }

    @Test
    @Order(3)
    public void shouldReturnCalculatorMultiply() throws Exception {
        // given
        Calculator calculator = new Calculator();
        calculator.setFirstNm(1);
        calculator.setSecondNm(1);

        // when
        int successPlus = calculatorService.calculatorMultiply(calculator);

        // then
        assertThat(successPlus, is(1));

    }

    @Test
    @Order(4)
    public void shouldReturnCalculatorDivide() throws Exception {
        // given
        Calculator calculator = new Calculator();
        calculator.setFirstNm(100);
        calculator.setSecondNm(10);

        // when
        int successPlus = calculatorService.calculatorDivide(calculator);

        // then
        assertThat(successPlus, is(10));

    }

}