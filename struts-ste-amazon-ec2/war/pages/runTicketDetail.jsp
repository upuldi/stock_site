<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=iso-8859-1'/>
    <meta name='viewport' content='width=device-width, initial-scale=1'/>
    <meta name='format-detection' content='telephone=no'/>

    <link rel="stylesheet" href="scripts/jquery.mobile-1.0.min.css"/>
    <script src="scripts/jquery-1.6.4.min.js"></script>
    <script src="scripts/jquery.mobile-1.0.min.js"></script>
    <script src="scripts/mcScripts.js"></script>
    <link rel='stylesheet' type='text/css' href='common/soa-mobile.css'/>
    <style type="text/css">@import "scripts/jquery.themes.css";</style>
    <script type="text/javascript" src="scripts/jquery.themes.js"></script>
    
    <style type="text/css">
            /*            .ui-btn-up-c {
                            
                            background-color: #659EC7;
                        }*/
        .newskin, .ui-icon-shadow {
            background: '';

        }

        .newskin, .ui-btn-up-c, .ui-icon-shadow {
            color: #3F5772;
            background-image: "";
            background-color: #659EC7;
            background: -webkit-gradient(linear, left top, left bottom, color-stop(50%, #659EC7), color-stop(50%, #659EC7)); /* Chrome,Safari4+ */

            /*            -moz-border-radius: 5 em;
-webkit-border-radius: 5em ;            */
        }
    </style>
</head>
<body>
<div>
    <div data-role="header" data-position="inline">
        <h1>
            <span class="ui-btn-left"><img id="spinner" src="images/hess.png" /> Detail Run Ticket</span>
            <span></span>
            <span id="username" class="ui-username-right"></span>
            <span class="column-space">&nbsp; </span>
            <span id="userRoad" class="ui-userRoad-right"></span>
        </h1>
        <a id="syncBtn" onclick="runTicketDetail.callSave();" class="ui-syncbtn-right">Save</a>
        <a class="ui-print-right"  >Print</a>
        <a onclick="runTicketDetail.logOut();" class="ui-btn-right">Logout</a>
    </div>

    <div data-role="content">
        <div id="woDiv">
            <div class="ui-column-header-c">
                <span class="column-loperator"><label for="operator">Operator:</label></span>
                <span class="column-operator"><input readonly type="text" name="operator" id="operator" value=""/></span>
                <span class="column-midlabel"> <label for="tickNo">Ticket No:</label></span>
                <span class="column-ticket"> <input readonly type="text" name="tickNo" id="tickNo" value=""/></span>
            </div>
            <div class="ui-column-header-c">
                <span class="column-llease"><label for="lName">Lease Name:</label></span>
                <span class="column-lease"><input readonly type="text" name="lName" id="lName" value=""/></span>
                <span class="column-lcounty"><label for="county">County :</label></span>
                <span class="column-county"> <input readonly type="text" name="county" id="county" value=""/></span>
                <span class="column-lstate"> <label for="state">State :</label></span>
                <span class="column-state"> <input readonly type="text" name="state" id="state" value=""/></span>
            </div>
            <div class="ui-column-header-c">
                <span class="column-llease"><label for="leaseNo">Lease No:</label></span>
                <span class="column-lease"><input readonly type="text" name="leaseNo" id="leaseNo" value=""/></span>

                <span class="column-midlabel"> <label for="federalNo">Federal No:</label></span>
                <span class="column-fedNo"> <input readonly type="text" name="federalNo" id="federalNo" value=""/></span>
            </div>
            <div class="ui-column-header-c">
                <span class="column-ldate"><label for="date">Date:</label></span>
                <span class="column-date"><input readonly type="text" name="date" id="date" value=""/></span>
                        <span class="column-tankNo"> 
                            <!--                            <label  for="tankNo">Tank No:</label>-->

                        <select id="tankNo" name="tankNo" data-theme="c" class="newskin">
                                  <option value="0">Tank No</option> 
                        </select></span>

                <!--                        <span class="column-tankNo"> <input  type="text" name="tankNo" id="tankNo" value=""  /></span>-->
                <span class="column-midlabel"> <label for="tankSize">Tank Size:</label></span>
                <span class="column-tankSize"> <input readonly type="text" name="tankSize" id="tankSize" value=""/></span>

            </div>
            <div class="ui-column-header-c">
                <span class="column-llocation"><label for="date">Location:</label></span>
                <span class="column-location"><input readonly type="text" name="location" id="location" value=""/></span>

            </div>
            <div class="ui-column-header-c">
                <span class="column-lfeet"><label for="feet1">Feet:</label></span>
                <span class="column-feet"><input type="text" name="feet1" id="feet1" value=""/></span>
                <span class="column-midlabel"> <label for="inche1">Inches:</label></span>
                <span class="column-inch"> <input type="text" name="inche1" id="inche1" value=""/></span>
                <span class="column-midlabel"> <label for="qurtInch">1/4 In:</label></span>
                <span class="column-qurtInch"> <input type="text" name="qurtInch" id="qurtInch" value=""/></span>

                <span class="column-ltemp"> <label for="temp">Temp:</label></span>
                <span class="column-feet"> <input type="text" name="temp" id="temp" value=""/></span>
                <span class="column-offLoad"> <label for="meterRd">Off Load Meter Reading 1:</label></span>
                <span class="column-meterrd"> <input type="text" name="meterRd" id="meterRd" value=""/></span>

            </div>
            <div class="ui-column-header-c">
                <span class="column-lfeet"><label for="feet2">Feet:</label></span>
                <span class="column-feet"><input type="text" name="feet2" id="feet2" value=""/></span>
                <span class="column-midlabel"> <label for="inche2">Inches:</label></span>
                <span class="column-inch"> <input type="text" name="inche2" id="inche2" value=""/></span>
                <span class="column-midlabel"> <label for="qurtInch2">1/4 In:</label></span>
                <span class="column-qurtInch"> <input type="text" name="qurtInch2" id="qurtInch2" value=""/></span>

                <span class="column-ltemp"> <label for="temp2">Temp:</label></span>
                <span class="column-feet"> <input type="text" name="temp2" id="temp2" value=""/></span>
                <span class="column-offLoad"> <label for="offmeterRd2">Off Load Meter Reading 2:</label></span>
                 <span class="column-meterrd"> <input type="text" name="offmeterRd2" id="offmeterRd2" /></span>

            </div>
            <div class="ui-column-header-c">
                <span class="column-lfeet"><label for="barrel">Gross Barrels:</label></span>
                <span class="column-feet"><input type="text" name="barrel" id="barrel" value=""/></span>
                <span class="column-midlabel"> </span>
                <span class="column-inch"> </span>
                <span class="column-midlabel"> </span>
                <span class="column-qurtInch"></span>

                <span class="column-ltemp"></span>
                <span class="column-feet"></span>
                <span class="column-offLoad"> <label for="calMeter">Total:</label></span>
                <span class="column-meterrd"> <input type="text" name="calMeter" id="calMeter" /></span>
            </div>
            <div class="ui-column-header-c">
<!--                <span class="column-midlabel"><label for="barrel">Gross Barrels:</label></span>
                <span class="column-barrel"><input type="text" name="barrel" id="barrel" value=""/></span>-->
                <span class="column-longlabel"><label for="oGty">Observed Gty & Temp:</label></span>
                <span class="column-oQty"><input type="text" name="oGty" id="oGty" value=""/></span>
                <span class="column-midlabel"><label for="sAndW">S & W :</label></span>
                <span class="column-sAndW"> <input type="text" name="sAndW" id="sAndW" value=""/></span>
                <span class="column-longlabel"> <label for="oTruckBy">Oil Trucked by:</label></span>
                <span class="column-truckedby"> <input type="text" readonly name="oTruckBy" id="oTruckBy" value=""/></span>
            </div>
            <div class="ui-column-header-c">
                <span class="column-longlabel"><label for="toTruck">Oil Trucked to:</label></span>
                <span class="column-oQty"><input type="text" name="toTruck" id="toTruck" value=""/></span>
                <span class="column-midlabel"> <label for="truckNo">Truck No:</label></span>
                <span class="column-sAndW"> <input type="text" name="truckNo" id="truckNo" value=""/></span>
                <span class="column-midlabel"> <label for="trailerNo">Trailer No:</label></span>
                <span class="column-feet"> <input type="text" name="trailerNo" id="trailerNo" value=""/></span>

            </div>
            <div class="ui-column-header-c">
                <span class="column-midlabel"><label for="driver1">Turned On:</label></span>
                <span class="column-ldriver"><label for="driver1">Driver:</label></span>
                <span class="column-driver"><input readonly type="text" name="driver1" id="driver1" value=""/></span>
                <span class="column-ldate"> <label for="time1">Date(MM-dd-yyyy):</label></span>
                <span class="column-date"> <input type= "text" name="time1" id="time1" /></span>
                <span class="column-lseal"> <label for="offSeal1">On seal:</label></span>
                <span class="column-feet"> <input type="text" name="offSeal1" id="offSeal1" value=""/></span>

            </div>
            <div class="ui-column-header-c">
                <span class="column-midlabel"><label for="driver2">Shut Off:</label></span>
                <span class="column-ldriver"><label for="driver2">Driver:</label></span>
                <span class="column-driver"><input type="text" name="driver2" id="driver2" value=""/></span>
                <span class="column-ldate"> <label for="shutTime">Date(MM-dd-yyyy):</label></span>
                <span class="column-date"> <input type= "text" name="shutDate" id="shutDate" /></span>
                <span class="column-ltime"> <label for="shutTime">Time(HH:mm):</label></span>
                <span class="column-feet"> <input type= "text" name="shutTime" id="shutTime" /></span>
               
                <span class="column-lseal"> <label for="offSeal2">Off seal:</label></span>
                <span class="column-feet"> <input type="text" name="offSeal2" id="offSeal2" value=""/></span>
                <span class="column-feet"> <input type="hidden" name="id" id="id" value=""/></span>
                <span class="column-feet"> <input type="hidden" name="shipmentId" id="shipmentId" value=""/></span>
                <span class="column-feet"> <input type="hidden" name="tankId" id="tankId" value=""/></span>
                <span class="column-feet"> <input type="hidden" name="truckByDriverId" id="truckByDriverId" value=""/></span>
             </div>
            <div class="ui-column-header-c">
                <span class="column-midlabel"><label for="noUnitsType">No of Units:</label></span>
                <span class="column-noUnits"><input type="text" name="noUnitsType" id="noUnitsType" value=""/></span>
               
                <span class="column-midlabel"><label for="noUnitsType">HMX:</label></span>
                 <span class="column-hmx"><input type="text" name="hmx" id="hmx" value=""/></span>
                 <span class="column-midlabel"><label for="hazmatInfo">Hazard Class:</label></span>
                <span class="column-hazmatInfo"><input type="text" name="hazmatInfo" id="hazmatInfo" value=""/></span>
<!--                <span class="column-midlabel"><label for="grossBarrels">Gross Barrels:</label></span>
                <span class="column-grossBarrels"><input type="text" name="grossBarrels" id="grossBarrels" value=""/></span>-->
            </div>
            <div class="ui-column-header-c">
              <span class="column-midlabel"><label for="remarks">Remarks:</label></span>
                <span class="column-remarks"><input type="text" name="remarks" id="remarks" value=""/></span>
            </div>
            <div id="carDetaillist" class="match-list">
                <ul id="jobtbl" data-divider-theme="c" data-theme="c" data-inset="true" data-role="listview">

                </ul>
            </div>
        </div>
    </div>
</div>
<script src="scripts/crudeoil/runTicketDetail.js"></script>
<script type="text/javascript">
var id = <%=request.getParameter("id")%>;
//Fire onload function when DOM is full rendered.
$(document).ready(function () {
	runTicketDetail.onLoad();
});
</script>
</body>
</html>
