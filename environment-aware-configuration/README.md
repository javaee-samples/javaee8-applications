# Environment Aware

This project was made using this archetype that I created: [javaee8-archetype](https://github.com/felipe-alves-moraes/javaee8-archetype)

With this approach I set my datasource configuration based on the environment that I was building my project.

The idea here is that you application should only have references of the environment around it through known variables.

To do this I've used [payara variable substitution](https://docs.payara.fish/documentation/payara-server/server-configuration/var-substitution/types-of-variables.html) feature. 

This way I was able to let the environment handle infrastructure configuration.

You can check the configuration inside the `web.xml` file and in each of the docker env-files inside the docker folder.

## Cons of this approach
When in development process you will have to set the environment variables in your machine or in you IDE. (This is not hard to achieve but some people may find this annoying)

Vendor dependent configuration.

## Pros
Simple configuration of resources.

Don't need to do any magical trick in you app to handle configuration.

CI/CD ready configuration.

# Build
`mvn clean package && docker build -f ./docker/Dockerfile -t br.com.fmoraes/environment-aware-configuration .`

# RUN

`docker rm -f environment-aware-configuration || true && docker run --env-file=./docker/local_env_properties -d -p 8080:8080 -p 4848:4848 --name environment-aware-configuration br.com.fmoraes/environment-aware-configuration`

You can also run the application using the script `buildAndRun.sh` by default it will pick the `local_env_properties` file to run docker, you can change it passing one of the following envs as argument: `dev`, `stage` and `prod`.

To run it locally in you IDE you have to configure these Environment Variables:

```
DATASOURCE_CLASS=org.apache.derby.jdbc.ClientDriver
DB_ENGINE=derby
DB_URL=//host.docker.internal:1527/environment-aware-configuration
DB_USER=app
DB_PASSWORD=app
```

OBS. You need to have a local instance of Apache Derby(Java DB) running in you local machine to this project to work, or configure any DB that you want changing the configuration files.
