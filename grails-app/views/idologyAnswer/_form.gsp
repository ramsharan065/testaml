<%@ page import="testaml.IdologyAnswer" %>



<div class="fieldcontain ${hasErrors(bean: idologyAnswerInstance, field: 'response', 'error')} required">
	<label for="response">
		<g:message code="idologyAnswer.response.label" default="Response" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="response" cols="40" rows="5" maxlength="5000" required="" value="${idologyAnswerInstance?.response}"/>

</div>

