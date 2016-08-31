<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<div id="content">
    <div class="box">
        <h3>Colombo Stock Exchange Market Summery</h3>

        <p></p>

        <script type="text/javascript" src="pages/amstock/swfobject.js"></script>
        <div id="flashcontent" align="CENTER">
            <strong>You need to upgrade your Flash Player</strong>
        </div>

        <script type="text/javascript">
            var so = new SWFObject("pages/amstock/amstock.swf", "amstock", "900", "600", "8", "#FFFFFF");
            so.addVariable("path", "");
            so.addParam("wmode", "transparent");
            so.addVariable("preloader_color", "#CD2626");
            so.addVariable("settings_file", encodeURIComponent("pages/market-chart-summery/amstock_settings_all-summery.xml"));
            so.write("flashcontent");
        </script>
    </div>
</div>