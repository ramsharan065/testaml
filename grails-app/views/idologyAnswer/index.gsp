
<%@ page import="testaml.IdologyAnswer" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'idologyAnswer.label', default: 'IdologyAnswer')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-idologyAnswer" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-idologyAnswer" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="response" title="${message(code: 'idologyAnswer.response.label', default: 'Response')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${idologyAnswerInstanceList}" status="i" var="idologyAnswerInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${idologyAnswerInstance.id}">${fieldValue(bean: idologyAnswerInstance, field: "response")}</g:link></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${idologyAnswerInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
