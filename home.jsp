<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.food.model.restaurent,com.food.model.menu,com.food.model.user"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>QuickBite Express</title>
    <link rel="stylesheet" href="home.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
   <style>
   body {
            background-image: linear-gradient(216deg, rgba(77, 77, 77,0.05) 0%, rgba(77, 77, 77,0.05) 25%,rgba(42, 42, 42,0.05) 25%, rgba(42, 42, 42,0.05) 38%,rgba(223, 223, 223,0.05) 38%, rgba(223, 223, 223,0.05) 75%,rgba(36, 36, 36,0.05) 75%, rgba(36, 36, 36,0.05) 100%),linear-gradient(44deg, rgba(128, 128, 128,0.05) 0%, rgba(128, 128, 128,0.05) 34%,rgba(212, 212, 212,0.05) 34%, rgba(212, 212, 212,0.05) 57%,rgba(25, 25, 25,0.05) 57%, rgba(25, 25, 25,0.05) 89%,rgba(135, 135, 135,0.05) 89%, rgba(135, 135, 135,0.05) 100%),linear-gradient(241deg, rgba(55, 55, 55,0.05) 0%, rgba(55, 55, 55,0.05) 14%,rgba(209, 209, 209,0.05) 14%, rgba(209, 209, 209,0.05) 60%,rgba(245, 245, 245,0.05) 60%, rgba(245, 245, 245,0.05) 69%,rgba(164, 164, 164,0.05) 69%, rgba(164, 164, 164,0.05) 100%),linear-gradient(249deg, rgba(248, 248, 248,0.05) 0%, rgba(248, 248, 248,0.05) 32%,rgba(148, 148, 148,0.05) 32%, rgba(148, 148, 148,0.05) 35%,rgba(202, 202, 202,0.05) 35%, rgba(202, 202, 202,0.05) 51%,rgba(181, 181, 181,0.05) 51%, rgba(181, 181, 181,0.05) 100%),linear-gradient(92deg, hsl(214,0%,11%),hsl(214,0%,11%));
            color: white;
        }

        header {
            background-color: #7B88C1;
            padding: 15px;
            text-align: center;
        }

        #b {
            font-style: italic;
            color: white;
            text-decoration: none;
            text-align:center;
           
            
            
            
            
        }
#b:hover{
             transform: scale(1.05);

}
        .search-form {
            margin-top: 20px;
            margin-bottom: 20px;
            text-align: center;
        }

        .container {
            margin-top: 20px;
        }

        .card {
            border: none;
            margin-bottom: 20px;
            background-color: #fff;
            transition: transform 0.3s;
            
        }

        .card:hover {
            transform: scale(1.05);
        }

        .color1 {
            background-image: linear-gradient(216deg, rgba(77, 77, 77,0.05) 0%, rgba(77, 77, 77,0.05) 25%,rgba(42, 42, 42,0.05) 25%, rgba(42, 42, 42,0.05) 38%,rgba(223, 223, 223,0.05) 38%, rgba(223, 223, 223,0.05) 75%,rgba(36, 36, 36,0.05) 75%, rgba(36, 36, 36,0.05) 100%),linear-gradient(44deg, rgba(128, 128, 128,0.05) 0%, rgba(128, 128, 128,0.05) 34%,rgba(212, 212, 212,0.05) 34%, rgba(212, 212, 212,0.05) 57%,rgba(25, 25, 25,0.05) 57%, rgba(25, 25, 25,0.05) 89%,rgba(135, 135, 135,0.05) 89%, rgba(135, 135, 135,0.05) 100%),linear-gradient(241deg, rgba(55, 55, 55,0.05) 0%, rgba(55, 55, 55,0.05) 14%,rgba(209, 209, 209,0.05) 14%, rgba(209, 209, 209,0.05) 60%,rgba(245, 245, 245,0.05) 60%, rgba(245, 245, 245,0.05) 69%,rgba(164, 164, 164,0.05) 69%, rgba(164, 164, 164,0.05) 100%),linear-gradient(249deg, rgba(248, 248, 248,0.05) 0%, rgba(248, 248, 248,0.05) 32%,rgba(148, 148, 148,0.05) 32%, rgba(148, 148, 148,0.05) 35%,rgba(202, 202, 202,0.05) 35%, rgba(202, 202, 202,0.05) 51%,rgba(181, 181, 181,0.05) 51%, rgba(181, 181, 181,0.05) 100%),linear-gradient(92deg, hsl(214,0%,11%),hsl(214,0%,11%));
            color: white;
            font-size: 20px;
            text-align: center;
            padding: 15px;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
   .card-body{
   
   font-size:15px;
   font-family:italic;
   }
     
        
        }
        .cart:hover{
        transform: scale(1.05);
        }
        .sameline {
      display: flex;
        justify-content: center;
        
      
    }
    .home {
      margin-right: 10px; 
   
    }
        
       
        }
        .home:hover{
        transform: scale(1.05);
        
        
        
        }
        .name{
        color:white;
        text-decoration:none;
        }
        
   
   
   </style>
</head>
<body>
<br>

    <h2 id="b">QuickBite Express</h2>
    <div class="sameline">
<div class="home"><a href="cartservlet"><p class="name">View Cart</p></a></div>
<div class="home"></div><a href="home"><p class="name" >Home</p></a></div>



  
<br>
<div class="container">
    

    <div class="row">
        <%
        List<restaurent> E =(List<restaurent>)request.getAttribute("restList");
        if(E !=null){
            for(restaurent res: E) {
        %>
        <div class="col-md-4">
            <a href="Menu?restaurent_id=<%= res.getRestaurent_id()%>" class="text-decoration-none">
                <div class="card">
                    <img src="<%=res.getImagepath() %>" class="card-img-top" alt="Restaurant Image" height="170px">
                    <div class="card-body">
 <h5 class="card-title">Name: <%= res.getName() %></h5>
   <p class="card-text">Rating: <%= res.getRating() %></p>
<p class="card-text">Cuisine Type: <%= res.getCuisine_type() %></p>
<p class="card-text">Address: <%= res.getAddress() %></p>
<p class="card-text">Delivery Time: <%= res.getDelivery_time() %></p>
<p class="card-text">Active: <%= res.isIs_active() %></p>
                    </div>
                </div>
            </a>
        </div>
        <%
            }
        }
        %>
    </div>
</div>
<br>
<br>
<br>
<br>
<footer class="color1">
    <p>&copy; 2024 QuickBite Express. All rights reserved.</p>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
