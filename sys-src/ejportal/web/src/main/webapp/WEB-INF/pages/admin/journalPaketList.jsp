<%--
  Created by IntelliJ IDEA.
  User: Janine
  Date: 19.07.2010
  Time: 13:44:54
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Paket Liste</title>
    <meta name="heading" content="Paket Liste"/>
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>
W&auml;hlen Sie ein neues Paket f&uuml;r das Journal:
<br><br>

<authz:authorize ifAnyGranted="ROLE_ADMIN,ROLE_PFLEGE">
    <s:url action="changePaket"  var="paketChange">
        <s:param name="journalId" value="%{journalId}"/>
    </s:url>
    <s:url action="searchPaket" var="paketSearch">
        <s:param name="journalId" value="%{journalId}"/>
    </s:url>

    <div class="userActions">
        <a class="small gray awesome" onClick ="window.location.href='${paketSearch}'">Neue Paketsuche durchf&uuml;hren</a> <br /><br />
    </div>

</authz:authorize>

<s:set name="pakete" value="pakete" scope="request"/>
<display:table name="pakete" class="table" requestURI="" id="paketList" export="false" pagesize="25">
    <display:column property="paketId" sortable="true" href="${paketChange}"
        paramId="paketId" paramProperty="paketId" titleKey="paket.paketId"/>
    <display:column property="paketName" sortable="true" titleKey="paket.paketName"/>

    <display:setProperty name="paging.banner.item_name" value="Paket"/>
    <display:setProperty name="paging.banner.items_name" value="Pakete"/>
    <display:setProperty name="basic.empty.showtable" value="false"/>
    <display:setProperty name="basic.msg.empty_list" value="Die Suche ergab keinen Treffer.<br/>"/>
    <display:setProperty name="paging.banner.one_item_found" value="Ein {0} gefunden.<br/>"/>
    <display:setProperty name="paging.banner.all_items_found" value="{0} {1} gefunden.<br/>"/>
    <display:setProperty name="paging.banner.some_items_found" value="{0} {1} gefunden, es werden die Treffer {2} bis {3} angezeigt.<br/>"/>

</display:table>

<script type="text/javascript">
    highlightTableRows("paketList");
</script>