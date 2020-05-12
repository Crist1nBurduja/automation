package Practice1.ex1;

import com.opencsv.CSVWriter;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

class OpenCSVWriter {
    private static final String STRING_ARRAY_SAMPLE = "./otherCSVwriter.csv";

    public static void main(String[] args) throws IOException {
        try (
                Writer writer = Files.newBufferedWriter(Paths.get(STRING_ARRAY_SAMPLE));

                CSVWriter csvWriter = new CSVWriter(writer,
                        CSVWriter.DEFAULT_SEPARATOR,
                        CSVWriter.NO_QUOTE_CHARACTER,
                        CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                        CSVWriter.DEFAULT_LINE_END);
        ) {
            String[] headerRecord = {"ID", "Numele", "Prenume", "Specialitatea","Anul"};
            csvWriter.writeNext(headerRecord);

            csvWriter.writeNext(new String[]{"1", "Marcov", "Valeria", "Tehnologii Iformationale","III"});
            csvWriter.writeNext(new String[]{"2", "Melinti", "Tatiana", "Tehnologii Iformationale","III"});
            csvWriter.writeNext(new String[]{"3", "Mustafenco", "Ana", "Tehnologii Iformationale","III"});
            csvWriter.writeNext(new String[]{"4", "Cretu", "Daniel", "Tehnologii Iformationale","III"});
            csvWriter.writeNext(new String[]{"5", "Burduja", "Cristin", "Tehnologii Iformationale","III"});
        }
    }
}