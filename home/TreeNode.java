package home;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.tree.DefaultMutableTreeNode;
import database.DatabaseConnection;

public class TreeNode {

    //Constructor
    public TreeNode(){}

    //Variable
    private ArrayList<DefaultMutableTreeNode> allNode;

    public String getSelectedNode(String node){ //get query to access database based on node chosen
        String query;
        switch (node) {
            case "Project/Township":
                query = "SELECT property_project FROM property GROUP BY property_project";
                return query;
            case "Owner":
                query = "SELECT owner_name FROM owner,property WHERE property_owner = owner_id GROUP BY owner_id";
                return query;
            case "Agent":
                query = "SELECT agent_name FROM agent,property WHERE property_agent = agent_id GROUP BY agent_id";
                return query;
        }
        return null;
    }

    public DefaultMutableTreeNode setChildNode(String nodeString,DefaultMutableTreeNode node){ //set child node based on what we get from database
        String query = getSelectedNode(nodeString); //get query to access database based on node chosen
        try{
            Statement stmt = DatabaseConnection.getConnection().createStatement();
            ResultSet rs=stmt.executeQuery(query);

            while(rs.next()){
                //add child node to their parent node
                node.add(new DefaultMutableTreeNode(rs.getString(1)));
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return node;
    }

    public DefaultMutableTreeNode getRootNode(){ //set all nodes
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Sort and Filter Property"); //Root node

        DefaultMutableTreeNode propertyNode = new DefaultMutableTreeNode("All Property");
        DefaultMutableTreeNode ownerNode = new DefaultMutableTreeNode("Owner");
        DefaultMutableTreeNode typeNode = new DefaultMutableTreeNode("Type");
        DefaultMutableTreeNode agentNode = new DefaultMutableTreeNode("Agent");
        DefaultMutableTreeNode statusNode = new DefaultMutableTreeNode("Status");
        DefaultMutableTreeNode projectNode = new DefaultMutableTreeNode("Project/Township");
        DefaultMutableTreeNode facilityNode = new DefaultMutableTreeNode("Facility");
        DefaultMutableTreeNode priceNode = new DefaultMutableTreeNode("Price");

        allNode = new ArrayList<>(Arrays.asList(typeNode, ownerNode, agentNode, statusNode, projectNode, facilityNode, priceNode));

        //set all child node
        String[] type = {"Single Storey","Double Storey","Triple Storey","Studio","Condominium","Apartment","Townhouse","Bungalow","Other"};

        for (String value : type) {
            typeNode.add(new DefaultMutableTreeNode(value));
        }

        ownerNode=setChildNode("Owner", ownerNode);

        agentNode=setChildNode("Agent", agentNode);

        statusNode.add(new DefaultMutableTreeNode("Active"));
        statusNode.add(new DefaultMutableTreeNode("Inactive"));

        projectNode=setChildNode("Project/Township", projectNode);

        String[] facility = {"TV","Gym","Wifi","Pool","Stove","Fridge","Parking","Water heater","Washing machine","Air conditioner"};
        for (String s : facility) {
            facilityNode.add(new DefaultMutableTreeNode(s));
        }

        priceNode.add(new DefaultMutableTreeNode("Low - High"));
        priceNode.add(new DefaultMutableTreeNode("High - Low"));

        //add all child node to root node
        rootNode.add(propertyNode);
        rootNode.add(typeNode);
        rootNode.add(ownerNode);
        rootNode.add(agentNode);
        rootNode.add(statusNode);
        rootNode.add(projectNode);
        rootNode.add(facilityNode);
        rootNode.add(priceNode);

        return rootNode;
    }

    //getter
    public ArrayList<DefaultMutableTreeNode>getParentNode(){
        return allNode;
    }
}
