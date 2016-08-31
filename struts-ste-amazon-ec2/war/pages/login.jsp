<%
    String userAgent = request.getHeader("user-agent").toLowerCase();

    if (((userAgent.contains("android")) && (userAgent.contains("mobile"))) ||
            ((userAgent.contains("android")) && !(userAgent.contains("mobile"))) ||
            ((userAgent.contains("blackberry"))) ||
            ((userAgent.contains("iphone"))) ||
            ((userAgent.contains("ipod"))) ||
            ((userAgent.contains("ipad")))) {

        if(request.getParameter("error") != null){
            response.sendRedirect(request.getContextPath() + "/pages/mobile/mobile-error-auth.jsp");
        }else{
            response.sendRedirect(request.getContextPath() + "/pages/mobile/mobile-login-indi.jsp");
       }


    }
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="-1" />
    <link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/images/favicon.ico"/>
    <link rel="icon" type="image/gif" href="<%=request.getContextPath()%>/images/animated-favicon.gif"/>
    <link href="<%=request.getContextPath()%>/pages/resources/websitestyle.css" rel="stylesheet" type="text/css" />
    <title>ShipXpress - Home</title>
    <SCRIPT>//'"]]>>isc_loginRequired
    //
    // Embed this whole script block VERBATIM into your login page to enable
    // SmartClient RPC relogin.


    if (!window.isc && (window.opener != null || window.top != window)) {
        while (document.domain.indexOf(".") != -1) {
            try {
                if (window.opener && window.opener.isc) break;
                if (window.top.isc) break;
            } catch (e) {
                try {
                    document.domain = document.domain.replace(/.*?\./, '');
                } catch (ee) {
                    break;
                }
            }
        }
    }

    var isc = top.isc ? top.isc : window.opener ? window.opener.isc : null;
    if (isc) isc.RPCManager.delayCall("handleLoginRequired", [window]);
    </SCRIPT>
    <script type="text/javascript">


        function loginButtonClick()
        {
            if ( document.loginForm.j_username.value == "" ||
                    document.loginForm.j_password.value == "" )
            {
                if ( document.loginForm.j_username.value == "" )
                {
                    alert("User ID is required");
                    document.loginForm.j_username.focus();
                }
                else
                {
                    alert("Password is required");
                    document.loginForm.j_password.focus();
                }

                return (false);
            }
        }

        <!--
        function mmLoadMenus() {
            if (window.mm_menu_0830165532_0) return;
            window.mm_menu_0830165532_0 = new Menu("root",90,18,"Tahoma",12,"#FFFFFF","#000000","#9F9F9F","#CCCCCC","left","middle",3,0,100,-5,7,true,true,true,0,false,true);
            mm_menu_0830165532_0.addMenuItem("History","location='/history.html'");
            mm_menu_0830165532_0.addMenuItem("Careers","location='/careers.html'");
            mm_menu_0830165532_0.fontWeight="bold";
            mm_menu_0830165532_0.hideOnMouseOut=true;
            mm_menu_0830165532_0.bgColor='#666666';
            mm_menu_0830165532_0.menuBorder=1;
            mm_menu_0830165532_0.menuLiteBgColor='#FFFFFF';
            mm_menu_0830165532_0.menuBorderBgColor='#666666';

            window.mm_menu_0830170814_0 = new Menu("root",130,18,"Tahoma",12,"#FFFFFF","#000000","#9F9F9F","#CCCCCC","left","middle",3,0,100,-5,7,true,true,true,0,true,false);
            mm_menu_0830170814_0.addMenuItem("ShipX","location='/solutionShippers.html'");
            mm_menu_0830170814_0.addMenuItem("RailSync&nbsp;","location='/railsync.html'");
            mm_menu_0830170814_0.addMenuItem("Custom&nbsp;Solutions","location='/custom_solutions.html'");
            mm_menu_0830170814_0.fontWeight="bold";
            mm_menu_0830170814_0.hideOnMouseOut=true;
            mm_menu_0830170814_0.bgColor='#666666';
            mm_menu_0830170814_0.menuBorder=1;
            mm_menu_0830170814_0.menuLiteBgColor='#FFFFFF';
            mm_menu_0830170814_0.menuBorderBgColor='#666666';
            window.mm_menu_0830171211_0 = new Menu("root",100,18,"Tahoma",12,"#FFFFFF","#000000","#9F9F9F","#CCCCCC","left","middle",3,0,100,-5,7,true,true,true,0,false,true);
            mm_menu_0830171211_0.addMenuItem("Press Releases","location='/press_releases.html'");
            mm_menu_0830171211_0.addMenuItem("Newsletter","location='/news_letter.html'");
            mm_menu_0830171211_0.fontWeight="bold";
            mm_menu_0830171211_0.hideOnMouseOut=true;
            mm_menu_0830171211_0.bgColor='#666666';
            mm_menu_0830171211_0.menuBorder=1;
            mm_menu_0830171211_0.menuLiteBgColor='#FFFFFF';
            mm_menu_0830171211_0.menuBorderBgColor='#666666';

            mm_menu_0830171211_0.writeMenus();
        } // mmLoadMenus()
        //-->

    </script>
    <script language="JavaScript" src="resources/mm_menu.js"></script>
    <script src="resources/AC_RunActiveContent.js" type="text/javascript"></script>

