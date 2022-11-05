<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<title>Ninja Gold</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>


<h2>Your Gold: <input name="Gold" type="button" value="" class="input"> </h2>

<div class="forms">
      <div>
        <form method="POST" action="/process_money" class="form">
            <input type="hidden" value="Farm" name="action">
          <h2>Farm</h2>
          <p>(earns 10-20 gold)</p>
          <input type="submit" value="Find Gold!">
        </form>
      </div>
      <div>
        <form method="POST" action="/process_money" class="form">
            <input type="hidden" value="Cave" name="action">
          <h2>Cave</h2>
          <p>(earns 10-20 gold)</p>
          <input type="submit" value="Find Gold!">
        </form>
      </div>
      <div>
        <form method="POST" action="/process_money" class="form">
            <input type="hidden" value="House" name="action">
          <h2>House</h2>
          <p>(earns 10-20 gold)</p>
          <input type="submit" value="Find Gold!">
        </form>
      </div>
      <div>
        <form method="POST" action="/process_money" class="form">
            <input type="hidden" value="Quest" name="action">
          <h2>Quest</h2>
          <p>(earns/takes 0-50 gold)</p>
          <input type="submit" value="Find Gold!">
        </form>
      </div>
    </div>

</body>
</html>