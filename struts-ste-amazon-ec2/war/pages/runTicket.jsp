<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv='Content-Type'  content='text/html; charset=iso-8859-1'/>
        <meta name='viewport' content='width=device-width, initial-scale=1'/>
        <meta name='format-detection' content='telephone=no'/>
		
        <link rel='stylesheet' type='text/css' href='common/soa-mobile.css'/>
        <link rel="stylesheet" href="scripts/jquery.mobile-1.0.min.css" />
        
        <script src="scripts/jquery-1.6.4.min.js"></script>
        <script src="scripts/jquery.mobile-1.0.min.js"></script>
        
        <script src="scripts/mcScripts.js"></script>
    </head>
    <body>
		<!-- Start off first page -->
        <div data-role="page" id="homePage">
            <div data-role="header" data-position="inline">	
                <h1><span class="ui-btn-left"><img id="spinner" src="images/hess.png" />Crude Oil Mobile Portal</span>
                <span></span> 
                <span id="username"  class="ui-username-right" ></span>
                <span class="column-space">&nbsp; </span>
                <span id="userRoad"  class="ui-userRoad-right" ></span></h1>
                <span class="ui-shiplogo-right"><img id="spinner" src="images/shipx.png" /></span>
                <a onclick="logOut();"  class="ui-btn-right">Logout</a>
            </div>
            <div data-role="content">      
                <div data-inline="true" class="tab-nav-c" style="vertical-align: center;font-size: 12px;">
                    <a data-inline="true" id="workOrdtab"  onclick="unloadInvTab();" data-role="button" class="btnPos0" href="">Run Ticket</a> 
                </div>
                <div id="msg"></div>        
                <div id="navigation"></div>
                <div id ="ticketDiv">
                    <div id="webPortalHeadings" class="ui-column-header-c" style="vertical-align: center;font-size: 14px;">
                        <span class="column-Maccept">Accept</span>
                        <span class="column-Mreject">Reject</span>
                        <span class="column-Mticket">Ticket</span>
                        <span class="column-Mdate">Date</span>
                        <span class="column-MopName">Operator</span>
                        <span class="column-MleaseName">Lease Name</span>
                        <span class="column-Mstatus">Status</span>
                        <span class="column-Mcomment">Comments</span>
                    </div>
                    <div id="woDetaillist" class="match-list">
                        <ul  id="jobtbl" data-divider-theme="c" data-theme="c" data-inset="true" data-role="listview">

                        </ul>
                    </div> 
                </div>
            </div>
        </div>
		
		<!-- Start off dialog page -->    
		<div data-role="dialog" id="commentDialog">
		    <div data-role="header" data-theme="e">
				<h1>Add Comment</h1>
		    </div>
		    <div data-role="content" data-theme="d">	
		        <div style="padding-top:2% ; padding-left:  4%" id="msgid"></div>
		        <div data-role="fieldcontain">
					<label for="comment">Comments :</label>
					<textarea cols="50" rows="10" name="comment" id="comment" maxlength="200"></textarea>
				</div>
			    <div data-role="fieldcontain">
					<input value="" type="checkbox" name="chkAddexception" id="chkAddexception" class="custom" onclick=""/>
					<label for="chkAddexception" style="padding-left:40px;">Add to Exceptions</label>
			    </div>
			    
			    <div style="padding-left: 25%;width: 70%;padding-top: 3%">
					<a onclick="runTicket.saveDialogComment();" style="width: 35%" data-role="button" data-inline="true">Save</a>
					<a onclick="runTicket.hideDialog();" style="width: 35%" data-role="button" data-inline="true">Cancel</a>
			    </div>
		    </div>
		</div>
    </body>
<script src="scripts/crudeoil/runTicket.js"></script>
<script type="text/javascript">
//Fire onload function when DOM is full rendered.
$(document).ready(function () {
	runTicket.onLoad();
});
</script>
</html>