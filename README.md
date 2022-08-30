# Project-Management-Web-App
App to help manage deadlines

In this project I make use of the Java Spring Boot Framework to create a backend application that is fully CRUD functional. Data is persisted onto a relational database and can be accessed via allowed REST API endpoints. To test
application a series of unit tests were designed on Mockito and POSTMAN was used to mimic a front-end interface.
This has been progressed so that a front-end for this application has been made using HTML CSS and Javascript. Dilligence in secure practise and assigning user access roles help to maintain the security of the database. 

The plannning of this project was done using a kanban board using github projects. Data was routinely uploaded onto github repositories to allow for version control.

[SQL Data persisted](reposqltable.PNG)

[Create CRUD functionality](reposignup.PNG)

[SQL Data persisted](repoupdateCRUD.PNG)

[Authentication/Get CRUD functionality](repologin.PNG)

[Add CRUD funcionality](repoaddcrud.PNG)

[Showing API input/output via Postman](repoPostman.PNG)

[Showing all CRUD operations on front end interface](repoCRUD.PNG)

[SQL Data persisted](repoBoard.PNG)


# Docs for the Azure Web Apps Deploy action: https://github.com/Azure/webapps-deploy
# More GitHub Actions for Azure: https://github.com/Azure/actions

name: Build and deploy JAR app to Azure Web App - Project-Management-App

on:
  push:
    branches:
      - Master
  workflow_dispatch:

jobs:
  build:
    runs-on: windows-latest

    steps:
      - uses: actions/checkout@v2

      - name: Set up Java version
        uses: actions/setup-java@v1
        with:
          java-version: '17'

      - name: Build with Maven
        run: mvn clean install

      - name: Upload artifact for deployment job
        uses: actions/upload-artifact@v2
        with:
          name: java-app
          path: '${{ github.workspace }}/target/*.jar'

  deploy:
    runs-on: windows-latest
    needs: build
    environment:
      name: 'production'
      url: ${{ steps.deploy-to-webapp.outputs.webapp-url }}

    steps:
      - name: Download artifact from build job
        uses: actions/download-artifact@v2
        with:
          name: java-app

      - name: Deploy to Azure Web App
        id: deploy-to-webapp
        uses: azure/webapps-deploy@v2
        with:
          app-name: 'Project-Management-App'
          slot-name: 'production'
          publish-profile: ${{ secrets.AzureAppService_PublishProfile_80b32d12e8dd45ef94fb37a06bd42aa8 }}
          package: '*.jar
