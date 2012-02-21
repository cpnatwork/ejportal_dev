<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="journalList.title"/></title>
    <meta name="heading" content="<fmt:message key='journalList.heading'/>"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<b><a href="<c:url value="/searchJournals.html"/>">Neue Suche</a></b>
<br><br>
<hr/>

<s:set name="journals" value="journals" scope="request"/>
<display:table name="journals" class="table" requestURI="" id="journalList" export="false" pagesize="25" defaultsort="1">
    <display:column property="id" sortable="true" href="showJournalDetail.html"
                    paramId="journalId" paramProperty="id" titleKey="journal.id"/>
    <display:column property="titel" sortable="true" titleKey="journal.titel"/>
    <display:column property="kurztitel" sortable="true" titleKey="journal.kurztitel"/>
    <display:column property="verlag.name" sortable="true" titleKey="journal.verlag.name"/>
<authz:authorize ifAnyGranted="ROLE_ADMIN,ROLE_PFLEGE,ROLE_LESEN,ROLE_PROJECT">
    <display:column property="konsortium.konsortiumName" sortable="true" titleKey="konsortium.konsortiumName"/>
    <display:column property="paket.paketName" sortable="true" titleKey="paket.paketName"/>
</authz:authorize>
    <display:setProperty name="paging.banner.item_name" value="Journal"/>
    <display:setProperty name="paging.banner.items_name" value="Journale"/>
    <display:setProperty name="basic.empty.showtable" value="false"/>
    <display:setProperty name="basic.msg.empty_list" value="Die Suche ergab keinen Treffer.<br/>"/>
    <display:setProperty name="paging.banner.one_item_found" value="Ein {0} gefunden.<br/><br/>"/>
    <display:setProperty name="paging.banner.all_items_found" value="{0} {1} gefunden.<br/><br/>"/>
    <display:setProperty name="paging.banner.some_items_found" value="{0} {1} gefunden, es werden die Treffer {2} bis {3} angezeigt.<br/><br/>"/>

</display:table>

<%--<c:out value="${buttons}" escapeXml="false" /> --%>



<script type="text/javascript">
    highlightTableRows("journalList");
</script>
