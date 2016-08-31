<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">

<head>

    <meta http-equiv="Content-Type" content="text/html;"/>
    <title><tiles:insertAttribute name="title" ignore="true"/></title>
    <link rel="stylesheet" href="pages/styles.css" type="text/css"/>
    <link rel="stylesheet" href="pages/jquery/jquery-ui.css" type="text/css"/>

    <script type="text/javascript" src="http://code.jquery.com/jquery-2.0.2.min.js"></script>
    <script type="text/javascript" src="pages/js/marquee.js"></script>
    <!-- Header Scripts -->
    <tiles:insertAttribute name="head-scripts"/>
</head>


<body class="<tiles:insertAttribute name="bodyclass" ignore="true"/>">

<div id="container">
    <!-- Header -->
    <tiles:insertAttribute name="header"/>
    <!-- Navigation -->
    <tiles:insertAttribute name="navi"/>
    <!-- Sub-Header -->
    <tiles:insertAttribute name="sub-header"/>
    <!-- Slide Container -->
    <tiles:insertAttribute name="slidecontainer"/>
</div>

<marquee behavior="scroll" scrollamount="9" direction="left" width="100%">
    <s:property value="fancyTicker" escape="false" />
</marquee>

<div id="body">

    <!-- body content -->
    <tiles:insertAttribute name="body-content"/>
    <!-- side bar -->
    <tiles:insertAttribute name="sidebar"/>
    <div class="clear"></div>

</div>

<!-- footer -->
<tiles:insertAttribute name="footer"/>
</body>

</html>



