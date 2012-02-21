<%--
  Created by IntelliJ IDEA.
  User: Nina
  Date: 05.08.2010
  Time: 12:11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Bibliothek</title>
    <meta name="heading" content="Bibliothek"/>
    <meta name="menu" content="StammMenu"/>
</head>

<jsp:include page="/common/stammMenu.jsp"/>

<s:url action="editBibliotheksmitarbeiter" var="bibliotheksmitarbeiterEdit">
    <s:param name="bibId" value="%{bibliotheksmitarbeiter.bibId}"/>
</s:url>
<s:url action="deleteBibliotheksmitarbeiter" var="bibliotheksmitarbeiterDelete">
    <s:param name="bibId" value="%{bibliotheksmitarbeiter.bibId}"/>
</s:url>
<div class="userActions">
  <a class="small gray awesome" onClick ="window.location.href='${bibliotheksmitarbeiterEdit}'">Bibliothek bearbeiten</a> <br /><br />
  <a class="small gray awesome" onClick ="if (confirm('Bibliothek wirklich entfernen?')) window.location.href='${bibliotheksmitarbeiterDelete}';">Bibliothek entfernen</a> <br /><br />
</div>

<s:push value="bibliotheksmitarbeiter">
    Name:<s:property value="name" /> <br/>
    Bibliothek:<s:property value="abteilungsHauptstelle" /><br/>
    Fensterumschlagadresse: <s:property value="fensterumschlagAdresse" />    <br/>
    Hausanschrift: <s:property value="hausanschrift" />    <br/>
    Postanschrift: <s:property value="postanschrift" />    <br/>
    Telefon: <s:property value="telefon" />    <br/>
    Fax: <s:property value="telefax" />    <br/>
    E-Mail: <s:property value="emailanschrift" />    <br/>
    URL: <s:property value="url" />    <br/>
    Umsatzsteuer Nr: <s:property value="umstId" />    <br/>
    Mitarbeiter: <s:property value="mitarbeiter" />   <br/>
    Dienstort: <s:property value="dienstort" />    <br/>

</s:push>
<br><br>
<hr/>