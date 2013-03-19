
<%@ page import="org.pickme.bo.Faculty" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'faculty.label', default: 'Faculty')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'faculty.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="title" title="${message(code: 'faculty.title.label', default: 'Title')}" />
                        
                            <g:sortableColumn property="firstName" title="${message(code: 'faculty.firstName.label', default: 'First Name')}" />
                        
                            <g:sortableColumn property="middleInitial" title="${message(code: 'faculty.middleInitial.label', default: 'Middle Initial')}" />
                        
                            <g:sortableColumn property="lastName" title="${message(code: 'faculty.lastName.label', default: 'Last Name')}" />
                                                
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${facultyInstanceList}" status="i" var="facultyInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${facultyInstance.id}">${fieldValue(bean: facultyInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: facultyInstance, field: "title")}</td>
                        
                            <td>${fieldValue(bean: facultyInstance, field: "firstName")}</td>
                        
                            <td>${fieldValue(bean: facultyInstance, field: "middleInitial")}</td>
                        
                            <td>${fieldValue(bean: facultyInstance, field: "lastName")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${facultyInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
