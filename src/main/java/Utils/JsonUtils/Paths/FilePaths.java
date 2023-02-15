package Utils.JsonUtils.Paths;

public final class FilePaths {

    private FilePaths() {
        throw new AssertionError();
    }

    private static final String MAIN_RESOURCES_PATH = "src/main/resources/";
    public static final String BFS_CONDITION_FILEPATH = String.format("%sBFSConditionData.json", MAIN_RESOURCES_PATH);
    public static final String GRAPH_FILEPATH = String.format("%sGraphData.json", MAIN_RESOURCES_PATH);
    public static final String GRAPH_WEIGHTS_FILEPATH = String.format("%sGraphWeightsData.json", MAIN_RESOURCES_PATH);
    public static final String DIJKSTRA_CONDITION_FILEPATH = String.format("%sDijkstraConditionData.json", MAIN_RESOURCES_PATH);
}
