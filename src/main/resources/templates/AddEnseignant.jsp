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
        <a href="index.html" class="brand-logo" >
          <img class="responsive-img" src="../static/images/logo-web.png" th:src="@{/images/logo-web.png}"/>
        </a>
        
<a href="#" data-activates="slide-out" class="button-collapse"><i class="material-icons">menu</i></a>

       
        <ul class="right hide-on-med-and-down">
          <li><a href="#">Log out</a></li>
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
      <a href="#!name"><span class="white-text name"></span></a>
      <a href="#!email"><span class="white-text email"></span></a>
    </div>
  </ul>
        </div> 
      </nav>
    </head>
  
<body>
<br/>
<br/>
<br/>
<div class="card-panel grey lighten-5 z-depth-1">
<br/>
<br/>
<form th:action="@{AddEE}" method="POST">
  <div class="row">
  <div class="col s12 l3">
  </div>
  <div class="col s12 l6">
      <div class="center-align">
        <label for="nom"><b style="color:#000;font-size:18px">nom</b></label>
        <input id="nom" type="text" class="validate" name="nom" required="" oninput="this.setCustomValidity('')" oninvalid="this.setCustomValidity('Veuillez entrer le nom')">
  </div>
  </div>
  </div>
  <div class="row">
  <div class="col s12 l3">
  </div>
  <div class="col s12 l6">
      <div class="center-align">
        <label for="prenom"><b style="color:#000;font-size:18px">prenom</b></label>
        <input id="prenom" type="text" class="validate" name="prenom" required="" oninput="this.setCustomValidity('')" oninvalid="this.setCustomValidity('Veuillez entrer le nom')">
  </div>
  </div>
  </div>
  
  <div class="row">
  <div class="col s12 l3">
  </div>
  <div class="col s12 l6">
      <div class="center-align">
        <label for="login"><b style="color:#000;font-size:18px">login</b></label>
        <input id="login" type="text" class="validate" name="login" required="" oninput="this.setCustomValidity('')" oninvalid="this.setCustomValidity('Veuillez entrer le nom')">
  </div>
  </div>
  </div>
  <div class="row">
  <div class="col s12 l3">
  </div>
  <div class="col s12 l6">
      <div class="center-align">
        <label for="pwd"><b style="color:#000;font-size:18px">pwd</b></label>
        <input id="pwd" type="text" class="validate" name="pwd" required="" oninput="this.setCustomValidity('')" oninvalid="this.setCustomValidity('Veuillez entrer le nom')">
  </div>
  </div>
  </div>
  <div class="row">
  <div class="col s12 l3">
  </div>
  <div class="col s12 l6">
      <div class="center-align">
        <label for="ref"><b style="color:#000;font-size:18px">ref</b></label>
        <input id="ref" type="text" class="validate" name="ref" required="" oninput="this.setCustomValidity('')" oninvalid="this.setCustomValidity('Veuillez entrer le nom')">
  </div>
  </div>
  </div>
  <br/>
  <br/>
  <br/>
    <div class="row">
    <div class="col s12 l3">
  </div>
      <div class="col s12 l3">
      </div>
      <div class="col s12 l6">
  <button class="btn waves-effect waves-light" type="submit"  >Enregistrer
  </button>
</div>
<div class="col s12 l3">
  </div>
</div>
<br/>
<br/>
<br/>
</form>
    </div>
    

      <!--Import jQuery before materialize.js-->
      <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.js"></script>
      <script type="text/javascript" src="/js/materialize.js"></script>
    </body>
  </html>