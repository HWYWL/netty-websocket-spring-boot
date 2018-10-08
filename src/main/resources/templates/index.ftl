<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Netty WebSocket测试</title>
    <link rel="stylesheet" href="css/index.css" />
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <meta charset="utf-8" />
</head>
<body>
<div class="page-header">
    <h1 style="margin-top:-20px;margin-left:20px;">Netty WebSocket测试</h1>
</div>
<div>
    <div class="zone_conn">
        <input type="text" class="form-control" style="float:left;" id="inp_url" value="ws://127.0.0.1:80" placeholder="连接的地址" />
        <button type="button" id="btn_conn" class="btn btn-primary" style="float:left;margin-left:10px;margin-right:10px;" onclick="fun_initWebSocket();">连接</button>
        <button type="button" id="btn_close" class="btn btn-danger" style="float:left;" disabled="disabled" onclick="fun_close();">断开</button>
    </div>
    <div class="clearboth">
        连接格式为 ws://IP或域名:端口（示例ws://127.0.0.1:80）<br />
    </div>
    <div class="zone_send">
        <a id="emoji" style="position:relative;left:374px;bottom:5px;cursor:pointer;" data-toggle="popover" title="表情"><img style="outline-width:40px;" src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/5c/huanglianwx_thumb.gif" />表情</a>
        <textarea id="inp_send" class="form-control" style="height:100px;" placeholder="发送的内容"></textarea>
        <br />
        <button type="button" id="btn_send" class="btn btn-info" onclick="fun_sendto();">发送（ctrl+回车）</button>
        <div style='margin-top:10px;color:red;line-height:30px;'>作者是个帅哥</div>
    </div>
</div>
<div style="position:absolute;top:100px;left:470px;">
    <div id="div_msgzone" class="panel panel-default">
        <div class="panel-heading">消息窗口</div>
        <div id="div_msg" class="panel-body"></div>
    </div>
</div>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/index.js?v=123"></script>
</body>
</html>
