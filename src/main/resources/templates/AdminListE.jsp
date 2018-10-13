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



		<ul id="slide-out" class="side-nav">
			<li><div class="user-view">
					<div class="background">
						<img src="images/pic08.jpg">
					</div>
					<a href="#!user"><img class="circle" src="images/pic01.jpg"></a>
					<a href="#!name"><span class="white-text name">Badr-Eddine</span></a>
					<a href="#!email"><span class="white-text email">badreddine.elkantouri@gmail.com</span></a>
				</div></li>
			<li><a class="waves-effect" href="/NDS/Index">Ajouter demande de
					Service</a></li>
			<li><a class="waves-effect" href="/NDM/Index">Ajouter demande de
					Materiel</a></li>
			<li><a class="waves-effect" href="#">Log out</a></li>
		</ul>
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
<br/>
<br/>
<div >
	<div class="row">
			<div class="col s12 l1">
				<p></p>
			</div>
			<div class="col s12 l3">
				<a href="http://localhost:8181/Admin/AddE" class="right hide-on-med-and-down">Ajouter Enseignant</a>
			</div>
			<div class="col s12 l3">
				<p></p>
			</div>
			
			<div class="col s12 l2">
				<p></p>
			</div>
		</div>
		</div>
	<div class="card-panel grey lighten-5 z-depth-1">
		<div class="row">
			<div class="col s12 l12">
				<ul class="collapsible popout" data-collapsible="accordion">

					<li th:each="e:${enseignants}">
						<div class="collapsible-header">
							<i class="material-icons">account_circle</i> <a
								th:text="${e.nom}"></a>
							<div class="col s12 l1"></div>
							<i class="material-icons">account_circle</i> <a th:text="${e.prenom}"></a>
							<div class="col s12 l1"></div>
							<i class="material-icons">content_paste</i> <a
								th:text="${e.RefEnseignant}"></a>
							<div class="col s12 l1"></div>
						</div>
						<div class="collapsible-body">
							<table class="striped">
								<thead>
									<tr>
										<th>Login</th>
										<th>PWD</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td th:text="${e.login}"></td>
										<td th:text="${e.pwd}"></td>
									</tr>
								</tbody>
							</table>
						</div>
					</li>

					

				</ul>
			</div>
		</div>
		<!--
<div class="col s4 l2">
</div>
<ul class="pagination">
    <li class="disabled"><a href="#!"><i class="material-icons">chevron_left</i></a></li>
    <li class="active"><a href="#!">1</a></li>
    <li class="waves-effect"><a href="#!">2</a></li>
    <li class="waves-effect"><a href="#!">3</a></li>
    <li class="waves-effect"><a href="#!">4</a></li>
    <li class="waves-effect"><a href="#!">5</a></li>
    <li class="waves-effect"><a href="#!"><i class="material-icons">chevron_right</i></a></li>
  </ul>!-->

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