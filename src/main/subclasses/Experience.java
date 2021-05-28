package main.subclasses;

public class Experience {
    private final String position;
    private final Double yearsOfExperience;

    public Experience(String position, Integer monthsOfExperience) throws Exception {
        if (monthsOfExperience < 0) {
            throw new Exception("Value of months cannot be less than 0");
        }
        double scale = Math.pow(10, 2);
        this.position = position;
        this.yearsOfExperience = Math.round(((double) monthsOfExperience / 12) * scale) / scale;
    }

    public String getPosition() {
        return position;
    }

    public Double getYearsOfExperience() {
        return yearsOfExperience;
    }
}
