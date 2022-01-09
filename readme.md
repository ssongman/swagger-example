
# 사용법


- dockerfile

```yaml
# 1. java 설치 (패키지 업데이트 + 만든사람 표시)
FROM    openjdk:11
MAINTAINER ssongmantop@gmail.com
RUN     apt-get -y update

# 2. 소스 복사
ADD ./app.jar /usr/src/app/app.jar

# 3. 실행 디렉토리 설정
WORKDIR /usr/src/app

# 4. App 서버 실행 (Listen 포트 정의)
EXPOSE 8080
CMD    java -jar app.jar

```


- build


```
docker build -f Dockerfile -t ssongman/swagger_example:v0.5 .
```



- 실행테스트

```
docker run -d --rm --name swagger-example -p 8080:8080 ssongman/swagger_example:v0.5


curl localhost:8180/v1/api-docs/
curl localhost:8180/swagger-ui.html
curl localhost:8180/rest/user
```



