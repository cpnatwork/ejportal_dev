<%--
  Created by IntelliJ IDEA.
  User: Michael
  Date: 05.08.2010
  Time: 10:41:36
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Exemplar</title>
    <meta name="heading" content="Exemplar"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>
<jsp:include page="/common/exemplarMenu.jsp"/>

<s:push value="exemplar">

    <authz:authorize ifAnyGranted="ROLE_ADMIN,ROLE_PFLEGE">
        <s:url value="/admin/editExemplar.html" var="exemplarEdit">
            <s:param name="exemplarId" value="%{exemplarId}"/>
            <s:param name="journalId" value="%{journalId}"/>
        </s:url>
        <s:url value="/admin/deleteExemplar.html" var="exemplarDelete">
            <s:param name="exemplarId" value="%{exemplarId}"/>
            <s:param name="journalId" value="%{journalId}"/>
        </s:url>
    <div class="userActions">
        <a class="small gray awesome" onClick ="window.location.href='${exemplarEdit}'">Exemplar bearbeiten</a> <br /><br />
        <a class="small gray awesome" onClick ="if (confirm('Exemplar wirklich entfernen?')) window.location.href='${exemplarDelete}';">Exemplar entfernen</a> <br /><br />
    </div>
    </authz:authorize>

    Journal: <s:property value="journal.titel" />    <br>
    Zust&auml;ndige Bibliothek: <s:property value="zustaendigeBib.name" />    <br>
  <%--  <ul>
        <li>Bibliothek: <s:property value="zustaendigeBib.Bibliothek" />    </li>
        <li>Fakult&auml;t: <s:property value="zustaendigeBib.fakultaet" />    </li>
        <li>E-Mail: <s:property value="zustaendigeBib.persEmail" />    </li>
        <li>Ansprechpartner: <s:property value="zustaendigeBib.bibAnsprechpartner1" /> ,  <s:property value="zustaendigeBib.bibAnsprechpartner2" />    </li>
    </ul>
--%>
    Eigent&uuml;mer: <s:property value="eigentuemer.name" />    <br>
    Besteller:  <s:property value="besteller.name" />    <br>
    Lieferant: <s:property value="lieferant.name" />    <br>
    <br>
    Beteiligung: <s:property value="beteiligung" />    <br>
    Form: <s:property value="form" />    <br>
    Zugangsart: <s:property value="zugangsart" />    <br>
    Status: <s:property value="status" />    <br>
    <br>
    Bestellnummer: <s:property value="bestellnummer" />    <br>
    Kundennummer: <s:property value="kundennummer" />    <br>
    Abonummer: <s:property value="abonummer" />    <br>
    Privatabo: <input type="checkbox" name="privatabo" value="<s:property value="privatabo" />" ${(privatabo) ? ' checked="checked"' : ''} disabled="disabled" id="privatabo" class="text medium"/><br>
    Ex Kommentar: <s:property value="exKommentar" />    <br>
    Print Ex Bayern: <s:property value="printexBayern" />    <br>
    <br>
    Abbestellung: <s:property value="abbestellung" />    <br>
    Abbestellt zum: <s:property value="abbestZum" />    <br>
    Umbestellung: <s:property value="umbestellung" />    <br>
    Umbestellt zum: <s:property value="umbestZum" />    <br>

</s:push>