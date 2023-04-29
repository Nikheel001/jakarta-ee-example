glassfish admin console

```
http://localhost:4848
```

jakarta jpa is also used

use db_init_script.txt to create file db

if needed, add hsqldb jar to glassfish lib (for hsql dependency add scope as provided in pom.xml)

add resource configs for hsql db in glassfish

```
<jdbc-connection-pool driver-classname="org.hsqldb.jdbc.JDBCDriver" datasource-classname="org.hsqldb.jdbc.JDBCDataSource" name="localhsqlpool" res-type="javax.sql.DataSource">
    <property name="password" value="none"></property>
    <property name="user" value="none"></property>
    <property name="url" value="jdbc:hsqldb:path\to\sampledb"></property>
</jdbc-connection-pool>
<jdbc-resource pool-name="localhsqlpool" jndi-name="localhsql"></jdbc-resource>

```

mvn clean package

deploy war as enterprice application from admin console

<b> double check batch-job xml file.</b>

start the job by visiting

```
http://127.0.0.1:8080/hsqldbsourcebatchtry/hsqldbsource/
```