

<%@ page import="org.pickme.i18n.MessageImport" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'messageImport.label', default: 'MessageImport')}" />
        <title><g:message code="default.create.label" args="[entityName]" encodeAs="HTML"/></title>
    </head>
    <body>
        <div class="nav">
			&nbsp;
        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" encodeAs="HTML" /></h1>
            <g:if test="${flash.message}">
            <div class="message"><g:message code="${flash.message}" args="${flash.args}" default="${flash.defaultMessage}" encodeAs="HTML"/></div>
            </g:if>
            <g:hasErrors bean="${messageImportInstance}">
            <div class="errors">
                <g:renderErrors bean="${messageImportInstance}" as="list" />
            </div>
            </g:hasErrors>
 				
                <div class="dialog">
                <table>
                    <tbody>                        
                        <tr class="prop" title="${message(code:'messageImport.name.hint' , default: 'Name', encodeAs:'HTML')}">
                            <td valign="top" class="name">
                            	<label for="name">
					 Filename
                            	</label>
                            </td>
                            <td valign="top" class="value ${hasErrors(bean: messageImportInstance, field: 'name', 'errors')}">
                                <fieldset> 
						<fileuploader:form  upload="docs" 
						successAction="saveMessages"
						successController="messageImport"
						errorAction="errorWithSave"
						errorController="messageImport">
                        <tr class="prop" title="${message(code:'messageImport.name.hint' , default: 'Name', encodeAs:'HTML')}">
                            <td valign="top" class="name">
                            	<label for="name">
								<g:message code="messageImport.name.label" default="Name" encodeAs="HTML" />
                            	</label>
                            </td>
                            <td valign="top" class="value ${hasErrors(bean: messageImportInstance, field: 'name', 'errors')}">
                                <g:textField name="name" value="${messageImportInstance?.name}" />
                            </td>
                        </tr>
						
						</fileuploader:form>
					</fieldset>
                            </td>
                        </tr>
                                           
                    </tbody>
                </table>
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create', encodeAs:'HTML')}" /></span>
                </div>
               </div>
        </div>
    </body>
</html>
