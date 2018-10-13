<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="utf-8" />
<title>Inventaire</title>
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
			<li><a href="../Logout/Index" th:href="@{/Logout/Index}">Log out</a></li>
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
	 <div class="nav-content">
      <ul>
        <li class="tab"><a class="waves-effect" href="../Login/Index">Demandes</a>
        <br/>
        <br/>
        </li>
        <li class="tab"><a class="waves-effect" href="../inventaire/list" th:href="@{/inventaire/list}">Inventaire</a>
        <br/>
        <br/></li>
        <br/>
        <br/>
      </ul>
    </div>
</nav>
</head>
<body>
	<div class="card-panel grey lighten-5 z-depth-1">
	   <br />
	   <a th:href=@{list} > Inventaire </a>
		<form th:action="@{chercher}" method="POST">
		<br />
			<div class="z-depth-1">
				<div class="row">

					<div class="col s12 m4 l2">
						<input id="Ref" name="Référentiel" type="text" class="validate">
						<label for="Ref">Référentiel</label>
					</div>
					<div class="col s12 m4 l2">
						<input id="Article" name="Article" type="text" class="validate">
						<label for="Article">Article</label>
					</div>
					<div class="col s12 m4 l2">
						<input id="dest" name="Destinataire" type="text" class="validate">
						<label for="dest">Destinataire</label>
					</div>
					<div class="col s12 m4 l2">
						<input id="ben" name="ben" type="text" class="validate"> <label
							for="ben">Bénéficiaire</label>
					</div>
					<div class="col s12 m4 l2">
						<input id="mar" name="mar" type="text" class="validate"> <label
							for="mar">Marque</label>
					</div>

				</div>
				<div class="row">
					<div class="col s12 m4 l2">
						<input id="loc" name="loc" type="text" class="validate"> <label
							for="loc">local</label>
					</div>
					<div class="col s12 m4 l2">
						<select class="browser-default" id="b" name="type">
						     <option value="" selected >Choix du type</option>
							<option th:each="listTypesArticles:${list}"
								th:text="${listTypesArticles}"></option>

						</select><br> <label for="b">Type</label>
					</div>
					<div class="col s12 m4 l2">
						<input id="date" type="date" name="dateAcq"> <label for="date">Date
							d'Acquisition</label>
					</div>
					<div class="col s12 m4 l2">
						<input id="dat" type="date" name="dateSortie"> <label for="dat">Date
							de Sortie</label>
					</div>
					<div class="col s12 m4 l2">
						<select class="browser-default" id="b" name="et" >
						     <option value="" selected >Choix de l'état</option>
							<option th:each="listEtatMateriels:${listM}" 
								  th:text="${listEtatMateriels}" ></option>

						</select><br> <label for="b">Etat du Matériel</label>
					</div>
					<div class="col s12 m4 l2"></div>
					<div class="col s12 m4 l2">
						<br />
						<button class="btn waves-effect waves-light" type="submit"
							value="action">
							Chercher <i class="material-icons right">search</i>
						</button>
						

					</div>
					
					<br />
				</div>
			</div>
		</form>
       
		<a th:href="@{form}" style="color:#0000ff; font-size : 16px;">    Ajout</a>

		<table class="table">
			<br/>
			<br/>
			<thead>
				<tr>
					<th>Réference</th>
					<th>Article</th>
					<th>Type</th>
					<th>Ressource Bénéficiaire</th>
					<th>Marque</th>
					<th>Date d'acquisition</th>
					<th>Local</th>
					<th>Date de Sortie</th>
					<th>Destinataire</th>
					<th>Etat</th>
				</tr>
			</thead>
			<tbody>
				<tr th:each="a:${article}">
					<td th:text="${a.ref}"></td>
					<td th:text="${a.nom}"></td>
					<td th:text="${a.type}"></td>
					<td th:text="${a.ressourceBeneficaire}"></td>
					<td th:text="${a.marque}"></td>
					<td th:text="${#dates.format(a.dateEntree,'dd-MM-yyyy')}" ></td>
					<td th:text="${a.local}"></td>
					<td th:text="${#dates.format(a.dateEntree,'dd-MM-yyyy')}"></td>

					<td th:text="${a.destinataire}"></td>
					<td th:text="${a.etat}"></td>
					<td><a th:src="@{/images/cor.png}" th:href="@{supprimer(id=${a.id})}">Supprimer</a></td>
					<td><a th:src="@{/images/edit.png}" th:href="@{edit(id=${a.id})}">Edit</a></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="container">
		<ul class="nav nav-pills">
			<li th:each="p:${pages}" th:class="${p==pageCourante}?active:''">
				<a th:text="${p+1}" th:href="@{list(page=${p})}"></a>
		</ul>
	</div>
	</div>
</body>
</html>