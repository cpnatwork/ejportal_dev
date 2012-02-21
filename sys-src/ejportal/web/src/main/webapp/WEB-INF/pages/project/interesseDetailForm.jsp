<%--
  Created by IntelliJ IDEA.
  User: mkoerner
  Date: 10.08.2010
  Time: 13:08:25
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Interesse bearbeiten</title>
    <meta name="heading" content="Interesse"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>

<s:url value="/project/searchProjectBesteller.html" var="bestellerChange" escapeAmp="false">
    <s:param name="journalId" value="%{journalId}"/>
    <s:param name="interesseId" value="%{interesseId}"/>    
</s:url>
<s:url value="/project/editProjectBesteller.html" var="bestellerEdit" escapeAmp="false">
    <s:param name="journalId" value="%{journalId}"/>
    <s:param name="interesseId" value="%{interesseId}"/>
    <s:param name="bestellerId" value="%{bestellerId}"/>
</s:url>
<s:url value="/project/deleteInteresse.html" var="interesseDelete" escapeAmp="false">
    <s:param name="journalId" value="%{journalId}"/>
    <s:param name="interesseId" value="%{interesseId}"/>
</s:url>

<div class="userActions">
    <a class="small gray awesome" onClick ="window.location.href='${bestellerChange}'">Anderen Besteller w&auml;hlen</a> <br /><br />
    <a class="small gray awesome" onClick ="window.location.href='${bestellerEdit}'">Besteller bearbeiten</a> <br /><br />
    <a class="small gray awesome" onClick ="if (confirm('Interesse wirklich entfernen?')) window.location.href='${interesseDelete}';">Interesse entfernen</a> <br /><br />
</div>

<b>Besteller: <s:property value="interesse.besteller.anrede"/> <s:property value="interesse.besteller.bestellerName"/></b> <br>
<br>
Erw&uuml;nschte Einzahlung: <s:property value="interesse.besteller.einzahlungErwuenscht"/> EUR <br>
Festgelegte Einzahlung: <s:property value="interesse.besteller.einzahlungFestgelegt"/> EUR <br>

<br><br>

<hr>


<div class="userActions">
</div>

<s:form id="interesseForm" action="editInteresse" method="post" validate="true">
    <s:hidden name="journalId" value="%{journalId}"/>
    <s:hidden name="interesseBaseTO.interesseId" value="%{interesseBaseTO.interesseId}"/>
    <s:textfield label="Interesse" key="interesseBaseTO.interesse" required="true" cssClass="text medium"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" label="Speichern" key="button.save" theme="simple"/>
    </li>

</s:form>

<s:url value="/project/showProjectCockpit.html" var="back" escapeAmp="false">
    <s:param name="journalId" value="%{journalId}"/>
</s:url>
<a href="${back}">zur&uuml;ck zur Projekt&uuml;bersicht</a>

<script type="text/javascrsipt">
    Form.focusFirstElement($("interesseForm"));
</script>