package dev.yka.TechnicalExercise.Services;

import dev.yka.TechnicalExercise.Models.DataEntry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataProcessingService {
    public static List<DataEntry> processData() {
        //Process Google URI into CSV
        // https://docs.google.com/spreadsheets/d/1Atg931ZiX6wjlx4pVO9uIcIhcK32htdz2NaAwWzC1uQ/gviz/tq?tqx=out:csv&sheet=SHEET1
        //Instantiate a list of DataEntry objects <- external lib
        //Group residents in the same address <- OneToMany r/ship? Resident instance variable of Address?
        //Filter  \
        //         > Seems that the filter or sorting is per property??
        //Sorting /
        return null;
    }
}
