package com.example.imports;

import java.nio.file.Path;
import java.util.List;

public class CsvProfileImporter implements ProfileImporter {
    private NaiveCsvReader cvR;
    private ProfileService pS;
    public CsvProfileImporter(NaiveCsvReader cvR, ProfileService pS) {
        this.cvR = cvR;
        this.pS = pS;
    }
    @Override
    public int importFrom(Path csvFile) {
        List<String[]> rows = cvR.read(csvFile);
        for (int i = 1; i < rows.size(); i++) {
            String[] row = rows.get(i);
            pS.createProfile(row[0], row[1], row[2]);
        }
        return rows.size() - 1; 
    }
    
}
