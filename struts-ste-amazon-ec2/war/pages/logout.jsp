<%@page contentType="text/html; charset=iso-8859-1" language="java"%>
<% 
    
    String isSsoEnabled = java.lang.System.getProperty("josso.config.url");
    
    if( isSsoEnabled != null ) {
    
		session.invalidate();
		response.sendRedirect(request.getContextPath() + "/josso_logout/");
    	
    }else{
    	
    	session.invalidate();
    	response.sendRedirect(request.getContextPath());
    
    }
	
%>
