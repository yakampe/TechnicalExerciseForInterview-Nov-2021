package dev.yka.TechnicalExercise.Services;

import dev.yka.TechnicalExercise.Models.DataEntry;
import dev.yka.TechnicalExercise.Models.ProcessedData;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DataProcessingService {
    public static List<ProcessedData> processData(List<DataEntry> dataEntry) {
        //Spec states that the data can be passed in any form - opting for JSON
        //Group residents in the same address <- OneToMany r/ship? Resident instance variable of Address?
        //Filter  \
        //         > Seems that the filter or sorting is per property??
        //Sorting /
        return null;
    }
}
