# promethus-simulator

## 介绍

```text
学习promethus的一个模拟器

```
### 运行

#### 本地运行

```bash
mvn package dependency:copy
docker-compose -f local/docker-compose.yml build
docker-compose -f local/docker-compose.yml up
```

通过 http://localhost:8080/actuator/prometheus 访问数据输出。
通过 http://localhost:9090/ 访问Prometheus。

通过下面这个命令停止服务：

```bash
docker-compose -f local/docker-compose.yml down
```
