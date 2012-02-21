<%--
  Created by IntelliJ IDEA.
  User: Janine
  Date: 04.07.2010
  Time: 16:40:13
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>


<head>
    <title>Provider</title>
    <meta name="heading" content="Provider von '<s:property value="journal.titel"/>' " />
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>

<authz:authorize ifAnyGranted="ROLE_ADMIN,ROLE_PFLEGE">

<s:url value="/admin/searchProvider.html"  var="providerChange">
    <s:param name="journalId" value="%{journal.id}"/>
</s:url>

<div class="userActions">
  <a class="small gray awesome" onClick ="window.location.href='${providerChange}'">Anderen Provider w&auml;hlen</a> <br /><br />
  <br>
</div>

</authz:authorize>


<s:push value="journal">
    Provider:  <s:property value="provider.name" />    <br>
    Abteilung: <s:property value="provider.abteilung" />    <br>
    Strasse: <s:property value="provider.strase" />    <br>
    Postfach: <s:property value="provider.postfach" />    <br>
    PLZ: <s:property value="provider.plz_ort" />    <br>
    Bundesland: <s:property value="provider.bundesland" />    <br>
    Land: <s:property value="provider.land" />    <br>
    Ansprechpartner: <s:property value="provider.ansprechpartner" />    <br>
    Email: <s:property value="provider.email" />    <br>
    Fax: <s:property value="provider.fax" />    <br>
    Telefon: <s:property value="provider.telefon" />    <br>
    Sprache: <s:property value="provider.bestellsprache" />    <br>
    Status: <s:property value="provider.status" />    <br>
    Kommentar: <s:property value="provider.kommentar" />    <br>
    Fernzugriff: <s:property value="provider.fernzugriff" />    <br>

    <br>

</s:push>



