<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="content">
    <div class="box">

        <h1>   </h1>
        <h1>   </h1>

        <h3>Colombo Stock Exchange Domestic Buying Change Over Time  </h3>
        <div id="containerDOMPER" style="min-width: 950px; height: 500px; margin: 0 auto"></div>

        <h1>   </h1>
        <h1>   </h1>
        <h1>   </h1>
        <p> </p>
        <p> </p>
        <p> </p>
        <p> </p>
        <p> </p>

        <h3>Colombo Stock Exchange Domestic Selling Change Over TIme  </h3>
        <div id="containerDOMSALE" style="min-width: 950px; height: 500px; margin: 0 auto"></div>

        <h1>   </h1>
        <h1>   </h1>
        <h1>   </h1>
        <p> </p>
        <p> </p>
        <p> </p>
        <p> </p>
        <p> </p>
        <h3>Colombo Stock Exchange Domestic Buying Vs Selling Comparison</h3>


        <script type="text/javascript" src="pages/amstock/swfobject.js"></script>
        <div id="flashcontent-buysell" align="CENTER">
            <strong>You need to upgrade your Flash Player</strong>
        </div>

        <script type="text/javascript">
            var so = new SWFObject("pages/amstock/amstock.swf", "amstock", "900", "500", "8", "#FFFFFF");
            so.addVariable("path", "");
            so.addVariable("preloader_color", "#CD2626");
            so.addVariable("settings_file", encodeURIComponent("pages/market-domestic-activity/amstock_settings-single-dom-purchease-vs-sale.xml"));
            so.write("flashcontent-buysell");
        </script>

        <h1>   </h1>
        <h1>   </h1>
        <h1>   </h1>
        <p> </p>
        <p> </p>
        <p> </p>
        <p> </p>
        <p> </p>


    </div>

</div>