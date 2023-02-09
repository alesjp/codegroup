<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="template/header.jspf" %>
<%@ include file="template/navbar.jspf" %>

<div class="container">
    <div class="row">
        <div class="col-md-12 col-md-offset-0 ">
            <div class="panel panel-primary">
                <div class="panel-heading">Adicionar Projeto</div>

                <div class="panel-body">
                    <form:form method="post" modelAttribute="projeto">
                        <form:hidden path="id"/>

                        <c:if test="${not empty showMsgErro}">
                            <div class="alert alert-danger" role="alert"><strong>Atenção: </strong>${showMsgErro}</div>
                        </c:if>

                        <fieldset class="form-group">
                            <div class="col-lg-12">
                                <legend>Nome</legend>
                                <form:input path="nome" type="text" class="form-control" required="required"/>
                                <form:errors path="nome" cssClass="text-warning"/>
                            </div>
                        </fieldset>

                        <fieldset class="form-group">
                            <div class="col-lg-12">
                                <legend>Descrição</legend>
                                <form:textarea path="descricao" type="text" class="form-control" required="required" rows="5"/>
                                <form:errors path="descricao" cssClass="text-warning"/>
                            </div>
                        </fieldset>

                        <fieldset class="form-group">
                            <div class="col-lg-4">
                                <legend>Data Início</legend>
                                <form:input path="dataInicio" type="text" class="form-control" required="required"/>
                                <form:errors path="dataInicio" cssClass="text-warning"/>
                            </div>

                            <div class="col-lg-4">
                                <legend>Data Previsão Fim</legend>
                                <form:input path="dataPrevisaoFim" type="text" class="form-control" required="required"/>
                                <form:errors path="dataPrevisaoFim" cssClass="text-warning"/>
                            </div>

                            <div class="col-lg-4">
                                <legend>Data Fim</legend>
                                <form:input path="dataFim" type="text" class="form-control" required="required"/>
                                <form:errors path="dataFim" cssClass="text-warning"/>
                            </div>
                        </fieldset>

                        <fieldset class="form-group">
                            <div class="col-lg-6">
                                <legend>Gerente Responsável</legend>
                                <form:select path="gerente" class="form-control" required="required">
                                    <form:option value="">SELECIONAR</form:option>
                                    <c:forEach items="${listaGerentes}" var="ger">
                                        <option value="${ger.id}" ${ger.id eq gerente.id ? 'selected="selected"' : ''} >
                                                ${ger.nome}
                                        </option>
                                    </c:forEach>
                                </form:select>
                                <form:errors path="gerente" cssClass="text-warning"/>
                            </div>

                            <div class="col-lg-6">
                                <legend>Orçamento Total</legend>
                                <div class="input-group">
                                    <div class="input-group-addon">R$</div>
                                    <form:input path="orcamento" type="text" class="form-control" required="required"/>
                                    <form:errors path="orcamento" cssClass="text-warning"/>
                                </div>
                            </div>
                        </fieldset>

                        <fieldset class="form-group">
                            <div class="col-lg-6">
                                <legend>Status</legend>
                                <form:select path="status" class="form-control" required="required">
                                    <form:option value="">SELECIONAR</form:option>
                                    <form:option value="EM ANÁLISE">EM ANÁLISE</form:option>
                                    <form:option value="ANÁLISE REALIZADA">ANÁLISE REALIZADA</form:option>
                                    <form:option value="ANÁLISE APROVADA">ANÁLISE APROVADA</form:option>
                                    <form:option value="INICIADO">INICIADO</form:option>
                                    <form:option value="PLANEJADO">PLANEJADO</form:option>
                                    <form:option value="EM ANDAMENTO">EM ANDAMENTO</form:option>
                                    <form:option value="ENCERRADO">ENCERRADO</form:option>
                                    <form:option value="CANCELADO">CANCELADO</form:option>
                                </form:select>
                                <form:errors path="status" cssClass="text-warning"/>
                            </div>

                            <div class="col-lg-6">
                                <legend>Risco</legend>
                                <form:select path="risco" class="form-control">
                                    <form:option value="">SELECIONAR</form:option>
                                    <form:option value="BAIXO RISCO">BAIXO RISCO</form:option>
                                    <form:option value="MÉDIO RISCO">MÉDIO RISCO</form:option>
                                    <form:option value="ALTO RISCO">ALTO RISCO</form:option>
                                </form:select>
                                <form:errors path="risco" cssClass="text-warning"/>
                            </div>
                        </fieldset>

                        <div class="col-lg-12">
                            <button type="submit" class="btn btn-success">Salvar</button>
                        </div>

                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="template/footer.jspf" %>
