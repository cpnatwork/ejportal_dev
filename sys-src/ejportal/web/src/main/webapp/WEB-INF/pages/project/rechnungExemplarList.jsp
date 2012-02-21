<%--
  Created by IntelliJ IDEA.
  User: Tselmeg
  Date: 11.08.2010
  Time: 13:28:25
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>
<head>
    <title>Exemplare</title>
    <meta name="heading" content="Exemplare von '<s:property value="journal.titel"/>' " />
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>

<s:url value="/project/showRechnungCreateForm.html" var="rechnungCreate">
    <s:param name="journalId" value="%{journal.id}"/>
    <s:param name="exemplarId" value="%{exemplar.id}"/>
</s:url>

<b>Bitte w&auml;hlen Sie das Exemplar f&uuml;r die neue Rechnung:</b><br/><br/>

<s:set name="exemplare" value="journal.exemplare" scope="request"/>
<display:table name="exemplare" class="table" requestURI="" id="exemplareList" export="false" pagesize="25">

    <display:column property="exemplarId" sortable="true"  href="${rechnungCreate}"
                    paramId="exemplarId" paramProperty="exemplarId" titleKey="exemplar.exemplarId"/>
    <display:column property="zustaendigeBib.name" sortable="true" titleKey="exemplar.zustaendigeBib"/>
    <display:column property="zustaendigeBib.bibliothek" sortable="true" titleKey="sigel.bibliothek"/>
    <display:column property="zustaendigeBib.bibAnsprechpartner1" sortable="true" titleKey="sigel.bibAnsprechpartner1"/>
    <display:column property="form" sortable="true" titleKey="exemplar.form"/>
    <display:column property="status" sortable="true" titleKey="exemplar.status"/>

    <display:setProperty name="paging.banner.item_name" value="Exemplar"/>
    <display:setProperty name="paging.banner.items_name" value="Exemplare"/>
    <display:setProperty name="basic.empty.showtable" value="false"/>
    <display:setProperty name="basic.msg.empty_list" value="Kein Exemplar vorhanden.<br/>"/>
    <display:setProperty name="paging.banner.one_item_found" value="Ein {0} vorhanden.<br/>"/>
    <display:setProperty name="paging.banner.all_items_found" value="{0} {1} vorhanden.<br/>"/>
    <display:setProperty name="paging.banner.some_items_found" value="{0} {1} vorhanden, es werden die Treffer {2} bis {3} angezeigt.<br/>"/>

</display:table>

<s:url value="/project/showProjectCockpit.html" var="projectSelect">
    <s:param name="journalId" value="%{journalId}"/>
</s:url>
<a href="${projectSelect}">zur&uuml;ck zur Projekt&uuml;bersicht</a>

<script type="text/javascript">
    highlightTableRows("exemplareList");
</script>



