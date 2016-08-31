<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="sidebar">
    <ul>
        <li>
            <h4><span>Charts of <strong><s:property value="listedCompany.stockCode"/></strong></span></h4>
            <ul class="blocklist">

                <s:iterator value="companyTickers" status="songStatus">
                    <li><a href="submitDataEODChartAction.action?stockCode=<s:property value="symbol" />"><font class="cusfont-orange"><s:property value="symbol" /></font> EOD</a></li>
                    <li><a href="submitDataCandleChartAction.action?stockCode=<s:property value="symbol" />"><font class="cusfont-orange"><s:property value="symbol" /></font> Candle Stick</a></li>
                    <li><a href="submitDataOHLCChartAction.action?stockCode=<s:property value="symbol" />"><font class="cusfont-orange"><s:property value="symbol" /></font> OHLC</a></li>
                </s:iterator>
            </ul>
        </li>
    </ul>
</div>

