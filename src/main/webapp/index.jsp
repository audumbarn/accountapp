<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $("button").click(function(){
    	$("#table").empty();
    	$("<tr><td>id</td><td>name</td><td>population</td></tr>").appendTo("#table");
    	$.getJSON("http://localhost:8764/CountryApp/rest/countries", function(data){
    	    $.each(data, function (index, value) {
    	    	var tblRow = "<tr>" +"<td>" + value.id + "</td>"+ "<td>" + value.countryName + "</td>" + "<td>" + value.population + "</td></tr>";
    	    	$(tblRow).appendTo("#table");
    	    });
    	});
    });
});
</script>
</head>
<body>

<button>Get all countries</button>

<table id="table">

</table>
</body>
</html>
