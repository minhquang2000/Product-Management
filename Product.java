/**
 * Product
 */
public class Product {
    private String bcode, title;
    private int quantity;
    private double price;
    /**
     * 
     * Default constructor
     * 
     */

    public Product() {

    }

    /**
     * 
     * Constructor method to initialize a product
     *
     * 
     * 
     * @param bcode    Product's bar code
     * 
     * @param title    Product's title
     * 
     * @param quantity Product's quantity
     * 
     * @param price    Product's price
     * 
     */

    public Product(String bcode, String title, int quantity, double price) {
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }
    public String getBcode(){
        return bcode;
    }
    public String getTitle(){
        return title;
    }
    public int getQuantity(){
        return quantity;
    }
    public double getPrice(){
        return price;
    }
    public void setBcode(String bcode){
        this.bcode = bcode;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void setPrice(double price){
        this.price = price;
    }
    /**
     * 
     * Convert this product to String for printing
     * 
     */

    @Override

    public String toString() {
        return bcode + " | " + title + " | " + quantity + " | " + price;
    }
}