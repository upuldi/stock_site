<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>

<div id="content">
    <div class="box">
        <h3>Natural Rubber Prices</h3>

        <script type="text/javascript" src="pages/amstock/swfobject.js"></script>
        <div id="flashcontentIndex" align="center">
            <strong>You need to upgrade your Flash Player</strong>
        </div>

        <script type="text/javascript">
            // <![CDATA[
            var so = new SWFObject("pages/amstock/amstock.swf", "amstock", "900", "500", "8", "#FFFFFF");
            so.addVariable("path", "");
            so.addParam("wmode", "transparent");
            so.addVariable("settings_file", encodeURIComponent("pages/commodity/amstock_settings_commodity.xml"));
            so.addVariable("preloader_color", "#CD2626");
            so.write("flashcontentIndex");
            // ]]>
        </script>

        <p></p><p></p>   <h2></h2>
    </div>
</div>



</body>
</html>