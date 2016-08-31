<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<body>
<div id="content">
    <div class="box">
        <p> Please enter the stock code or company code in below text box.</p>
        <s:form action="submitDataStockSplitAction.action">
            <tr>
                <td><b>Company/Stock/Symbol</b></td>
                <td><input style="	background:#FFFFFF url(pages/images/search.png) no-repeat 4px 4px;
	padding:4px 4px 4px 22px;
	border:1px solid #CCCCCC;
	width:400px;
	height:18px;
" id="autoText" name="stockCode" maxlength="20"/></td>
            </tr>
            <s:submit cssClass="formbutton"/>
        </s:form>
        <p></p>
    </div>
</div>
</body>