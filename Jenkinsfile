#!/usr/bin/env groovy
node{

	stage('SCM'){
		checkout scm
	}
	stage('Build'){
		echo "build"
		sh 'mvn clean install -DskipTests=true '
	}
	stage('Test'){
		echo "test"
		sh 'mvn test'
	}
	stage('Deploy'){
		echo "deploy"
		sh 'mvn spring-boot:run'
	}
}
