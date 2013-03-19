

<%@ page import="org.pickme.bo.PermanentAddress" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'permanentAddress.label', default: 'PermanentAddress')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${permanentAddressInstance}">
            <div class="errors">
                <g:renderErrors bean="${permanentAddressInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="address1"><g:message code="permanentAddress.address1.label" default="Address1" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: permanentAddressInstance, field: 'address1', 'errors')}">
                                    <g:textField name="address1" value="${permanentAddressInstance?.address1}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="address2"><g:message code="permanentAddress.address2.label" default="Address2" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: permanentAddressInstance, field: 'address2', 'errors')}">
                                    <g:textField name="address2" value="${permanentAddressInstance?.address2}" />
                                </td>
                            </tr>
                        
	                        <tr class="prop">
	                            <td valign="top" class="name">
	                                <label for="city"><g:message code="permanentAddress.city.label" default="City" /></label>
	                            </td>
	                            <td valign="top" class="value ${hasErrors(bean: permanentAddressInstance, field: 'city', 'errors')}">
	                                <div id="cityDiv">
									   First, select a state from list below:
									</div>
	                            </td>
	                        </tr>


                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="region"><g:message code="permanentAddress.region.label" default="Region" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: permanentAddressInstance, field: 'region', 'errors')}">
                                    <g:select onchange="${remoteFunction(controller:'permanentAddress', action:'regionSelected',update:'cityDiv', params:'\'region=\' + this.value' )}" name="region" from="${permanentAddressInstance.constraints.region.inList}" value="${permanentAddressInstance?.region}" valueMessagePrefix="permanentAddress.region" noSelection="['': '']" />
                                </td>
                            </tr>

                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="postalCode"><g:message code="permanentAddress.postalCode.label" default="Postal Code" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: permanentAddressInstance, field: 'postalCode', 'errors')}">
                                    <g:textField name="postalCode" value="${permanentAddressInstance?.postalCode}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="countryCode"><g:message code="permanentAddress.countryCode.label" default="Country Code" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: permanentAddressInstance, field: 'countryCode', 'errors')}">
                                    <g:textField name="countryCode" value="US" readonly="readonly" />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
