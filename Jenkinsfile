pipeline {
  agent any
  tools {
        gradle "gradle6.8.3"
	org.jenkinsci.plugins.docker.commons.tools.dockertool "Default"
    }
  
  options {
	 buildDiscarder(logRotator(numToKeepStr: '2', daysToKeepStr: '1'))
  }
  stages {
    stage('Build') {
      steps {  
        sh "gradle clean compileJava build --refresh-dependencies"   
      }
    }
    stage('Build Docker Image') {
      steps {
          sh '''
				docker build -f Dockerfile -t java-11-demo
				echo "image build completed"
			 '''
      }
    }
  }
}
