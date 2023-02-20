package ApproxiAlgoTasks;

import Models.CountryStatesModel;
import Models.RadioStationModel;
import Utils.JsonUtils.Paths.FilePaths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import static Utils.JsonUtils.JsonManager.gsonModelParser;
import static Utils.JsonUtils.Paths.FilePaths.RADIO_STATIONS_FILEPATH;

public class GreedyAlgorithm {

    private static final RadioStationModel RADIO = (RadioStationModel)
            gsonModelParser(RADIO_STATIONS_FILEPATH, RadioStationModel.class);
    private static final CountryStatesModel STATES = (CountryStatesModel)
            gsonModelParser(FilePaths.COUNTRY_STATES_FILEPATH, CountryStatesModel.class);
    private HashSet<String> baseStatesSet = new HashSet<>();
    private HashMap<String, HashSet<String>> baseStationsSet = new HashMap<>();

    public HashSet<String> getBaseStatesSet() {
        generateStatesSet();
        return baseStatesSet;
    }

    public HashMap<String, HashSet<String>> getBaseStationsSet() {
        generateRadioStationsCoverage();
        return baseStationsSet;
    }

    private HashSet<String> generateStatesSet() {
        HashSet<String> statesNeeded = new HashSet<>();
        statesNeeded.addAll(
                Arrays.asList(
                        STATES.getMt(), STATES.getWa(),
                        STATES.getOr(), STATES.getId(), STATES.getNv(),
                        STATES.getUt(), STATES.getCa(), STATES.getAz()
                )
        );
        baseStatesSet = statesNeeded;
        return statesNeeded;
    }

    private HashMap<String, HashSet<String>> generateRadioStationsCoverage() {
        HashMap<String, HashSet<String>> stations = new HashMap<>();
        stations.put(RADIO.getKone(), new HashSet(Arrays.asList(STATES.getId(), STATES.getNv(), STATES.getUt())));
        stations.put(RADIO.getKtwo(), new HashSet(Arrays.asList(STATES.getWa(), STATES.getId(), STATES.getMt())));
        stations.put(RADIO.getKthree(), new HashSet(Arrays.asList(STATES.getOr(), STATES.getNv(), STATES.getCa())));
        stations.put(RADIO.getKfour(), new HashSet(Arrays.asList(STATES.getNv(), STATES.getUt())));
        stations.put(RADIO.getKfive(), new HashSet(Arrays.asList(STATES.getCa(), STATES.getAz())));
        baseStationsSet = stations;
        return stations;
    }

    public HashSet<String> findBestCoveredRadioStations() {
        HashSet<String> statesNeeded = generateStatesSet();
        HashMap<String, HashSet<String>> stations = generateRadioStationsCoverage();
        HashSet<String> finalStations = new HashSet();
        while (!statesNeeded.isEmpty()) {
            String bestStation = null;
            HashSet<String> statesCovered = new HashSet();
            for (String station: stations.keySet()) {
                HashSet covered = new HashSet(statesNeeded);
                covered.retainAll(stations.get(station));
                if (covered.size() > statesCovered.size()) {
                    bestStation = station;
                    statesCovered = covered;
                }
            }
            statesNeeded.removeAll(statesCovered);
            finalStations.add(bestStation);
        }
        return finalStations;
    }
}
