package pl.radzik.michal.modulbazydanych.utils;

import java.util.Objects;

public class CarFilter {

    private int yearFrom;

    private int yearTo;

    public CarFilter() {
    }

    public CarFilter(int yearFrom, int yearTo) {
        this.yearFrom = yearFrom;
        this.yearTo = yearTo;
    }

    public int getYearFrom() {
        return yearFrom;
    }

    public void setYearFrom(int yearFrom) {
        this.yearFrom = yearFrom;
    }

    public int getYearTo() {
        return yearTo;
    }

    public void setYearTo(int yearTo) {
        this.yearTo = yearTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarFilter carFilter = (CarFilter) o;
        return yearFrom == carFilter.yearFrom && yearTo == carFilter.yearTo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(yearFrom, yearTo);
    }

    @Override
    public String toString() {
        return "CarFilter{" +
                "yearFrom=" + yearFrom +
                ", yearTo=" + yearTo +
                '}';
    }
}
