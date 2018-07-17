FROM payara/micro:5.182

ADD ./target/libs /opt/libs

COPY ./target/environment-aware-configuration.war ${DEPLOY_DIR}

ENTRYPOINT ["java", "-jar", "/opt/payara/payara-micro.jar", \
"--addLibs", "/opt/libs/", \
"--deploy", "/opt/payara/deployments/environment-aware-configuration.war"]
