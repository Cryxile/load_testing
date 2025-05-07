import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class JMeterLogAnalyzer {

    public static void main(String[] args) {
        String jmeterLogPath = "result.jtl";
        analyzeRPS(jmeterLogPath);
    }

    public static void analyzeRPS(String filePath) {
        try (Reader reader = new FileReader(filePath);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                     .withFirstRecordAsHeader()
                     .withIgnoreHeaderCase()
                     .withTrim())) {

            Map<Long, Integer> requestsPerSecond = new HashMap<>();
            for (CSVRecord requestRecord : csvParser) {
                boolean isSuccess = Boolean.parseBoolean(requestRecord.get("success"));
                if (!isSuccess) {
                    continue;
                }
                long timestamp = Long.parseLong(requestRecord.get("timeStamp"));
                long timestampSec = timestamp / 1000;
                requestsPerSecond.put(timestampSec, requestsPerSecond.getOrDefault(timestampSec, 0) + 1);
            }
            int maxRPS = requestsPerSecond.values().stream()
                    .max(Integer::compare)
                    .orElse(0);

            System.out.println("Max RPS: " + maxRPS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}