<%--
  Created by IntelliJ IDEA.
  User: Florian
  Date: 09.08.2010
  Time: 15:07:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>EZB Daten</title>
    <meta name="heading" content="EZB Daten" />
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>


<authz:authorize ifAnyGranted="ROLE_ADMIN,ROLE_PFLEGE">

<s:url value="/admin/searchEzbDaten.html"  var="ezbDatenChange">
    <s:param name="journalId" value="%{journalId}"/>
</s:url>

<div class="userActions">
  <a class="small gray awesome" onClick ="window.location.href='${ezbDatenChange}'">Zuordnung &auml;ndern</a> <br /><br />
  <br>
</div>

</authz:authorize>


<s:push value="ezbDaten">
<table id="ezbimport">

  <tr>
    <td>EZB-Id:</td>
    <td><s:property value="ezbId" /></td>
  </tr>
  <tr>
    <td>Titel:</td>
    <td><s:property value="titel" /></td>
  </tr>
  <tr>
    <td>ZDB-Nummer:</td>
    <td><s:property value="zdbNummer" /></td>
  </tr>
  <tr>
    <td>Ampel:</td>


     <c:if test="${ezbDaten.ampelfarbe=='1'}"><td>gruen</td></c:if>
      <c:if test="${ezbDaten.ampelfarbe=='2'}"><td>gelb</td></c:if>
      <c:if test="${ezbDaten.ampelfarbe=='4'}"><td>rot</td></c:if>
      <c:if test="${ezbDaten.ampelfarbe=='6'}"><td>gelb/rot</td></c:if></td>

   <%--<td><s:property value="ampelfarbe" /> </td>--%>
  </tr>
    <tr>
    <td>Verlag:</td>
    <td><s:property value="verlag" /></td>
  </tr>
  <tr>
    <td>Typ:</td>
    <td><s:property value="typ" /></td>
  </tr>
  <tr>
    <td>Preistyp:</td>
    <td><s:property value="preistyp" /></td>
  </tr>
  <tr>
    <td>Zugangsbedingung:</td>
    <td><s:property value="zugangsbedingung" /> </td>
  </tr>
  <tr>
    <td>ISSN Online:</td>
    <td><s:property value="issne" /></td>
  </tr>
  <tr>
    <td>ISSN Print:</td>
    <td><s:property value="issnp" /></td>
  </tr>
  <tr>
    <td>Bibliographische URL:</td>
    <td><s:property value="biburl" /></td>
  </tr>
  <tr>
    <td>Volltext URL:</td>
    <td><s:property value="volltexturl" /> </td>
  </tr>
    <tr>
    <td>Frontdoor URL:</td>
    <td><s:property value="frontdoorurl" /></td>
  </tr>
  <tr>
    <td>Link zur Zeitschrift:</td>
    <td><s:property value="link" /></td>
  </tr>
</table>
</s:push>