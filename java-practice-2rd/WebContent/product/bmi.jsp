<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    String THeight = request.getParameter("height");
    String TWeight = request.getParameter("weight");

    Double RHeight = Double.parseDouble(THeight);
    Double RWeight = Double.parseDouble(TWeight);

    RHeight = RHeight/100;

    double bmi = RWeight / (RHeight*RHeight);
%>

  
    Your height : <%= THeight %> cm <br/>

    Your weight : <%= TWeight %> kg <br/><br/>

    and Your BMI is : <%= bmi %> <br/> ※ Comment :

    

    <% if(bmi > 25) %> ddd?

    <% if(bmi > 20 && bmi <=25) %> ffff

    <% if(bmi <= 20 ) %> qqqq?    