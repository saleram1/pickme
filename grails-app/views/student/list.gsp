
<%@ page import="org.pickme.bo.Student" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'student.label', default: 'Student')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1>Students</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'student.id.label', default: 'Id')}" />

                            <g:sortableColumn property="lastName" title="${message(code: 'student.lastName.label', default: 'Last Name')}" />                        
                            <g:sortableColumn property="firstName" title="${message(code: 'student.firstName.label', default: 'First Name')}" />
                        
                            <g:sortableColumn property="dateOfBirth" title="${message(code: 'student.dateOfBirth.label', default: 'Date Of Birth')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${studentInstanceList}" status="i" var="studentInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${studentInstance.id}">${fieldValue(bean: studentInstance, field: "id")}</g:link></td>

                            <td>${fieldValue(bean: studentInstance, field: "lastName")}</td>
                        
                            <td>${fieldValue(bean: studentInstance, field: "firstName")}</td>                       

                            <td><g:formatDate date="${studentInstance.dateOfBirth}" type="date" style="MEDIUM" /></td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${studentInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
