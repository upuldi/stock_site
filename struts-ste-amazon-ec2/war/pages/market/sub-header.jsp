<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<div id="sub-header">
    <h2><font class="cusfont-orange">ASPI</font> <s:property value="aspiValue"/> <img
            src="pages/images/<s:property value="aspiImage" />"/> <font
            class="<s:property value="fontClassASPIChangeValue" />"><s:property value="aspiChange"/></font> <font
            class="<s:property value="fontClassASPIChangePresentage" />"><s:property
            value="aspiChangePresentage"/>%</font><font class="cusfont-orange"> S&P20</font> <s:property
            value="mpiValue"/> <img src="pages/images/<s:property value="mpiImage" />"/> <font
            class="<s:property value="fontClassMPIChangeValue" />"> <s:property value="mpiChange"/></font> <font
            class="<s:property value="fontClassMPIChangePresentage" />"><s:property
            value="mpiChangePresentage"/>%</font></h2>

    <h2>   &nbsp;</h2>
</div>