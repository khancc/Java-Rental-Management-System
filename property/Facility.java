package property;

import java.sql.*;
import java.util.ArrayList;
import database.DatabaseConnection;

public class Facility {
    private Boolean swimmingPool=false,parking=false,wifi=false,airCon=false,tv=false,fridge=false,washingMachine=false,gymRoom=false,waterHeater=false,gas=false;
    private int propertyId;

    //Constructor
    public Facility(){}
	
     public void resetFacility(){ //reset all facility become false
        this.swimmingPool = false;
        this.parking = false;
        this.wifi = false;
        this.airCon = false;
        this.tv = false;
        this.fridge = false;
        this.washingMachine = false;
        this.gymRoom = false;
        this.waterHeater = false;
        this.gas = false;
    }

    public void setFacility(ArrayList<String> facilities){ //set facility from user input
	    resetFacility(); //make use all false
        for(String facility: facilities){
            if (facility.equals("Swimming Pool")) this.swimmingPool = true;
            if (facility.equals("Parking")) this.parking = true;
            if (facility.equals("Wifi")) this.wifi = true;
            if (facility.equals("Air Conditional")) this.airCon = true;
            if (facility.equals("Tv")) this.tv = true;
            if (facility.equals("Fridge")) this.fridge = true;
            if (facility.equals("Washing Machine")) this.washingMachine = true;
            if (facility.equals("Gym Room")) this.gymRoom = true;
            if (facility.equals("Water Heater")) this.waterHeater = true;
            if (facility.equals("Stove")) this.gas = true;
        }
    }

    public void storeDatabase(){ //store facility into database
        try {
            Statement statement = DatabaseConnection.getConnection().createStatement();
            String sql = "insert into facility (pool, parking, wifi, air_conditioner, tv, fridge, washing_machine, gym, water_heater, stove,property_id) values ("
                    + swimmingPool + "," + parking + "," +  wifi  + "," + airCon + "," + tv + "," + fridge + "," + washingMachine + "," + gymRoom + "," +waterHeater + "," + gas
                    + ",(SELECT property_id FROM property order by property_id desc limit 1));"; //set this property's id using the latest property's id
            statement.executeUpdate(sql);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void updateDatabase(int propertyID){ //update facility in database
        try {

            Statement statement = DatabaseConnection.getConnection().createStatement();
            String sql = "update facility " +
                    "set pool = " +swimmingPool +
                    ", parking = " + parking +
                    ", wifi = " + wifi +
                    ", air_conditioner = " + airCon +
                    ", tv = " + tv +
                    ", fridge = " + fridge +
                    ", washing_machine = " + washingMachine +
                    ", gym = " + gymRoom +
                    ", water_heater = " + waterHeater +
                    ", stove = " + gas +
                    " where property_id = " + propertyID +
                    ";";
            statement.executeUpdate(sql);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public ArrayList<String> getFacilityFromDatabase(int propertyID){ //read facility from database
        ArrayList<String> trueFacility = new ArrayList<>();
        try{
            Statement statement = DatabaseConnection.getConnection().createStatement();
            String sql = "select * from facility where property_id=" + propertyID + ";";
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                swimmingPool = result.getBoolean("pool");
                if (swimmingPool)
                    trueFacility.add("Swimming Pool");

                parking = result.getBoolean("parking");
                if (parking)
                    trueFacility.add("Parking");

                wifi = result.getBoolean("wifi");
                if (wifi)
                    trueFacility.add("Wifi");

                airCon = result.getBoolean("air_conditioner");
                if (airCon)
                    trueFacility.add("Air Conditional");

                tv = result.getBoolean("tv");
                if (tv)
                    trueFacility.add("Tv");

                fridge = result.getBoolean("fridge");
                if (fridge)
                    trueFacility.add("Fridge");

                washingMachine = result.getBoolean("washing_machine");
                if (washingMachine)
                    trueFacility.add("Washing Machine");

                gymRoom = result.getBoolean("gym");
                if (gymRoom)
                    trueFacility.add("Gym Room");

                waterHeater = result.getBoolean("water_heater");
                if (waterHeater)
                    trueFacility.add("Water Heater");

                gas = result.getBoolean("stove");
                if (gas)
                    trueFacility.add("Stove");

            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return trueFacility;
    }

    //getter
    public int getPropertyId() {
        return this.propertyId;
    }

    //setter
    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

}
