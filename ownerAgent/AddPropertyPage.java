package ownerAgent;

public class AddPropertyPage extends PropertyPage {
    //Constructor
    public AddPropertyPage(){
        this.setTitle("Add Property Page");

        //Overwrite
        titleLabel.setText("Add Property");
        saveButton.setText("Submit Property");

        //Set initial active status
        activeStatusCB.setSelected(true);
    }
}
