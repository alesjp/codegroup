<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="template/header.jspf" %>
<%@ include file="template/navbar.jspf" %>

<div class="container">
    <div>
        <a type="button" class="btn btn-primary btn-md" href="/codegroup/novo-projeto">Novo Projeto</a>
    </div>
    <br>
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3>Projetos</h3>
        </div>
        <div class="panel-body">

            <c:if test="${not empty showMsgErro}">
                <div class="alert alert-danger" role="alert"><strong>Atenção: </strong>${showMsgErro}</div>
            </c:if>

            <table class="table table-striped">
                <thead>
                <tr>
                    <th width="30%">Nome</th>
                    <th width="10%">Data Início</th>
                    <th width="30%">Gerente Responsável</th>
                    <th width="10%">Status</th>
                    <th width="20%">Ações</th>
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
