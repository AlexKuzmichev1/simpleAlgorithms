package ApproxiAlgoTasks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GreedyAlgorithm {

    private HashSet<String> finalStations = new HashSet<>();

    private HashSet<String> generateStates(String[] baseStates) {
        HashSet<String> states = new HashSet<>();
        for (String state : baseStates) {
            states.add(state);
        }
        return states;
    }

    private HashSet<String> generateRadioStations(String[] baseStations) {
        HashSet<String> stations = new HashSet<>();
        for (String station : baseStations) {
            stations.add(station);
        }
        return stations;
    }

    private HashMap<String, String[]> generateRadioStationsCoverage() {
        HashMap<String, String[]> stations = new HashMap<>();
        stations.put("kone", new String[]{"id", "nv", "ut"});
        stations.put("ktwo", new String[]{"wa", "id", "mt"});
        stations.put("kthree", new String[]{"or", "nv", "ca"});
        stations.put("kfour", new String[]{"nv", "ut"});
        stations.put("kfive", new String[]{"ca", "az"});
        return stations;
    }

    public HashMap<String, String[]> findBestCoveredRadioStations(HashSet<String> states, HashSet<String> stations, HashMap<String, String[]> stationsWithCoverage) {
        HashMap<String, String[]> finalStations = new HashMap<>();
        HashSet<String> statesNeeded = states;
        while (!statesNeeded.isEmpty()) {
            HashMap<String, String[]> bestStation = new HashMap<>();
            HashSet<String> statesCovered = new HashSet<>();
            for (String station : stations) {
                HashSet<String> statesFromStation = generateStates(stationsWithCoverage.get(station));
                HashSet<String> covered = new HashSet<>();
                covered.addAll(statesNeeded);
                covered.addAll(statesFromStation);
                if (covered.size() > statesCovered.size()) {
                    bestStation.put(station, (String[]) statesFromStation.toArray());
                    statesCovered = covered;
                }
            }
            statesNeeded.removeAll(statesCovered);
            finalStations.putAll(bestStation);
        }

        return finalStations;
    }
}
