<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<link rel="stylesheet" href="style.css" type="text/css">
<script src="pages/amcharts-new/amcharts/amcharts.js" type="text/javascript"></script>
<script src="pages/amcharts-new/amcharts/raphael.js" type="text/javascript"></script>


<%@page contentType="text/html" pageEncoding="UTF-8" %>
<div id="content">
<div class="box">
<h2>EOD Line Charts</h2>

<script type="text/javascript">

    var chart1;
    AmCharts.ready(function () {

        var ajaxResponse = "{\"keyValueDataList\":[{\"key\":\"Vol Today\",\"value\":"+ <s:property value="volToday"/> +"},{\"key\":\"Vol WTD\",\"value\":"+  <s:property value="restVolWeek"/> +"}],\"positiveNegativeMarketParticipents\":\"success\"}";

        alert("ajaxResponse" + ajaxResponse);
        var replaced = ajaxResponse.replace("quot"," ");
        alert("replaced" + replaced);
        var responseObjK = JSON.parse(ajaxResponse);
        var jasonStringArray = JSON.stringify(responseObjK.keyValueDataList);
        var jasonArrayObject = JSON.parse(jasonStringArray);

        /* Draw PIE Chart. */
        drawChart1(chart1, jasonArrayObject);
    });

    var chart2;
    AmCharts.ready(function () {

        var ajaxResponse = "{\"keyValueDataList\":[{\"key\":\"Vol Today\",\"value\":"+ <s:property value="volToday"/> +"},{\"key\":\"Vol WTD\",\"value\":"+  <s:property value="restVolWeek"/> +"}],\"positiveNegativeMarketParticipents\":\"success\"}";

        alert("ajaxResponse" + ajaxResponse);
        var replaced = ajaxResponse.replace("quot"," ");
        alert("replaced" + replaced);
        var responseObjK = JSON.parse(ajaxResponse);
        var jasonStringArray = JSON.stringify(responseObjK.keyValueDataList);
        var jasonArrayObject = JSON.parse(jasonStringArray);

        /* Draw PIE Chart. */
        drawChart2(chart2, jasonArrayObject);
    });


    function drawChart1(chart, jasonArrayObject) {

        chart = new AmCharts.AmPieChart();
        chart.colors = ["#32B232" , "#FF0F00"];
        chart.pieAlpha = 10;
        //chart.pieBaseColor = "#FF8040";
        // title of the chart
        // chart.addTitle("Volume", 16);
        chart.dataProvider = jasonArrayObject;
        chart.titleField = "key";
        chart.valueField = "value";
        chart.sequencedAnimation = true;
        chart.startEffect = "elastic";
        chart.innerRadius = "30%";
        chart.startDuration = 2;
        chart.labelRadius = 15;
        chart.depth3D = 5;
        chart.angle = 15;
        chart.write("chartdivVol1");
    }
    function drawChart2(chart, jasonArrayObject) {

        chart = new AmCharts.AmPieChart();
        chart.colors = ["#32B232" , "#FF0F00"];
        chart.pieAlpha = 10;
        //chart.pieBaseColor = "#FF8040";
        // title of the chart
        // chart.addTitle("Volume", 16);
        chart.dataProvider = jasonArrayObject;
        chart.titleField = "key";
        chart.valueField = "value";
        chart.sequencedAnimation = true;
        chart.startEffect = "elastic";
        chart.innerRadius = "30%";
        chart.startDuration = 2;
        chart.labelRadius = 15;
        chart.depth3D = 5;
        chart.angle = 15;
        chart.write("chartdivVol2");
    }

</script>

<p>

<p>

<h1></h1><br /><br />

<fieldset>

    <legend>Stock Data</legend>
    <s:form action="submitDataEODChartAction.action">
        <sx:autocompleter cssClass="formitem" label="Stock Code" list="stockCodes" name="stockCode"></sx:autocompleter>
        <s:submit cssClass="formbutton"/>
    </s:form>

    <h1></h1>

    <h1></h1>

    <h1></h1>

    <h1></h1>

    <h1></h1>

    <p></p>

    <p></p>

    <p></p>

    <p></p>

    <p></p>

</fieldset>

