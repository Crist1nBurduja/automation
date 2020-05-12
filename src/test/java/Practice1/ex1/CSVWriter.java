package Practice1.ex1;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;

import java.util.Arrays;

public class CSVWriter {
    private static final String SAMPLE_CSV_FILE = "infoStudents.csv";

    public static void main(String[] args) throws IOException {
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(SAMPLE_CSV_FILE));

                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("ID", "Numele", "Prenume", "Specialitatea","Anul"));
        ) {
            csvPrinter.printRecord("1", "Marcov", "Valeria", "Tehnologii Iformationale","III");
            csvPrinter.printRecord("2", "Melinti", "Tatiana", "Tehnologii Iformationale","III");
            csvPrinter.printRecord("3", "Mustafenco", "Ana", "Tehnologii Iformationale","III");
            csvPrinter.printRecord("4", "Cretu", "Daniel", "Tehnologii Iformationale","III");
            csvPrinter.printRecord(Arrays.asList("5", "Burduja", "Cristin", "Tehnologii Iformationale","III"));

            csvPrinter.flush();
        }
    }
}
