<%@page contentType="text/html; charset=iso-8859-1" language="java"%>
<%
    
    String isSsoEnabled = java.lang.System.getProperty("josso.config.url");
    
    if( isSsoEnabled != null ) {
    
    	response.sendRedirect(request.getContextPath() + "/josso_login/");
    	
    }else{
        
        if(request.getParameter("error") != null){
            response.sendRedirect(request.getContextPath() + "/pages/login.jsp?error=true");

        }else{
            response.sendRedirect(request.getContextPath() + "/pages/login.jsp");

        }
    
    }
    
%>

