#!/bin/bash
nohup java -Xmx512m -Xms128m -Xss256k \
-Dspring.profiles.active=development \
-Duser.timezone=${KERO_SPRING_USER_TIME_ZONE} \
-Dspring.datasource.hikari.connection-timeout=30000 \
-jar ${KERO_HOME}/ems-service/ems-service.jar > /dev/null 2>&1 &
