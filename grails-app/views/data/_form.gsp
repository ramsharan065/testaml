<%@ page import="com.test.Data" %>



<div class="fieldcontain ${hasErrors(bean: dataInstance, field: 'response', 'error')} required">
	<label for="response">
		<g:message code="data.response.label" default="Response" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="response" required="" value="${dataInstance?.response}"/>

</div>

