<%--
  Created by IntelliJ IDEA.
  User: mkoerner
  Date: 10.08.2010
  Time: 14:27:33
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>
<head>
    <title>Projekt &Uuml;bersicht</title>
    <meta name="heading" content="Projekt &Uuml;bersicht" />
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>

<s:url action="editRechnung" var="rechnungDetail" escapeAmp="false">
    <s:param name="journalId" value="%{journalId}"/>
</s:url>


<h1>Journalkosten</h1>

<s:url action="editJournalkosten" var="journalkostenDetail" escapeAmp="false">
    <s:param name="journalId" value="%{journalId}"/>
</s:url>

<div class="userActions">
    <a class="small gray awesome" onClick ="window.location.href='${journalkostenDetail}'">Journalkosten bearbeiten</a> <br /><br />
</div>

    <br><b>Abonnement-Preis f&uuml;r Institution</b><br>

    <table>
        <tr>
            <td></td>
            <td>Online + Print</td>
            <td>Online</td>
            <td>Print</td>
        </tr>
        <tr>
            <td>Originalpreis</td>
            <td><s:property value="preisPO"/></td>
            <td><s:property value="preisO"/></td>
            <td><s:property value="preisP"/></td>
        </tr>
        <tr>
            <td>MwSt.</td>
            <td><s:property value="journalkosten.mwStPO"/></td>
            <td><s:property value="journalkosten.mwStO"/></td>
            <td><s:property value="journalkosten.mwStP"/></td>
        </tr>
        <tr>
            <td>Endpreis</td>
            <td><s:property value="endpreisPO"/></td>
            <td><s:property value="endpreisO"/></td>
            <td><s:property value="endpreisP"/></td>
        </tr>
    </table>


    <br><b>Abonnement-Preis f&uuml;r Personen</b><br>

    <table>
        <tr>
            <td></td>
            <td>Online + Print</td>
            <td>Online</td>
            <td>Print</td>
        </tr>
        <tr>
            <td>Originalpreis</td>
            <td><s:property value="iPreisPO"/></td>
            <td><s:property value="iPreisO"/></td>
            <td><s:property value="iPreisP"/></td>
        </tr>
        <tr>
            <td>MwSt.</td>
            <td><s:property value="journalkosten.iMwStPO"/></td>
            <td><s:property value="journalkosten.iMwStO"/></td>
            <td><s:property value="journalkosten.iMwStP"/></td>
        </tr>
        <tr>
            <td>Endpreis</td>
            <td><s:property value="endpreisIPO"/></td>
            <td><s:property value="endpreisIO"/></td>
            <td><s:property value="endpreisIP"/></td>
        </tr>
    </table>

<h1>Interesse</h1>

<s:url value="/project/showInteresseCreateForm.html" var="interesseCreate" escapeAmp="false">
    <s:param name="journalId" value="%{journalId}"/>
</s:url>
<s:url value="/project/searchProjectBestellerDelete.html" var="bestellerAdmin" escapeAmp="false">
    <s:param name="journalId" value="%{journalId}"/>
</s:url>
<s:url value="/project/editInteresse.html" var="interesseDetail" escapeAmp="false">
    <s:param name="journalId" value="%{journalId}"/>
</s:url>

<div class="userActions">
    <a class="small gray awesome" onClick ="window.location.href='${bestellerAdmin}'">Besteller verwalten</a> <br /><br />
    <a class="small gray awesome" onClick ="window.location.href='${interesseCreate}'">Neues Interesse erstellen</a> <br /><br />
</div>

<s:set name="interessen" value="interessen" scope="request"/>
<display:table name="interessen" class="table" requestURI="" id="interessenList" export="false" pagesize="25">

    <display:column property="interesseId" sortable="true"  href="${interesseDetail}"
                    paramId="interesseId" paramProperty="interesseId" titleKey="interesse.interesseId"/>
    <display:column property="interesse" sortable="true" titleKey="interesse.interesse"/>    
    <display:column property="besteller.anrede" sortable="true" titleKey="interesse.bestellerAnrede"/>
    <display:column property="besteller.bestellerName" sortable="true" titleKey="interesse.besteller"/>
    <display:column property="besteller.sigel.name" sortable="true" titleKey="interesse.sigelName"/>
    <display:column property="besteller.funktion" sortable="true" titleKey="interesse.funktion"/>

    <display:setProperty name="paging.banner.item_name" value="Interesse"/>
    <display:setProperty name="paging.banner.items_name" value="Interessen"/>
    <display:setProperty name="basic.empty.showtable" value="false"/>
    <display:setProperty name="basic.msg.empty_list" value="Kein Interesse vorhanden.<br/>"/>
    <display:setProperty name="paging.banner.one_item_found" value="Ein {0} vorhanden.<br/>"/>
    <display:setProperty name="paging.banner.all_items_found" value="{0} {1} vorhanden.<br/>"/>
    <display:setProperty name="paging.banner.some_items_found" value="{0} {1} vorhanden, es werden die Treffer {2} bis {3} angezeigt.<br/>"/>

