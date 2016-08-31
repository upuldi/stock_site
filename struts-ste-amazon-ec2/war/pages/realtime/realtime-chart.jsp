<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<script type="text/javascript">

    function AjaxMarketStatus() {

        //  document.getElementById('subHeaderDivAJAX').innerHTML = "";

        //  alert("Welcome ");
        var xmlHttp;
        try {
            xmlHttpMain = new XMLHttpRequest();
        }
        catch (e) {
            try {
                xmlHttpMain = new ActiveXObject("Msxml2.XMLHTTP");
            }
            catch (e) {
                try {
                    xmlHttpMain = new ActiveXObject("Microsoft.XMLHTTP");
                }
                catch (e) {
                    alert("No AJAX!?");
                    return false;
                }
            }
        }

        xmlHttpMain.onreadystatechange = function () {

            try {

                if (xmlHttpMain.readyState == 4) {

                    //  alert("READY" );
                    var ajaxResponse = xmlHttpMain.responseText;


                    //  alert("RESPONSE : " + ajaxResponse.toString());

                    var responseObjK = JSON.parse(ajaxResponse);

                    //   alert("DATA FOUND : responseObjK.lastTradedPrice)" + responseObjK.lastTradedPrice);

                    if (null != responseObjK.lastTradedPrice) {
                        document.getElementById('closeValue').innerHTML = responseObjK.lastTradedPrice;
                        document.getElementById('closeValue').className = responseObjK.changeClass
                    }
                    if (null != responseObjK.changeImage) {
                        document.getElementById('changeImage').src = "pages/images/" + responseObjK.changeImage;
                    }
                    if (null != responseObjK.change) {

                        document.getElementById('openBks').innerHTML = "(";
                        document.getElementById('closeBks').innerHTML = ")";

                        document.getElementById('change').innerHTML = responseObjK.change;
                        document.getElementById('change').className = responseObjK.changeClassPresentage;
                    }
                    if (null != responseObjK.changePresentage) {
                        document.getElementById('changePresentage').innerHTML = responseObjK.changePresentage;
                        document.getElementById('changePresentage').className = responseObjK.changeClassPresentage;
                    }
                    if (null != responseObjK.trade) {
                        document.getElementById('tradeTxt').innerHTML = "Trades ";
                        document.getElementById('trades').innerHTML = responseObjK.trade;
                    }
                    if (null != responseObjK.volume) {
                        document.getElementById('volTxt').innerHTML = "Volume " ;
                        document.getElementById('volume').innerHTML = responseObjK.volume;
                    }
                    if (null != responseObjK.recordTIme) {
                        document.getElementById('recrodTime').innerHTML = responseObjK.recordTIme;
                    }
                    if (null != responseObjK.closingPrice) {
                        document.getElementById('closingPrice').innerHTML = responseObjK.closingPrice;
                    }
                    if (null != responseObjK.prevClose) {
                        document.getElementById('previousClose').innerHTML = responseObjK.prevClose;
                    }
                    if (null != responseObjK.lastTradedPrice) {
                        document.getElementById('lastTradedPrice').innerHTML = responseObjK.lastTradedPrice;
                    }
                    if (null != responseObjK.lastTradedPriceRange) {
                        document.getElementById('lastTradedPriceRange').innerHTML = responseObjK.lastTradedPriceRange;
                    }
                    if (null != responseObjK.allTimeHigh) {
                        document.getElementById('allTimeHigh').innerHTML = responseObjK.allTimeHigh;
                    }
                    if (null != responseObjK.allTimeLow) {
                        document.getElementById('allTimeLow').innerHTML = responseObjK.allTimeLow;
                    }
                    if (null != responseObjK.betaAsi) {
                        document.getElementById('betaASI').innerHTML = responseObjK.betaAsi;
                    }
                    if (null != responseObjK.betaMpi) {
                        document.getElementById('betaMPI').innerHTML = responseObjK.betaMpi;
                    }
                    if (null != responseObjK.marketCap) {
                        document.getElementById('marketCap').innerHTML = responseObjK.marketCap;
                    }
                    if (null != responseObjK.marketCapPresent) {
                        document.getElementById('marketCapPresent').innerHTML = responseObjK.marketCapPresent;
                    }
                    if (null != responseObjK.turnover) {
                        document.getElementById('turnover').innerHTML = responseObjK.turnover;
                    }
                    if (null != responseObjK.toYtd) {
                        document.getElementById('ytdTurnover').innerHTML = responseObjK.toYtd;
                    }
                    if (null != responseObjK.toMtd) {
                        document.getElementById('mtdTurnover').innerHTML = responseObjK.toMtd;
                    }
                    if (null != responseObjK.toWtd) {
                        document.getElementById('wtdTurnover').innerHTML = responseObjK.toWtd;
                    }
                    if (null != responseObjK.volume) {
                        document.getElementById('vol').innerHTML = responseObjK.volume;
                    }
                    if (null != responseObjK.volYtd) {
                        document.getElementById('ytdVol').innerHTML = responseObjK.volYtd;
                    }
                    if (null != responseObjK.volMtd) {
                        document.getElementById('mtdVol').innerHTML = responseObjK.volMtd;
                    }
                    if (null != responseObjK.volWtd) {
                        document.getElementById('wtdVol').innerHTML = responseObjK.volWtd;
                    }


                    setTimeout('AjaxMarketStatus()', 60000);
                }

            } catch (e) {
                // alert("ISSUE : " + e);
            }
        }

        if (null != document.getElementsByName('stockCode')[0].value) {
            var stockCodeVal = document.getElementsByName('stockCode')[0].value;
            var url = "fetchTickerDataRealTimeTickerAJAXData.action?symbol=" + stockCodeVal;
            // alert("request url : " + url);
            xmlHttpMain.open("GET", url, true);
            xmlHttpMain.send(null);
        }
        return true;
    }

    <s:if test="showTable == true ">
    window.onload = function () {
        AjaxMarketStatus();
        AjaxMarketStatus();
        setTimeout('AjaxMarketStatus()', 60000);

    }
    </s:if>

