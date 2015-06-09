<%@ page import="testaml.Idology" %>



<div class="fieldcontain ${hasErrors(bean: idologyInstance, field: 'response', 'error')} required">
	<label for="response">
		<g:message code="idology.response.label" default="Response" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="response" cols="40" rows="5" maxlength="5000" required="" value="${idologyInstance?.response}"/>

</div>

