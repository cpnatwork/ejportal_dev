<%--
  Created by IntelliJ IDEA.
  User: mkoerner
  Date: 10.08.2010
  Time: 13:07:32
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Besteller erstellen</title>
    <meta name="heading" content="Besteller"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>



<s:form id="bestellerForm" action="createProjectBesteller" method="post" validate="true">
    <s:hidden name="journalId" value="%{journalId}"/>
    <s:hidden name="interesseId" value="%{interesseId}"/>

    <s:textfield label="Anrede" key="bestellerBaseTO.anrede" cssClass="text medium"/>
    <s:textfield label="Name" key="bestellerBaseTO.bestellerName" required="true" cssClass="text medium"/>
    <s:textfield label="Funktion" key="bestellerBaseTO.funktion" cssClass="text medium"/>
    <br>
    <s:textfield label="Projekt" key="bestellerBaseTO.projekt" required="true" cssClass="text medium"/>
    <br>
    <s:textfield label="Erwünschte Einzahlung" key="bestellerBaseTO.einzahlungErwuenscht" cssClass="text medium"/>
    <s:textfield label="Festgelegte Einzahlung" key="bestellerBaseTO.einzahlungFestgelegt" cssClass="text medium"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" label="Speichern" key="button.save" theme="simple"/>
    </li>

</s:form>

<s:url value="/project/editInteresse.html" var="back" escapeAmp="false">
    <s:param name="journalId" value="%{journalId}"/>
    <s:param name="interesseId" value="%{interesseId}"/>
    <s:param name="bestellerId" value="%{bestellerId}"/>
</s:url>
<a href="${back}">zur&uuml;ck zum Interesse</a>

<script type="text/javascrsipt">
    Form.focusFirstElement($("interesseForm"));
</script>