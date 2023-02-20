package Tests;

import ApproxiAlgoTasks.GreedyAlgorithm;
import org.testng.annotations.Test;

public class GreedyAlgorithmTest {

    private static final GreedyAlgorithm GREEDY_ALGORITHM = new GreedyAlgorithm();

    @Test
    public void checkTheGreedyVoid() {
        System.out.println(GREEDY_ALGORITHM.findBestCoveredRadioStations());
    }
}
