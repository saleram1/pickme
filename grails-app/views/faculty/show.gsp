
<%@ page import="org.pickme.bo.Course" %>
<%@ page import="org.pickme.bo.Faculty" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'faculty.label', default: 'Faculty')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="faculty.title.label" default="Title" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: facultyInstance, field: "title")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="faculty.firstName.label" default="First Name" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: facultyInstance, field: "firstName")}</td>
                            
                        </tr>
<g:if test="${facultyInstance.middleInitial}">                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="faculty.middleInitial.label" default="Middle Initial" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: facultyInstance, field: "middleInitial")}</td>                                                  </tr>
</g:if>                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="faculty.lastName.label" default="Last Name" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: facultyInstance, field: "lastName")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="faculty.identifier.label" default="Identifier" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: facultyInstance, field: "identifier")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="faculty.emailAddress.label" default="Email Address" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: facultyInstance, field: "emailAddress")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="faculty.faculty.label" default="Courses:" /></td>
                            
                            <td valign="top" style="text-align: left;" class="value">
                                <ul>
                                <g:each in="${Course.findAllByFaculty(facultyInstance, [sort:'name'])}" var="c">
                                    <li><g:link controller="course" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link>
				    </li>
                                </g:each>
                                </ul>
                            </td>                            
                        </tr>                                       
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${facultyInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
