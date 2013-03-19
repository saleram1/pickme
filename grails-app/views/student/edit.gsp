

<%@ page import="org.pickme.bo.Student" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'student.label', default: 'Student')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${studentInstance}">
            <div class="errors">
                <g:renderErrors bean="${studentInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${studentInstance?.id}" />
                <g:hiddenField name="version" value="${studentInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="firstName"><g:message code="student.firstName.label" default="First Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: studentInstance, field: 'firstName', 'errors')}">
                                    <g:textField name="firstName" maxlength="100" value="${studentInstance?.firstName}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="middleInitial"><g:message code="student.middleInitial.label" default="Middle Initial" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: studentInstance, field: 'middleInitial', 'errors')}">
                                    <g:textField name="middleInitial" maxlength="30" value="${studentInstance?.middleInitial}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="lastName"><g:message code="student.lastName.label" default="Last Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: studentInstance, field: 'lastName', 'errors')}">
                                    <g:textField name="lastName" maxlength="100" value="${studentInstance?.lastName}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="studentIdentifier"><g:message code="student.studentIdentifier.label" default="Student Identifier" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: studentInstance, field: 'studentIdentifier', 'errors')}">
                                    <g:textField name="studentIdentifier" value="${studentInstance?.studentIdentifier}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="dateOfBirth"><g:message code="student.dateOfBirth.label" default="Date Of Birth" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: studentInstance, field: 'dateOfBirth', 'errors')}">
                                    <g:datePicker name="dateOfBirth" precision="day" value="${studentInstance?.dateOfBirth}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="emailAddress"><g:message code="student.emailAddress.label" default="Email Address" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: studentInstance, field: 'emailAddress', 'errors')}">
                                    <g:textField name="emailAddress" value="${studentInstance?.emailAddress}" />
                                </td>
                            </tr>
 
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="faculty"><g:message code="course.faculty.label" default="Address" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: studentInstance, field: 'permanentAddress', 'errors')}">
                                    <g:select name="permanentAddress.id" from="${org.pickme.bo.PermanentAddress.list()}" optionKey="id" value="${studentInstance?.permanentAddress?.id}" noSelection="['null': '']" />
                                </td>
                            </tr>
                       
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="memberships"><g:message code="student.memberships.label" default="Memberships" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: studentInstance, field: 'memberships', 'errors')}">
                                    
<ul>
<g:each in="${studentInstance?.memberships?}" var="m">
    <li><g:link controller="membership" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="membership" action="create" params="['student.id': studentInstance?.id]">Add Course to Schedule&hellip;</g:link>

                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
