FROM openjdk:11-slim
WORKDIR /usr/src/app
COPY src/internshipmansys/ internshipmansys/
COPY src/taxenfmansys/ taxenfmansys/
COPY src/taxmanagementsys/ taxmanagementsys/
COPY run.sh .
RUN chmod +x run.sh
CMD ["./run.sh"]