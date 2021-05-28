package main.register;

import main.comparators.MainSort;
import main.employees.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

final public class Register {
    private final ArrayList<Employee> register;

    public Register(Employee... employees) {
        this.register = new ArrayList<>(Arrays.asList(employees));
    }

    public ArrayList<Employee> getRegister() {
        return register;
    }

    public void addEmployee(Employee employee) {
        register.add(employee);
    }

    public void addEmployees(Employee... employees) {
        register.addAll(Arrays.asList(employees));
    }

    public void removeEmployee(String id) {
        register.removeIf(employee -> employee.getId().equals(id));
    }

    public ArrayList<Employee> display() {
        register.sort(new MainSort());

        for (Employee worker : register) {
            System.out.println("\n##################################################################");
            System.out.println(worker.toString());
            System.out.println("##################################################################");
        }

        return register;
    }

    public List<Employee> displayByCity(String city) {
        List<Employee> filtered = register.stream()
                .filter(employee -> employee.getAddress().getCity().equals(city))
                .collect(Collectors.toList());

        for (Employee worker : filtered) {
            System.out.println("\n##################################################################");
            System.out.println(worker.toString());
            System.out.println("##################################################################");
        }

        return filtered;
    }
}