</display:table>

<h1>Rechnungen</h1>

<s:url value="/project/showExemplarForRechnung.html" var="exemplarForRechnung" escapeAmp="false">
    <s:param name="journalId" value="%{journalId}"/>
</s:url>
<div class="userActions">
    <a class="small gray awesome" onClick ="window.location.href='${exemplarForRechnung}';">Neue Rechnung erstellen</a> <br /><br />
</div>

<s:set name="rechnungen" value="rechnungen" scope="request"/>
<display:table name="rechnungen" class="table" requestURI="" id="rechnungenList" export="false" pagesize="25">

    <display:column property="rechnungId" sortable="true"  href="${rechnungDetail}"
                    paramId="rechnungId" paramProperty="rechnungId" titleKey="rechnung.rechnungId"/>
    <display:column property="exemplar.zustaendigeBib.name" sortable="true" titleKey="rechnung.exemplar"/>
    <display:column property="bezugsform" sortable="true" titleKey="rechnung.bezugsform"/>
    <display:column property="bezugsjahr" sortable="true" titleKey="rechnung.bezugsjahr"/>
    <display:column property="betrag" sortable="true" titleKey="rechnung.betrag"/>

    <display:setProperty name="paging.banner.item_name" value="Rechnung"/>
    <display:setProperty name="paging.banner.items_name" value="Rechnungen"/>
    <display:setProperty name="basic.empty.showtable" value="false"/>
    <display:setProperty name="basic.msg.empty_list" value="Keine Rechnung vorhanden.<br/>"/>
    <display:setProperty name="paging.banner.one_item_found" value="Ein {0} vorhanden.<br/>"/>
    <display:setProperty name="paging.banner.all_items_found" value="{0} {1} vorhanden.<br/>"/>
    <display:setProperty name="paging.banner.some_items_found" value="{0} {1} vorhanden, es werden die Treffer {2} bis {3} angezeigt.<br/>"/>

</display:table>


<h1>Nutzung</h1>

<s:url value="/project/showNutzungCreateForm.html" var="nutzungCreate" escapeAmp="false">
    <s:param name="journalId" value="%{journalId}"/>
</s:url>
<s:url value="/project/deleteNutzung.html" var="nutzungDelete" escapeAmp="false">
    <s:param name="journalId" value="%{journalId}"/>
    <s:param name="nutzungId" value="%{nutzungId}"/>
</s:url>

<div class="userActions">
    <a class="small gray awesome" onClick ="window.location.href='${nutzungCreate}'">Neue Nutzung erstellen</a> <br /><br />
</div>

<s:set name="nutzungen" value="nutzungen" scope="request"/>
<display:table name="nutzungen" class="table" requestURI="" id="nutzungenList" export="false" pagesize="25">

    <display:column property="nutzungId" sortable="true" titleKey="nutzung.nutzungId"/>
    <display:column property="nutzungsjahr" sortable="true" titleKey="nutzung.nutzungsjahr"/>
    <display:column property="zeitraum" sortable="true" titleKey="nutzung.zeitraum"/>
    <display:column property="zugriffe" sortable="true" titleKey="nutzung.zugriffe"/>
    <display:column property="rechnungsbetrag" sortable="true" titleKey="nutzung.rechnungsbetrag"/>
    <display:column href="${nutzungDelete}" value="entfernen" paramId="nutzungId" paramProperty="nutzungId"/>

    <display:setProperty name="paging.banner.item_name" value="Nutzung"/>
    <display:setProperty name="paging.banner.items_name" value="Nutzungen"/>
    <display:setProperty name="basic.empty.showtable" value="false"/>
    <display:setProperty name="basic.msg.empty_list" value="Keine Nutzung vorhanden.<br/>"/>
    <display:setProperty name="paging.banner.one_item_found" value="Eine {0} vorhanden.<br/>"/>
    <display:setProperty name="paging.banner.all_items_found" value="{0} {1} vorhanden.<br/>"/>
    <display:setProperty name="paging.banner.some_items_found" value="{0} {1} vorhanden, es werden die Treffer {2} bis {3} angezeigt.<br/>"/>

</display:table>

<script type="text/javascript">
    highlightTableRows("interessenList");
    highlightTableRows("rechnungenList");
    highlightTableRows("nutzungenList");
</script>