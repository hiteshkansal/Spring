<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<!DOCTYPE html>

<html>

<head>
	<title> Student Registration Form</title>
</head>

<body>

	<form:form action="processForm" modelAttribute="student">
	
		First Name: <form:input path="firstName"/>
		
		<br><br>
		
		Last Name: <form:input path="lastName"/>
		
		<br><br>
		
		Country:
		
		<form:select path="country">
		
		 	<%-- Hard Coded value
		 	<form:option value="Brazil" label="Brazil" />
		 	<form:option value="France" label="France" />
		 	<form:option value="Germany" label="Germany" />
		 	<form:option value="India" label="India" />
		 	--%>
		 	
		 	<%-- From a java file 
		 	<form:options items="${student.countryOptions}"/>
		 	--%>
		 	 
		 	<!-- From a properties file -->
		 	<form:options items="${theCountryOptions}" />
		 	
		</form:select>
		
		<br><br>
		Languages: 
		
		Java <form:radiobutton path="favoriteLanguage" value="Java"/>
		C# <form:radiobutton path="favoriteLanguage" value="C#"/>
		Python <form:radiobutton path="favoriteLanguage" value="Python"/>
		Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
		
		<br><br>
		Operating Systems:
		
		Linux <form:checkbox path="operatingSystems" value="Linux"/>
		Windows <form:checkbox path="operatingSystems" value="Windows"/>
		Mac <form:checkbox path="operatingSystems" value="Mac"/>
		
		<br><br>
		
		<input type="submit" value="submit" />
	
	</form:form>
	
</body>

</html>