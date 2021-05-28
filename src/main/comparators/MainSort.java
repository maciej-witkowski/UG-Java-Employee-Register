package main.comparators;

import main.employees.Employee;

import java.util.Comparator;

public class MainSort implements Comparator<Employee> {
    public int compare(Employee a, Employee b) {
        return (a.getExperience().getYearsOfExperience() > b.getExperience().getYearsOfExperience() ? -1 :
                    (a.getAge() > b.getAge() ? 1 :
                            a.getLastName().compareTo(b.getLastName())));
    }
}
