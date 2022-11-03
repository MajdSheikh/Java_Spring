
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Omikuji Form</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>


<h1>Send an Omikuji</h1>
<div class=container>

   <form action="/omikuji/show" method="post" class="form">
   
   		<div>
   		<label for="number">pick any number from 5 to 25</label><br>
		<input type="number" name="number"><br>
   		</div><br>
   		
   		<div>
   		<label>Enter the name of any city</label><br>
        <input type="text" name="city">
   		</div><br>
   		
   		<div>
   		<label>Enter the name of any real person</label><br>
        <input type="text" name="person">
   		</div><br>
   		
   		<div>
   		<label>Enter professional endeavor or hobby </label><br>
        <input type="text" name="hobby">
   		</div><br>
   		
   		<div>
   		<label>Enter any type of living thing </label><br>
        <input type="text" name="livingThing">
   		</div><br>
   		
   		<div>
   		<label for="nice">Say something nice to someone </label><br>
        <textarea  id="nice" rows="4" cols="30" name="nice"></textarea>
   		</div><br>
   		
   		<div>
   		<p>send and show a friend</p>
   		<input type="submit" value="send" class="button">
   		</div>

    </form>
</div>


</body>
</html>