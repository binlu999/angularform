<%@page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String key=request.getParameter("key");
 %>
<script type="text/javascript">
var keyid="<%= key %>";
</script>
  
<html ng-app="surveyform.edit">
  <head>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular-animate.js"></script>
    <script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-1.3.2.js"></script>
    <script src="/js/tabs.js"></script>
    
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>

<style type="text/css">
  form.tab-form-demo .tab-pane {
    margin: 20px 20px;
  }
</style>

<form name="surveyForm" ng-controller="survey.edit.ctl">

  
 <uib-accordion close-others="false">
  	<uib-accordion-group heading="Form Headers">
  		<div ng-include src="'/subviews/formeditheader.html'"></div>
    </uib-accordion-group>
    <uib-accordion-group heading="Questions">
    	<div ng-include src="'/subviews/formeditquestion.html'"></div>
    </uib-accordion-group>
 </uib-accordion>

<DIV class="ipqsnav" style="text-align:center;" colspan="3">
				<button type="button"  class="btn btn-primary" ng-click="submitSurvey()">Submit</button>
				
			</DIV>
			
  Model:
  <pre>{{ data | json }}</pre>
 
</form>
  </body>
</html>


