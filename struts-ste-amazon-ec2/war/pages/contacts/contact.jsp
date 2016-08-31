<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Contact Us</title>
</head>
<body>

<div id="content">
    <div class="box">

        <p>If you have any enquiries, please feel free to contact us using the form below.</p>

        <p>Alternatively you can email us at <a href="mailo:info@csewatch.com">info@csewatch.com</a></p>

        <s:if test="showSubheader == true ">
            <h3><s:property value="textMessage" /></h3><br />
        </s:if>

        <fieldset>

            <legend>Add your comments</legend>

            <form action="addContractDetailsContractUsAction.action" method="get">

                <p><label for="name">Name:</label>

                    <input name="name" id="name"  type="text"/><br /></p>

                <p><label for="email">Email:</label>

                    <input name="email" id="email"   type="text"/><br /></p>

                <p><label for="email">Subject:</label>

                    <input name="email" id="subject"   type="text"/><br /></p>

                <p><label for="message">Message:</label>

                    <textarea cols="60" rows="11" name="message" id="message"></textarea><br /></p>
                         <p>
                <%
                  ReCaptcha c = ReCaptchaFactory.newReCaptcha("6LeduswSAAAAAHCsG4w5b3Y23mfR-y-ZPOGX7o9w", "6LeduswSAAAAALbZLjFZTdYl6Yq7le4DfJD7ZkMu", false);
                  out.print("<div class= \"formpadding\" >" +  c.createRecaptchaHtml(null, null) + "</div>");
                %>
                </p><br />
                <p><input name="send" class="formbutton" value="Send Us" type="submit"/></p>

            </form>

        </fieldset>


    </div>
</div>

</body>
</html>