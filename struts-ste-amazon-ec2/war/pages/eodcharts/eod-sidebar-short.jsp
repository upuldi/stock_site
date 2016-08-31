<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="sidebar">
    <ul>
        <li>
            <h4><span>Other <strong> Charts</strong></span></h4>
            <ul class="blocklist">
                <li><a href="inputDataSimpleEODChartSideBarAction.action">Simple Gray</a></li>
                <li><a href="inputDataGrayEODChartSideBarAction.action">Simple Trade</a></li>
                <li><a href="inputDataCompactEODChartSideBarAction.action">Compact</a></li>
            </ul>
        </li>
    </ul>
    <br />
    <ul>
        <li>
            <h4><span>More <strong>Charts</strong></span></h4>
            <ul class="blocklist">
                <li><a href="submitDataForiegnHoldChart.action?stockCode=<s:property value="stockCode" />">Foriegn
                    Holding Change</a></li>
                <li><a href="submitDataIssuedQtyChart.action?stockCode=<s:property value="stockCode" />">Issued Qty
                    Change</a></li>
            </ul>
        </li>
    </ul>
</div>

