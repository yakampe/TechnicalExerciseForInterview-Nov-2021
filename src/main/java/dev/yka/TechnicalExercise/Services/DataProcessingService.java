package dev.yka.TechnicalExercise.Services;

import dev.yka.TechnicalExercise.Models.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {
    public List<ProcessedData> processData(List<DataEntry> dataEntries, String sortType, DataProcessingFilter dataProcessingFilter) {
        List<WrappedProcessedData> parsedList = new ArrayList<>();

        dataEntries.stream().forEach(eachEntry -> {
            ProcessedData processedData = new ProcessedData(eachEntry);
            int duplicateAddressIndex = parsedList.indexOf(new WrappedProcessedData(processedData));
            Resident resident = new Resident(eachEntry);

            //If there are no duplicates addresses add to list and include resident
            //else concat list with new resident and replace the old address
            if(duplicateAddressIndex < 0) {
                processedData.setResidents(Arrays.asList(resident));
                parsedList.add(new WrappedProcessedData(processedData));
            } else {
                ProcessedData unwrappedData = parsedList.get(duplicateAddressIndex).unwrap();
                ArrayList<Resident> objects = new ArrayList<>();
                objects.addAll(unwrappedData.getResidents());
                objects.add(resident);
                unwrappedData.setResidents(objects);
                parsedList.set(duplicateAddressIndex, new WrappedProcessedData(unwrappedData));
            }
        });

        if(sortType != null) {
            return sortedList(parsedList, sortType);
        }

        return parsedList.stream().map(WrappedProcessedData::unwrap).collect(Collectors.toList());
    }

    private List<ProcessedData> sortedList(List<WrappedProcessedData> parsedList, String sortType) {
        Function<ProcessedData, String> sortMethodReference = ProcessedData::getAddress1;

        switch (sortType) {
            case "city":
                sortMethodReference = ProcessedData::getCity;
                break;
            case "postcode":
                sortMethodReference = ProcessedData::getPostcode;
                break;
        }

        return parsedList.stream().map(WrappedProcessedData::unwrap).sorted(Comparator.comparing(sortMethodReference)).collect(Collectors.toList());
    }


}
