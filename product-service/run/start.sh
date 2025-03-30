#!/bin/bash
nohup java -Xmx1536m -Xms512m -Xss256k \
-Dspring.profiles.active=production \
-Duser.timezone=${KERO_SPRING_USER_TIME_ZONE} \
-Dspring.datasource.hikari.connection-timeout=30000 \
-jar ${KERO_HOME}/ems-service/ems-service.jar > /dev/null 2>&1 &