<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Spring Boot FreeMarker</title>

    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/css/narrow.css" rel="stylesheet">
    <script src="/static/js/jquery-3.2.1.js"></script>
    <script src="/static/js/index.js" type="text/javascript"></script>
    <script src="/static/js/bootstrap.min.js"></script>
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
        <h3 class="text-muted">${city.city}  <a class="text-muted select-city" href="/city"><small>&nbsp;&nbsp;更换城市</small></a></h3>
    </div>
   
    <h2>Weather Today  &nbsp; &nbsp;
    <!--<a class="btn btn-success add-user" href="javascript:;"  role="button">Add</a>-->
     </h2>
    <div class="table-responsive">
        <table class="table table-hover">
            <tbody>
                    <tr>
                    	<td>时间 date</td>
                        <td>${city.date}</td>
                    </tr>
                    <tr>
                    	<td>日期 week</td>
                        <td>${city.week}</td>
                    </tr>
                    <tr>
                        <td>天气 weather</td>
                        <td>${city.weather}</td>
                    </tr>
                    <tr>
                        <td>温度 temp</td>
                        <td>${city.temp}</td>
                    </tr>
                    <tr>
                        <td>最高温度 temphigh</td>
                        <td>${city.temphigh}</td>
                    </tr>
                    <tr>
                        <td>最低温度 templow</td>
                        <td>${city.templow}</td>
                    </tr>
                    <tr>
                        <td>湿度 humidity</td>
                        <td>${city.humidity}</td>
                    </tr>
                    <tr>
                        <td>压力 pressure</td>
                        <td>${city.pressure}</td>
                    </tr>
                     <tr>
                        <td>风速 windspeed</td>
                        <td>${city.windspeed}</td>
                    </tr>
                     <tr>
                        <td>风向 winddirect</td>
                        <td>${city.winddirect}</td>
                    </tr>
                     <tr>
                        <td>风力 windpower</td>
                        <td>${city.windpower}</td>
                    </tr>
                     <tr>
                        <td>更新时间 updatetime</td>
                        <td>${city.updatetime}</td>
                    </tr>
                    
            </tbody>
        </table>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th width="150px">iname</th>
                    <th width="100px">ivalue</th>
                    <th>detail</th>
                </tr>
            </thead>
            <tbody>
                <#list city.index as index>
                    <tr>
                        <td>${index.iname}</td>
                        <td>${index.ivalue}</td>
                        <td>${index.detail}</td>
                    </tr>
                </#list>
            </tbody>
        </table>
    </div>
     <div class="table-responsive">
        <table class="table table-hover">
            <thead>
                <tr>
                    <th width="100px">date</th>
                    <th width="70px">week</th>
                    <th>sunrise</th>
                    <th>sunset</th>
                    <th>night-weather</th>
                    <th>night-lowtemp</th>
                    <th>day-weather</th>
                    <th>day-temphigh</th>
                </tr>
            </thead>
            <tbody>
                <#list city.daily?sort_by("date") as day>
                    <tr>
                        <td>${day.date}</td>
                        <td>${day.week}</td>
                        <td>${day.sunrise}</td>
                        <td>${day.sunset}</td>
                        <td>${day.night.weather}</td>
                        <td>${day.night.templow}</td>
                        <td>${day.day.weather}</td>
                        <td>${day.day.temphigh}</td>
                    </tr>
                </#list>
            </tbody>
        </table>
    </div>	
</body>
</html>