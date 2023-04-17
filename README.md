# ticker-api

## 사전 설치
* docker
* java 17

## 실행
```shell
./gradlew build
docker-compose up -d
./gradlew bootRun
```
* 기본 포트는 9092로 설정되어 있습니다.
* doc: http://127.0.0.1:9092/swagger-ui/index.html

## 테스트
* 유닛 테스트까지 하려 했으나 인수 테스트로 대체합니다...
* mysql testcontainer 적용해두었습니다.

## jib
```shell
./gradlew jibDockerBuild 
```
* 'gcr.io/ticker-api/ticker'