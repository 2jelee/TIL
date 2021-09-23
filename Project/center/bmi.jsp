<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%-- 
  Title         : Assignment2.
  Subject       : Internet Programming
  Author        : Mohd Rafyiq Bin Ramli
  Matrix Number : SX085606CJD04 
  Lecturer      : Dr. Hishammuddin Bin Asmuni
--%>
<body>
<%--         <%@include file="htmlheadtag.jsp" %> --%>
<%--         <%@include file="header.jsp" %> --%>


        <div class="container">
<%--             <%@include file="menu.jsp" %> --%>
            <div class="row">
                <div class="box">
                    <div class="col-lg-12 text-center">
                        <h1 class="brand-name">BMI Calculator
                        <img src="img/bmi1.jpg" alt=""/></h1>
                    </div>
                </div>
            </div>



            <div class="row">
                <div class="box">
                    <div class="col-lg-6">
                        <hr>
                            <h2 class="intro-text text-center">Question 1 :
                                <strong>Body Mass Index Problem</strong>
                            </h2>
                        <hr>

                        <hr class="visible-xs">
                        <p>Write a JSP that allow users enter the weight and the height of a person and then displays his/her Body Mass Index using the following formula:</p>
                        <img class="img-responsive img-border img-left" src="img/bmi-formula.jpg" alt="">

                    </div>
                    <div class="col-lg-6">
                        <hr>
                        <h2 class="intro-text text-center">Answer :<strong>Body Mass Index Problem</strong></h2>
                        <hr>
                        <hr class="visible-xs">
                        <div align="center">
                            <div style="background-color:green; color:yellow; font-weight:bold; ">Body Mass Index Calculator</div><br>
                            <form action="bmi.jsp" method="POST">
                                Weight : <input type="text" name="weightTextBox" id="weightTextBox" value="" />&nbsp; kg<br><br>
                                Height : <input type="text" name="heightTextBox" id="heightTextBox" value="" />&nbsp; m<br><br>
                                <input type="submit" value="Calculate BMI" name="calculateBMIButton" />
                            </form>
                        </div>

                            <%
    String semakberat = request.getParameter("weightTextBox");
    String semaktinggi = request.getParameter("heightTextBox");
    if (semakberat == null && semaktinggi == null) 
    {
        %><div align="center"><h4>You can enter your Weight and Height</h4></div><%// myText is null when the page is first requested, 
        // so do nothing
    } else if (semakberat.length() == 0 && semaktinggi.length() == 0) {  %>
            <div align="center"><h4>Please Enter Weight & Height</h4></div>
 <% }else if (semakberat.length() == 0 && semaktinggi.length() != 0) { %>
            <div align="center"><h4>Please Enter Weight</h4></div>
 <% }else if (semakberat.length()!= 0 && semaktinggi.length() == 0) { %>
            <div align="center"><h4>Please Enter Height</h4></div>
 <% } else {
        float berat=0, tinggi=0, bmi=0;           
        berat = Float.parseFloat(request.getParameter("weightTextBox"));
        tinggi = Float.parseFloat(request.getParameter("heightTextBox")); 
//         DecimalFormat df = new DecimalFormat("#,###,##0.0");
        String status = new String();
        bmi = berat / (tinggi * tinggi);
        //Start : Weight Status
        if (bmi < 18.5)
           status = "Underweight";
        else if (bmi > 18.5 && bmi < 25)
           status = "Normal";   
        else if (bmi > 25 && bmi < 30)
           status = "Normal"; 
        else if (bmi > 30)
           status = "Obese";
        else
           status = "No Status";
        
        if (tinggi > 3)
           status = "invalid range, Height in Meter please";
%>
        <div align="center">
            <h4>Your Weight :<%= berat %> kg</h4>
            <h4>Your Height :<%= tinggi %> m</h4>
<%--             <h4>Your BMI : <%= df.format(bmi) %></h4> --%>
            <h4>Weight Status : <%= status %></h4> 
        </div>

 <% } %> 
                    </div>                
                </div>
            </div>

            <div class="row">
                <div class="box">


                        <hr>
                        <h2 class="intro-text text-center">JSP 
                            <strong>Code</strong>
                        </h2>
                        <hr>
                        <iframe src="sourcecode/bmi.txt" width="100%" height="100%"></iframe>                                       

                </div>
        </div>
        </div>



<%--         <%@include file="footer.jsp" %> --%>
    </body>
</html>