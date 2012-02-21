<%--
  Created by IntelliJ IDEA.
  User: Tselmeg
  Date: 03.08.2010
  Time: 13:31:35
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Liste der Pakete</title>
    <meta name="heading" content="Pakete"/>
    <meta name="menu" content="StammMenu"/>
</head>

<jsp:include page="/common/stammMenu.jsp"/>
<%--
<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editPaket.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<c:url value="/masterdataMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false" />
--%>

<s:set name="pakete" value="pakete" scope="request"/>
<display:table name="pakete" class="table" requestURI="" id="paketList" export="false" pagesize="25">
    <display:column property="paketId" sortable="true" href="showPaketDetail.html"
                    paramId="paketId" paramProperty="paketId" titleKey="paket.paketId"/>
    <display:column property="paketName" sortable="true" titleKey="paket.paketName"/>

    <display:setProperty name="paging.banner.item_name" value="Paket"/>
    <display:setProperty name="paging.banner.items_name" value="Pakete"/>
    <display:setProperty name="basic.empty.showtable" value="false"/>
    <display:setProperty name="basic.msg.empty_list" value="Die Suche ergab keinen Treffer."/>
    <display:setProperty name="paging.banner.one_item_found" value="Ein {0} gefunden.<br/>"/>
    <display:setProperty name="paging.banner.all_items_found" value="{0} {1} gefunden.<br/>"/>
    <display:setProperty name="paging.banner.some_items_found" value="{0} {1} gefunden, es werden die Treffer {2} bis {3} angezeigt.<br/>"/>
</display:table>

<%--<c:out value="${buttons}" escapeXml="false" /> --%>

<script type="text/javascript">
    highlightTableRows("paketList");
</script>
