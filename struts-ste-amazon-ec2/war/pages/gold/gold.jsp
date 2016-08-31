<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<div id="content">
    <div class="box">
        <h3>Change of Gold Price in SriLanka</h3>

        <script type="text/javascript" src="pages/amstock/swfobject.js"></script>
        <div id="flashcontentIndex" align="center">
            <strong>You need to upgrade your Flash Player</strong>
        </div>

        <script type="text/javascript">
            // <![CDATA[
            var so = new SWFObject("pages/amstock/amstock.swf", "amstock", "900", "500", "8", "#FFFFFF");
            so.addVariable("path", "");
            so.addParam("wmode", "transparent");
            so.addVariable("preloader_color", "#CD2626");
            so.addVariable("settings_file", encodeURIComponent("pages/gold/amstock_settings_gold.xml"));
            so.write("flashcontentIndex");
            // ]]>
        </script>
        <p></p><p></p>   <h2></h2>
    </div>
</div>
