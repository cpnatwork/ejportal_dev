<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Nina
  Date: 05.08.2010
  Time: 16:27:08
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Bibliothek</title>
    <meta name="heading" content="Bibliothek von '<s:property value="journal.titel"/>' " />
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>

<authz:authorize ifAnyGranted="ROLE_ADMIN,ROLE_PFLEGE">
<s:url value="/admin/searchBibliotheksmitarbeiter.html"  var="bibliotheksmitarbeiterChange">
    <s:param name="journalId" value="%{journal.id}"/>
</s:url>

<div class="userActions">
  <a class="small gray awesome" onClick ="window.location.href='${bibliotheksmitarbeiterChange}'">Andere Bibliothek w&auml;hlen</a> <br /><br />
  <br>
</div>
</authz:authorize>


<s:push value="journal">
    <p>
    Bibliothek:  <s:property value="bibliotheksmitarbeiter.name" />    <br/>
    Abteilungshauptstelle: <s:property value="bibliotheksmitarbeiter.abteilungsHauptstelle" />    <br/>
    Fensterumschlagadresse: <s:property value="bibliotheksmitarbeiter.fensterumschlagAdresse" />    <br/>
    Hausanschrift: <s:property value="bibliotheksmitarbeiter.hausanschrift" />   <br/>
    Postanschrift: <s:property value="bibliotheksmitarbeiter.postanschrift" />    <br/>
    Telefon: <s:property value="bibliotheksmitarbeiter.telefon" />    <br/>
    Fax: <s:property value="bibliotheksmitarbeiter.telefax" />    <br/>
    E-Mail: <s:property value="bibliotheksmitarbeiter.emailanschrift" />    <br/>
    URL: <s:property value="bibliotheksmitarbeiter.url" />   <br/>
    Umsatzsteuer Nr: <s:property value="bibliotheksmitarbeiter.umstId" />    <br/>
    Mitarbeiter: <s:property value="bibliotheksmitarbeiter.mitarbeiter" />    <br/>
    Dienstort: <s:property value="bibliotheksmitarbeiter.dienstort" />   <br/>
    </p>
</s:push>
