<%--
  Created by IntelliJ IDEA.
  User: uj32uvac
  Date: 09.08.2010
  Time: 14:48:44
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Suchergebnisse: Zust&auml;ndige Bibliothek f&uuml;r Exemplar</title>
    <meta name="heading" content="Zust&auml;ndige Bibliothek"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>
<jsp:include page="/common/exemplarMenu.jsp"/>


<br>
Zust&auml;ndige Bibliothek f&uuml;r Exemplar &auml;ndern...
<br>
<s:url action="changeZustaendigeBib"  var="zustaendigeBibChange" escapeAmp="false">
    <s:param name="journalId" value="%{journalId}"/>
    <s:param name="exemplarId" value="%{exemplarId}"/>
</s:url>

<s:set name="sigels" value="sigels" scope="request"/>
<display:table name="sigels" class="table" requestURI="" id="zustaendigeBibList" export="false" pagesize="25">
    <display:column property="sigelId" sortable="true" href="${zustaendigeBibChange}"
        paramId="zustaendigeBibId" paramProperty="sigelId" titleKey="sigel.sigelId"/>
    <display:column property="name" sortable="true" titleKey="sigel.name"/>
    <display:column property="bibliothek" sortable="true" titleKey="sigel.bibliothek"/>
    <display:column property="fakultaet" sortable="true" titleKey="sigel.fakultaet"/>
    <display:column property="persEmail" sortable="true" titleKey="sigel.persEmail"/>
    <display:column property="bibAnsprechpartner1" sortable="true" titleKey="sigel.bibAnsprechpartner1"/>
    <display:column property="bibAnsprechpartner2" sortable="true" titleKey="sigel.bibAnsprechpartner2"/>

    <display:setProperty name="paging.banner.item_name" value="Zust&auml;ndige Bibliothek"/>
    <display:setProperty name="paging.banner.items_name" value="Zust&auml;ndige Bibliotheken"/>
    <display:setProperty name="basic.empty.showtable" value="false"/>
    <display:setProperty name="basic.msg.empty_list" value="Die Suche ergab keinen Treffer."/>
    <display:setProperty name="paging.banner.one_item_found" value="Ein {0} gefunden."/>
    <display:setProperty name="paging.banner.all_items_found" value="{0} {1} gefunden."/>
    <display:setProperty name="paging.banner.some_items_found" value="{0} {1} gefunden, es werden die Treffer {2} bis {3} angezeigt."/>
</display:table>


<script type="text/javascript">
    highlightTableRows("zustaendigeBibList");
</script>