</head>

<body onLoad="document.forms[0].j_username.focus()">
<script language="JavaScript1.2">mmLoadMenus();</script>

<div class="main">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="117">
                            <img src="<%=request.getContextPath()%>/images/shipx_logo.gif" alt="ShipXpress Logo" width="117" height="67"/>
                        </td>
                        <td>
                            <form name="loginForm" action="j_security_check" method="post">
                                <table align="right">
                                    <!-- Check if this is an error or not ...  -->
                                    <% if (request.getParameter("error") != null) { %>
                                    <tr class="navigation_text">
                                        <td colspan='3'> <font color="red">Invalid User ID or Password..</font> </td>
                                    </tr>
                                    <% } %>
                                    <tr class="navigation_text">
                                        <td align="right" >
                                            <strong>User ID</strong>
                                        </td>
                                        <td>
                                            <input type="text" tabindex="1" name="j_username" maxlength="20" size="13" value>
                                        </td>
                                        <td>
                                            &nbsp;<input type="submit" tabindex="3" value="Login" name="optype" onclick="return loginButtonClick()">
                                        </td>
                                    </tr>
                                    <tr class="navigation_text">
                                        <td align="left" >
                                            <strong>Password</strong>
                                        </td>
                                        <td>
                                            <input type="password" tabindex="2" name="j_password" maxlength="40" size="13" value>
                                        </td>
                                        <td>
                                            <input type="reset" value="Reset" name="optype">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="4" align="center">
                                            <a href="/changepassword/setupChangePassword.do"><font size="-1">Forgot Password?</font></a>
                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="313" class="bg_style1">&nbsp;</td>
                        <td>
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr class="navigation_text">
                                    <td width="40">&nbsp;</td>
                                    <td width="60" align="center">Home</td>
                                    <td width="2" align="center">
                                        <img src="<%=request.getContextPath()%>/images/nav_sep.gif" width="2" height="10"/>
                                    </td>
                                    <td width="100" align="center"><a href="#" name="link2" id="link1" onmouseover="MM_showMenu(window.mm_menu_0830165532_0,-2,13,null,'link2')" onmouseout="MM_startTimeout();">Our Company</a></td>
                                    <td width="2" align="center"><img src="<%=request.getContextPath()%>/images/nav_sep.gif" width="2" height="10" /></td>
                                    <td width="105" align="center"><a href="#" name="link6" id="link3" onmouseover="MM_showMenu(window.mm_menu_0830170814_0,0,14,null,'link6')" onmouseout="MM_startTimeout();">Our Solutions</a></td>
                                    <td width="2" align="center"><img src="<%=request.getContextPath()%>/images/nav_sep.gif" width="2" height="10" /></td>
                                    <td align="center"><a href="#" name="link4" id="link4" onmouseover="MM_showMenu(window.mm_menu_0830171211_0,0,14,null,'link4')" onmouseout="MM_startTimeout();">News</a></td>
                                    <td width="2" align="center"><img src="<%=request.getContextPath()%>/images/nav_sep.gif" width="2" height="10" /></td>
                                    <td width="90" align="center"><a href="/contact_us.html">Contact Us</a></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td>
                <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="766" height="193">
                    <param name="wmode" value="transparent">
                    <param name="movie" value="<%=request.getContextPath()%>/images/home_banner.swf" />
                    <param name="quality" value="high" />
                    <embed src="<%=request.getContextPath()%>/images/home_banner.swf" wmode="transparent" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="766" height="193"></embed>
                </object>
            </td>
        </tr>
        <tr>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="375" class="body_text">ShipXpress is a premier provider of web-based software and service solutions that make it easy for <a href="/railsync.html" class="link1">railroads</a>, <a href="/solutionShippers.html" class="link1">rail shippers</a> and <a href="/solutionShippers.html" class="link1">railcar owners</a> to operate their businesses effectively and efficiently.<br />
                            <br/>
                            More than 90 industrial customers - including Fortune 50 chemical companies, leading building products manufacturers and railroads - depend on ShipXpress to deliver collaborative rail logistics solutions.</td>
                        <td>&nbsp;</td>
                        <td width="375" align="left" valign="top" class="body_text">ShipXpress is staffed by rail industry professionals and backed by the latest in technology.<br />
                            <br/>
                            All ShipXpress applications are hosted in a secure data center and maintained by our experienced staff. There is never any software to buy, hardware to maintain or upgrades to install. And with help always just a call or click away at our 24/7 customer service center, what could be easier?</td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td>&nbsp;</td>
        </tr>
        <tr align="center">
            <td><img src="<%=request.getContextPath()%>/images/image_1.gif" width="273" height="55" /></td>
        </tr>
        <tr align="center">
            <td class="text_style1">2315 Beach Blvd, Suite 104, Jacksonville Beach, FL 32250 (904) 241-5850</td>
        </tr>
        <tr align="center">
            <td class="text_style1"><a href="mailto:info@shipxpress.com">Info@ShipXpress.com</a></td>
        </tr>
        <tr align="center">
            <td class="text_style1">&nbsp;</td>
        </tr>
    </table>
</div>

</body>
</html>
