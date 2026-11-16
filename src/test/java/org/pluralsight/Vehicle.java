
package org.pluralsight;

import java.math.BigDecimal;
import java.time.Year;

public class Vehicle extends Asset {

    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired,
                   BigDecimal originalCost, String makeModel,
                   int year, int odometer) {

        super(description, dateAcquired, originalCost);

        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public BigDecimal getValue() {

        int age = Year.now().getValue() - year;

        BigDecimal value = getOriginalCost();

        if (age >= 0 && age <= 3) {
            value = value.multiply(
                    BigDecimal.ONE.subtract(
                            new BigDecimal("0.03").multiply(
                                    BigDecimal.valueOf(age))));

        } else if (age >= 4 && age <= 6) {
            value = value.multiply(
                    BigDecimal.ONE.subtract(
                            new BigDecimal("0.06").multiply(
                                    BigDecimal.valueOf(age))));

        } else if (age >= 7 && age <= 10) {
            value = value.multiply(
                    BigDecimal.ONE.subtract(
                            new BigDecimal("0.08").multiply(
                                    BigDecimal.valueOf(age))));

        } else if (age > 10) {
            value = new BigDecimal("1000.00");
        }

        // Reduce value by 25% if mileage is over 100,000
        // Honda and Toyota vehicles are exempt

        boolean isHondaOrToyota =
                makeModel.toLowerCase().contains("honda") ||
                        makeModel.toLowerCase().contains("toyota");

        if (odometer > 100000 && !isHondaOrToyota) {
            value = value.multiply(new BigDecimal("0.75"));
        }

        return value;
    }
}
