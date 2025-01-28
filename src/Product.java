import java.util.Objects;

public class Product {

    private String ID = "";
    private String name = "";
    private String description = "";
    private double cost = 0;


    public Product(String ID, String name, String description, double cost) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String toCSV() {
        return ID + ", " + name + ", " + description + ", " + cost;
    }

    public String toJSON() {

        String retString = "";
        char DQ = '\u0022';

        retString = "{\"ID\"" + ": " + "\"" + this.getID() + "\"" + ", ";
        retString += "\"name\"" + ": " + "\"" + this.getName() + "\"" +  ", ";
        retString += "\"description\"" + ": " + "\"" + this.getDescription() + "\"" + ", ";
        retString += "\"cost\"" + ": " + "\"" + this.getCost() + "}";

        return retString;
    }

    public String toXML() {
        String retString = ("<Product> \n" +
                " <ID>" + ID + "</ID> \n" +
                " <name>" + name + "</name> \n" +
                " <description>" + description + "</description> \n" +
                " <cost>" + cost + "</cost> \n" +
                "</Product>");
        return retString;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost='" + cost + '\'' +
                '}';
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return cost == product.cost && Objects.equals(ID, product.ID) && Objects.equals(name, product.name) && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, description, cost);
    }

}
