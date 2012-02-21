@echo off

rem ***  Migration vorbereiten  ***
rem migration\input> subst_d_create.cmd


set EXECDIR=..\migration_input
set EXECCMD=mvn -P prod,mysql compile exec:java -Dexec.mainClass=migration.App
start /D %EXECDIR% /WAIT cmd /D/C %EXECCMD%

pause
GOTO :eof
