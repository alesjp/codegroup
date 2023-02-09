<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="template/header.jspf" %>
<%@ include file="template/navbar.jspf" %>

<div class="container">
    <div>
        <a type="button" class="btn btn-primary btn-md" href="/codegroup/novo-projeto">Novo Projeto</a>
    </div>
    <br>
    <div class="panel panel-primary">
        <div id="projetos" class="panel-heading">
            <h3>Projetos</h3>
        </div>
        <div class="panel-body">

            <c:if test="${not empty showMsgErro}">
                <div class="alert alert-danger" role="alert"><strong>Atenção: </strong>${showMsgErro}</div>
            </c:if>

            <table aria-describedby="projetos" class="table table-striped">
                <thead>
                <tr>
                    <th>Nome</th>
                    <th>Data Início</th>
                    <th>Gerente Responsável</th>
                    <th>Status</th>
                    <th>Ações</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${projetos}" var="projeto">
                    <tr>
                        <td>${projeto.nome}</td>
                        <td><fmt:formatDate value="${projeto.dataInicio}" pattern="dd/MM/yyyy"/></td>
                        <td>${projeto.gerente.nome}</td>
                        <td>${projeto.status}</td>
                        <td>
                            <a type="button" class="btn btn-success" href="/codegroup/update-projeto?id=${projeto.id}">Editar</a>
                            <a type="button" class="btn btn-warning" href="/codegroup/delete-projeto?id=${projeto.id}">Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>

<%@ include file="template/footer.jspf" %>
