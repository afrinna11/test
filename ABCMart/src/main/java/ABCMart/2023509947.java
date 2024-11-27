package ABCMart;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;



public class OrderServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
 
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

 
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }

 
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      // Declarations
      DecimalFormat df = new DecimalFormat("0.00");
      double subtotal = 0.00, total = 0.00;
      double fruitTotal = 0.00, vegetablesTotal = 0.00;
      double householdTotal = 0.00, dairyTotal = 0.00;

      // Retrieve input parameter values (7 marks)
      String fruitQtyStr = request.getParameter("fruitQuantity");
      String vegetablesQtyStr = request.getParameter("vegetablesQuantity");
      String householdQtyStr = request.getParameter("householdQuantity");
      String dairyQtyStr = request.getParameter("dairyQuantity");
      String discountCode = request.getParameter("voucher");

      int fruitQty = Integer.parseInt(fruitQtyStr);
      int vegetablesQty = Integer.parseInt(vegetablesQtyStr);
      int householdQty = Integer.parseInt(householdQtyStr);
      int dairyQty = Integer.parseInt(dairyQtyStr);

      // Calculate total for each category (4 marks)
      fruitTotal = fruitQty * 5.00;
      vegetablesTotal = vegetablesQty * 3.00;
      householdTotal = householdQty * 7.00;
      dairyTotal = dairyQty * 15.00;

      // Calculate subtotal (1 mark)
      subtotal = fruitTotal + vegetablesTotal + householdTotal + dairyTotal;

      // Calculate total after discount (4 marks)
      if ("GROCERY10".equalsIgnoreCase(discountCode)) {
          total = subtotal * 0.90; // Apply 10% discount
      } else {
          total = subtotal; // No discount
      }

      // Display output in HTML (14 marks)
      out.println("<html><body>");
      out.println("<h1>ABC Mart</h1>");
      out.println("<h2>Order Summary</h2>");
      out.println("<tr><th>Category</th><th>Quantity</th><th>Total</th></tr>");
      out.println("<br>Fruits:" + fruitQty + "RM " + df.format(fruitTotal));
      out.println("<br>Vegetables:" + vegetablesQty + "RM " + df.format(vegetablesTotal));
      out.println("<br>Household:" + householdQty + "RM " + df.format(householdTotal) );
      out.println("<br>Dairy:" + dairyQty + "RM " + df.format(dairyTotal) );
      out.println("<br>Subtotal:RM " + df.format(subtotal) );
      if ("GROCERY10".equalsIgnoreCase(discountCode)) {
          out.println("<br>Discount (10%)<br>-RM " + df.format(subtotal * 0.10) );
      }
      out.println("<br>Total:RM " + df.format(total));
      out.println("<br>------------------------------------------");
      out.println("<br>--Thank you!--");
      out.println("</body></html>");
  }

 //Nurul Afrina binti Abdul Rahim(2023509947)
    
    
  }