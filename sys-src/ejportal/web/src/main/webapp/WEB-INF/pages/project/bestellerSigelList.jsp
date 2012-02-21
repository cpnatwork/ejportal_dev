<%--
  Created by IntelliJ IDEA.
  User: mkoerner
  Date: 11.08.2010
  Time: 13:59:47
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Suchergebnisse: Sigel f&uuml;r Besteller</title>
    <meta name="heading" content="Sigel"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>

W&auml;hlen Sie einen neues Sigel f&uuml;r den Besteller:
<br><br>
<s:url action="changeProjectBestellerSigel"  var="sigelChange" escapeAmp="false">
    <s:param name="journalId" value="%{journalId}"/>
    <s:param name="interesseId" value="%{interesseId}"/>
    <s:param name="bestellerId" value="%{bestellerId}"/>
</s:url>

<s:set name="sigels" value="sigels" scope="request"/>
<display:table name="sigels" class="table" requestURI="" id="sigelList" export="false" pagesize="25">
    <display:column property="sigelId" sortable="true" href="${sigelChange}"
        paramId="sigelId" paramProperty="sigelId" titleKey="sigel.sigelId"/>
    <display:column property="name" sortable="true" titleKey="sigel.name"/>
    <display:column property="bibliothek" sortable="true" titleKey="sigel.bibliothek"/>
    <display:column property="fakultaet" sortable="true" titleKey="sigel.fakultaet"/>
    <display:column property="persEmail" sortable="true" titleKey="sigel.persEmail"/>
    <display:column property="bibAnsprechpartner1" sortable="true" titleKey="sigel.bibAnsprechpartner1"/>
    <display:column property="bibAnsprechpartner2" sortable="true" titleKey="sigel.bibAnsprechpartner2"/>
    

    <display:setProperty name="paging.banner.item_name" value="Sigel"/>
    <display:setProperty name="paging.banner.items_name" value="Sigel"/>
    <display:setProperty name="basic.empty.showtable" value="false"/>
    <display:setProperty name="basic.msg.empty_list" value="Die Suche ergab keinen Treffer.<br/>"/>
    <display:setProperty name="paging.banner.one_item_found" value="Ein {0} gefunden.<br/>"/>
    <display:setProperty name="paging.banner.all_items_found" value="{0} {1} gefunden.<br/>"/>
    <display:setProperty name="paging.banner.some_items_found" value="{0} {1} gefunden, es werden die Treffer {2} bis {3} angezeigt.<br/>"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("sigelList");
</script>