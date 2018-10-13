<!DOCTYPE html>
  <html xmlns:th="http://www.thymeleaf.org">
    <head>
    <meta charset="utf-8"/>
      <!--Import Google Icon Font-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
	  <link href="../static/css/materialize.css" th:href="@{/css/materialize.css}" rel="stylesheet" type="text/css"/>
	  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
       <nav class="nav-extended">
         <div class="nav-wrapper">
        <a href="#" class="brand-logo"> <img class="responsive-img"
			src="../static/images/clr.png" th:src="@{/images/clr.png}"
			width="180" height="80" />
		</a>
        
<a href="#" data-activates="slide-out" class="button-collapse"><i class="material-icons">menu</i></a>

       
        <ul class="right hide-on-med-and-down">
          <li th:text="${E.nom}"></li>
          <li>.</li>
          <li th:text="${E.prenom}"></li>
          <li><a href="../Logout/Index" th:href="@{/Logout/Index}">Log out</a></li>
        </ul>
      
        <div class="row">
             <div class="col s12 m4 l4"><p></p></div>
             <div class="col s12 m4 l4"><h4 class="right hide-on-med-and-down">App Gestion de Matériels</h4></div>
             <div class="col s12 m4 l4"><p></p></div>
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
          <li><a class="waves-effect" href="#">Ajouter demande de Service</a></li>
          <li><a class="waves-effect" href="#">Ajouter demande de Materiel</a></li>
          <li><a class="waves-effect" href="#">Log out</a></li>
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
  <div class="card-panel grey lighten-5 z-depth-1">
 <div class="row">
    <div class="col s12 l1"><p></p></div>
    <div class="col s12 l3"><a href="/NDS/Index" class="right hide-on-med-and-down">Nouvelle Demande de Service</a></div>
    <div class="col s12 l3"><p></p></div>
    <div class="col s12 l3"><a href="/NDM/Index" class="right hide-on-med-and-down">Nouvelle Demande de Matériel</a></div>
    <div class="col s12 l2"><p></p></div>
</div>
<form th:action="@{Chercher}" method="GET">
      <div class="z-depth-1">
    <div class="row">
    <div class="col s12 l3">
    
    </div>
    <div class="col s12 l9">
      <div class="col s12 l2">
      </div>
      <div class="col s12 l5">
        <div class="input-field">
          <input id="MotCle" name="MotCle" type="text" class="validate">
          <label for="MotCle">Mot Clé?</label>
      </div>
    </div>
      <div class="col s12 l2">
      </div>
      </div>
    </div>
    <div class="row">
     <div class="col s12 l2"></div>
      <div class="col s12 l3">
        <label for="a">Select Etat</label>
  <select class="browser-default" id="a" name="etat" >
    <option value="" disabled selected>--option--</option>
    <option th:each="s:${EtatD}" th:text="${s}" value="" th:value="${s}"></option>
  </select>
  </div>
  <div class="col s12 l2"></div>
     <!--  <div class="col s12 l4">
        <label for="b">Select Demandeur</label>
  <select class="browser-default" id="b" name="demandeur">
    <option value="" disabled selected>--option--</option>
    <option th:each="d:${Demandeur}" th:text="${d.nom}" value="" th:value="${d.nom}"></option>
  </select>
      </div> -->
      <div class="col s12 l3">
        <label for="c">Select type demande</label>
  <select class="browser-default" id="c" name="type">
    <option value="" disabled selected>--option--</option>
    <option value="DemandeM">Demande de materiel</option>
    <option value="DemandeS">Demande de service</option>
  </select>
      </div>
      <div class="col s12 l2"></div>
    </div>
    <div class="row">
      <div class="col s12 l5">
      </div>
      <div class="col s12 l4">
  <button class="btn waves-effect waves-light" type="submit" value="action">Chercher
    <i class="material-icons right">search</i>
  </button>
</div>
<div class="col s12 l3">
  </div>
</div>
<br/>
    </div>
    </form>
       <div class="row">
      <div class="col s12 l12">
      <ul class="collapsible popout" data-collapsible="accordion">

    <li th:each="d:${demandes}"> 

    <div class="collapsible-header">
      <i class="material-icons" >content_paste</i>
     <a th:text="${d.Objet}"></a>
      <div class="col s12 l1"></div>
      <i class="material-icons" >date_range</i>
       <a th:text="${d.date}"></a>
       <div class="col s12 l1"></div>
       <i class="material-icons" >date_range</i>
         <a th:text="${d.Etat}"></a>
          </div>
<div class="collapsible-body">
     <table class="striped">
        <thead>
        <tr>
        <th>Type service</th>
        <th>Commentaire</th>
        <th>Etat service</th>
        </tr>    
        </thead>
        <tbody>
        <tr th:each="s:${d.services}">
        <td th:text="${s.typeService.nameTypeService}"></td>
        <td th:text="${s.commentaire}"></td>
        <td th:text="${s.EtatS}"></td>
        </tr>
        </tbody>
      </table>
</div>
    </li>
    
        <li th:each="d:${demandem}">
    

    <div class="collapsible-header">
      <i class="material-icons" >content_paste</i>
     <a th:text="${d.Objet}"></a>
      <div class="col s12 l1"></div>
      <i class="material-icons" >date_range</i>
       <a th:text="${d.date}"></a>
       <div class="col s12 l1"></div>
       <i class="material-icons" >date_range</i>
         <a th:text="${d.Etat}"></a>
          </div>
<div class="collapsible-body">
      <table class="striped">
        <thead>
        <tr>
        <th>categorie</th>
        <th>type</th>
        <th>commentaire</th>
        <th>quantite</th>
        </tr>    
        </thead>
        <tbody>
        <tr th:each="m:${d.article}">
        <td th:text="${m.catArticle.label}"></td>
        <td th:text="${m.label}"></td>
        <td th:text="${m.commentaire}"></td>
        <td th:text="${m.Quantite}"></td>
        </tr>
        </tbody>
      </table>
</div>
    </li>
       
      </ul></div></div>
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
<br/> 
<br/>  
<br/>      
       
      <!--Import jQuery before materialize.js-->
      <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.js"></script>
	  <script type="text/javascript" src="../js/materialize.js">
	  </script>
    </body>
  </html>