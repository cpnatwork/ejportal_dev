<%--
  Created by IntelliJ IDEA.
  User: mkoerner
  Date: 11.08.2010
  Time: 11:09:32
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Suchergebnisse: Besteller f&uuml;r Interesse</title>
    <meta name="heading" content="Besteller"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>

W&auml;hlen Sie einen neuen Besteller f&uuml;r das Interesse:
<br><br>
<s:url value="/project/changeProjectBesteller.html"  var="bestellerChange" escapeAmp="false">
    <s:param name="interesseId" value="%{interesseId}"/>
    <s:param name="journalId" value="%{journalId}"/>
</s:url>

<s:set name="bestellerList" value="bestellerList" scope="request"/>
<display:table name="bestellerList" class="table" requestURI="" id="bestellerTable" export="false" pagesize="25">
    <display:column property="bestellerId" sortable="true" href="${bestellerChange}"
        paramId="bestellerId" paramProperty="bestellerId" titleKey="bestellerProj.bestellerId"/>
    <display:column property="anrede" sortable="true" titleKey="bestellerProj.anrede"/>
    <display:column property="bestellerName" sortable="true" titleKey="bestellerProj.bestellerName"/>
    <display:column property="funktion" sortable="true" titleKey="bestellerProj.funktion"/>
    <display:column property="projekt" sortable="true" titleKey="bestellerProj.projekt"/>
    <display:column property="einzahlungErwuenscht" sortable="true" titleKey="bestellerProj.einzahlungErwuenscht"/>
    <display:column property="einzahlungFestgelegt" sortable="true" titleKey="bestellerProj.einzahlungFestgelegt"/>

    <display:setProperty name="paging.banner.item_name" value="Besteller"/>
    <display:setProperty name="paging.banner.items_name" value="Besteller"/>
    <display:setProperty name="basic.empty.showtable" value="false"/>
    <display:setProperty name="basic.msg.empty_list" value="Die Suche ergab keinen Treffer."/>
    <display:setProperty name="paging.banner.one_item_found" value="Ein {0} gefunden.<br/>"/>
    <display:setProperty name="paging.banner.all_items_found" value="{0} {1} gefunden.<br/>"/>
    <display:setProperty name="paging.banner.some_items_found" value="{0} {1} gefunden, es werden die Treffer {2} bis {3} angezeigt.<br/>"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("bestellerTable");
</script>