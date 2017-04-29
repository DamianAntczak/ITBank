package Record;

import Operation.BankingOperation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by krzysztof on 31/03/2017.
 */
public class Report {

    private List<Record> records = new ArrayList<>();

    public Report(List<Record> records) {
        this.records = records;
    }

    public void print() {
        System.out.println("===============REPORT===============");
        for (Record record : records) {
            System.out.println(record.toString());
        }
        System.out.println("====================================");
    }

    public void printToFile(String clientID, BankingOperation.BankingOperationType type) {
        try {
            SimpleDateFormat format1 = new SimpleDateFormat("yy_MM_dd_HH-mm");
            SimpleDateFormat format2 = new SimpleDateFormat("yyyy MM dd HH:mm");

            final String formatedDate = format1.format(new Date());
            String fileName = fileName = "./raport_" + type.name() + "_" + formatedDate + ".txt";

            File raportFile = new File(fileName);

            FileWriter fw = new FileWriter(raportFile);
            BufferedWriter bw = new BufferedWriter(fw);

            StringBuffer sb = new StringBuffer();
            sb.append("================REPORT================" + System.lineSeparator());
            sb.append("          "
                    + format2.format(new Date())
                    + "           " + System.lineSeparator());
            sb.append("type: " + type.name() + System.lineSeparator());
            sb.append("       CLIENT ID " + clientID + System.lineSeparator());
            for (Record record : records) {
                sb.append("--------------------------------------" + System.lineSeparator());
                sb.append(record);
                sb.append("--------------------------------------" + System.lineSeparator());
                sb.append(System.lineSeparator());
            }
            sb.append("======================================" + System.lineSeparator());
            bw.write(sb.toString());
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
