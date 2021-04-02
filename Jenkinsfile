def namespace = "gradleproject"
def imageTag = "frozenmind/java11demo:latest"

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
	      sh("sudo docker build -t ${imageTag} .")
              sh("sudo docker push ${imageTag}")
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
