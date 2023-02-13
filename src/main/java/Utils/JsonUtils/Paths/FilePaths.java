package Utils.JsonUtils.Paths;

public final class FilePaths {

    private FilePaths() {
        throw new AssertionError();
    }

    private static final String MAIN_RESOURCES_PATH = "src/main/resources/";
    public static final String BFS_CONDITION_FILEPATH = String.format("%sBFSConditionData.json", MAIN_RESOURCES_PATH);
    public static final String BFS_GRAPH_FILEPATH = String.format("%sBFSGraphData.json", MAIN_RESOURCES_PATH);
}
