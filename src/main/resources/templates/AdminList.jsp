<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="utf-8" />
<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link href="../static/css/materialize.css"
	th:href="@{/css/materialize.css}" rel="stylesheet" type="text/css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<nav class="nav-extended">
	<div class="nav-wrapper">
		<a href="#" class="brand-logo"> <img class="responsive-img"
			src="../static/images/logo-web.png" th:src="@{/images/logo-web.png}" />
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


	</div>
	
		<div class="nav-content">
		<ul >
			<li ><a href="../Admin/ListE" class="active">Enseignants</a></li>
			<li><a href="../Admin/Index">Validation</a></li>
		</ul>
	</div>

	
</nav>
</head>
<div class="preloader-background">
	<div class="progress">
		<div class="indeterminate"></div>
	</div>

</div>
<body>
	<br />
	<br />
	<div></div>

	<div id="validation" class="card-panel grey lighten-5 z-depth-1">
		<div class="row">
			<div class="col s12 l12">
				<ul class="collapsible popout" data-collapsible="accordion">

					<li>
						<div class="collapsible-header">
							<i class="material-icons">close</i> <a>Liste des catégories</a>
							<div class="col s12 l1"></div>
						</div>
						<div class="collapsible-body">
							<table class="striped">
								<tbody>
									<tr th:each="cat:${listCat}">
										<td th:text="${cat.label}"></td>
										<td><a
											th:href="@{'/Admin/validerc?idCategorie=' + ${cat.idCatArticle}}">Valider</a>
									</tr>
								</tbody>
							</table>
						</div>
					</li>
					<li>
						<div class="collapsible-header">
							<i class="material-icons">close</i> <a>Liste des articles</a>
							<div class="col s12 l1"></div>
						</div>
						<div class="collapsible-body">
							<table class="striped">
								<tbody>
									<tr th:each="article:${listArticle}">
										<td th:text="${article.label}"></td>
										<td><a
											th:href="@{'/Admin/validera?idArticle=' + ${article.idArticle}}">Valider</a>
									</tr>
								</tbody>
							</table>
						</div>
					</li>
					<li>
						<div class="collapsible-header">
							<i class="material-icons">close</i> <a>Liste des services</a>
							<div class="col s12 l1"></div>
						</div>
						<div class="collapsible-body">
							<table class="striped">
								<tbody>
									<tr th:each="s:${listServices}">
										<td th:text="${s.typeService.nameTypeService}"></td>
										<td><a
											th:href="@{'/Admin/validers?idService=' + ${s.idService}}">Valider</a>
										</td>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</li>
				</ul>
			</div>
		</div>

	</div>
	</div>
	
	</div>
	</div>
	<br />
	<br />
	<br />

	<!--Import jQuery before materialize.js-->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.2.1.js"></script>
	<script type="text/javascript" src="../js/materialize.js">
		
	</script>
</body>
</html>