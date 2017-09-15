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
    </div>
   
    <h2>头条  &nbsp; &nbsp;</h2>
    <div class="table-responsive">
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>title</th>
                    <th>date</th>
                    <th>uniquekey</th>
                </tr>
            </thead>
            <tbody>
                <#list news as new>
                    <tr>
                        <td><a href="${new.url}">${new.title}</a></td>
                        <td>${new.date}</td>
                        <td>${new.uniquekey}</td>
                    </tr>
                </#list>
            </tbody>
        </table>
    </div>
   	
</body>
</html>