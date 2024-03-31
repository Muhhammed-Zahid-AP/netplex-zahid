<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.food.model.cart,com.food.model.cartitem,java.util.Map,java.util.HashMap,com.food.model.menu,com.food.dao.menudao,com.food.daoimplementation.menudaoimp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="additem.css">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<style>

 body {
           background-image: linear-gradient(216deg, rgba(77, 77, 77,0.05) 0%, rgba(77, 77, 77,0.05) 25%,rgba(42, 42, 42,0.05) 25%, rgba(42, 42, 42,0.05) 38%,rgba(223, 223, 223,0.05) 38%, rgba(223, 223, 223,0.05) 75%,rgba(36, 36, 36,0.05) 75%, rgba(36, 36, 36,0.05) 100%),linear-gradient(44deg, rgba(128, 128, 128,0.05) 0%, rgba(128, 128, 128,0.05) 34%,rgba(212, 212, 212,0.05) 34%, rgba(212, 212, 212,0.05) 57%,rgba(25, 25, 25,0.05) 57%, rgba(25, 25, 25,0.05) 89%,rgba(135, 135, 135,0.05) 89%, rgba(135, 135, 135,0.05) 100%),linear-gradient(241deg, rgba(55, 55, 55,0.05) 0%, rgba(55, 55, 55,0.05) 14%,rgba(209, 209, 209,0.05) 14%, rgba(209, 209, 209,0.05) 60%,rgba(245, 245, 245,0.05) 60%, rgba(245, 245, 245,0.05) 69%,rgba(164, 164, 164,0.05) 69%, rgba(164, 164, 164,0.05) 100%),linear-gradient(249deg, rgba(248, 248, 248,0.05) 0%, rgba(248, 248, 248,0.05) 32%,rgba(148, 148, 148,0.05) 32%, rgba(148, 148, 148,0.05) 35%,rgba(202, 202, 202,0.05) 35%, rgba(202, 202, 202,0.05) 51%,rgba(181, 181, 181,0.05) 51%, rgba(181, 181, 181,0.05) 100%),linear-gradient(92deg, hsl(214,0%,11%),hsl(214,0%,11%));
            color: #343a40;
            font-family: 'Helvetica Neue', sans-serif;
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            color:white;
        }

#a{

text-decoration:none;
color:black;

}
#h1{
color:white;
font-style:italic;
text-align:center;
}

.main{
 width: 300px;
            margin: 20px auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 8px; 
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); 
            background-color: #f9f9f9;
          color:black;

}

</style>
</head>
<body>
<br>
<h1 id="h1">Your Shopping Cart</h1>

    <div class="main">
    

<%
cart cart=(cart)session.getAttribute("cart");
if(cart != null && !cart.getItems().isEmpty()){
for(cartitem item : cart.getItems().values())
{



%>

        <div>
            <h3><%=item.getName()%></h3>
            <p>Price:<%=item.getPrice()%></p>

            <form action="cartservlet" method="post">
                <input type="hidden" name="itemid" value="<%=item.getOrder_item_id()%>">
                
                <label>Quantity:
                    <input type="number" name="quantity" value="<%=item.getQuantity()%>" min="1">
                </label>
                <input type="submit"  name="action" value="update" class="btn btn-success">
                <input type="submit" name="action" value="remove" class="btn btn-danger">
              
            </form>
        </div>

<br>
        <%
            }
        } 
            else {
        %>

        <p>Your cart is empty</p>

        <%
            }
        %>

<br>


        <a id="a" href="Menu?restaurent_id=<%=session.getAttribute("restaurentid")%>"><input type="button" value="Add more Items" class="btn btn-warning"></a>
<br>
        <%
            if (session.getAttribute("cart") != null) {
        %>

        <form action="checkout.jsp" method="post">
            <input type="submit" name="proceed" value="Proceed to Checkout" class="btn btn-info">
        </form>


        <%
            }
        %>

    </div>







</body>
</html>