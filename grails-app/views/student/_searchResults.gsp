
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