package main.subclasses;

public class Effectiveness {
    private final String effectiveness;
    private final Integer value;

    public Effectiveness(String effectiveness) throws Exception {
        switch (effectiveness) {
            case "NISKA":
                this.value = 60;
                break;
            case "ŚREDNIA":
                this.value = 90;
                break;
            case "WYSOKA":
                this.value = 120;
                break;
            default:
                throw new Exception("The efficiency value must be NISKA, ŚREDNIA or WYSOKA");
        }
        this.effectiveness = effectiveness;
    }

    public String getEffectiveness() {
        return effectiveness;
    }

    public Integer getValue() {
        return value;
    }
}
