@echo off

rem ***  Migration vorbereiten  ***
rem migration\input> subst_d_create.cmd


set EXECDIR=ejportal\core
set EXECCMD=mvn -P prodcreate,mysql install
start /D %EXECDIR% /WAIT cmd /D/C %EXECCMD%

set EXECDIR=ejportal\core
set EXECCMD=mvn -P prodcreate,mysql install
start /D %EXECDIR% /WAIT cmd /D/C %EXECCMD%

pause
GOTO :eof
