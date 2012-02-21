<%--
  Created by IntelliJ IDEA.
  User: ev55esul
  Date: 05.08.2010
  Time: 17:31:53
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title>Liste der Faecher</title>
    <meta name="heading" content="Faecher"/>
    <meta name="menu" content="StammMenu"/>
</head>

<jsp:include page="/common/stammMenu.jsp"/>
<%--
<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editFach.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<c:url value="/masterdataMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false" />
--%>

<s:set name="faecher" value="faecher" scope="request"/>
<display:table name="faecher" class="table" requestURI="" id="fachList" export="false" pagesize="25">
    <display:column property="fachId" sortable="true" href="showFachDetail.html"
                    paramId="fachId" paramProperty="fachId" titleKey="fach.fachId"/>
    <display:column property="fachName" sortable="true" titleKey="fach.fachName"/>

    <display:setProperty name="paging.banner.item_name" value="Fach"/>
    <display:setProperty name="paging.banner.items_name" value="F&auml;cher"/>
    <display:setProperty name="basic.empty.showtable" value="false"/>
    <display:setProperty name="basic.msg.empty_list" value="Die Suche ergab keinen Treffer."/>
    <display:setProperty name="paging.banner.one_item_found" value="Ein {0} gefunden.<br/>"/>
    <display:setProperty name="paging.banner.all_items_found" value="{0} {1} gefunden.<br/>"/>
    <display:setProperty name="paging.banner.some_items_found" value="{0} {1} gefunden, es werden die Treffer {2} bis {3} angezeigt.<br/>"/>
</display:table>

<%--<c:out value="${buttons}" escapeXml="false" /> --%>

<script type="text/javascript">
    highlightTableRows("fachList");
</script>