<%--
  Created by IntelliJ IDEA.
  User: mkoerner
  Date: 05.08.2010
  Time: 17:33:52
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Suchergebnisse: Eigent&uuml;mer f&uuml;r Exemplar</title>
    <meta name="heading" content="Eigent&uuml;mer"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>
<jsp:include page="/common/exemplarMenu.jsp"/>

W&auml;hlen Sie einen neuen Eigent&uuml;mer f&uuml;r das Exemplar:
<br><br>
<s:url action="changeEigentuemer"  var="eigentuemerChange" escapeAmp="false">
    <s:param name="journalId" value="%{journalId}"/>
    <s:param name="exemplarId" value="%{exemplarId}"/>
</s:url>

<s:set name="sigels" value="sigels" scope="request"/>
<display:table name="sigels" class="table" requestURI="" id="eigentuemerList" export="false" pagesize="25">
    <display:column property="sigelId" sortable="true" href="${eigentuemerChange}"
        paramId="eigentuemerId" paramProperty="sigelId" titleKey="sigel.sigelId"/>
    <display:column property="name" sortable="true" titleKey="sigel.name"/>
    <display:column property="bibliothek" sortable="true" titleKey="sigel.bibliothek"/>
    <display:column property="fakultaet" sortable="true" titleKey="sigel.fakultaet"/>
    <display:column property="persEmail" sortable="true" titleKey="sigel.persEmail"/>
    <display:column property="bibAnsprechpartner1" sortable="true" titleKey="sigel.bibAnsprechpartner1"/>
    <display:column property="bibAnsprechpartner2" sortable="true" titleKey="sigel.bibAnsprechpartner2"/>
    

    <display:setProperty name="paging.banner.item_name" value="Eigentümer"/>
    <display:setProperty name="paging.banner.items_name" value="Eigentümer"/>
    <display:setProperty name="basic.empty.showtable" value="false"/>
    <display:setProperty name="basic.msg.empty_list" value="Die Suche ergab keinen Treffer.<br/><br/>"/>
    <display:setProperty name="paging.banner.one_item_found" value="Ein {0} gefunden.<br/><br/>"/>
    <display:setProperty name="paging.banner.all_items_found" value="{0} {1} gefunden.<br/><br/><br/>"/>
    <display:setProperty name="paging.banner.some_items_found" value="{0} {1} gefunden, es werden die Treffer {2} bis {3} angezeigt.<br/>"/>
</display:table>
<%--<br>
<s:url action="showExemplarDetail" var="eigentuemerSelect">
    <s:param name="exemplarId" value="%{exemplarId}"/>
</s:url>
<a href="${eigentuemerSelect}">zur&uuml;ck zum Exemplar</a>--%>

<script type="text/javascript">
    highlightTableRows("eigentuemerList");
</script>