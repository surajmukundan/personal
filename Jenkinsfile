def namespace = "gradleproject"
def imageTag = "java11demo:latest"
def registry = "localhost:5000"


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
	      sh("sudo docker build -t java11demo:latest .")
	      //sh("sudo docker login -u ${DOCKER_USERNAME} -p ${DOCKER_PASSWORD} ${registry}")
	      sh("sudo docker tag java11demo:latest localhost:5000/java11demo")
              sh("sudo docker image push localhost:5000/java11demo")
	      sh("echo 'image build and push completed'")
	      
			 
      }
    }
	  stage('Deploy Image') {
      steps {
          
	      sh("kubectl get ns ${namespace} || kubectl create ns ${namespace}")
	      sh("kubectl --namespace=${namespace} apply -f deployTemplate.yaml")
	      sh("echo 'image deploy completed'")
      }
    }
  }

}
