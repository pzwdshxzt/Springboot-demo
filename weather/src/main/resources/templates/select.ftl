<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Spring Boot FreeMarker</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <link href="static/css/narrow.css" rel="stylesheet">
    <script src="static/js/jquery-3.2.1.js"></script>
    <script src="static/js/index.js" type="text/javascript"></script>
    <script src="static/js/bootstrap.min.js"></script>
    <script src="static/js/bootstrap-datetimepicker.fr.js"></script>
    <script src="static/js/bootstrap-datetimepicker.min.js"></script>
</head>
<body>
<div class="container">
    <div class="header clearfix">
        <nav>
            <ul class="nav nav-pills pull-right">
                <li role="presentation" class="active"><a href="/index">Home</a></li>
                <li role="presentation"><a href="/news">News</a></li>
                <li role="presentation"><a href="#">Contact</a></li>
            </ul>
        </nav>
        <h3 class="text-muted">Select City</h3>
    </div>

    <h2>City &nbsp; &nbsp;<a class="btn btn-success back-index" href="/city"  role="button">Back <Index></Index></a></h2>
	    <div class="form-group">
	        <div class="form-group">
			    <div class="row">
			        <div class="col-md-4">
			            <select name="province_code" id="city_select_0" class="form-control select-box-0" ref="city_select">
			            	<#list city0 as city>
			                    <option value="${city.cityid}">${city.city}</option>
			                </#list>
			            </select>
			        </div>
			        <div class="col-md-4" >
			            <select name="city_code" id="city_select_1" class="form-control select-box-1" style="display:none">
			            	
			            </select>
			        </div>
			         <div class="col-md-4">
			            <select name="city_code" id="city_select_2" class="form-control" style="display:none">
			            
			            </select>
			        </div>
			    </div>
			</div>
            <a  class="btn btn-success select-city-sumbit" href="javascript:;" >Submit</a>
        </div>
</body>
</html>