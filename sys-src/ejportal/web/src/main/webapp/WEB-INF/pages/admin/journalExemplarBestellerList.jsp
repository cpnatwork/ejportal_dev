   <%--
  Created by IntelliJ IDEA.
  User: mkoerner
  Date: 05.08.2010
  Time: 17:34:19
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Suchergebnisse: Besteller f&uuml;r Exemplar</title>
    <meta name="heading" content="Besteller"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>
<jsp:include page="/common/exemplarMenu.jsp"/>

W&auml;hlen Sie einen neuen Besteller f&uuml;r das Exemplar:
<br><br>
<s:url action="changeBesteller"  var="bestellerChange" escapeAmp="false">
    <s:param name="exemplarId" value="%{exemplarId}"/>
    <s:param name="journalId" value="%{journalId}"/>
</s:url>

<s:set name="sigels" value="sigels" scope="request"/>
<display:table name="sigels" class="table" requestURI="" id="bestellerList" export="false" pagesize="25">
    <display:column property="sigelId" sortable="true" href="${bestellerChange}"
        paramId="bestellerId" paramProperty="sigelId" titleKey="sigel.sigelId"/>
    <display:column property="name" sortable="true" titleKey="sigel.name"/>
    <display:column property="bibliothek" sortable="true" titleKey="sigel.bibliothek"/>
    <display:column property="fakultaet" sortable="true" titleKey="sigel.fakultaet"/>
    <display:column property="persEmail" sortable="true" titleKey="sigel.persEmail"/>
    <display:column property="bibAnsprechpartner1" sortable="true" titleKey="sigel.bibAnsprechpartner1"/>
    <display:column property="bibAnsprechpartner2" sortable="true" titleKey="sigel.bibAnsprechpartner2"/>

    <display:setProperty name="paging.banner.item_name" value="Besteller"/>
    <display:setProperty name="paging.banner.items_name" value="Besteller"/>
    <display:setProperty name="basic.empty.showtable" value="false"/>
    <display:setProperty name="basic.msg.empty_list" value="Die Suche ergab keinen Treffer.<br/>"/>
    <display:setProperty name="paging.banner.one_item_found" value="Ein {0} gefunden.<br/><br/>"/>
    <display:setProperty name="paging.banner.all_items_found" value="{0} {1} gefunden.<br/><br/>"/>
    <display:setProperty name="paging.banner.some_items_found" value="{0} {1} gefunden, es werden die Treffer {2} bis {3} angezeigt.<br/><br/>"/>
</display:table>

<%--<br>
<s:url action="showExemplarDetail" var="bestellerSelect">
    <s:param name="exemplarId" value="%{exemplarId}"/>
</s:url>
<a href="${bestellerSelect}">zur&uuml;ck zum Exemplar</a>--%>

<script type="text/javascript">
    highlightTableRows("bestellerList");
</script>