<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<div id="content">
    <div class="box">
        <h1>   </h1>
        <h1>   </h1>

        <h3>Colombo Stock Exchange ASPI Price Index Chart  </h3>
        <div id="containerASPI" style="min-width: 950px; height: 500px; margin: 0 auto"></div>

        <h1>   </h1>
        <h1>   </h1>
        <h1>   </h1>
        <p> </p>
        <p> </p>
        <p> </p>
        <p> </p>
        <p> </p>

        <h3>Colombo Stock Exchange MPI Price Index Chart   </h3>
        <div id="containerMPI" style="min-width: 950px; height: 500px; margin: 0 auto"></div>

        <h1>   </h1>
        <h1>   </h1>
        <h1>   </h1>
        <p> </p>
        <p> </p>
        <p> </p>
        <p> </p>
        <p> </p>

        <h3>Colombo Stock Exchange SNP Price Index  Chart</h3>
        <div id="containerSNP" style="min-width: 950px; height: 500px; margin: 0 auto"></div>

        <h1>   </h1>
        <h1>   </h1>
        <h1>   </h1>
        <p> </p>
        <p> </p>
        <p> </p>
        <p> </p>
        <p> </p>

        <h3>Colombo Stock Exchange Price Index Comparison</h3>



        <script type="text/javascript" src="pages/amstock/swfobject.js"></script>
        <div id="flashcontent" align="CENTER">
            <strong>You need to upgrade your Flash Player</strong>
        </div>

        <script type="text/javascript">
            var so = new SWFObject("pages/amstock/amstock.swf", "amstock", "950", "500", "8", "#FFFFFF");
            so.addVariable("path", "");
            so.addVariable("preloader_color", "#CD2626");
            so.addVariable("settings_file", encodeURIComponent("pages/market/amstock_settings_index.xml"));
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


    </div>

</div>