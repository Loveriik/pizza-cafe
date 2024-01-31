<%@ page import="model.PizzaType" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <link rel="stylesheet" href="./styles/pizzaMenuStyles.css"/>
    <title>Pizza menu</title>
</head>
<body>
<header class="header">
    <nav class="nav">
        <h1 class="title1">Welcome to Papa Pizza</h1>
        <div>
            <button>Sign up</button>
            <button>Sign up</button>
        </div>
    </nav>
</header>
<section class="section1">
    <ul>
                <% ArrayList<PizzaType> pizzaArray = (ArrayList<PizzaType>) request.getAttribute("pizza"); %>
                <%for (int i = 0; i < pizzaArray.size(); i++) {%>
                <li>
                    <%= pizzaArray.get(i).getName() %>
                </li>
                <% } %>
    </ul>
</section>
</body>
</html>
