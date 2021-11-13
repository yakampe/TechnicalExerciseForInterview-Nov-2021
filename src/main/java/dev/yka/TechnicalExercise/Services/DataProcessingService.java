package dev.yka.TechnicalExercise.Services;

import dev.yka.TechnicalExercise.Models.DataEntry;
import dev.yka.TechnicalExercise.Models.ProcessedData;
import dev.yka.TechnicalExercise.Models.Resident;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {
    public List<ProcessedData> processData(List<DataEntry> dataEntry) {
        //Spec states that the data can be passed in any form - opting for JSON
        //Group residents in the same address <- OneToMany r/ship? Resident instance variable of Address?
        //Filter  \
        //         > Seems that the filter or sorting is per property??
        //Sorting /
        return processDataEntries(dataEntry);
    }

    private List<ProcessedData> processDataEntries(List<DataEntry> dataEntries) {
        return dataEntries.stream()
                .map(x -> {
                    Resident resident = new Resident("Fred","Smith","M", LocalDate.parse("2010-01-01", DateTimeFormatter.ISO_DATE));
                    return new ProcessedData(x.getAddress1(), x.getAddress2(), x.getCity(), x.getState(), x.getPostcode(), x.getCountryCode(), Arrays.asList(resident));
                }).collect(Collectors.toList());
    }
}
