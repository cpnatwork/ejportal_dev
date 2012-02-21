<%--
  Created by IntelliJ IDEA.
  User: mkoerner
  Date: 09.08.2010
  Time: 13:04:34
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>


<head>
    <title>Lieferant</title>
    <meta name="heading" content="Lieferant des Exemplars" />
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>
<jsp:include page="/common/exemplarMenu.jsp"/>


<authz:authorize ifAnyGranted="ROLE_ADMIN,ROLE_PFLEGE">

<s:url value="/admin/searchLieferant.html" var="lieferantChange">
    <s:param name="exemplarId" value="%{exemplarId}"/>
    <s:param name="journalId" value="%{journalId}"/>
</s:url>

<div class="userActions">
    <a class="small gray awesome" onClick ="window.location.href='${lieferantChange}'">Anderen Lieferanten w&auml;hlen</a> <br /><br />
  <br>
</div>

</authz:authorize>


<s:push value="exemplar">
    Lieferant:  <s:property value="lieferant.name" />    <br>
    Abteilung: <s:property value="lieferant.abteilung" />    <br>
    Strasse: <s:property value="lieferant.strase" />    <br>
    Postfach: <s:property value="lieferant.postfach" />    <br>
    PLZ: <s:property value="lieferant.plz_ort" />    <br>
    Bundesland: <s:property value="lieferant.bundesland" />    <br>
    Land: <s:property value="lieferant.land" />    <br>
    Ansprechpartner: <s:property value="lieferant.ansprechpartner" />    <br>
    Email: <s:property value="lieferant.email" />    <br>
    Fax: <s:property value="lieferant.fax" />    <br>
    Telefon: <s:property value="lieferant.telefon" />    <br>
    Sprache: <s:property value="lieferant.bestellsprache" />    <br>
    Status: <s:property value="lieferant.status" />    <br>
    Kommentar: <s:property value="lieferant.kommentar" />    <br>
    Fernzugriff: <s:property value="lieferant.fernzugriff" />    <br>

    <br>

</s:push>