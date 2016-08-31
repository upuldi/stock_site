/**
 * runTiekct screen
 * @author semika
 *  
 */
var	runTicket = {
		
		selectedTenderId: null,
		dataList:[],
		rejectTender: null,
		
		/**
		 * Format data in 'yyyy-mm-dd' format.
		 */
		formatDate: function(dateStr) {
			return dateStr.substring(0, 10);
		},
		
		/**
		 * Return comment for a given tender id.
		 */
		getComment: function(id) {
			var comment = "";
			$.each(runTicket.dataList, function(i, line) { 
				if (line.id == id) {
					comment = line.comments;
					return false;
				}
			});
			return comment;
		},
		
		/**
		 * Save comment for tender detail.
		 */
		saveComment : function() {
			var comment = $("#comment").val();
			var chkAddException = $("#chkAddexception").attr("checked"); 
			$.ajax({
				  type: 'POST',
				  url: 'crudeOilTenderSupport!saveComment.action',
				  data: {id:runTicket.selectedTenderId,comments:comment},
				  success: function(data) {
					  runTicket.refreshData();
				  }, 
				  
				  error: function() {
					  alert("Comment save failed"); //TODO Need to modify  
				  },
				  
				  dataType: 'json'
			});
			
		},
		
		/**
		 * This method will be invoked when 'Save' button clicked on comment dialog box,
		 */
		saveDialogComment: function() {
			
			if (runTicket.rejectTender) { //rejecting render record.
				runTicket.reject(runTicket.selectedTenderId);
			} else { //comment add or update
				runTicket.saveComment();
			}
			
			//reset flag variable.
			runTicket.rejectTender = null;
			
			//close the dialog.
			runTicket.hideDialog();
		},
		
		
		openCommentDialog: function(id, rejectTender) {
			runTicket.selectedTenderId = id;
			var comment = runTicket.getComment(id);
			$('#comment').attr("value", comment);
			
			//Flag to indentify the dialog box open for rejecting tender or adding a comment.
			runTicket.rejectTender = rejectTender;
			
			$.mobile.changePage( "#commentDialog", { transition: "slideup"} );
		},
		
		/**
		 * Hide dialog
		 */
		hideDialog: function() {
			$.mobile.changePage('#homePage', 'pop', false, true);
			$('#chkAddexception').removeAttr('checked');
			$('#comment').attr("value", "");
			runTicket.rejectTender = null;
		},
		
		/**
		 * Refresh the page.
		 */
		refreshRunTicket : function(){       
            $(location).attr('href','runTicket.html');
        },
		
        /**
         * Logout
         */
        logOut : function(){
            $.getJSON("user/LoginSupport!logoff.action",{},
	            function(data1) {             
	                delCookie("loginCookie");
	                $(location).attr('href','login.html');
	            }
            );
        },
		
		/**
		 * TODO Need to remove timeout and use callback
		 * @param event
		 * @param id
		 * @returns          ss
		 */
		reject : function(id) {
			
			var comment = $("#comment").val();
			var chkAddException = $("#chkAddexception").attr("checked"); 
			$.ajax({
				  type: 'POST',
				  url: 'crudeOilTenderSupport!saveAcceptRejectTender.action',
				  data: {id:id,comments:comment,status:"R"}, 
				  success: function(data) {
					  $("#" + id).css("background-color","#C11B17");
	                  $("#" + id).css("color","white");
	                  runTicket.refreshData(); 
				  }, 
				  
				  error: function() {
					  alert("Reject failed");  
				  },
				  
				  dataType: 'json'
			});
			
           /* var url = "crudeOilTenderSupport!saveAcceptRejectTender.action?id="+ id + "&status=" + "R";                    
            $.post( url, 
                function() { 
                    $("#" + id).css("background-color","#C11B17");
                    $("#" + id).css("color","white");
                    runTicket.refreshData();  
                }
            );      */  
        },
        
        /**
         * Need to remove timeout and use callback.
         */
		accept : function(event, id) {
            var acceptRow =  id ;   
            var url = "crudeOilTenderSupport!saveAcceptRejectTender.action?id="+ acceptRow + "&status=" + "A"  ;
            $.post( url, 
                function() { 
                     $("#" + id).css("background-color","#7A5DC7");
                     $("#" + id).css("color","white");
                     runTicket.refreshData();       
                }
            );  
        },
		
		/**
		 * Select ticket
		 */
		selectTicket : function(event, id) {
			//alert(id);
            var tickerRow = "#" + id ;
//          $(tickerRow).css("background","#7A5DC7");runTicketDetail.jsp
//          $(tickerRow).css("color","white");
            //$.mobile.changePage( "detailRunTicket.html", { transition: "slideup"} );
            //$.mobile.changePage( "detailRunTicket.html?id=" + id, { transition: "flip"} );
            
            $.mobile.changePage("runTicketDetail.jsp", {
            	type: "post",
            	data: {id:id},
            	transition: "flip"
            });
            
            //$.mobile.changePage( "detailRunTicket.html", { transition: "pop"} );
            //$(location).attr('href','detailRunTicket.html?id=' + id);  
		},
		
		getStatusCaption: function(status) {
			switch(status) {
				case 'P':
					return "PENDING";
					break;
				case 'A':
					return "ACCEPTED";
					break;
				case 'R':
					return "REJECTED";
					break;
				default :
					return "";
				
			}
		},
		
		/**
		 * Refresh grid data.
		 */
		refreshData : function () { 
            $("#jobtbl").empty(); 
            $.ajax({  
                url: '\\iethanol\\mobile\\crudeOilTenderSupport!fetchCrudeOilListForUser.action',
                cache: false,
                beforeSend: function() { $.mobile.showPageLoadingMsg(); }, //Show spinner
                complete: function() { $.mobile.hidePageLoadingMsg() }, //Hide spinner
                success:  function(data) {   
                	runTicket.dataList = data.list;
                    $.each( data.list, function(i, line) {   
                    	
                    	var status = runTicket.getStatusCaption(line.status);
                    	var comment = line.comments?line.comments:"";
                    	var date = runTicket.formatDate(line.date);
                                 
                        if (line.status=='P') {
                        	var sb = [];
                        	sb[sb.length] = "<li style=\"vertical-align: center;font-size: 14px;\" class=\"ui-column-header-c\" id= " + line.id + ">";
                        	sb[sb.length] = "<span  class=\"column-Maccept\">";
                        	sb[sb.length] = "<img style=\"vertical-align: center;align: center;\" src=\"images/accept.png\" onclick=\"runTicket.accept(event, " + line.id + ");\" >";
                        	sb[sb.length] = "</span>";
                        	sb[sb.length] = "<span  class=\"column-Mreject\">";
                        	sb[sb.length] = "<img style=\"vertical-align: center;align: center;\" src=\"images/reject.png\" onclick=\"runTicket.openCommentDialog(" + line.id + ", 'REJECT');\"  >";
                        	sb[sb.length] = "</span>";
                        	sb[sb.length] = "<span style=\"border-bottom: 4px double; color: #000000;font-weight: bold;\" onclick=\"runTicket.selectTicket(event, " + line.ticketNo + ");\" class=\"column-Mticket\">" + line.ticketNo +"</span>";
                        	sb[sb.length] = "<span  class=\"column-Mdate\">" + date +"</span>";
                        	sb[sb.length] = "<span class=\"column-MopName\">" + line.operatorName + "</span>";
                        	sb[sb.length] = "<span class=\"column-MleaseName\">" + line.leaseName + "</span>";
                        	sb[sb.length] = "<span class=\"column-Mstatus\">" + status + "</span>";
                        	sb[sb.length] = "<span class=\"column-Mcomment\"><img onclick=\"runTicket.openCommentDialog(" + line.id + ");\" title=\""+ comment +"\" style=\"vertical-align: center;align: right;\" src=\"images/comment.png\"></span>";
                        	sb[sb.length] = "</li>";
                        	
                            $('#jobtbl').append(sb.join(""));
                            
                        } else if (line.status=='A') { 
                        	 var sb = [];
                        	 sb[sb.length] = "<li style=\"vertical-align: center;font-size: 14px;\" class=\"ui-column-header-c\" id= " + line.id + ">";
                        	 sb[sb.length] = "<span class=\"column-Maccept\">";
                        	 sb[sb.length] = "<img style=\"vertical-align: center;align: center;\" src=\"images/accept.png\">";
                        	 sb[sb.length] = "</span>";
                        	 sb[sb.length] = "<span class=\"column-Mreject\" ></span>";
                        	 sb[sb.length] = "<span style=\"border-bottom: 4px double; color: #000000;font-weight: bold;\" onclick=\"runTicket.selectTicket(event, " + line.ticketNo + ");\" class=\"column-Mticket\">" + line.ticketNo +"</span>";
                        	 sb[sb.length] = "<span  class=\"column-Mdate\">" + date +"</span>";
                        	 sb[sb.length] = "<span class=\"column-MopName\">" + line.operatorName + "</span>";
                        	 sb[sb.length] = "<span class=\"column-MleaseName\">" + line.leaseName + "</span>";
                        	 sb[sb.length] = "<span class=\"column-Mstatus\">" + status + "</span>";
                        	 sb[sb.length] = "<span class=\"column-Mcomment\"><img onclick=\"runTicket.openCommentDialog(" + line.id + ");\" title=\"" + comment + "\" style=\"vertical-align: center;align: right;\" src=\"images/comment.png\"></span>";
                        	 sb[sb.length] = "</li>";
                        	 
                             $('#jobtbl').append(sb.join(""));  
                             
                        } else if (line.status=='R') { 
                        	var sb = [];
                        	sb[sb.length] = "<li style=\"vertical-align: center;font-size: 14px;\" class=\"ui-column-header-c\" id= " + line.id + ">";
                        	sb[sb.length] = "<span class=\"column-Maccept\"></span>";
                        	sb[sb.length] = "<span class=\"column-Mreject\" >";
                        	sb[sb.length] = "<img style=\"vertical-align: center;align: center;\" src=\"images/reject.png\">";
                        	sb[sb.length] = "</span>";
                        	sb[sb.length] = "<span style=\"border-bottom: 4px double; color: #000000; font-weight: bold;\" onclick=\"runTicket.selectTicket(event, " + line.ticketNo + ");\" class=\"column-Mticket\">" + line.ticketNo +"</span>";
                        	sb[sb.length] = "<span  class=\"column-Mdate\">" + date +"</span>";
                        	sb[sb.length] = "<span class=\"column-MopName\">" + line.operatorName + "</span>";
                        	sb[sb.length] = "<span class=\"column-MleaseName\">" + line.leaseName + "</span>";
                        	sb[sb.length] = "<span class=\"column-Mstatus\">" + status + "</span>";
                        	sb[sb.length] = "<span class=\"column-Mcomment\"><img onclick=\"runTicket.openCommentDialog(" + line.id + ");\" title=\"" + comment + "\" style=\"vertical-align: center;align: right;\" src=\"images/comment.png\"></span>";	
                        	sb[sb.length] = "</li>";
                        	$('#jobtbl').append(sb.join("")); 
                        }                     
                    });               
                }  
            });
        },
        
        /**
         * Initialize UI components.
         */
        _initComponents: function() {
        	//Initialize comment dialog box.
        	//$("#commentDialog").dialog();
        	
        	//var obj = {"id":100};
        	//$(document).delegate('#dialoglink', 'click' ,function(evt) {
    	    /*$("#dialoglink").simpledialog({
    	        'mode' : 'blank',
    	        'prompt': false,
    	        'forceInput': false,
    	        'useModal':true,
    	        'fullHTML' : $("#dialog").html()
    	    });*/
        	//});
        },
        
		/**
		 * Fire with window onload.
		 */
		onLoad: function() {
			runTicket._initComponents();
            runTicket.refreshData();  
		}	
	}