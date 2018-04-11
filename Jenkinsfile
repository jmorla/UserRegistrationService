#!/usr/bin/env groovy
node{
	stage('SCM'){
		checkout scm
		branchName = env.BRANCH_NAME
		echo "${branchName}"
	}
	stage('Build'){
		echo "build"
	}
	stage('Test'){
		echo "test"
	}
	stage('Deploy'){
		echo "deploy"
	}
}
