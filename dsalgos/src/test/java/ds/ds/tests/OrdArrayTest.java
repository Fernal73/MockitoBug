package ds.tests;

import static ds.tests.TestData.INIT_TOSTRING_DATA;
import static org.mockito.Mockito.*;

import ds.IArray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.CsvSource;

@TestInstance(Lifecycle.PER_CLASS)
@Execution(ExecutionMode.SAME_THREAD)
@DisplayName("OrdArrayTest")
class OrdArrayTest {

  @ParameterizedTest
  @CsvSource(INIT_TOSTRING_DATA)
  @DisplayName("OrdArrayTest.testDisplay")
  void testDisplay(@AggregateWith(OrdArrayArgumentsAggregator.class) IArray arr) {
    IArray ordArray = spy(arr);

    doAnswer(
            i -> {
              i.callRealMethod();
              return null;
            })
        .when(ordArray)
        .display();
    ordArray.display();
    doCallRealMethod().when(ordArray).display();
    ordArray.display();
    verify(ordArray, times(2)).display();
  }
}
