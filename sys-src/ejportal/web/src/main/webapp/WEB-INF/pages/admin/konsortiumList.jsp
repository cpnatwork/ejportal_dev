<%--
  Created by IntelliJ IDEA.
  User: mkoerner
  Date: 03.08.2010
  Time: 15:20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Liste der Konsortien</title>
    <meta name="heading" content="Konsortien"/>
    <meta name="menu" content="StammMenu"/>
</head>

<jsp:include page="/common/stammMenu.jsp"/>

<%--
<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editInstitution.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<c:url value="/mainMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false" />
--%>

<!-- test -->
<s:set name="konsortien" value="konsortien" scope="request"/>
<!-- test -->
<display:table name="konsortien" class="table" requestURI="" id="konsortienList" export="false" pagesize="25">
    <display:column property="konsortiumId" sortable="true" href="showKonsortiumDetail.html"
                    paramId="konsortiumId" paramProperty="konsortiumId" titleKey="konsortium.konsortiumId"/>
    <display:column property="konsortiumName" sortable="true" titleKey="konsortium.konsortiumName"/>


    <display:setProperty name="paging.banner.item_name" value="Konsortium"/>
    <display:setProperty name="paging.banner.items_name" value="Konsortien"/>
    <display:setProperty name="basic.empty.showtable" value="false"/>
    <display:setProperty name="basic.msg.empty_list" value="Die Suche ergab keinen Treffer."/>
    <display:setProperty name="paging.banner.one_item_found" value="Ein {0} gefunden.<br/>"/>
    <display:setProperty name="paging.banner.all_items_found" value="{0} {1} gefunden.<br/>"/>
    <display:setProperty name="paging.banner.some_items_found" value="{0} {1} gefunden, es werden die Treffer {2} bis {3} angezeigt.<br/>"/>
</display:table>

<%--<c:out value="${buttons}" escapeXml="false" /> --%>

<script type="text/javascript">
    highlightTableRows("konsortienList");
</script>