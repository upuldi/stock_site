<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<div id="sub-header">
    <s:if test="showSubheader == true ">
    <h2><font class="cusfont-orange">Open</font> <s:property value="eodData.open" /> <font class="cusfont-orange">High</font> <s:property value="eodData.high" /> <font class="cusfont-orange">Low</font> <s:property value="eodData.low" /> <font class="cusfont-orange">Close</font> <s:property value="eodData.close" /> <font class="cusfont-orange">Vol</font> <s:property value="eodData.vol" /> <font class="cusfont-orange">Trades</font> <s:property value="eodData.trade" /></h2>
    <s:else><h2>Daily Stock Charts</h2></s:else>
    </s:if>
</div>
