$(document).ready(function() {
    var max_fields      = 10; //maximum input boxes allowed
    var wrapper         = $("#parentContainer");
    var add_button      = $("#addButton_Cowner");
    
	var x = 0; //initlal text box count

	var data = {}
	loadData();
	$(add_button).click(function(e){ //on add input button click
        e.preventDefault();
        loadData();
    });
   function loadData(){
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "/NDS/typeServicesAjax",
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				showDynamicItem(data);
			},
			error : function(e) {
				console.log("ERROR: ", e);
				//display(e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});
	}
   
    
    function showDynamicItem(items){
        if(x < max_fields){ //max input box allowed
        	
        	var htmlOption="";
			for(i=0;i<items.length;i++){
				htmlOption +='<option value="'+items[i].idTypeService+'">'+items[i].nameTypeService+'</option>  ';	
			}
             $(wrapper).append('<div class="containerItem">'          
             		+'<div class="col s12 l3"></div>'
					+'<div class="col s12 l6">'
					+	'<div class="center-align">'
					+		'<label for="a'+x+'"><b style="color:#000;font-size:18px">Service</b></label> <button type="button" id="addService">+</button><select class="browser-default" id="a" name="formData[' + x + '].typeService.idTypeService">'
					+			'<option value="" disabled selected>--option--</option>'
					+ htmlOption
					+		'</select>'
					+	'</div>'


					+'</div>'
					+'<br /> <br /> <br />'
					+'<div class="row">'
					+	'<div class="col s12 l3"></div>'
					+	'<div class="col s12 l6">'
					+		'<div class="center-align">'
					+			'<div class="input-field col s12">'  
					+				'<textarea id="textarea2'+x+'+" class="materialize-textarea" data-length="120" name="formData[' + x + '].commentaire" placeholder="Saissiez votre commentaire"> </textarea>'					
					+				'<label for="textarea2'+x+'">Votre commentaire</label>'
					+			'</div>'
					+		'</div>'
					+	'</div>'
					+	'<div class="col s12 l3"></div>'
					+ '</div></div>');

            x++; //text box increment now x=1 after x++ x=2,so next code 2%2==0 is true
            
        }
    }
    
    $(wrapper).on("click",".remove_field", function(e){ //user click on remove text
        e.preventDefault(); $(this).parent('div').remove(); x--;
    })
    
    $(document).on('change','#selectCategory',function(){
    	var idCat = $( "#selectCategory" ).val()
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "/NDM/typeArticleAjax?id_cat="+idCat,
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				$("#selectArticle").html("");
				for(i=0; i<data.length; i++){
					$("#selectArticle").append('<option value="'+data[i].idArticle+'">'+ data[i].label+'</option>');
				}
					
				//showDynamicItem(data);
			},
			error : function(e) {
				console.log("ERROR: ", e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});
   });
    $("#addCategory").click(function(){
    	var category = prompt("Nouvelle catégorie");
    	if(category!=null && category !=""){
    		$("#selectCategory").append('<option value="'+category+'">'+category+'</option>');
    		console.log("===>"+category);
    	}
    });
    
   $("#addArticle").click(function(){
	   	var article = prompt("Nouvel Article");
		if(article!=null && article !=""){
			$("#selectArticle").append('<option value="'+article+'">'+article+'</option>');
			console.log("===>"+article);
		}
   });
   
   $("#addService").click(function(){
	   	var article = prompt("Nouveau service");
		if(article!=null && article !=""){
			$("#selectArticle").append('<option value="'+article+'">'+article+'</option>');
			console.log("===>"+article);
		}
  }) 
});