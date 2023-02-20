package Tests;

import ApproxiAlgoTasks.GreedyAlgorithm;
import Models.CountryStatesModel;
import Models.RadioStationModel;
import Utils.JsonUtils.Paths.FilePaths;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.HashSet;
import static Utils.JsonUtils.JsonManager.gsonModelParser;
import static Utils.JsonUtils.Paths.FilePaths.RADIO_STATIONS_FILEPATH;

public class GreedyAlgorithmTest {

    private static final GreedyAlgorithm GREEDY_ALGORITHM = new GreedyAlgorithm();
    private static final RadioStationModel RADIO = (RadioStationModel)
            gsonModelParser(RADIO_STATIONS_FILEPATH, RadioStationModel.class);
    private static final CountryStatesModel STATES = (CountryStatesModel)
            gsonModelParser(FilePaths.COUNTRY_STATES_FILEPATH, CountryStatesModel.class);

    @Test
    public void checkStatesData() {
        HashSet<String> statesExpected = new HashSet<>();
        statesExpected.add(STATES.getOr());
        statesExpected.add(STATES.getMt());
        statesExpected.add(STATES.getNv());
        statesExpected.add(STATES.getAz());
        statesExpected.add(STATES.getWa());
        statesExpected.add(STATES.getId());
        statesExpected.add(STATES.getCa());
        statesExpected.add(STATES.getUt());

        Assert.assertEquals(GREEDY_ALGORITHM.getBaseStatesSet(), statesExpected, "States data is incorrect");
    }

    @Test
    public void checkStationsData() {
        HashSet<String> stationsExpected = new HashSet<>();
        stationsExpected.add(RADIO.getKfour());
        stationsExpected.add(RADIO.getKtwo());
        stationsExpected.add(RADIO.getKone());
        stationsExpected.add(RADIO.getKthree());
        stationsExpected.add(RADIO.getKfive());

        Assert.assertEquals(GREEDY_ALGORITHM.getBaseStationsSet().keySet(), stationsExpected,
                "Stations data is incorrect");
    }

    @Test
    public void checkGreedyRadioStationsSearch() {
        ArrayList<String> radioStations = new ArrayList<>();
        radioStations.add(RADIO.getKfour());
        radioStations.add(RADIO.getKtwo());
        radioStations.add(RADIO.getKthree());
        radioStations.add(RADIO.getKfive());

        Assert.assertEquals(radioStations, GREEDY_ALGORITHM.findBestCoveredRadioStations(),
                "Something goes wrong with main greedy void");
    }
}
