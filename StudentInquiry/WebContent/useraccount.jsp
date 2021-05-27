<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html>

        <head>
            <title>Online Help Desk</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
                integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
                crossorigin="anonymous">
                <style>
                        #footer {
            position: fixed;
            
            bottom: 0;
            width: 100%;
            
            
        }
        td{
        
        color:#2a0080;
        }
        
		.button1 {
  		display: inline-block;
  		padding: 15px 25px;
  		font-size: 24px;
 		cursor: pointer;
  		text-align: center;
  		text-decoration: none;
  		outline: none;
  		color: #fff;
  		background-color: #00032e;
  		border: none;
  		border-radius: 15px;
  		box-shadow: 0 9px #999;
		}

.button1:hover {background-color: #0c0f38}

.button1:active {
  background-color: #3e8e41;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}
                
                </style>
                
                

        </head>
		
        <body style ="background-color: #ADD8E6";>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #0c0f38">
                    <div>
                        <a href="" class="navbar-brand"> Online Help Desk </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Users</a></li>
                    </ul>
                </nav>
            </header>
            <!--add content in here    -->
            
            <center>
            <c:forEach var="cus" items="${cusDetails}">
	
	<c:set var="id" value="${cus.id}"/>
	<c:set var="name" value="${cus.name}"/>
	<c:set var="email" value="${cus.email}"/>
	<c:set var="phone" value="${cus.phone}"/>
	<c:set var="userName" value="${cus.userName}"/>
	<c:set var="password" value="${cus.password}"/>
	
	
	<h1 style="color:#2a0080;"> Welcome!, ${cus.email}</h1>
	
	
	
	
	
	
	
	<br>
	<table>
	<tr><h2 style="color:#2a0080;">Student Details</h2></tr>
	<b><tr><td>StudentID</td><td>${cus.id}</td></tr>
	<tr><td>Email</td><td>${cus.name}</td></tr>
	<tr><td>Name</td><td>${cus.email}</td></tr>
	<tr><td>Phone Number</td><td>${cus.phone}</td></tr>
	<tr><td>Username</td><td>${cus.userName}</td></tr></b>
	
	</table>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	</c:forEach>
	
	<c:url value="updatecustomer.jsp" var="cusupdate">
		<c:param name="id" value="${id}"/>
		<c:param name="name" value="${name}"/>
		<c:param name="email" value="${email}"/>
		<c:param name="phone" value="${phone}"/>
		<c:param name="userName" value="${userName}"/>
		<c:param name="password" value="${password}"/>
		
	</c:url>
	

	
	<br>
	<br>
	<br>
	<br>
	<div class = "button">
	<a  href = "deletechat.jsp">
	<input class = "button1" type = "button" name="delete" value="Delete Inquiry ">
	</a><br><br>
	<a href = "chatinsert.jsp">
	<input class = "button1" type = "button" name="insert" value="Insert Inquiry  ">
	</a><br><br>
	<a href = "Chatedit.jsp">
	<input class = "button1" type = "button" name="edit" value="Update Inquiry" style="justify-content: center;">
	</a>
	</div>
        <br><br><br>    
            </center><br>
            
            
            
            <footer id = "footer">
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #0c0f38">
                    <div>
                        <a href="" class="nav-link"> About Us </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link"> Contact Us</a></li>
                    </ul>
                </nav>
            </footer>
        </body>

        </html>








