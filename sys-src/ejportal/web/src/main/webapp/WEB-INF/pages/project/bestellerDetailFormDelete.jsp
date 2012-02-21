<%--
  Created by IntelliJ IDEA.
  User: mkoerner
  Date: 10.08.2010
  Time: 13:08:00
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Besteller bearbeiten</title>
    <meta name="heading" content="Besteller"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>

<s:url value="/project/searchProjectBestellerSigel.html" var="sigelChange" escapeAmp="false">
    <s:param name="journalId" value="%{journalId}"/>
    <s:param name="interesseId" value="%{interesseId}"/>
    <s:param name="bestellerId" value="%{bestellerId}"/>
</s:url>
<s:url value="/project/deleteBesteller.html" var="bestellerDelete" escapeAmp="false">
    <s:param name="journalId" value="%{journalId}"/>
    <s:param name="interesseId" value="%{interesseId}"/>
    <s:param name="bestellerId" value="%{bestellerId}"/>
</s:url>

<div class="userActions">
    <a class="small gray awesome" onClick ="window.location.href='${sigelChange}'">Anderes Sigel w&auml;hlen</a> <br /><br />
    <a class="small gray awesome" onClick ="if (confirm('Besteller wirklich entfernen?')) window.location.href='${bestellerDelete}';">Besteller entfernen</a> <br /><br />
</div>


Sigel: <s:property value="besteller.sigel.name"/> <br>
Fakult&auml;t: <s:property value="besteller.sigel.fakultaet"/> <br>
<br>


<hr>

<s:form id="bestellerForm" action="editProjectBesteller" method="post" validate="true">
    <s:hidden name="journalId" value="%{journalId}"/>
    <s:hidden name="interesseId" value="%{interesseId}"/>

    <s:hidden name="bestellerBaseTO.bestellerId" value="%{bestellerBaseTO.bestellerId}"/>
    <s:textfield label="Anrede" key="bestellerBaseTO.anrede" cssClass="text medium"/>
    <s:textfield label="Name" key="bestellerBaseTO.bestellerName" required="true" cssClass="text medium"/>
    <s:textfield label="Funktion" key="bestellerBaseTO.funktion" cssClass="text medium"/>
    <br>
    <s:textfield label="Projekt" key="bestellerBaseTO.projekt" required="true" cssClass="text medium"/>
    <br>
    <s:textfield label="Erwünschte Einzahlung" key="bestellerBaseTO.einzahlungErwuenscht" required="true" cssClass="text medium"/>
    <s:textfield label="Festgelegte Einzahlung" key="bestellerBaseTO.einzahlungFestgelegt" required="true" cssClass="text medium"/>

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