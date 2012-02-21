<%--
  Created by IntelliJ IDEA.
  User: Janine
  Date: 14.07.2010
  Time: 16:22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Konsortium Liste</title>
    <meta name="heading" content="Konsortium Liste"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>
W&auml;hlen Sie ein neues Konsortium f&uuml;r das Journal:
<br><br>



<authz:authorize ifAnyGranted="ROLE_ADMIN,ROLE_PFLEGE">
    <s:url action="changeKonsortium"  var="konsortiumChange">
    <s:param name="journalId" value="%{JournalId}"/>
</s:url>
    <s:url action="searchKonsortium" var="konsortiumSearch">
        <s:param name="journalId" value="%{journalId}"/>
    </s:url>

    <div class="userActions">
        <a class="small gray awesome" onClick ="window.location.href='${konsortiumSearch}'">Neue Konsortiumsuche durchf&uuml;hren</a> <br /><br />
    </div>

</authz:authorize>

<s:set name="konsortien" value="konsortien" scope="request"/>
<display:table name="konsortien" class="table" requestURI="" id="konsortiumList" export="false" pagesize="25">
    <display:column property="konsortiumId" sortable="true" href="${konsortiumChange}"
        paramId="konsortiumId" paramProperty="konsortiumId" titleKey="konsortium.konsortiumId"/>
    <display:column property="konsortiumName" sortable="true" titleKey="konsortium.konsortiumName"/>

    <display:setProperty name="paging.banner.item_name" value="Konsortium"/>
    <display:setProperty name="paging.banner.items_name" value="Konsortien"/>
    <display:setProperty name="basic.empty.showtable" value="false"/>
    <display:setProperty name="basic.msg.empty_list" value="Die Suche ergab keinen Treffer.<br/>"/>
    <display:setProperty name="paging.banner.one_item_found" value="Ein {0} gefunden.<br/>"/>
    <display:setProperty name="paging.banner.all_items_found" value="{0} {1} gefunden.<br/>"/>
    <display:setProperty name="paging.banner.some_items_found" value="{0} {1} gefunden, es werden die Treffer {2} bis {3} angezeigt.<br/>"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("konsortiumList");
</script>

