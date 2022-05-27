<%@ page import="java.util.HashMap" %>
<%@ page import="com.example.ProductAsm.Entity.Product" %>
<%@ page import="com.example.ProductAsm.Constant.ValidationConstant" %><%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 5/27/2022
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        .invalid-feedback {
            display: block;
        }
    </style>
</head>
<body>
<%
    HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");
    if(errors == null) {
        errors = new HashMap<>();
    }
    Product product = (Product) request.getAttribute("product");
    if(product == null) {
        product = new Product();
    }
%>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <form action="/products/create" method="post">
                <fieldset class="form-group">
                    <label>Name</label> <input type="text"  class="form-control" name="name" value="<%= product.getName() %>" >
                    <% if(errors.containsKey(ValidationConstant.PRODUCT_ERROR_KEY_NAME)) { %>
                    <div class="invalid-feedback">
                        <%= errors.get(ValidationConstant.PRODUCT_ERROR_KEY_NAME) %>
                    </div>
                    <% } %>
                </fieldset>
                <fieldset class="form-group">
                    <label>Thumbnail</label> <input type="text"  class="form-control" name="thumbnail" value="<%= product.getThumbnail() %>" >
                    <% if(errors.containsKey(ValidationConstant.PRODUCT_ERROR_KEY_THUMBNAIL)) { %>
                    <div class="invalid-feedback">
                        <%= errors.get(ValidationConstant.PRODUCT_ERROR_KEY_THUMBNAIL) %>
                    </div>
                    <% } %>
                </fieldset>
                <fieldset class="form-group">
                    <label>Price</label> <input type="number"  class="form-control" name="price" value="<%= product.getPrice() %>" >
                    <% if(errors.containsKey(ValidationConstant.PRODUCT_ERROR_KEY_PRICE)) { %>
                    <div class="invalid-feedback">
                        <%= errors.get(ValidationConstant.PRODUCT_ERROR_KEY_PRICE) %>
                    </div>
                    <% } %>
                </fieldset>
                <fieldset class="form-group">
                    <label>Email</label> <input type="text"  class="form-control" name="manufactureEmail" value="<%= product.getManufactureEmail() %>" >
                    <% if(errors.containsKey(ValidationConstant.PRODUCT_ERROR_KEY_MANUFACTURE_EMAIl)) { %>
                    <div class="invalid-feedback">
                        <%= errors.get(ValidationConstant.PRODUCT_ERROR_KEY_MANUFACTURE_EMAIl) %>
                    </div>
                    <% } %>
                </fieldset>
                <fieldset class="form-group">
                    <label>Phone</label> <input type="text"  class="form-control" name="manufacturePhone" value="<%= product.getManufacturePhone() %>" >
                    <% if(errors.containsKey(ValidationConstant.PRODUCT_ERROR_KEY_MANUFACTURE_PHONE)) { %>
                    <div class="invalid-feedback">
                        <%= errors.get(ValidationConstant.PRODUCT_ERROR_KEY_MANUFACTURE_PHONE) %>
                    </div>
                    <% } %>
                </fieldset>
                <fieldset class="form-group">
                    <label>Description</label> <textarea  class="form-control" name="description" ><%= product.getDescription() %></textarea>
                </fieldset>
                <fieldset class="form-group">
                    <label>Details</label> <textarea  class="form-control" name="detail" ><%= product.getDetail() %></textarea>
                </fieldset>
                <button type="submit" class="btn btn-success">Save</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
