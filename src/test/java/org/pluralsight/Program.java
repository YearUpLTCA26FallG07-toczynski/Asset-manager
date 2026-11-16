
package org.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {

        ArrayList<Asset> assets = new ArrayList<>();

        // Create two houses
        House house1 = new House(
                "My house",
                "01/15/2020",
                new BigDecimal("350000.00"),
                "123 Main Street",
                1,
                2000,
                5000
        );

        House house2 = new House(
                "Vacation home",
                "06/10/2022",
                new BigDecimal("250000.00"),
                "456 Beach Road",
                2,
                1500,
                3000
        );

        // Create two vehicles
        Vehicle vehicle1 = new Vehicle(
                "My car",
                "03/20/2021",
                new BigDecimal("30000.00"),
                "Honda Accord",
                2022,
                85000
        );

        Vehicle vehicle2 = new Vehicle(
                "Tom's truck",
                "09/05/2018",
                new BigDecimal("45000.00"),
                "Ford F-150",
                2015,
                125000
        );

        // Add everything to the ArrayList
        assets.add(house1);
        assets.add(house2);
        assets.add(vehicle1);
        assets.add(vehicle2);

        // Display all assets
        for (Asset asset : assets) {

            System.out.println("--------------------------------");

            System.out.println("Description: " + asset.getDescription());
            System.out.println("Date Acquired: " + asset.getDateAcquired());
            System.out.println("Original Cost: $" + asset.getOriginalCost());
            System.out.println("Current Value: $" + asset.getValue());

            // Check whether the asset is a House
            if (asset instanceof House) {

                House house = (House) asset;

                System.out.println("Address: " + house.getAddress());

            }

            // Check whether the asset is a Vehicle
            else if (asset instanceof Vehicle) {

                Vehicle vehicle = (Vehicle) asset;

                System.out.println("Year: " + vehicle.getYear());
                System.out.println("Make/Model: " + vehicle.getMakeModel());

            }
        }

        System.out.println("--------------------------------");
    }
}
