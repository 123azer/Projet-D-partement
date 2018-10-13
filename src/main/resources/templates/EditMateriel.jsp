<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="utf-8" />
<title>Formulaire de matériaux</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="../static/css/bootstrap.min.css"
	th:href="@{/css/bootstrap.min.css}" />
<link rel="stylesheet" type="text/css" href="../static/css/myStyle.css"
	th:href="@{/css/myStyle.css}" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link href="../static/css/materialize.css"
	th:href="@{/css/materialize.css}" rel="stylesheet" type="text/css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<nav class="nav-extended">
	<div class="nav-wrapper">
		<a href="#" class="brand-logo"> <img class="responsive-img"
			src="../static/images/clr.png" th:src="@{/images/clr.png}"
			width="180" height="80" />
		</a> <a href="#" data-activates="slide-out" class="button-collapse"><i
			class="material-icons">menu</i></a>
		<ul class="right hide-on-med-and-down">
			<li><a href="#"> <img class="responsive-img"
					src="../static/images/logout.png" th:src="@{/images/logout.png}"
					width="100" height="40" />
			</a></li>
		</ul>
		<div class="row">
			<div class="col s12 m4 l4">
				<p></p>
			</div>
			<div class="col s12 m4 l4">
				<h4 class="right hide-on-med-and-down">App Gestion de Matériels</h4>
			</div>
			<div class="col s12 m4 l4">
				<p></p>
			</div>
		</div>
		<ul id="slide-out" class="side-nav">
			<li><div class="user-view">
					<div class="background"></div>
				</div></li>
			<li><a class="waves-effect" href="#">Log out</a></li>
		</ul>
	</div>
</nav>
</head>
<body>
	<br />
	<br />
 <div style="clear:both;margin:-20px 0 15px 0;height:20px!important front-size=:16 px; color:#0000ff;">
<a th:href=@{list} style="margin-left: 80px;  front-size:16px; color:#0000ff;"> Inventaire</a><a style="front-size=:16px; color:#0000ff;"> > Edit </a></div>
	<br /><br />
	<form th:action="@{UpdateArticle}" method="post" th:object="${b}">
		<div class="row">
			
			<div class="col s12 m6 l3">
				 <input type="hidden"
					th:field="*{id}" class="form-control" /> <span></span>
			</div>
			
			<div class="col s12 m6 l3">
				<label class="control-label">Réferentiel:</label> <input disabled type="text"
					th:field="*{ref}" class="form-control" /> <span></span>
			</div>
			<div class="col s12 m6 l3">
				<label for="b">Type</label><br /> <select th:field="*{type}" class="browser-default"
					id="b">
					<option th:each="listTypesArticles:${list}"
						th:value="${listTypesArticles}" th:text="${listTypesArticles}" ></option>
				</select>
			</div>
		</div>
		<div class="row">
			<div class="col s12 m6 l3"></div>
			<div class="col s12 m6 l3">
				<label class="control-label">Local:</label> <input type="text"
					th:field="*{local}" class="form-control" /> <span></span>
			</div>

			<div class="col s12 m6 l3">
				<label class="control-label">Marque:</label> <input type="text"
					th:field="*{marque}" class="form-control" /> <span></span>
			</div>
		</div>
		<div class="row">
			<div class="col s12 m6 l3"></div>
			<div class="col s12 m6 l3">
				<label for="b">Etat du Matériel</label><br /> <select th:field="*{etat}"
					class="browser-default" id="b">
					<option th:each="listEtatMateriels:${listM}"
						th:value="${listEtatMateriels}" th:text="${listEtatMateriels}" ></option>

				</select><br>
			</div>
			<div class="col s12 m6 l3">
				<label class="control-label">Ressource Bénéficaire:</label> <input
					type="text" th:field="*{ressourceBeneficaire}" class="form-control" />
				<span></span>
			</div>
		</div>
		<div class="row">
			<div class="col s12 m6 l3"></div>
			<div class="col s12 m6 l3">
				<label class="control-label">Date d'Entrée:</label> <input
					th:type="date" th:field="*{dateEntree}"  class="form-control" /> <span></span>
			</div>
			<div class="col s12 m6 l3">
				<label class="control-label">Date Sortie:</label> <input th:type="date"
					th:field="*{dateSortie}" class="form-control" /> <span></span>
			</div>
		</div>
		<div class="row">
			<div class="col s12 m6 l3"></div>
			<div class="col s12 m6 l3">
				<label class="control-label">Article:</label> <input type="text"
					th:field="*{nom}" class="form-control" /> <span></span>
			</div>
			<div class="col s12 m6 l3">
				<label class="control-label">Destinataire:</label> <input
					type="text" th:field="*{destinataire}" class="form-control" /> <span></span>
			</div>
		</div>
		<div class="row">

			<div class="col s12 m6 l3"></div>
			<div class="col s12 m6 l3">
				<button type="submit" class="btn btn-primary">Save</button>
			</div>
		</div>
	</form>

</body>
</html>