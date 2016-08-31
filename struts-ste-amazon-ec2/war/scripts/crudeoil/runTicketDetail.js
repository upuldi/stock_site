/**
 * runTiekctDetail screen
 */
var	runTicketDetail = {
		
		logOut: function() {
			$.getJSON("user/LoginSupport!logoff.action", {},
	                function (data1) {
	                    delCookie("loginCookie");
	                    $(location).attr('href', 'login.html');
	                }
	        );
		},
		
		/**
		 * Load run ticket data from the server and populate the
		 * form.
		 */
        loadRunDetails : function() {
            
        	var paraval = runTicketDetail._getParameterByName('id');
            var url="";
            $.ajax({
                url:'runTicketSupport!fetchRunTicketByNumber.action?runTicketId=' + id,
                cache:false,
                success:function (data) {
                    $.each(data.list, function (i, line) {
                        //   alert('gauge feet'+ line.runTicketId +'-'+line.leaseName+line.truckByDriverId+'-'+line.ticketNo+'-'+line.trailerNo);
                        //alert(line.offLoadMeterReading2);
                        
                        $("#date").val(line.planedShiDate);
                        $('#truckByDriverId').val(line.truckByDriverId);
                        $('#tickNo').val(line.runTicketId);
                        $('#truckNo').val(line.truckNo);
                        $('#trailerNo').val(line.trailerNo);
                        $('#leaseNo').val(line.leaseNo);
                        $('#lName').val(line.leaseName);
                        $('#operator').val(line.operatorName);
                        $('#id').val(line.id);
                        $('#shipmentId').val(line.shipmentId);
                        $("#temp").val(line.gauge1Temp);
                        $("#temp2").val(line.gauge2Temp);
                        $("#feet1").val(line.gauge1Feet);
                        $("#feet2").val(line.gauge2Feet);
                        $("#inche1").val(line.gauge1Inch);
                        $("#inche2").val(line.gauge2Inch);
                        $("#qurtInch").val(line.gauge1Inch);
                        $("#qurtInch2").val(line.gauge2Inch);                    
                        $("#meterRd").val(line.offLoadMeterReading);
                        $("#sAndW").val(line.bsW);
                        $("#barrel").val(line.grossBarrels);
                        $("#oGty").val(line.obseverdGty);                    
                        $("#oTruckBy").val(line.truckByDriver);
                        $("#toTruck").val(line.oilTruckTo);                     
                        $("#time1").val(line.inputDate);                    
                        $("#shutTime").val(line.shutTime);
                        $("#shutDate").val(line.inputDate2);
                        $("#driver1").val(line.truckByDriver);
                        $("#offSeal1").val(line.onSeal);
                        $("#offSeal2").val(line.offSeal);
                        $("#driver2").val(line.shutOffDriverId);
                        $("#hazmatInfo").val(line.hazmatInfo);
                        $("#hmx").val(line.hmx);
                        $("#remarks").val(line.remarks);
                        $("#noUnitsType").val(line.noUnitsType);
                        $("#location").val(line.wellLocation);                    
                        $("#offmeterRd2").val(line.offLoadMeterReading2);
                        $("#tankNo").val(line.tankId);
                        var event = jQuery.Event("change");
                        $("#tankNo").trigger(event);
                    });
                }
            });
                  
        },
		
        _getParameterByName : function (name) {
		  
        	name = name.replace(/[\[]/, "\\\[").replace(/[\]]/, "\\\]");
        	var regexS = "[\\?&]" + name + "=([^&#]*)";
        	var regex = new RegExp(regexS);
        	var results = regex.exec(window.location.search);
		
        	if (results == null) {
        		return "";        		
        	} else {
        		return results[1];
        	}
		},
        
        callSave : function() {

            var runticketInstanceId = $('#id').val() ; // Set the runticket instance id here
            var shipmentId = $('#shipmentId').val(); // Set the shipment Id here
            var tankId =  $('#tankNo').val().toString(); // Set Tank Id here
            var truckByDriverId = $('#truckByDriverId').val().toString() // set truckByDriverId read only
            
            var gauge1Temp = $("#temp").val();
            var gauge2Feet = $("#feet2").val();
            var gauge2Inch = $("#inche2").val();
            var gauge2QuarterIn = $("#qurtInch2").val() ;
            var gauge1QuarterIn = $("#qurtInch").val() ;
            var gauge2Temp = $("#temp2").val();
            var grossBarrels = $("#barrel").val(); 
            var obseverdGty = $("#oGty").val();
            var obseverdTemp = 0;
            var bsW = $("#sAndW").val().toString();
           // var truckByDriver = $("#oTruckBy").val().toString();
            var truckNo = $("#truckNo").val().toString();
            var trailerNo = $("#trailerNo").val().toString();
            var turnedOnWitnessSign = 0;
            //var turnedOnDateTime = $("#time1").val().toString();
            var inputDate = $("#time1").val().toString();
            var offSeal = $("#offSeal2").val().toString();        
            var shutOffDriverId = $("#driver2").val().toString();
            var shutOffWitnessSign = 0;
            var inputDate2  = $("#shutDate").val().toString();
            var shutTime  = $("#shutTime").val().toString();
            var onSeal =  $("#offSeal1").val().toString();
            var noUnitsType = $("#noUnitsType").val().toString();
            var remarks = $("#remarks").val().toString();
            var offLoadMeterReading = $("#meterRd").val().toString();
            var hmx = $("#hmx").val().toString();
            var hazmatInfo = $("#hazmatInfo").val().toString();
            var wellLocation= $("#location").val().toString();
            var offLoadMeterReading2 = $("#offmeterRd2").val().toString();
            var oilTruckTo = $("#toTruck").val().toString();
            //alert($("#offSeal1").val().toString());
            var url = "runTicketSupport!saveRunticket.action?id=" + runticketInstanceId + "&shipmentId=" + shipmentId +
                    "&runTicketId=" + $("#tickNo").val() + "&tankId=" + tankId + "&gauge1Feet=" + $("#feet1").val() +
                    "&gauge1Inch=" + $("#inche1").val() + "&gauge1QuarterIn=" + gauge1QuarterIn + "&gauge1Temp=" + gauge1Temp +
                    "&gauge2Feet=" + gauge2Feet + "&gauge2Inch=" + gauge2Inch + "&gauge2QuarterIn=" + gauge2QuarterIn + "&gauge2Temp=" + gauge2Temp +
                    "&grossBarrels=" + grossBarrels + "&obseverdGty=" + obseverdGty + "&obseverdTemp=" + obseverdTemp + "&bsW=" + bsW +
                     "&truckByDriverId=" + truckByDriverId + "&truckNo=" + truckNo + "&trailerNo=" + trailerNo + "&turnedOnWitnessSign" + turnedOnWitnessSign +
                     "&offSeal=" + offSeal + "&shutOffDriverId=" + shutOffDriverId + "&shutOffWitnessSign=" + shutOffWitnessSign  +
                    "&onSeal=" + onSeal + "&noUnitsType=" + noUnitsType + "&hmx=" + hmx + "&hazmatInfo=" + hazmatInfo +
                    "&wellLocation=" + wellLocation + "&remarks=" + remarks + "&offLoadMeterReading=" + offLoadMeterReading + "&inputDate=" + inputDate + "&shutTime=" + shutTime + "&inputDate2=" + inputDate2 +
                    "&offLoadMeterReading2=" + offLoadMeterReading2 + "&oilTruckTo=" + oilTruckTo;
           
            $.post(url,
                    function () {
                         $(location).attr('href', 'runTicket.jsp');
                    }
            );
        },
		
        _rendertnks : function(row) {        
            var combo = document.getElementById("tankNo");
            var option = document.createElement("option");
            option.text = row.key;
            option.value = row.value;                
            try {
                combo.add(option, null);
            }catch(error) {
                combo.add(option); // IE only
            }
            return false;
        },
        
        /**
         * Populate tanks 
         */
        populateTanks : function() {
            $.post( "commonLookupSupport!lookupDynamicValues.action", { lookupType: 'findLookups_tank_volume'} ,
                function( data ) { 
                    document.getElementById("tankNo").options.length = 1;
                    $.each( data.list, function(i, line){                        
                    	runTicketDetail._rendertnks(line);
                    });           
                    runTicketDetail.loadRunDetails();
                }
            );            
        },
		
        /**
         *Initialize events of page elements.
         */
		_initEvents: function() {
			$('#tankNo').change(function() {
	            var tsize ;
	            tsize = $('#tankNo option:selected').val();
	            $('#tankSize').val(tsize);
	        });
	        $('#offmeterRd2').change(function() {
	            var read2 = $('#offmeterRd2').val();
	            var read1 = $('#meterRd').val();
	            var tread = read2- read1 ;
	            $('#calMeter').val(tread); 
	        });
		},
		
		/**
		 * Fire with window onload.
		 */
		onLoad: function() {
			runTicketDetail._initEvents();
			runTicketDetail.populateTanks();	
		}
	}