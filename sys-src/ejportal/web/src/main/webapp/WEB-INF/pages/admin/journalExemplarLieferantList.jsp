<%--
  Created by IntelliJ IDEA.
  User: mkoerner
  Date: 05.08.2010
  Time: 17:34:41
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Suchergebnisse: Lieferant f&uuml;r Exemplar</title>
    <meta name="heading" content="Lieferanten"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>
<jsp:include page="/common/exemplarMenu.jsp"/>

W&auml;hlen Sie einen neuen Lieferanten f&uuml;r das Exemplar:
<br><br>
<s:url action="changeLieferant"  var="lieferantChange" escapeAmp="false">
    <s:param name="exemplarId" value="%{exemplarId}"/>
    <s:param name="journalId" value="%{journalId}"/>
</s:url>

<s:set name="institutions" value="institutions" scope="request"/>
<display:table name="institutions" class="table" requestURI="" id="lieferantList" export="false" pagesize="25">
    <display:column property="id" sortable="true" href="${lieferantChange}"
        paramId="lieferantId" paramProperty="id" titleKey="institution.id"/>
    <display:column property="name" sortable="true" titleKey="institution.name"/>
    <display:column property="strasse" sortable="true" titleKey="institution.strasse"/>
    <display:column property="plz_ort" sortable="true" titleKey="institution.plz_ort"/>
    <display:column property="bundesland" sortable="true" titleKey="institution.bundesland"/>
    <display:column property="land" sortable="true" titleKey="institution.land"/>
    <display:column property="ansprechpartner" sortable="true" titleKey="institution.ansprechpartner"/>
    <display:column property="abteilung" sortable="true" titleKey="institution.abteilung"/>

    <display:setProperty name="paging.banner.item_name" value="Lieferant"/>
    <display:setProperty name="paging.banner.items_name" value="Lieferanten"/>
    <display:setProperty name="basic.empty.showtable" value="false"/>
    <display:setProperty name="basic.msg.empty_list" value="Die Suche ergab keinen Treffer."/>
    <display:setProperty name="paging.banner.one_item_found" value="Ein {0} gefunden.<br/><br/>"/>
    <display:setProperty name="paging.banner.all_items_found" value="{0} {1} gefunden.<br/><br/>"/>
    <display:setProperty name="paging.banner.some_items_found" value="{0} {1} gefunden, es werden die Treffer {2} bis {3} angezeigt.<br/><br/>"/>
</display:table>
<%--<br>
<s:url action="showExemplarDetail" var="lieferantSelect">
    <s:param name="exemplarId" value="%{exemplarId}"/>
</s:url>
<a href="${lieferantSelect}">zur&uuml;ck zum Exemplar</a>--%>

<script type="text/javascript">
    highlightTableRows("lieferantList");
</script>