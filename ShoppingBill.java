import java.io.*; // FileWriter, IOException
import java.sql.*; // JDBC classes
import java.util.*; // ArrayList, List, Scanner, Calendar
import java.text.SimpleDateFormat;

class Product {
    private String id;
    private String pname;
    private int qty;
    private double price;
    private double totalPrice;
    private java.sql.Date purchaseDate;

 
    Product(String id, String pname, int qty, double price, double totalPrice) {
        this.id = id;
        this.pname = pname;
        this.qty = qty;
        this.price = price;
        this.totalPrice = totalPrice;
        this.purchaseDate = new java.sql.Date(System.currentTimeMillis());
    }

    public String getId() 
   { 
     return id;
 	}
    public String getPname() 
   { 
	return pname; 
     }
    public int getQty() 
   { 
      return qty; 
    }
    public double getPrice()
   { 
   return price; 
   }
    public double getTotalPrice() 
   { 
    return totalPrice; 
    }
    public java.sql.Date getPurchaseDate()
    { 
     return purchaseDate; 
    }

    private static String centerText(String text, int width) {
        int padding = (width - text.length()) / 2;
        return " ".repeat(Math.max(0, padding)) + text + " ".repeat(Math.max(0, padding));
    }

    public static void displayFormat(FileWriter writer) throws IOException {
        String header = "   ------------------------------------------------------------\n" +
                        "     Product ID       Name           Quantity         Rate         \n" +
                        "   ------------------------------------------------------------\n";
        String centeredHeader = centerText(header, 80); 
        System.out.print(centeredHeader);
        writer.write(centeredHeader);    
    }

    public void display(FileWriter writer) throws IOException {
        String productLine = String.format(
            "      %-15s %-18s %-10d %-16.2f\n", 
                   id, pname, qty, price
        );
        System.out.print(productLine); 
        writer.write(productLine);    
    }
}

public class ShoppingBill {
    public static void main(String args[]) {
        String id, productName;
        int quantity;
        double price, totalPrice, overAllPrice = 0.0;
        double cgst, sgst, subtotal, discount;
        char choice;

 
        String url = "jdbc:mysql://localhost:3306/shoppingdb";
        String username = "root";
        String password = "1234";

        try (FileWriter writer = new FileWriter("invoice_output.txt");
             Connection conn = DriverManager.getConnection(url, username, password);
             Scanner scan = new Scanner(System.in)) {

           
            String header = centerText("--------------------Invoice-----------------", 80) + "\n" +
                            centerText("Trinity store", 80) + "\n" +
                            centerText("3/98 Mecrobertganj New Mumbai", 80) + "\n" +
                            centerText("Opposite Metro Walk", 80) + "\n" +
                            centerText("GSTIN: 03AWBPP8756K592 Contact: (+91) 9989907105", 80) + "\n";
            System.out.print(header);
            writer.write(header);

            java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(currentDate);
            String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
            String dateInfo = centerText("Date: " + formatter.format(currentDate) + "  " + days[calendar.get(Calendar.DAY_OF_WEEK) - 1], 80) + "\n" +
                              centerText("Contact: (+91) 6303048101", 80) + "\n";
            System.out.println(dateInfo);
            writer.write(dateInfo);

           
            System.out.print("Enter Customer Name: ");
            String customerName = scan.nextLine();
            String customerInfo = centerText("Customer Name: " + customerName, 80) + "\n";
            System.out.println(customerInfo);
            writer.write(customerInfo);

            
            List<Product> productList = new ArrayList<>();
            do {
                System.out.println("Enter the product details: ");
                System.out.print("Product ID: ");
                id = scan.nextLine();

                
                String query = "SELECT pname, price FROM items WHERE id = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                    pstmt.setString(1, id);
                    ResultSet rs = pstmt.executeQuery();

                    if (rs.next()) {
                       
                        productName = rs.getString("pname");
                        price = rs.getDouble("price");
                        System.out.println("Product Name : " + productName +"\n"+ "Price (per unit) : " + price);
                    } 
		 else{
                        
                        System.out.print("Product Name: ");
                        productName = scan.nextLine();
                        System.out.print("Price (per unit): ");
                        price = scan.nextDouble();

                       
                        String insertItemQuery = "INSERT INTO items (id, pname, price) VALUES (?, ?, ?)";
                        try (PreparedStatement insertPstmt = conn.prepareStatement(insertItemQuery)) {
                        insertPstmt.setString(1, id);
                        insertPstmt.setString(2, productName);
                        insertPstmt.setDouble(3, price);
                        insertPstmt.executeUpdate();
                    }}}

            System.out.print("Quantity: ");
            quantity = scan.nextInt();
            totalPrice = price * quantity;
            overAllPrice += totalPrice;

            productList.add(new Product(id, productName, quantity, price, totalPrice));

            System.out.print("Want to add more items? (y or n): ");
            choice = scan.next().charAt(0);
            scan.nextLine(); // Clear the buffer

        } while (choice == 'y' || choice == 'Y');
           
            Product.displayFormat(writer);
            for (Product p : productList) {
                p.display(writer);
            }

           
            discount = overAllPrice * 0.02;
            subtotal = overAllPrice - discount;
            sgst = subtotal * 0.12; // 12%
            cgst = sgst;

            
            String totals = centerText("Total Amount (Rs.): " + overAllPrice, 80) + "\n" +
                            centerText("Discount (Rs.): " + discount, 80) + "\n" +
                            centerText("Subtotal: " + subtotal, 80) + "\n" +
                            centerText("SGST (12%): " + sgst, 80) + "\n" +
                            centerText("CGST (12%): " + cgst, 80) + "\n" +
                            centerText("Invoice Total: " + (subtotal + cgst + sgst), 80) + "\n" +
                            centerText("----------------Thank You for Shopping!!-----------------", 80) + "\n" +
                            centerText("Visit Again", 80) + "\n";
            System.out.println("\n");
            System.out.println(totals);
            writer.write(totals);

           
            String insertQuery = "INSERT INTO products (id, pname, qty, price, totalPrice, purchaseDate) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
                for (Product p : productList) {
                    pstmt.setString(1, p.getId());
                    pstmt.setString(2, p.getPname());
                    pstmt.setInt(3, p.getQty());
                    pstmt.setDouble(4, p.getPrice());
                    pstmt.setDouble(5, p.getTotalPrice());
                    pstmt.setDate(6, p.getPurchaseDate());
                    pstmt.executeUpdate();
                }}
        } catch (SQLException | IOException e) {
            System.err.println("Error: " + e.getMessage());
        }}
  
    private static String centerText(String text, int width) {
        int padding = (width - text.length()) / 2;
        return " ".repeat(Math.max(0, padding)) + text + " ".repeat(Math.max(0, padding));
    }}
