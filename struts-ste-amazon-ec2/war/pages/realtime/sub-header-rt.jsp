<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<div id="sub-header">
    <s:if test="showTable == true "> <div id="subHeaderDivAJAX">
        <h2><font id="closeValue"></font> <img id="changeImage"/>
            <font id="openBks" class="cusfont-white"></font><font id="change"></font><font id="closeBks"
                                                                                           class="cusfont-big-white"></font> <font id="changePresentage"></font>
            <font id="tradeTxt" class="cusfont-orange"></font>
            <font id="trades" class="cusfont-white"></font>
            <font id="volTxt" class="cusfont-orange"></font>
            <font id="volume" class="cusfont-white"> </font></h2></div>

        <s:else><h2>Daily Stock Charts</h2></s:else>
    </s:if>
</div>


