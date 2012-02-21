<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Florian
  Date: 29.06.2010
  Time: 11:41:36
  To change this template use File | Settings | File Templates.
--%>

<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Journal</title>
    <meta name="heading" content="Journal"/>
    <meta name="menu" content="JournalMenu"/>
</head>



<jsp:include page="/common/journalMenu.jsp"/>

<authz:authorize ifAnyGranted="ROLE_ADMIN,ROLE_PFLEGE">

<s:url value="/admin/searchPaket.html" var="paketChange">
    <s:param name="journalId" value="%{journal.id}"/>
</s:url>
<s:url value="/admin/searchKonsortium.html"  var="konsortiumChange">
    <s:param name="journalId" value="%{journal.id}"/>
</s:url>
<s:url value="/admin/editJournal.html" var="journalEdit">
    <s:param name="journalId" value="%{journal.id}"/>
</s:url>
<s:url value="/admin/deleteJournal.html" var="journalDelete">
    <s:param name="journalId" value="%{journal.id}"/>
</s:url>

<div class="userActions">
  <a class="small gray awesome" onClick ="window.location.href='${paketChange}'">Anderes Paket w&auml;hlen</a> <br /><br />
  <a class="small gray awesome" onClick ="window.location.href='${konsortiumChange}'">Anderes Konsortium w&auml;hlen</a> <br /><br />
  <a class="small gray awesome" onClick ="window.location.href='${journalEdit}'">Journal bearbeiten</a> <br /><br />
  <a class="small gray awesome" onClick ="if (confirm('Journal wirklich entfernen?')) window.location.href='${journalDelete}';">Journal entfernen</a> <br /><br />
</div>
</authz:authorize>

<s:push value="journal">
    <b>Titel:</b>  <s:property value="titel"/>    <br>
    <b>Kurztitel:</b> <s:property value="kurztitel" />    <br>
    <b>eISSN:</b> <s:property value="issn" />    <br>
    <b>pISSN:</b> <s:property value="issnPrint" />    <br>
    <b>Verlag:</b> <s:property value="verlag.name" />    <br>
    <b>Bibliotheksmitarbeiter:</b> <s:property value="bibliotheksmitarbeiter.mitarbeiter"/> <br>
    <b>E-Mail:</b> <s:property value="bibliotheksmitarbeiter.emailanschrift"/><br>
    <br>
    <b>Konsortium:</b> <s:property value="konsortium.konsortiumName" /><br>
    <b>Zugang &uuml;ber:</b> <s:property value="zugangUeber" /><br>
    <b>Nutzungsbestimmungen:</b> <s:property value="nutzungsbestimmungen" />    <br>
    <b>Kennung:</b> <s:property value="zugangsId" />    <br>
    <b>Passwort:</b> <s:property value="zugangsPasswort" />    <br>
    <br>
    <b>Anmeldedatum:</b> <s:property value="anmeldedatum" />    <br>
    <b>Freischaltdatum:</b> <s:property value="freischaltdatum" />    <br>
    <b>Rotschaltungsdatum:</b> <s:property value="rotschaltungsdatum" />    <br>
    <b>Bemerkung zur Rotschaltung:</b> <s:property value="rotschaltungsbemerkungen" />    <br>
    <br>
    <b>Kommentar Intranet:</b> <s:property value="kommentarIntranet" />    <br>
    <br>

    <authz:authorize ifAnyGranted="ROLE_ADMIN,ROLE_PFLEGE, ROLE_PROJECT">
        <b>Herausgeber:</b> <s:property value="herausgeber" />    <br>
        <b>Provider:</b> <s:property value="provider.name" />    <br>
        <b>Anker:</b> <s:property value="anker" />    <br>
        <b>Bearbeitungsdatum:</b> <s:property value="bearbeitungsdatum" />    <br>
        <b>Status:</b> <s:property value="status" />    <br>
        <b>ZDB Nummer:</b> <s:property value="zdbNummer" />    <br>
        <b>EZB ID:</b> <s:property value="ezbId" />    <br>
        <b>Read Me (titelbezogen):</b> <input type="checkbox" name="readMeTitelbezogen" value="<s:property value="readMeTitelbezogen" />" ${(readMeTitelbezogen) ? ' checked="checked"' : ''} disabled="disabled" id="readMeTitelbezogen" class="text medium"/> <br>
        <%--Import ID: <s:property value="importId" />    <br>--%>
        <b>Paket:</b> <s:property value="paket.paketName" /> <br>
        <br>
    </authz:authorize>

    <%-- Sicherheitshalber in eigenem auth tag -- darf nur admin sehen !!!! --%>
    <%-- Begin Security Area --%>
        <authz:authorize ifAnyGranted="ROLE_ADMIN,ROLE_PFLEGE">
            <b>Kommentar Adminstrator:</b> <s:property value="kommentarAdmin" />    <br>
            <b>Kommentar:</b> <s:property value="kommentar" />    <br>
        </authz:authorize>
    <%-- Ende Security Area --%>

    <b>Letzte &Auml;nderung:</b> <s:property value="aenderungsdatum" />    <br>

</s:push>








