glassfish admin console

```
http://localhost:4848
```

can check batch status in common tasks -> server -> Batch.

mvn clean package

deploy war as enterprice application from admin console

<b> double check batch-job xml file.</b>

don't forget to add itemprocessors or steps...

start the job by visiting

```
http://127.0.0.1:8080/filesourcebatchtry/filesource/
```