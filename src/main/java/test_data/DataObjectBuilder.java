package test_data;

import com.google.gson.Gson;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class DataObjectBuilder {

    public static <T> T buildDataObject(String filePath, Class<T> objectType) {

        T returnData;
        String absolutePath = System.getProperty("user.dir").concat(filePath);

        try (
                Reader reader = Files.newBufferedReader(Paths.get(absolutePath));
                ) {
            Gson gson = new Gson();
            returnData = gson.fromJson(reader,objectType);

        } catch (NoSuchFileException noSuchFileException) {
            throw new RuntimeException("[ERR] Can't located a file path: "+absolutePath);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return returnData;
    }
}
