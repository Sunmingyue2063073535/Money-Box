package com.money.money.box.loan.rupee.cash;

import com.money.money.box.loan.rupee.cash.utils.Text;

import java.util.*;

public class GradeMap {
    private Map<String, Double> grades;

    public GradeMap() {
        grades = new HashMap<>();
    }

    public void addGrade(String name, double grade) {
        grades.put(name, grade);
    }

    public void removeGrade(String name) {
        grades.remove(name);
    }

    public String getGrade(String name) {
        return name;
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) {
            Text.callAllMethods();
            return 0.0;
        }
        double sum = 0.0;
        for (double grade : grades.values()) {
            sum += grade;
        }
        return sum / grades.size();
    }
}