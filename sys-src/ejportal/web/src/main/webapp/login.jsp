<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="login.title"/></title>
    <meta name="heading" content="<fmt:message key='login.heading'/>"/>
    <meta name="menu" content="Login"/>
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/application.css'/>" />
</head>
<body id="login"/>

    <div id="loginBox">

        <h1>Anmeldung</h1><br/>
        <form method="post" id="loginForm" action="<c:url value='/j_security_check'/>"
                             onsubmit="saveUsername(this);return validateForm(this)">


            <c:if test="${param.error != null}">
                <p class="error">
                    <img src="${ctx}/images/iconWarning.gif" alt="<fmt:message key='icon.warning'/>" class="icon"/>
                    <fmt:message key="errors.password.mismatch"/>
                        <%--${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}--%>
                </p>
            </c:if>
            <p>

                <label for="j_username" class="required desc">
                    <span>Benutzername</span>
                    <input type="text" class="input-text" name="j_username" id="j_username" tabindex="1" />
                </label>
            </p>

            <p>

                <label for="j_password" class="required desc">
                    <span>Passwort</span>  
                    <input type="password" class="input-text" name="j_password" id="j_password" tabindex="2" />
                </label>

            </p>

            <c:if test="${appConfig['rememberMeEnabled']}">
            <p>
                 <input type="checkbox" name="_spring_security_remember_me" id="rememberMe" tabindex="3"/>
                 <span>Angemeldet bleiben</span>
            </p>
            </c:if>
            <p>
                <input type="submit" class="button" name="login" value="<fmt:message key='button.login'/>" tabindex="4" />
            </p>

    </form>
   


    <%@ include file="/scripts/login.js"%>

    <p><!--<fmt:message key="login.passwordHint"/>--></p>
</div>