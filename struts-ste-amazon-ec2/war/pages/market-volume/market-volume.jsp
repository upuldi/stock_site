<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="content">
    <div class="box">

        <h3>CSE Market Volume Change</h3>
        <div id="containerTOT" style="min-width: 950px; height: 500px; margin: 0 auto"></div>

        <h1>   </h1>
        <h1>   </h1>
        <h1>   </h1>
        <p> </p>
        <p> </p>
        <p> </p>
        <p> </p>
        <p> </p>
        <h1>   </h1>
        <h1>   </h1>
        <h1>   </h1>
        <p> </p>

        <h3>CSE Domestic Volume Change</h3>
        <div id="containerDVOL" style="min-width: 950px; height: 500px; margin: 0 auto"></div>

        <h1>   </h1>
        <h1>   </h1>
        <h1>   </h1>
        <p> </p>
        <p> </p>
        <p> </p>
        <p> </p>
        <p> </p>
        <h1>   </h1>
        <h1>   </h1>
        <h1>   </h1>
        <p> </p>

        <h3>Cse Foreign Volume Change</h3>
        <div id="containerFVOL" style="min-width: 950px; height: 500px; margin: 0 auto"></div>

        <h1>   </h1>
        <h1>   </h1>
        <h1>   </h1>
        <p> </p>
        <p> </p>
        <p> </p>
        <p> </p>
        <p> </p>
        <h1>   </h1>
        <h1>   </h1>
        <h1>   </h1>
        <p> </p>

        <h3>Colombo Stock Exchange Market Volume Comparison</h3>

        <script type="text/javascript" src="pages/amstock/swfobject.js"></script>
        <div id="flashcontent" align="CENTER">
            <strong>You need to upgrade your Flash Player</strong>
        </div>

        <script type="text/javascript">
            var so = new SWFObject("pages/amstock/amstock.swf", "amstock", "900", "500", "8", "#FFFFFF");
            so.addVariable("path", "");
            so.addVariable("preloader_color", "#CD2626");
            so.addVariable("settings_file", encodeURIComponent("pages/market-volume/amstock_settings-single-total-volume.xml"));
            so.write("flashcontent");
        </script>

        <h1>   </h1>
        <h1>   </h1>
        <h1>   </h1>
        <p> </p>
        <p> </p>
        <p> </p>
        <p> </p>
        <p> </p>
        <h1>   </h1>
        <h1>   </h1>
        <h1>   </h1>
        <p> </p>

    </div>

</div>