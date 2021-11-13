package dev.yka.TechnicalExercise.Models;

public class DataProcessingFilter {
    private String filterType;
    private String filterComparator;
    private String filterCriteria;

    public DataProcessingFilter(String filterType, String filterComparator, String filterCriteria) {
        this.filterType = filterType;
        this.filterComparator = filterComparator;
        this.filterCriteria = filterCriteria;
    }

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public String getFilterComparator() {
        return filterComparator;
    }

    public void setFilterComparator(String filterComparator) {
        this.filterComparator = filterComparator;
    }

    public String getFilterCriteria() {
        return filterCriteria;
    }

    public void setFilterCriteria(String filterCriteria) {
        this.filterCriteria = filterCriteria;
    }
}
