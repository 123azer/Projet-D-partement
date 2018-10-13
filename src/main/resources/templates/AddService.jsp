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
<form th:action="@{AddS}" method="POST">
  <div class="row">
  <div class="col s12 l3">
  </div>
  <div class="col s12 l6">
      <div class="center-align">
        <label for="b"><b style="color:#000;font-size:18px">Service</b></label><button type="button"  id="addCategory">+</button>
        <select class="browser-default" id="selectCategory" oninput="this.setCustomValidity('')" name="typeser" required="required"  oninvalid="this.setCustomValidity('Veuillez choisir la catégorie')">
           <option value="" disabled selected> -- </option>
           <option th:each="ser : ${typeService}" th:value="${ser.nameTypeService}" th:utext="${ser.nameTypeService}"/>
        </select>
  </div>
  </div>
</div>
 <div class="row">
          <div class="col s12 l3">
          </div>
          <div class="col s12 l6">
          <div class="center-align">
          <div class="input-field col s12">
            <textarea id="textarea2" class="materialize-textarea" data-length="120" name="comment"></textarea>
            <label for="textarea2">Commentaire</label>
          </div>
    </div>
  </div>
  <div class="col s12 l3">
          </div>
        </div>
  <br/>
  <br/>
  <br/>
    <div class="row">
      <div class="col s12 l3">
      </div>
      <div class="col s12 l6">
  <button class="btn waves-effect waves-light" type="submit" >Ajouter Service
  </button>
</div>
</form>
<div class="col s12 l3">
<a href="/Login/Index"><button class="btn waves-effect waves-light" >Enregistrer
  </button></a>
  </div>
  
</div>
<br/>
<br/>
<br/>
    </div>

      <!--Import jQuery before materialize.js-->
      <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.js"></script>
      <script type="text/javascript" src="/js/materialize.js"></script>
      <script type="text/javascript" src="/js/app.js"></script>
    </body>
  </html>