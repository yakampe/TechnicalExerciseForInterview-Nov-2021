package dev.yka.TechnicalExercise.Services;

import dev.yka.TechnicalExercise.Models.DataEntry;
import dev.yka.TechnicalExercise.Models.ProcessedData;
import dev.yka.TechnicalExercise.Models.Resident;
import dev.yka.TechnicalExercise.Models.WrappedProcessedData;
import org.springframework.stereotype.Service;

import java.util.*;
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
        List<WrappedProcessedData> parsedList = new ArrayList<>();

        dataEntries.stream()
        .forEach(eachEntry -> {
            ProcessedData pd = new ProcessedData(eachEntry.getAddress1(), eachEntry.getAddress2(), eachEntry.getCity(), eachEntry.getState(), eachEntry.getPostcode(), eachEntry.getCountryCode(), new ArrayList<>());
            int duplicateAddressIndex = parsedList.indexOf(new WrappedProcessedData(pd));
            Resident resident = new Resident(eachEntry.getFirstName(), eachEntry.getSurname(), eachEntry.getGender(), eachEntry.getDateOfBirth());
            if(duplicateAddressIndex < 0) {
                pd.setResidents(Arrays.asList(resident));
                parsedList.add(new WrappedProcessedData(pd));
            } else {
                ProcessedData unwrappedData = parsedList.get(duplicateAddressIndex).unwrap();
                ArrayList<Resident> objects = new ArrayList<>();
                objects.addAll(unwrappedData.getResidents());
                objects.add(resident);
                unwrappedData.setResidents(objects);
                parsedList.add(duplicateAddressIndex, new WrappedProcessedData(unwrappedData));
            }
        });

        return parsedList.stream().map(WrappedProcessedData::unwrap).collect(Collectors.toList());
    }

}
