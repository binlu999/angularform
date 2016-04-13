<%@page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

   
   
 <%
   HttpServletRequest renderRequest=request;
  HttpServletResponse renderResponse = response;
  
 String themeStr = "paper.bootstrap.min.css";
  
 String contextPath = renderRequest.getContextPath();
 
 // quick btns view
 String quickBtnsView = "quickBtnsViewDEFAULT";
 

 
 %>
       
<script src="<%= renderResponse.encodeURL(contextPath + "/libs/angular/angular.js" ) %>"></script>
<script src="<%= renderResponse.encodeURL(contextPath + "/libs/angular/angular-route.js") %>"></script>
        
<link href="<%= renderResponse.encodeURL(contextPath + "/libs/bootstrap/3.3.5/css/"+themeStr)%>" rel="stylesheet">
       
<link href="<%= renderResponse.encodeURL(contextPath + "/libs/angular/ui-grid/3.0.6/ui-grid.min.css") %>" rel="stylesheet"> 


<link href="<%= renderResponse.encodeURL(contextPath + "/css/main.css") %>" rel="stylesheet"> 
<link href="<%= renderResponse.encodeURL(contextPath + "/css/animation.css") %>" rel="stylesheet">    
<link href="<%= renderResponse.encodeURL(contextPath + "/css/aside.css") %>" rel="stylesheet">    
<link href="<%= renderResponse.encodeURL(contextPath + "/css/tab.css") %>" rel="stylesheet">    
<link href="<%= renderResponse.encodeURL(contextPath + "/css/ui.grid.css") %>" rel="stylesheet">    
<link href="<%= renderResponse.encodeURL(contextPath + "/css/upload.css") %>" rel="stylesheet">


 <script src="<%= renderResponse.encodeURL(contextPath + "/libs/angular/ui-grid/3.0.6/ui-grid.min.js") %>"></script>
 <script src="<%= renderResponse.encodeURL(contextPath + "/libs/angular/1.3.19/angular-messages.min.js") %>"></script>

    
<script type="text/javascript">  
 var cmodRenderUrl = "<portlet:renderURL/>";
 
 var surveyBaseUrl  = ''; 
 
 var submitSearchCmodUrl = '<portlet:resourceURL id="ResourceIdSearchCmod" escapeXml="false" />';
 
 var submitGetReportsListUrl = '<portlet:resourceURL id="ResourceIdGetReportsList" escapeXml="false"><portlet:param name="paramFoo" value="abcfooval"/></portlet:resourceURL>';
  
 var submitGetReportsListUrlTest = '<portlet:resourceURL id="ResourceIdGetReportsListTest" escapeXml="false" />';
 
 var downloadReportUrl = '<portlet:resourceURL id="ResourceIdDownloadReport" escapeXml="false"/>';
 
 var showReportUrl = '<portlet:resourceURL id="ResourceIdShowReport" escapeXml="false"/>';
 
 
 var getDownlineUrl = '<portlet:resourceURL id="ResourceIdGetDownline" escapeXml="false"><portlet:param name="paramFoo" value="defooval"/></portlet:resourceURL>';
 

 
 var spinImg = "<img  src='<%= renderResponse.encodeURL(renderRequest.getContextPath()+"/images/spinner-black.gif")%>'>";
 
 
 var quickBtnsView = '<%= renderResponse.encodeURL(renderRequest.getContextPath()+"/views/"+ quickBtnsView) %>' ;


 
 
</script>
 

 
    <div  ng-app="surveyNgApp" style="width:100%;"> 
   
        <div class="container">
        
	 
            <div class="row">
                <div class="col-xs-1 col-sm-2">
                </div>
                <div class="col-xs-10 col-sm-8">
                    <div ng-view=""></div>
                </div>
                <div class="col-xs-1 col-sm-2">
                </div>
            </div> 
            
            <script src="<%= renderResponse.encodeURL(renderRequest.getContextPath() + "/js/utils.js")%>"></script>
            <script src="<%= renderResponse.encodeURL(renderRequest.getContextPath() + "/js/initOptions.js") %>"></script>
  			<script src="<%= renderResponse.encodeURL(renderRequest.getContextPath() + "/js/main.js") %>"></script>
  			<script src="<%= renderResponse.encodeURL(renderRequest.getContextPath() + "/js/messages.js") %>"></script>
  			<script src="<%= renderResponse.encodeURL(renderRequest.getContextPath() + "/config/cmodconfig.js")%>"></script>
  			<script src="<%= renderResponse.encodeURL(renderRequest.getContextPath() + "/js/app.js")%>"></script>
			<script src="<%= renderResponse.encodeURL(renderRequest.getContextPath() + "/js/controllers.js")%>"></script>
			<script src="<%= renderResponse.encodeURL(renderRequest.getContextPath() + "/js/appsvc.js")%>"></script>		
    		<script src="<%= renderResponse.encodeURL(renderRequest.getContextPath() + "/js/usersvc.js")%>"></script>
    	  			
        </div>	    	
 

		<br/> 
		<br/>  
 

    	        
        <div id="footerDiv" class="container">
     	<div  class="row">
 			
 			<div class="col-xs-1 col-sm-2">
 			</div>
 			
  			<div class="col-xs-10 col-sm-8"> 
				
  			</div>
  	      			
 		 
 			<div class="col-xs-1 col-sm-2">
 			</div>
 		
 		</div>     
 		</div> 
 		
 		<br/>
 		<br/>
    
    
    
    </div>    

