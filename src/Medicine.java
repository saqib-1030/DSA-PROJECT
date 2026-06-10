public class Medicine {

    // ---------- Attributes ----------
    private String medicineId;
    private String medicineName;
    private String category;
    private double price;
    private int    quantity;
    private String expiryDate;
    private String manufacturer;

    // ---------- Constructor ----------
    public Medicine(String medicineId, String medicineName, String category,
                    double price, int quantity, String expiryDate, String manufacturer) {
        this.medicineId   = medicineId;
        this.medicineName = medicineName;
        this.category     = category;
        this.price        = price;
        this.quantity     = quantity;
        this.expiryDate   = expiryDate;
        this.manufacturer = manufacturer;
    }

    // ---------- Getters ----------
    public String getMedicineId()   { return medicineId; }
    public String getMedicineName() { return medicineName; }
    public String getCategory()     { return category; }
    public double getPrice()        { return price; }
    public int    getQuantity()     { return quantity; }
    public String getExpiryDate()   { return expiryDate; }
    public String getManufacturer() { return manufacturer; }

    // ---------- Setters ----------
    public void setMedicineName(String medicineName) { this.medicineName = medicineName; }
    public void setCategory(String category)         { this.category     = category; }
    public void setPrice(double price)               { this.price        = price; }
    public void setQuantity(int quantity)            { this.quantity     = quantity; }
    public void setExpiryDate(String expiryDate)     { this.expiryDate   = expiryDate; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    // ---------- Display ----------
    public void displayMedicine() {
        System.out.println("--------------------------------------");
        System.out.println("  ID          : " + medicineId);
        System.out.println("  Name        : " + medicineName);
        System.out.println("  Category    : " + category);
        System.out.println("  Price       : Rs. " + price);
        System.out.println("  Quantity    : " + quantity);
        System.out.println("  Expiry Date : " + expiryDate);
        System.out.println("  Manufacturer: " + manufacturer);
        System.out.println("--------------------------------------");
    }
}