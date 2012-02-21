@echo off

rem ***  Migration vorbereiten  ***
rem migration\input> subst_d_create.cmd

set EXECDIR=ejportal\web
set EXECCMD=mvn -P prod,mysql tomcat:run
start /D %EXECDIR% /WAIT cmd /D/C %EXECCMD%

pause
GOTO :eof