<s:if test="showTable == true">
    <h4>As of <s:property value="dateString"/></h4>
    <fieldset>
        <legend>Stock Info</legend>
        <h1></h1>

        <h1></h1>


        <table>
            <tbody>
            <tr>
                <th>Open</th>
                <th>High</th>
                <th>Low</th>
                <th>Close</th>
                <th>Change</th>
                <th>Change Presentage</th>
                <th>Volume</th>
                <th>Trades</th>
            </tr>
            <tr>
                <td class=""><s:property value="eodData.open"/></td>
                <td class=""><s:property value="eodData.high"/></td>
                <td class=""><s:property value="eodData.low"/></td>
                <td class=""><s:property value="eodData.close"/></td>
                <td class=""><s:property value="change"/></td>
                <td class=""><s:property value="changePresentage"/>%</td>
                <td class=""><s:property value="formatedVolume"/></td>
                <td class=""><s:property value="formatedTrades"/></td>
            </tr>
            </tbody>
        </table>


    </fieldset>
    <fieldset>
        <legend>Pricing Info</legend>
        <h1></h1>

        <h1></h1>


        <table>
            <tbody>
            <tr>
                <th>All Time High</th>
                <th>All Time Low</th>
            </tr>
            <tr>
                <td class=""><s:property value="ticker.allTimeHigh"/></td>
                <td class=""><s:property value="ticker.allTimeLow"/></td>
            </tr>
            </tbody>
        </table>


    </fieldset>
    <fieldset>
        <legend>Market Info</legend>
        <h1></h1>

        <h1></h1>


        <table>
            <tbody>
            <tr>
                <th>Market Capitalisation</th>
                <th>Market Capitalisation percentage</th>
                <th>Beta Against ASI</th>
                <th>Beta Against MPI</th>
            </tr>
            <tr>
                <td class=""><s:property value="ticker.marketCap"/></td>
                <td class=""><s:property value="ticker.marketCapPresent"/></td>
                <td class=""><s:property value="ticker.betaAsi"/></td>
                <td class=""><s:property value="ticker.betaMpi"/></td>
            </tr>
            </tbody>
        </table>


    </fieldset>
    <fieldset>
        <legend>Turnover Info</legend>
        <h1></h1>

        <h1></h1>


        <table>
            <tbody>
            <tr>
                <th>YTD Turnover</th>
                <th>MTD Turnover</th>
                <th>WTD Turnover</th>
            </tr>
            <tr>
                <td class=""><s:property value="ticker.toYtd"/></td>
                <td class=""><s:property value="ticker.toMtd"/></td>
                <td class=""><s:property value="ticker.toWtd"/></td>
            </tr>
            </tbody>
        </table>


    </fieldset>
    <fieldset>
        <legend>Volume Info</legend>
        <h1></h1>

        <h1></h1>


        <table>
            <tbody>
            <tr>
                <th>YTD Volume</th>
                <th>MTD Volume</th>
                <th>WTD Volume</th>
            </tr>
            <tr>
                <td class=""><s:property value="ticker.volYtd"/></td>
                <td class=""><s:property value="ticker.volMtd"/></td>
                <td class=""><s:property value="ticker.volWtd"/></td>
            </tr>
            </tbody>
        </table>


    </fieldset>

</s:if>

<h1></h1>

<h1></h1>

<h1></h1>

<h1></h1>

<h1></h1>

<p></p>

<p></p>

<p></p>

<p></p>

<p></p>


