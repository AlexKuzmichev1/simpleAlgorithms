package Utils.JsonUtils;

import com.google.gson.*;
import java.io.FileReader;
import java.lang.reflect.Type;

public class JsonManager {

    private static final GsonBuilder BUILDER = new GsonBuilder();
    private static final Gson GSON = BUILDER.create();

    public static Object gsonModelParser(String filePath, Object typeModel) {
        try (FileReader reader = new FileReader(filePath)){
            return GSON.fromJson(reader, (Type) typeModel);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
