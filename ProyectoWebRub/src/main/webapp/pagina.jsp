<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	
	<%@include file="trocito.jsp" %>
	<%! public String concatenar(String a, String b){
		
			return a+"$$$"+b;
		}
	%>
	
	
	<h1>Bienvenidos a mi página</h1>
	<%
		
		String cad1 = "Pepe";
		String cad2 = " Peralta";
		String res = cad1 + cad2;
		out.append(res);
	%>
	<% 	int[] a=arreglito();
	   	String mostrar="";
	   	for(int num : a)
			mostrar += num +",";
		List<String> nombres = new LinkedList<>();
	%>
	<br/>
	<%
		out.append(concatenar("Holajas","chau"));
	%>
	<br/>
	<table border="1">
		<tr>
			<td><%=concatenar("hola","amigo")%></td><td><%= res %></td>
			
		</tr>
		<tr>
			<td><%= mostrar %></td><td>VALOR</td>
		</tr>
	</table>
	<%
		int n1 = 5;
		int n2 = 7;
		out.append((n1+n2)+"");
	%>
</body>
	<%! public int[] arreglito(){
			int[] arr = new int[4];
			arr[0] = 45;arr[1]=101;
			arr[2] = 7; arr[3] =10;
			return arr;
		}
	%>
</html>