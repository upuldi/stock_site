<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title></title>
</head>
<body>
<div id="content">

    <div class="box">
        <p></p>

        <p></p><p></p>
        <s:if test="cseCompanyList.size > 0 ">
            <h3>Search results</h3><p></p>
            <table  style="width: 600px; "><tbody>
            <tr>
                <th  class=""><b>Company Name</b></th>
                <th class=""><b>Company Code</b></th>
            </tr>
            <s:iterator value="cseCompanyList" status="songStatus">
                <tr>
                    <td class=""><a style="text-decoration: none;" href="getCompanyDataCompanyInfo.action?companyId=<s:property value="id" />"><s:property value="companyName" /></a></td>
                    <td class=""><a style="text-decoration: none;" href="getCompanyDataCompanyInfo.action?companyId=<s:property value="id" />"><s:property value="stockCode" /></a></td>
                </tr>
            </s:iterator></tbody>
            </table>
            <p></p>
            <p>Please click on a following record to proceed.</p>
        </s:if><s:else> <p>Sorry.No record found.</p> </s:else>
        <p></p><br /><h1> </h1>

    </div></div>
</body>
</html>