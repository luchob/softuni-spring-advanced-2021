package bg.softuni.async;

import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
public class HeavyDutyService {

  private static Logger LOGGER = LoggerFactory.getLogger(HeavyDutyController.class);

  @Async
  void doWork() {
    StopWatch stopWatch = new StopWatch();
    LOGGER.info("Starting heavy duty work");
    stopWatch.start();

    int array[] = generateArray(100_000);
    bubbleSort(array);
    stopWatch.stop();
    LOGGER.info("Ending heavy duty work in {}", stopWatch.getLastTaskTimeMillis());
  }

  void bubbleSort(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n-1; i++)
      for (int j = 0; j < n-i-1; j++)
        if (arr[j] > arr[j+1])
        {
          // swap arr[j+1] and arr[j]
          int temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
        }
  }

  int[] generateArray(int size) {
    int[] result = new int[size];

    Random random = new Random();

    for (int idx = 0; idx < result.length; idx++) {
      result[idx] = random.nextInt(10_000_000);
    }

    return result;
  }


}
