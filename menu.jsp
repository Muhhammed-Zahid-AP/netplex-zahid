<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.food.model.menu, com.food.model.order_item,com.food.model.cart,com.food.model.cartitem" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Menu</title>
    <style>
        body {
           background-image: linear-gradient(216deg, rgba(77, 77, 77,0.05) 0%, rgba(77, 77, 77,0.05) 25%,rgba(42, 42, 42,0.05) 25%, rgba(42, 42, 42,0.05) 38%,rgba(223, 223, 223,0.05) 38%, rgba(223, 223, 223,0.05) 75%,rgba(36, 36, 36,0.05) 75%, rgba(36, 36, 36,0.05) 100%),linear-gradient(44deg, rgba(128, 128, 128,0.05) 0%, rgba(128, 128, 128,0.05) 34%,rgba(212, 212, 212,0.05) 34%, rgba(212, 212, 212,0.05) 57%,rgba(25, 25, 25,0.05) 57%, rgba(25, 25, 25,0.05) 89%,rgba(135, 135, 135,0.05) 89%, rgba(135, 135, 135,0.05) 100%),linear-gradient(241deg, rgba(55, 55, 55,0.05) 0%, rgba(55, 55, 55,0.05) 14%,rgba(209, 209, 209,0.05) 14%, rgba(209, 209, 209,0.05) 60%,rgba(245, 245, 245,0.05) 60%, rgba(245, 245, 245,0.05) 69%,rgba(164, 164, 164,0.05) 69%, rgba(164, 164, 164,0.05) 100%),linear-gradient(249deg, rgba(248, 248, 248,0.05) 0%, rgba(248, 248, 248,0.05) 32%,rgba(148, 148, 148,0.05) 32%, rgba(148, 148, 148,0.05) 35%,rgba(202, 202, 202,0.05) 35%, rgba(202, 202, 202,0.05) 51%,rgba(181, 181, 181,0.05) 51%, rgba(181, 181, 181,0.05) 100%),linear-gradient(92deg, hsl(214,0%,11%),hsl(214,0%,11%));
            color: #343a40;
            font-family: 'Helvetica Neue', sans-serif;
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        .div {
           
            text-align: center;
            padding: 20px;
            color: white;
           
        }
        .h2{
        text-decoration:none;
        text-align:left;
         
   
        }
        h2:hover{
         transform: scale(1.01);
        }

        .menu {
            text-align: center;
            color: white;
            font-family: 'Italic';
        }

        #a {
            background-color: white;
            color: #333;
            border: 1px solid #ddd;
            padding: 15px;
            margin-bottom: 20px;
            width: 400px;
            text-align: center;
            margin-left: auto;
            margin-right: auto;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        #button {
            margin-top: 10px;
        }
        #button:hover{
         transform: scale(1.10);
        }
        
        .gotocart:hover{
        
         transform: scale(1.04);
        }
       
    </style>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body>


<div class="div">
<a href="home" class="h2">
<h2><---Go to Restaurant</h2>
</a>
    <h1 class="menu">MENU</h1>
    



<div class="container mt-4">
    <div class="row justify-content-center">
        <%
        List<menu> res = (List<menu>) request.getAttribute("menulist");
        if (res != null) {
            for (menu m : res) {
        %>
        <div class="col-md-6">
            <div id="a">
                <h3>Name: <%= m.getItem_name() %></h3>
                <p>Description: <%= m.getDescription() %></p>
                <p>Price: <%= m.getPrice() %></p>
                
                <form action="cartservlet" method="post" >
                Quantity:<input type="number" name="quantity" value="1" min="1"><br>
                    <input type="submit"  value="Add to cart" class="btn btn-success">
                    <input type="hidden" name="itemid" value="<%=m.getMenu_id()%>">
                    <input type="hidden" name="action" value="add">
                </form>
            </div>
        </div>
        <%
            }
        }
        %>
    </div>
</div>
<footer class="text-center mt-4">
    <p>&copy; 2024 QuickBite Express. All rights reserved.</p>
</footer>
</div>

</body>
</html>
