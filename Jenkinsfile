pipeline {
  agent any
  tools {
        gradle "gradle6.8.3"
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
				sudo -S docker build -t java11demo .
				echo "image build completed"
			 '''
      }
    }
  }
}
