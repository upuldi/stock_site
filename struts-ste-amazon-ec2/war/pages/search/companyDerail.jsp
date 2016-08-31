<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title><s:property value="listedCompany.companyName"/></title>
</head>
<body>
<div id="content">

    <div class="box">
        <p></p>

        <h2><s:property value="listedCompany.companyName"/></h2>

        <p></p>

        <p><s:property value="listedCompany.description"/></P>

        <p></p>
        <fieldset>

            <legend>General Data</legend>
            <br />
            <table style="width: 600px; ">
                <tbody>
                <tr>
                    <th class=""><b>Sector</b></th>
                    <th class=""><b>Board</b></th>
                    <th class=""><b>Company Code</b></th>
                </tr>
                <tr>
                    <td><s:property value="listedCompany.sector"/></td>
                    <td><s:property value="listedCompany.board"/></td>
                    <td><s:property value="listedCompany.stockCode"/></td>
                </tr>
                </tbody>
            </table>
        </fieldset>
        <fieldset>
            <legend>Contract Data</legend>
            <br />
            <table style="width: 600px; ">
                <tbody>
                <tr>
                    <th class=""><b>Telephone</b></th>
                    <th class=""><b>Fax</b></th>
                    <th class=""><b>Email</b></th>
                    <th class=""><b>Website</b></th>
                </tr>
                <tr>
                    <td><s:property value="listedCompany.telephone"/></td>
                    <td><s:property value="listedCompany.fax"/></td>
                    <td><s:property value="listedCompany.email"/></td>
                    <td><a href="<s:property value="listedCompany.website"/>" target="_blank"><s:property
                            value="listedCompany.website"/></a></td>
                </tr>
                </tbody>
            </table>
            <table style="width: 600px; ">
                <tbody>
                <tr>
                    <th class=""><b>Address</b></th>
                </tr>
                <tr>
                    <td><s:property value="listedCompany.address"/></td>
                </tr>
                </tbody>
            </table>
        </fieldset>
        <fieldset>

            <legend>Other Data</legend>
            <br />
            <table style="width: 600px; ">
                <tbody>
                <tr>
                    <th class=""><b>Finacial Year End</b></th>
                    <th class=""><b>Established</b></th>
                    <th class=""><b>Quoted Date</b></th>
                    <th class=""><b>Chairman</b></th>
                </tr>
                <tr>
                    <td><s:property value="listedCompany.financialYearEnd"/></td>
                    <td><s:property value="listedCompany.established"/></td>
                    <td><s:property value="listedCompany.quotedDate"/></td>
                    <td><s:property value="listedCompany.chairman"/></td>
                </tr>
                </tbody>
            </table>
        </fieldset><br />

    </div>

</div>
</body>
</html>