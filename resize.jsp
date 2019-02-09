<%-- 
    Document   : newjsp
    Created on : 24 avr. 2015, 20:29:15
    Author     : Nicolas Enzweiler
--%>

<%@page contentType="text/html" pageEncoding="GBK"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="../jsp/jquery.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=GBK">
        <title>JSP Page</title>
        <script>
             var viewportWidth = $("body").innerWidth();
            var viewportHeight = $("body").innerHeight();
            var radioLabelW1 = $("#label1").width()/viewportWidth;
            var radioLabelH1 = $("#label1").height()/viewportWidth;
            
            var radioInputtextW1 = $("#inputtext").width()/viewportWidth;
            var radioInputtextH1 = $("#inputtext").height()/viewportWidth;
            $window.bind('resize', function(){
                $("#label1").width(radioLabelW1 * viewportWidth);
                $("#label1").height(radioLabelH1 * viewportWidth);
                
                $("#inputtext").width(radioInputtextW1 * viewportWidth);
                $("#inputtext").height(radioInputtextH1 * viewportWidth);
            })
            
        </script>
    </head>
    <body>
        <label id="label" style="width:50px;height:25px">test resize1</label>
        <input id="inputtext" type="text" style="width: 200px;height: 25px"/>
        <label id="label" style="width:50px;height:25px">test resize2</label>
        <label id="label" style="width:50px;height:25px">test resize3</label>
    </body>
</html>
