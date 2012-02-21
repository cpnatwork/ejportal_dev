<%@ include file="/common/taglibs.jsp"%>

<c:if test="${pageContext.request.locale.language ne 'en'}">
    <div id="switchLocale"><a href="<c:url value='/?locale=en'/>"><fmt:message key="webapp.name"/> in English</a></div>
</c:if>

<div id="branding">
    <h1>E-Journals - Friedrich-Alexander-Universit&auml;t Erlangen-N&uuml;rnberg</a></h1>
    <p>Tagline</p>
</div>
<hr />

<%-- Put constants into request scope --%>
<appfuse:constants scope="request"/>