<s:if test="showChart == true ">

    <s:if test="showVolChart == true ">
        <fieldset>
            <legend>Volume And Turnover</legend>

            <table> <tr><td>
                <div id="chartdivVol1" style="width:500px; height:400px;"></div> </td>
                <td><div id="chartdivVol2" style="width:500px; height:400px;"></div></td>
            </tr>
            </table>
        </fieldset>
    </s:if>


    <h1></h1>

    <h1></h1>

    <p></p>


    <fieldset>


        <legend>EOD <s:property value="stockCode"/> Price Movements</legend>
        <h1></h1>

        <h1></h1>

        <h1></h1>

        <h1></h1>

        <h1></h1>

        <p></p>

        <p></p>

        <p></p>

        <p></p>

        <p></p>

        <script type="text/javascript" src="pages/amstock/swfobject.js"></script>
        <center>
            <div id="flashcontent" align="CENTER">
                <strong>You need to upgrade your Flash Player</strong>
            </div>
        </center>
        <script type="text/javascript">
            var so = new SWFObject("pages/amstock/amstock.swf", "amstock", "900", "700", "8", "#FFFFFF");
            so.addVariable("path", "");
            so.addVariable("chart_settings", "<settings> <margins>0</margins> <text_size>10</text_size> <header> <enabled>false</enabled> </header> <number_format> <letters> <letter number='1000'>K</letter> <letter number='1000000'>M</letter> <letter number='1000000000'>B</letter> </letters> </number_format> <data_sets> <data_set did='0'> <title> <s:property value="stockCode"/> </title> <short> <s:property value="stockCode"/> </short> <description></description> <file_name>http://localhost:8080/struts-site/getEODChartDataEODDataAction.action?type=<s:property value="stockCode"/> </file_name> <main_drop_down selected='true'></main_drop_down> <compare_list_box selected='false'></compare_list_box> <csv> <reverse>true</reverse> <separator>,</separator> <date_format>YYYY-MM-DD</date_format> <decimal_separator>.</decimal_separator> <columns> <column>date</column> <column>volume</column> <column>close</column> <column>trades</column> </columns> </csv> </data_set> </data_sets> <error_messages> <enabled>0</enabled> </error_messages> <charts> <chart cid='0'> <bg_color>f5f5f5,ffffff</bg_color> <title>Value</title> <height>60</height> <border_color>#CCCCCC</border_color> <border_alpha>100</border_alpha> <grid> <x> <dashed>true</dashed> </x> <y_right> <color>cccccc</color> <alpha>100</alpha> <dashed>true</dashed> </y_right> </grid> <legend> <graph_on_off>false</graph_on_off> <fade_others_to>10</fade_others_to> <show_date>true</show_date> </legend> <graphs> <graph gid='0'> <axis>right</axis> <type>line</type> <smoothed>1</smoothed> <data_sources> <close>close</close> </data_sources> <compare_source>close</compare_source> <legend> <date key='true' title='true'><![CDATA[<b>{close}</b>]]></date> <period key='true' title='true'> <![CDATA[open:<b>{open}</b> low:<b>{low}</b> high:<b>{high}</b> close:<b>{close}</b>]]></period> <date_comparing key='true' title='true'><![CDATA[{close.percents}]]></date_comparing> <period_comparing key='true' title='true'><![CDATA[{close.percents}]]></period_comparing> </legend> </graph> </graphs> </chart> <chart> <title>Volume</title> <height>30</height> <border_color>#CCCCCC</border_color> <border_alpha>0</border_alpha> <grid> <x> <alpha>10</alpha> <dashed>true</dashed> </x> <y_left> <alpha>10</alpha> <dashed>true</dashed> <approx_count>3</approx_count> </y_left> </grid> <values> <x> <enabled>true</enabled> </x> </values> <legend> <positive_color>7f8da9</positive_color> <negative_color>db4c3c</negative_color> <show_date>false</show_date> </legend> <column_width>70</column_width> <graphs> <graph> <type>column</type> <data_sources> <close>volume</close> </data_sources> <period_value>average</period_value> <cursor_color>002b6d</cursor_color> <fill_alpha>100</fill_alpha> <legend> <date key='false' title='false'>  <![CDATA[ {average} ]]>  </date> <period key='false' title='false'>  <![CDATA[ <b>{average.percents}</b> ]]>  </period> </legend> </graph> </graphs> </chart> <chart> <title>Trades</title> <height>30</height> <border_color>#CCCCCC</border_color> <border_alpha>0</border_alpha> <grid> <x> <alpha>10</alpha> <dashed>true</dashed> </x> <y_left> <alpha>10</alpha> <dashed>true</dashed> <approx_count>3</approx_count> </y_left> </grid> <values> <x> <enabled>true</enabled> </x> </values> <legend> <positive_color>7f8da9</positive_color> <negative_color>db4c3c</negative_color> <show_date>false</show_date> </legend> <column_width>70</column_width> <graphs> <graph> <type>column</type> <data_sources> <close>trades</close> </data_sources> <period_value>average</period_value> <cursor_color>002b6d</cursor_color> <fill_alpha>100</fill_alpha> <legend> <date key='false' title='false'>  <![CDATA[ {average} ]]>  </date> <period key='false' title='false'>  <![CDATA[ <b>{average.percents}</b> ]]>  </period> </legend> </graph> </graphs> </chart> </charts> <data_set_selector> <width>130</width> <max_comparing_count>3</max_comparing_count> <main_drop_down_title>Select:</main_drop_down_title> <compare_list_box_title>Compare to:</compare_list_box_title> <balloon_text>{title}: {description}</balloon_text> </data_set_selector> <period_selector> <button> <bg_color_hover>b81d1b</bg_color_hover> <bg_color_selected>b81d1b</bg_color_selected> <text_color_hover>ffffff</text_color_hover> <text_color_selected>ffffff</text_color_selected> </button> <periods> <period pid='0' type='DD' count='5'>5D</period> <period pid='1' type='DD' count='10'>10D</period> <period pid='2' type='DD' count='20'>20D</period> <period pid='3' type='MM' count='30'>1M</period> <period pid='4' type='MM' count='2'>2M</period> <period pid='5' type='MM' count='3'>3M</period> <period pid='6' type='MM' count='4'>4M</period> <period pid='7' type='MM' count='6' selected='1'>6M</period> <period pid='8' type='YYYY' count='6'>1Y</period> <period pid='9' type='MAX' count='0'>MAX</period> </periods> <periods_title>Zoom:</periods_title> <tom_period_title>Custom period:</tom_period_title> </period_selector> <header> <enabled></enabled> <text><![CDATA[<b>{title}</b> ({short}) {description}]]></text> <text_size>12</text_size> </header> <plot_area> <border_color>cccccc</border_color> </plot_area> <scroller> <enabled>true</enabled> <height>50</height> <graph_data_source>close</graph_data_source> <bg_color>f5f5f5,ffffff</bg_color> <resize_button_style>dragger</resize_button_style> <playback> <enabled>true</enabled> <color>002b6d</color> <color_hover>db4c3c</color_hover> <speed>3</speed> <max_speed>10</max_speed> <speed_indicator> <color>002b6d</color> </speed_indicator> </playback> </scroller> </settings>");
            so.write("flashcontent");
        </script>

        <p></p>

        <p></p>

        <p></p>

        <p></p>

        <p></p>

        <p></p>

        <h1></h1>

        <h1></h1>


    </fieldset>

</s:if>

<h1></h1>

<h1></h1>

<h1></h1>

<h1></h1>

<h1></h1>

<h1></h1>

<h1></h1>

<h1></h1>

<p></p>

<p></p>

<p></p>

<p></p>

<p></p>

</div>

</div>