#!/usr/bin/env groovy
node{

	stage('SCM'){
		checkout scm
	}
	stage('Build'){
		echo "build"
		sh 'mvn clean package -DskipTests=true -U'
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
