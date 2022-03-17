package property;

import java.util.ArrayList;

public interface PropertyInterface{

    //save new property and facility into database
    void addProperty(Property property,ArrayList<String> facility);

    //save edited property and facility into database
    void editProperty(Property property,ArrayList<String> facility);

    //delete a property in database
    void deleteProperty(int propertyID);

    //Get all my properties from database
    ArrayList<Property> viewOwnProperty();
}
