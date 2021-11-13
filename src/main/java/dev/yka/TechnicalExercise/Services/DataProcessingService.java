package dev.yka.TechnicalExercise.Services;

import dev.yka.TechnicalExercise.Models.DataEntry;
import dev.yka.TechnicalExercise.Models.ProcessedData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
                .map(x -> new ProcessedData(x.getAddress1(), x.getAddress2(), x.getCity(), x.getState(), x.getPostcode(), x.getCountryCode(), new ArrayList<>())).collect(Collectors.toList());
    }
}
