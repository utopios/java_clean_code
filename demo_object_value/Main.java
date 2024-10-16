public class Temperature {
    private final double value;

    public Temperature(doube value) {
        this.value = value;
    }

    public doube getValue() {
        return this.value;
    }
}

public class Main {
    public static void main(String[] args) {

    }

    private Temperature convertToFahrenheit(Temperature temperature) {
        //temperature.setValue(temperature.getValue * 9/5 + 32);
        return new Temperature(temperature.getValue() * 9/5 +32);
    }
}