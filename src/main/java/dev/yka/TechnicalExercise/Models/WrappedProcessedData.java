package dev.yka.TechnicalExercise.Models;

public class WrappedProcessedData {
    private ProcessedData processedData;

    public WrappedProcessedData(ProcessedData processedData) {
        this.processedData = processedData;
    }
    public ProcessedData unwrap() {
        return processedData;
    }

    public boolean equals(Object other) {
        if (other instanceof WrappedProcessedData) {
            return ((WrappedProcessedData) other).processedData.getAddress1().equals(processedData.getAddress1()) &&
                    ((WrappedProcessedData) other).processedData.getAddress2().equals(processedData.getAddress2()) &&
                    ((WrappedProcessedData) other).processedData.getPostcode().equals(processedData.getPostcode()) &&
                    ((WrappedProcessedData) other).processedData.getCountryCode().equals(processedData.getCountryCode()) &&
                    ((WrappedProcessedData) other).processedData.getCity().equals(processedData.getCity());
        } else {
            return false;
        }
    }

}

