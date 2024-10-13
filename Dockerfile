FROM jenkins/jenkins:latest

USER root

# Установка Maven и wget
RUN apt-get update && \
    apt-get install -y maven wget unzip && \
    apt-get clean

# Установка Allure
RUN wget -qO allure.zip https://github.com/allure-framework/allure2/releases/download/2.20.1/allure-2.20.1.zip && \
    unzip allure.zip -d /opt/ && \
    ln -s /opt/allure-2.20.1/bin/allure /usr/bin/allure && \
    rm allure.zip

USER jenkins
