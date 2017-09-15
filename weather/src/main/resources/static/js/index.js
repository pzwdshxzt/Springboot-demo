$(document).ready(function(){
	
	
    $(".add-user").click(function () {
        window.location="/add";
    });
    $(".back-index").click(function () {
        window.location="/index";
    });
    
    $(".select-city").click(function () {
        window.location="/city";
    });
   
    $(".select-city-sumbit").click(function () {
    	var id = $("#city_select_2").val();
    	if(id == undefined){
    		id = $("#city_select_1").val();
    		if(id == undefined){
    			id = $("#city_select_0").val();
    		}
    	}
    	window.location="/"+id+"/city";
    });
    
    $(".select-box-0").change(function () {
        var id = $(".select-box-0").val();
    	$.ajax({
            type : 'POST',
            dataType : "json",
            url : "/city/"+id,
            cache : false,
            success : function(response) {
            
            	$("#city_select_1").empty();
                addHtml(response, $("#city_select_1"));
            },
        });
    });
    
    $(".select-box-1").change(function () {
        var id = $(".select-box-1").val();
    	$.ajax({
            type : 'POST',
            dataType : "json",
            url : "/city/2/"+id,
            cache : false,
            success : function(response) {
            	$("#city_select_2").empty();
                addHtml(response, $("#city_select_2"));
            },
        });
    });
   

    
    var addHtml = function(response, $this) {
        if (!response[0]){
        	$this.hide();
        	return ;
        }else{
        	$this.show();
        }
        var html = '';
        $.each(response, function(i) {
            if (response[i]) {
            	  if (i==0) {
            		  html += '<option selected="selected" value="' + response[i].cityid + '"'; 
            	  }else{
                	  html += '<option value="' + response[i].cityid + '"'; 
                  }
               
                html += '">' + response[i].city + '</option>';
            }
        });
        $this.html(html);
    };
    
  
    
    
});


