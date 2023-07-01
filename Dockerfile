FROM amazoncorretto:17.0.7-al2-generic as build

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn

COPY pom.xml .

RUN ./mvnw dependency:go-offline -B

COPY src src

RUN ./mvnw package -DskipTests

RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)


FROM amazoncorretto:17.0.7-al2-generic

ARG DEPENDENCDY=/app/target/dependency

COPY --from=build ${DEPENDENCDY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCDY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCDY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*","com.hci.hcionlineshop.HcionlineshopApplication"]