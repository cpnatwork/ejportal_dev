<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ev55esul
  Date: 02.08.2010
  Time: 17:17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp"%>
<head>
    <title>Fach</title>
    <meta name="heading" content="Fach von '<s:property value="journal.titel"/>' " />
    <meta name="menu" content="JournalMenu"/>
</head>

<jsp:include page="/common/journalMenu.jsp"/>

<authz:authorize ifAnyGranted="ROLE_ADMIN,ROLE_PFLEGE">
<s:url value="/admin/listFaecher.html" var="fachList">
    <s:param name="journalId" value="%{journal.id}"/>
</s:url>
<s:url value="/admin/dropFach.html"  var="fachDrop">
    <s:param name="journalId" value="%{journal.id}"/>
</s:url>

<div class="userActions">
  <a class="small gray awesome" onClick ="window.location.href='${fachList}'">Fach hinzuf&uuml;gen</a> <br /><br />
</div>
</authz:authorize>


<s:push value="journal">
<s:set name="faecher" value="faecher" scope="request"/>
<display:table name="faecher" class="table" requestURI="" id="faecherList" export="false" pagesize="25">
    <display:column property="fachId" sortable="true" titleKey="fach.fachId"/>
    <display:column property="fachName" sortable="true" titleKey="fach.fachName"/>
    <authz:authorize ifAnyGranted="ROLE_ADMIN,ROLE_PFLEGE">
    <display:column href="${fachDrop}" value="Fach entfernen" paramId="fachId" paramProperty="fachId"/>
    </authz:authorize>
    <display:setProperty name="paging.banner.item_name" value="Fach"/>
    <display:setProperty name="paging.banner.items_name" value="F&auml;cher"/>
    <display:setProperty name="basic.empty.showtable" value="false"/>
    <display:setProperty name="basic.msg.empty_list" value="Keine F&auml;cher vorhanden."/>
    <display:setProperty name="paging.banner.one_item_found" value=""/>
    <display:setProperty name="paging.banner.all_items_found" value=""/>
</display:table>
</s:push>



           
