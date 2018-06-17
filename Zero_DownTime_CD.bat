@echo off

cf login -a api.run.pivotal.io -u jipson_jose@syntelinc.com -p Syntel123$ -o DHOrgPilot -s development

setlocal enabledelayedexpansion
set isPluginInstalled=0
set pluginList=
FOR /F "skip=3" %%g IN ('cf plugins') do (
set pluginList=!pluginList! %%g )

for %%y in (%pluginList%) do (
IF "%%y" == "autopilot" (
	set isPluginInstalled=1
)
)

IF %isPluginInstalled% == 0 (
	cf install-plugin autopilot -r CF-Community -f
)

cd ./employee-master-service
cf zero-downtime-push employee-master-service -f manifest.yml