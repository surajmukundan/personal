def namespace = 'gradleproject'
def registry = 'https://hub.docker.com/repository/docker'
def imageTag = "hub.docker.com/repository/docker/frozenmind/java11demo:latest"

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
				sudo docker build -t ${imageTag} .
				sudo docker push ${imageTag}
				echo "image build and push completed"
			 '''
      }
    }
	  stage('Deploy Image') {
      steps {
          sh '''
				kubectl get ns ${namespace} || kubectl create ns ${namespace}
				kubectl --namespace=${namespace} apply -f deployTemplate.yaml
				echo "image deploy completed"
			 '''
      }
    }
  }

}
