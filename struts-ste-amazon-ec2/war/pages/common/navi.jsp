<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<div id="nav">

    <ul class="sf-menu dropdown">
        <li
                <s:if test="selectedLink == \"home\" ">class="selected" </s:if>  ><a href="homeLink.action">Home</a>
        </li>

        <li
                <s:if test="selectedLink == \"marketdata\" ">class="selected" </s:if> ><a class="has_submenu"
                                                                                          href="marketSummeryMarketSummeryAllAction.action">Market</a>
            <ul>
                <%--    <li><a href="marketIndexMarketChartAction.action">Index</a></li> --%>
                <li><a href="marketTradesMarketTradesChartAction.action">Trades</a></li>
                <li><a href="marketTurnoverMarketTurnoverChartAction.action">Turnover</a></li>
                <li><a href="marketVolumeMarketVolumeChartAction.action">Volume</a></li>
                <li><a href="marketDomesticActivityMarketDomesticActivityAction.action">Domestic Activity</a></li>
                <li><a href="marketForeignActivityMarketForeignActivityAction">Foreign Activity</a></li>
                <li><a href="marketCapitalizationMarketCapitalizationAction">Market Factors</a></li>
                <%--                <li><a href="html5TtestHTML5TestAction">New HTML5</a></li>
              <li><a href="hcTestHCTestAction">New hc</a></li> --%>
            </ul>
        </li>

        <li <s:if test="selectedLink == \"index\" "> class="selected" </s:if> >
            <a class="has_submenu" href="marketSummeryMarketSummeryAllAction.action">Index</a>
            <ul>
                <li><a href="marketIndexASPIMarketChartAction.action">ASPI</a></li>
                <li><a href="marketIndexMPIMarketChartAction.action">MPI</a></li>
                <li><a href="marketIndexSNP20MarketChartAction.action">SNP20</a></li>
                <li><a href="marketIndexSectorsMarketChartAction.action">Sectors</a></li>
            </ul>
        </li>

        <li
                <s:if test="selectedLink == \"charts\" ">class="selected" </s:if> ><a class="has_submenu"
                                                                                      href="defaultStockLink.action">Stock
            Charts</a>
            <ul>
                <%-- <li><a href="inputDataDayChartAction.action">Line Day Charts</a></li>--%>
                <li><a href="inputDataEODChartAction.action">Daily Stock Charts</a></li>
                <li><a href="inputDataStockDividentAction.action">Divident Dates</a></li>
                <li><a href="inputDataStockSplitAction.action">Share Splits</a></li>
                <li><a href="inputDataStockRightsAction.action">Share Right Issues</a></li>
                <li><a href="inputDataCandleChartAction.action">Daily Candle Stick Charts</a></li>
                <li><a href="inputDataOHLCChartAction.action">Daily OHLC Charts</a></li>
                <%--<li><a href="foriegnHoldingLink.action">Forign Holding</a></li>--%>
                <%--<li><a href="tradeLink.action">Trades</a></li>--%>

            </ul>
        </li>
        <li <s:if test="selectedLink == \"realtime\" ">class="selected" </s:if>><a class="has_submenu"
                                                                                   href="inputDataRealtimeChartAction.action">RealTime
            Charts</a>
            <ul>
                <li><a href="getRealTimeIndexDataRealtimeIndexChartAction.action">Market Today</a></li>
                <%--                <li><a href="inputDataRealtimeChartAction.action">Stock Charts</a></li>--%>
            </ul>
        </li>


        <li <s:if test="selectedLink == \"commodity\" ">class="selected" </s:if>><a class="has_submenu"
                                                                                    href="commodityLink.action">Commodity
            Charts</a>
            <ul>
                <li><a href="goldLink.action">Gold</a></li>
                <li><a href="commodityLink.action">Rubber</a></li>
            </ul>
        </li>


        <li <s:if test="selectedLink == \"contacts\" ">class="selected" </s:if>><a
                href="contactUsLink.action">Contact</a></li>
    </ul>

</div>