</script>

<div id="content">

    <div class="box">

        <h2>Daily Charts</h2>

        <p>

        <p>

        <h1></h1>

        <fieldset>

            <legend>Stock Data</legend>
            <s:form onsubmit="AjaxMarketStatus()" action="submitDataRealtimeChartAction.action">
                <sx:autocompleter cssClass="formitem" label="Stock Code" list="stockCodes" name="stockCode"
                                  id="stockCodeField"></sx:autocompleter>
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

            <h1></h1>

            <p></p>

            <p></p>

            <p></p>

            <p></p>

            <p></p>
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

            <h1></h1>

            <p></p>

            <p></p>

            <p></p>

            <p></p>

            <p></p>

        </fieldset>

        <s:if test="showChart == true">

            <h4>As of <font id="recrodTime"></font></h4>
            <fieldset>
                <legend>Stock Info</legend>
                <h1></h1>
                <h1></h1>



                <table>
                    <tbody>
                    <tr>
                        <th>Closing Price</th>
                        <th>Previous Close</th>
                        <th>Last Traded Price</th>
                        <th>Last Traded Price Range</th>
                    </tr>
                    <tr>
                        <td class=""><font id="closingPrice"></font></td>
                        <td class=""><font id="previousClose"></font></td>
                        <td class=""><font id="lastTradedPrice"></font></td>
                        <td class=""><font id="lastTradedPriceRange"></font></td>
                    </tr>
                    </tbody>
                </table>

                <table>
                    <tbody>
                    <tr>
                        <th>All Time High</th>
                        <th>All Time Low</th>
                    </tr>
                    <tr>
                        <td class=""><font id="allTimeHigh"></font></td>
                        <td class=""><font id="allTimeLow"></font></td>
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
                        <th>Market Capitalisation </th>
                        <th>Market Capitalisation percentage </th>
                        <th>Beta Against ASI  </th>
                        <th>Beta Against MPI </th>
                    </tr>
                    <tr>
                        <td class=""><font id="marketCap"></font></td>
                        <td class=""><font id="marketCapPresent"></font></td>
                        <td class=""><font id="betaASI"></font></td>
                        <td class=""><font id="betaMPI"></font></td>
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
                        <th>Turnover </th>
                        <th>YTD Turnover </th>
                        <th>MTD Turnover </th>
                        <th>WTD Turnover </th>
                    </tr>
                    <tr>
                        <td class=""><font id="turnover"></font></td>
                        <td class=""><font id="ytdTurnover"></font></td>
                        <td class=""><font id="mtdTurnover"></font></td>
                        <td class=""><font id="wtdTurnover"></font></td>
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
                        <th>Volume </th>
                        <th>YTD Volume </th>
                        <th>MTD Volume </th>
                        <th>WTD Volume </th>
                    </tr>
                    <tr>
                        <td class=""><font id="vol"></font></td>
                        <td class=""><font id="ytdVol"></font></td>
                        <td class=""><font id="mtdVol"></font></td>
                        <td class=""><font id="wtdVol"></font></td>
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

            <fieldset>
                <legend>Daily <s:property value="stockCode"/> Price Movements</legend>

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

                <div id="flashcontent" align="center">
                    <strong>You need to upgrade your Flash Player</strong>
                </div>

                <script type="text/javascript">
                    var so = new SWFObject("pages/amstock/amstock.swf", "amstock", "900", "500", "8", "#FFFFFF");
                    so.addVariable("path", "");
                    so.addVariable("chart_settings", "<settings> <margins>0</margins> <text_size>10</text_size> <data_reloading> <interval>60</interval> <show_preloader>1</show_preloader> </data_reloading> <header> <enabled>false</enabled> </header> <number_format> <letters> <letter number='1000'>K</letter> <letter number='1000000'>M</letter> <letter number='1000000000'>B</letter> </letters> </number_format> <data_sets> <data_set did='0'> <title>Relatime Data</title> <short>Stock</short> <description></description> <file_name>http://localhost:8080/struts-site/getRealTimeDataRealTimeDataCSVAction.action?param=<s:property value="param"/></file_name> <trend_lines_file_name>pages/realtime/trend_lines.xml</trend_lines_file_name> <main_drop_down selected='true'></main_drop_down> <csv> <reverse>true</reverse> <separator>,</separator> <date_format>YYYY-MM-DD hh:mm:ss</date_format> <decimal_separator>,</decimal_separator> <columns> <column>date</column> <column>volume</column> <column>close</column> </columns> </csv> </data_set> </data_sets> <error_messages> <enabled>0</enabled> </error_messages> <charts> <chart cid='0'> <bg_color>f5f5f5,ffffff</bg_color> <title>Value</title> <height>60</height> <border_color>#CCCCCC</border_color> <border_alpha>100</border_alpha> <grid> <x> <dashed>true</dashed> </x> <y_right> <color>cccccc</color> <alpha>100</alpha> <dashed>true</dashed> </y_right> </grid> <legend> <graph_on_off>false</graph_on_off> <fade_others_to>10</fade_others_to> <show_date>true</show_date> </legend> <comparing> <recalculate_from_start>0</recalculate_from_start> </comparing> <events> <use_hand_cursor>1</use_hand_cursor> </events> <trend_lines> <drawing_enabled>1</drawing_enabled> <line_width>2</line_width> <dash_length>5</dash_length> </trend_lines> <graphs> <graph gid='0'> <axis>right</axis> <type>line</type> <smoothed>1</smoothed> <data_sources> <close>close</close> </data_sources> <compare_source>close</compare_source> <legend> <date key='true' title='true'><![CDATA[<b>{close}</b>]]></date> <period key='true' title='true'> <![CDATA[open:<b>{open}</b> low:<b>{low}</b> high:<b>{high}</b> close:<b>{close}</b>]]></period> <date_comparing key='true' title='true'><![CDATA[{close.percents}]]></date_comparing> <period_comparing key='true' title='true'><![CDATA[{close.percents}]]></period_comparing> </legend> </graph> </graphs> </chart> <chart> <title>Volume</title> <height>30</height> <border_color>#CCCCCC</border_color> <border_alpha>0</border_alpha> <grid> <x> <alpha>10</alpha> <dashed>true</dashed> </x> <y_left> <alpha>10</alpha> <dashed>true</dashed> <approx_count>3</approx_count> </y_left> </grid> <values> <x> <enabled>true</enabled> </x> </values> <legend> <positive_color>7f8da9</positive_color> <negative_color>db4c3c</negative_color> <show_date>false</show_date> </legend> <column_width>70</column_width> <graphs> <graph> <type>column</type> <data_sources> <close>volume</close> </data_sources> <period_value>average</period_value> <cursor_color>002b6d</cursor_color> <fill_alpha>100</fill_alpha> <legend> <date key='false' title='false'>  <![CDATA[ {average} ]]>  </date> <period key='false' title='false'>  <![CDATA[ <b>{average.percents}</b> ]]>  </period> </legend> </graph> </graphs> </chart> </charts> <date_formats> <legend> <days>hh:mm:ss month DD, YYYY</days> </legend> </date_formats> <data_set_selector> <width>130</width> <max_comparing_count>3</max_comparing_count> <main_drop_down_title>Select:</main_drop_down_title> <compare_list_box_title>Compare to:</compare_list_box_title> <balloon_text>{title}: {description}</balloon_text> </data_set_selector> <period_selector> <button> <bg_color_hover>b81d1b</bg_color_hover> <bg_color_selected>b81d1b</bg_color_selected> <text_color_hover>ffffff</text_color_hover> <text_color_selected>ffffff</text_color_selected> </button> <date_format>hh:mm</date_format> <periods_title>Zoom:</periods_title> <tom_period_title>Custom period:</tom_period_title> <periods> <period pid='0' type='mm' count='5'>5M</period> <period pid='1' type='mm' count='10' selected='1'>10M</period> <period pid='2' type='mm' count='20' selected='1'>20M</period> <period pid='3' type='MAX' count='30'>30M</period> <period pid='4' type='hh' count='1'>1H</period> <period pid='5' type='hh' count='2'>2H</period> <period pid='6' type='hh' count='3' selected='1'>3H</period> <period pid='7' type='hh' count='4'>4H</period> <period pid='8' type='hh' count='6' selected='1'>6H</period> <period pid='9' type='MAX' count='0'>MAX</period> </periods> <periods_title>Zoom:</periods_title> <tom_period_title>Custom period:</tom_period_title> </period_selector> <date_formats> <!-- [24] (12 / 24) The time in the legend and x axis might be displayed using 12 or 24 hour format --> <hour_format></hour_format> <legend> <minutes>mm:ss</minutes> </legend> <x_axis> <minutes>mm:ss</minutes> </x_axis> </date_formats> <header> <enabled></enabled> <text><![CDATA[<b>{title}</b> ({short}) {description}]]></text> <text_size>12</text_size> </header> <plot_area> <border_color>cccccc</border_color> </plot_area> <scroller> <enabled>true</enabled> <height>50</height> <graph_data_source>close</graph_data_source> <bg_color>f5f5f5,ffffff</bg_color> <resize_button_style>dragger</resize_button_style> <playback> <enabled>true</enabled> <color>002b6d</color> <color_hover>db4c3c</color_hover> <speed>3</speed> <max_speed>10</max_speed> <speed_indicator> <color>002b6d</color> </speed_indicator> </playback> </scroller> </settings>");
                    so.write("flashcontent");
                </script>

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