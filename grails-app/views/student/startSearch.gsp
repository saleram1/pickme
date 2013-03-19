<%@ page import="org.pickme.bo.Student" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'student.label', default: 'Student')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>

		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1>Student Search</h1>
            <g:if test="${flash.message}">
            	<div class="message">${flash.message}</div>
            </g:if>

            <g:formRemote name="myForm" method="post" url="[ controller: 'student', action:'search']" update="resultsDiv"   on404="alert('No results found!');">
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
                                    <g:datePicker name="dateOfBirth" precision="day" years="${1980..2010}" value="${studentInstance?.dateOfBirth}"  />
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
                        
                        </tbody>
                    </table>
                </div>

                <div class="buttons">
                    <span class="button"><input type="submit" value="Search" /></span>
                </div>

				<div id="resultsDiv">
					&nbsp;
				</div>
            </g:formRemote>
        </div>
    </body>
</html>
