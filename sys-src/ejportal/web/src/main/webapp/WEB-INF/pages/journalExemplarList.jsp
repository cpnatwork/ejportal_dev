<%--
  Created by IntelliJ IDEA.
  User: mkoerner
  Date: 04.08.2010
  Time: 16:28:13
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>
<head>
    <title>Exemplare</title>
    <meta name="heading" content="Exemplare von '<s:property value="journal.titel"/>' " />
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>


<authz:authorize ifAnyGranted="ROLE_ADMIN,ROLE_PFLEGE">
    <s:url value="/admin/showExemplarCreateForm.html" var="exemplarCreate">
        <s:param name="journalId" value="%{journal.id}"/>
    </s:url>

<div class="userActions">
    <a class="small gray awesome" onClick ="window.location.href='${exemplarCreate}'">Neues Exemplar erstellen</a> <br /><br />
</div>

</authz:authorize>

<s:url action="showExemplarDetail" var="exemplarDetail">
    <s:param name="journalId" value="%{journal.id}"/>
</s:url>


<s:push value="journal">
<s:set name="exemplare" value="exemplare" scope="request"/>
<display:table name="exemplare" class="table" requestURI="" id="exemplareList" export="false" pagesize="25">

    <display:column property="exemplarId" sortable="true"  href="${exemplarDetail}"
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
    <display:setProperty name="paging.banner.one_item_found" value="Ein {0} gefunden.<br/>"/>
    <display:setProperty name="paging.banner.all_items_found" value="{0} {1} gefunden.<br/>"/>
    <display:setProperty name="paging.banner.some_items_found" value="{0} {1} gefunden, es werden die Treffer {2} bis {3} angezeigt.<br/>"/>

</display:table>
</s:push>

<script type="text/javascript">
    highlightTableRows("exemplareList");
</script>



