<html>
<head>
<style>
body {background-color: powderblue; margin: 50px}
h1 {
    color: blue;
    font-family: verdena;
    font-size: 300%;
}
h2   {
	 color: tomato; 
	 font-family: verdana;
}
p    {
	 color: black;
	 font-family: helvetica;
}
p.error {
	color: red;
}

div.gallery {
  margin: 5px;
  border: 1px solid #ccc;
  float: left;
  width: 180px;
}

div.gallery:hover {
  border: 1px solid #777;
}

div.gallery img {
  width: 100%;
  height: auto;
}

div.desc {
  padding: 15px;
  text-align: center;
}

</style>
</head>
<body>

<p> Lets see if this works. </p>
  <%
    double num = Math.random();
    if (num > 0.95) {
  %>
      <h2>You'll have a luck day!</h2><p>(<%= num %>)</p>
  <%
    } else {
  %>
      <h2>Well, life goes on ... </h2><p>(<%= num %>)</p>
  <%
    }
  %>
  <a href="<%= request.getRequestURI() %>"><h3>Try Again</h3></a>
</body>
</html>