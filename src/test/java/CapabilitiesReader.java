import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user
 */
public class CapabilitiesReader {

    public static Map<Integer, List<String>> readCapabilites() {
        Map<Integer, List<String>> capabilities = new HashMap<Integer, List<String>>();
        String fileToParse = "C:\\Users\\user\\IdeaProjects\\TestingLab9\\src\\test\\resources\\capabilities.csv";
        BufferedReader fileReader = null;

        final String DELIMITER = ",";
        try {
            String line = "";
            fileReader = new BufferedReader(new FileReader(fileToParse));
            int id = 0;
            List<String> caps = new ArrayList<String>();
            while ((line = fileReader.readLine()) != null) {
                String[] tokens = line.split(DELIMITER);
                caps.clear();
                for(String token : tokens) {
                    caps.add(token);
                }
                capabilities.put(id++, caps);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return capabilities;
    }

}
